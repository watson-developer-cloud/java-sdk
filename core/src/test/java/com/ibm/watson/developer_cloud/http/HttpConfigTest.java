package com.ibm.watson.developer_cloud.http;

import org.junit.Test;

import java.net.InetSocketAddress;
import java.net.Proxy;

import static org.junit.Assert.assertEquals;

/**
 * Unit tests for the HttpConfigOptions object.
 */
public class HttpConfigTest {

  @Test
  public void testHttpConfigOptions() {
    Proxy proxy = new Proxy(Proxy.Type.HTTP, new InetSocketAddress("proxyHost", 8080));
    HttpConfigOptions configOptions = new HttpConfigOptions.Builder()
        .disableSslVerification(true)
        .proxy(proxy)
        .build();

    assertEquals(true, configOptions.shouldDisableSslVerification());
    assertEquals(proxy, configOptions.getProxy());
  }
}
