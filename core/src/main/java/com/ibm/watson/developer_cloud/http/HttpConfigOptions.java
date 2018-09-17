package com.ibm.watson.developer_cloud.http;

import java.net.Proxy;

/**
 * Options class for configuring the HTTP client.
 */
public class HttpConfigOptions {
  private boolean disableSslVerification;
  private Proxy proxy;

  boolean shouldDisableSslVerification() {
    return this.disableSslVerification;
  }

  Proxy getProxy() {
    return this.proxy;
  }

  public static class Builder {
    private boolean disableSslVerification;
    private Proxy proxy;

    public HttpConfigOptions build() {
      return new HttpConfigOptions(this);
    }

    /**
     * Sets flag to disable any SSL certificate verification during HTTP requests. This should ONLY be used if truly
     * intended, as it's unsafe otherwise.
     *
     * @param disableSslVerification whether to disable SSL verification or not
     * @return the builder
     */
    public Builder disableSslVerification(boolean disableSslVerification) {
      this.disableSslVerification = disableSslVerification;
      return this;
    }

    /**
     * Sets HTTP proxy to be used by connections with the current client.
     *
     * @param proxy the desired {@link Proxy}
     * @return the builder
     */
    public Builder proxy(Proxy proxy) {
      this.proxy = proxy;
      return this;
    }
  }

  private HttpConfigOptions(Builder builder) {
    this.disableSslVerification = builder.disableSslVerification;
    this.proxy = builder.proxy;
  }
}
