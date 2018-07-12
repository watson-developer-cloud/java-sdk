package com.ibm.watson.developer_cloud.service;

import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class AuthenticationTest {
  private static final String APIKEY = "12345";

  public class TestService extends WatsonService {
    private static final String SERVICE_NAME = "test";

    public TestService() {
      super(SERVICE_NAME);
    }
  }

  @Test
  public void authenticateWithApiKeyAsUsername() {
    TestService service = new TestService();
    service.setUsernameAndPassword("apikey", APIKEY);
    assertTrue(service.isTokenManagerSet());
  }
}
