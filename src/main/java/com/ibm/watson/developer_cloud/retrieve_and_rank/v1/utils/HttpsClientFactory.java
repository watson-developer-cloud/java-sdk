package com.ibm.watson.developer_cloud.retrieve_and_rank.v1.utils;

import java.io.File;
import java.net.URI;

import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;

/**
 * Factory for secure HTTPS {@link CloseableHttpClient HttpClients}.
 */
public class HttpsClientFactory extends HttpClientFactory {
    protected final CustomSSLConnection customSSLConnection;

    public HttpsClientFactory(File truststoreFile, String truststorePassword) {
        customSSLConnection = new CustomSSLConnection(truststoreFile, truststorePassword);
    }

    public HttpsClientFactory(URI scopeUri, String username, String password, File truststoreFile,
            String truststorePassword) {
        super(scopeUri, username, password);
        customSSLConnection = new CustomSSLConnection(truststoreFile, truststorePassword);
    }

    @Override
    public CloseableHttpClient createHttpClient() {
        return createHttpClientBuilder().build();
    }

    @Override
    public HttpClientBuilder createHttpClientBuilder() {
        final HttpClientBuilder builder = super.createHttpClientBuilder();
        builder.setSSLSocketFactory(customSSLConnection.getSSLConnectionFactory());
        return builder;
    }
}