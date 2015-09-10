package com.ibm.watson.developer_cloud.retrieve_and_rank.v1.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.security.KeyManagementException;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateException;
import java.util.Locale;

import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocketFactory;

import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.conn.ssl.SSLContexts;
import org.apache.http.conn.ssl.TrustSelfSignedStrategy;

/**
 * Use a custom JKS truststore to connect to a server securely
 */
public class CustomSSLConnection {
    private static final String KEYSTORE_FORMAT = "jks";
    private final KeyStore truststore;

    public CustomSSLConnection(File truststoreFile, String truststorePassword) {
        try {
            truststore = KeyStore.getInstance(KEYSTORE_FORMAT);
        } catch (final KeyStoreException e) {
            throw new RuntimeException("Invalid truststore format.", e);
        }

        try (FileInputStream fileStream = new FileInputStream(truststoreFile)) {
            truststore.load(fileStream, truststorePassword.toCharArray());
        } catch (final NoSuchAlgorithmException | CertificateException | IOException e) {
            throw new RuntimeException(
                    String.format(Locale.ROOT, "Failed to read truststore [%s].", truststoreFile.getAbsolutePath()), e);
        }
    }

    private SSLContext getSSLContext() {
        try {
            return SSLContexts.custom()
                    .loadTrustMaterial(truststore, new TrustSelfSignedStrategy())
                    .build();
        } catch (KeyManagementException | NoSuchAlgorithmException | KeyStoreException e) {
            throw new RuntimeException(String.format(Locale.ROOT, "Failed to load truststore."), e);
        }
    }

    public SSLSocketFactory getSSLSocketFactory() {
        return getSSLContext().getSocketFactory();
    }

    public SSLConnectionSocketFactory getSSLConnectionFactory() {
        return new SSLConnectionSocketFactory(getSSLContext(), SSLConnectionSocketFactory.ALLOW_ALL_HOSTNAME_VERIFIER);
    }
}
