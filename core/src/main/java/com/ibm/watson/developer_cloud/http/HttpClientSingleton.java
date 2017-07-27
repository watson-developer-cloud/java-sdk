/*
 * Copyright 2017 IBM Corp. All Rights Reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except in compliance with
 * the License. You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software distributed under the License is distributed on
 * an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the License for the
 * specific language governing permissions and limitations under the License.
 */
package com.ibm.watson.developer_cloud.http;

import java.io.IOException;
import java.net.CookieManager;
import java.net.CookiePolicy;
import java.security.KeyManagementException;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;
import javax.net.ssl.TrustManagerFactory;
import javax.net.ssl.X509TrustManager;

import com.ibm.watson.developer_cloud.service.WatsonService;
import com.ibm.watson.developer_cloud.service.security.DelegatingSSLSocketFactory;
import com.ibm.watson.developer_cloud.util.HttpLogging;

import okhttp3.ConnectionSpec;
import okhttp3.OkHttpClient;
import okhttp3.OkHttpClient.Builder;
import okhttp3.TlsVersion;

/**
 * This class encapsulate the {@link OkHttpClient} instance in a singleton pattern. OkHttp performs best when you create
 * a single OkHttpClient instance and reuse it for all of your HTTP calls. This is because each client holds its own
 * connection pool and thread pools. Reusing connections and threads reduces latency and saves memory. Conversely,
 * creating a client for each request wastes resources on idle pools.
 */
public class HttpClientSingleton {
  private static HttpClientSingleton instance = null;

  private static final Logger LOG = Logger.getLogger(WatsonService.class.getName());

  /**
   * Gets the single instance of HttpClientSingleton.
   *
   * @return single instance of HttpClientSingleton
   */
  public static HttpClientSingleton getInstance() {
    if (instance == null) {
      instance = new HttpClientSingleton();
    }
    return instance;
  }

  private OkHttpClient okHttpClient;

  /**
   * Instantiates a new HTTP client singleton.
   */
  protected HttpClientSingleton() {
    this.okHttpClient = configureHttpClient();
  }

  /**
   * Configures the HTTP client.
   *
   * @return the HTTP client
   */
  private OkHttpClient configureHttpClient() {
    final OkHttpClient.Builder builder = new OkHttpClient.Builder();

    addCookieJar(builder);

    builder.connectTimeout(60, TimeUnit.SECONDS);
    builder.writeTimeout(60, TimeUnit.SECONDS);
    builder.readTimeout(90, TimeUnit.SECONDS);

    builder.addNetworkInterceptor(HttpLogging.getLoggingInterceptor());

    ConnectionSpec spec = new ConnectionSpec.Builder(ConnectionSpec.MODERN_TLS).allEnabledCipherSuites().build();
    builder.connectionSpecs(Arrays.asList(spec, ConnectionSpec.CLEARTEXT));

    setupTLSProtocol(builder);

    return builder.build();
  }

  /**
   * Adds the cookie jar.
   *
   * @param builder the builder
   */
  private void addCookieJar(final OkHttpClient.Builder builder) {
    final CookieManager cookieManager = new CookieManager();
    cookieManager.setCookiePolicy(CookiePolicy.ACCEPT_ALL);

    builder.cookieJar(new WatsonCookieJar(cookieManager));
  }


  /**
   * Specifically enable all TLS protocols. See: https://github.com/watson-developer-cloud/java-sdk/issues/610
   *
   * @param builder the {@link OkHttpClient} builder.
   */
  private void setupTLSProtocol(final OkHttpClient.Builder builder) {
    try {
      TrustManagerFactory trustManagerFactory =
          TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm());
      trustManagerFactory.init((KeyStore) null);
      TrustManager[] trustManagers = trustManagerFactory.getTrustManagers();

      if (trustManagers.length != 1 || !(trustManagers[0] instanceof X509TrustManager)) {
        throw new IllegalStateException("Unexpected default trust managers:" + Arrays.toString(trustManagers));
      }

      X509TrustManager trustManager = (X509TrustManager) trustManagers[0];

      // On IBM JDK's this gets only TLSv1
      SSLContext sslContext = SSLContext.getInstance("TLS");

      sslContext.init(null, new TrustManager[] { trustManager }, null);
      SSLSocketFactory sslSocketFactory = new DelegatingSSLSocketFactory(sslContext.getSocketFactory()) {
        @Override
        protected SSLSocket configureSocket(SSLSocket socket) throws IOException {
          socket.setEnabledProtocols(new String[] { TlsVersion.TLS_1_0.javaName(), TlsVersion.TLS_1_1.javaName(),
              TlsVersion.TLS_1_2.javaName() });

          return socket;
        }
      };

      builder.sslSocketFactory(sslSocketFactory, trustManager);

    } catch (NoSuchAlgorithmException e) {
      LOG.log(Level.SEVERE, "The cryptographic algorithm requested is not available in the environment.", e);
    } catch (KeyStoreException e) {
      LOG.log(Level.SEVERE, "Error using the keystore.", e);
    } catch (KeyManagementException e) {
      LOG.log(Level.SEVERE, "Error initializing the SSL Context.", e);
    }
  }

  /**
   * Creates an {@link OkHttpClient} instance with a new {@link WatsonCookieJar}.
   *
   * @return the client
   */
  public OkHttpClient createHttpClient() {
    Builder builder = okHttpClient.newBuilder();
    addCookieJar(builder);
    return builder.build();
  }
}
