/**
 * Copyright 2015 IBM Corp. All Rights Reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.ibm.watson.developer_cloud.retrieve_and_rank.v1.utils;

import static com.ibm.watson.developer_cloud.retrieve_and_rank.v1.utils.RetrieveAndRankMessages.*;

import java.net.URI;

import org.apache.http.HttpException;
import org.apache.http.HttpHost;
import org.apache.http.HttpRequest;
import org.apache.http.HttpRequestInterceptor;
import org.apache.http.auth.AuthScope;
import org.apache.http.auth.AuthState;
import org.apache.http.auth.Credentials;
import org.apache.http.auth.UsernamePasswordCredentials;
import org.apache.http.client.CredentialsProvider;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.protocol.HttpClientContext;
import org.apache.http.impl.auth.BasicScheme;
import org.apache.http.impl.client.BasicCredentialsProvider;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.protocol.HttpContext;
import org.apache.http.protocol.HttpCoreContext;

/**
 * Factory for {@link CloseableHttpClient HttpClients}.
 */
public class HttpClientFactory {
    private static final MessageFormatter MSGS = new MessageFormatter(bundleName());

    private final CredentialsProvider defaultCredentialsProvider;

    public HttpClientFactory() {
        this.defaultCredentialsProvider = null;
    }

    public HttpClientFactory(URI scopeUri, String username, String password) {
        final BasicCredentialsProvider credentialsProvider = new BasicCredentialsProvider();
        credentialsProvider.setCredentials(
                new AuthScope(scopeUri.getHost(), scopeUri.getPort()),
                new UsernamePasswordCredentials(username, password));

        this.defaultCredentialsProvider = credentialsProvider;
    }

    public CloseableHttpClient createHttpClient() {
        return createHttpClientBuilder().build();
    }

    @SuppressWarnings("synthetic-access")
    public HttpClientBuilder createHttpClientBuilder() {
        final HttpClientBuilder builder = HttpClientBuilder.create()
                .setMaxConnTotal(128)
                .setMaxConnPerRoute(32)
                .setDefaultRequestConfig(RequestConfig.copy(RequestConfig.DEFAULT)
                        .setRedirectsEnabled(true).build());
        if (defaultCredentialsProvider != null) {
            builder.setDefaultCredentialsProvider(defaultCredentialsProvider);
            builder.addInterceptorFirst(new PreemptiveAuthInterceptor());
        }
        return builder;
    }

    private static class PreemptiveAuthInterceptor implements HttpRequestInterceptor {

        @Override
        public void process(final HttpRequest request, final HttpContext context) throws HttpException {
            final AuthState authState = (AuthState) context.getAttribute(HttpClientContext.TARGET_AUTH_STATE);

            // If no auth scheme available yet, try to initialize it preemptively
            if (authState.getAuthScheme() == null) {
                final CredentialsProvider credsProvider = (CredentialsProvider) context
                        .getAttribute(HttpClientContext.CREDS_PROVIDER);
                final HttpHost targetHost = (HttpHost) context.getAttribute(HttpCoreContext.HTTP_TARGET_HOST);
                final Credentials creds = credsProvider.getCredentials(new AuthScope(targetHost.getHostName(),
                        targetHost.getPort()));
                if (creds == null) {
                    throw new HttpException(MSGS.format(NO_CREDENTIALS_FOR_PREEMPTIVE_AUTH));
                }
                authState.update(new BasicScheme(), creds);
            }

        }

    }
}