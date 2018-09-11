package com.ibm.watson.developer_cloud.service;

import org.junit.Test;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;

public class AuthenticationTest {
  private static final String APIKEY_USERNAME = "apikey";
  private static final String APIKEY = "12345";
  private static final String ICP_APIKEY = "icp-12345";

  public class TestService extends WatsonService {
    private static final String SERVICE_NAME = "test";

    public TestService() {
      super(SERVICE_NAME);
    }
  }

  @Test
  public void authenticateWithApiKeyAsUsername() {
    TestService service = new TestService();
    service.setUsernameAndPassword(APIKEY_USERNAME, APIKEY);
    assertTrue(service.isTokenManagerSet());
  }

  @Test
  public void authenticateWithIcp() {
    TestService service = new TestService();
    service.setUsernameAndPassword(APIKEY_USERNAME, ICP_APIKEY);
    assertFalse(service.isTokenManagerSet());
  }
}
