package com.ibm.watson.developer_cloud.service;

import org.junit.Test;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.Map;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;

public class AuthenticationTest {
  private static final String APIKEY_USERNAME = "apikey";
  private static final String APIKEY = "12345";
  private static final String ICP_APIKEY = "icp-12345";
  private static final String BASIC_USERNAME = "basicUser";

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

  @Test
  public void multiAuthenticationWithMultiBindSameServiceOnVcapService()
      throws ClassNotFoundException, NoSuchFieldException, IllegalAccessException {

    Field theCaseInsensitiveEnvironment = Class.forName("java.lang.ProcessEnvironment")
        .getDeclaredField("theCaseInsensitiveEnvironment");
    theCaseInsensitiveEnvironment.setAccessible(true);

    Field field = Field.class.getDeclaredField("modifiers");
    field.setAccessible(true);
    field.setInt(theCaseInsensitiveEnvironment,
        theCaseInsensitiveEnvironment.getModifiers() & ~Modifier.PRIVATE & ~Modifier.FINAL);

    Map<String, String> systemEnv = (Map<String, String>) theCaseInsensitiveEnvironment.get(null);
    systemEnv.put("VCAP_SERVICES", "{\n"
        + "  \"test\": [\n"
        + "    {\n"
        + "      \"credentials\": {\n"
        + "        \"apikey\": \"" + APIKEY + "\",\n"
        + "        \"url\": \"https://gateway.watsonplatform.net/discovery/api\"\n"
        + "      },\n"
        + "      \"plan\": \"lite\"\n"
        + "    }\n"
        + "  ]\n"
        + "}\n");

    theCaseInsensitiveEnvironment.set(null, systemEnv);

    TestService serviceA = new TestService();
    serviceA.setUsernameAndPassword(APIKEY_USERNAME, APIKEY);

    TestService serviceB = new TestService();
    serviceB.setUsernameAndPassword(BASIC_USERNAME, APIKEY);

    assertTrue(serviceA.isTokenManagerSet());
    assertFalse(serviceB.isTokenManagerSet());
  }
}
