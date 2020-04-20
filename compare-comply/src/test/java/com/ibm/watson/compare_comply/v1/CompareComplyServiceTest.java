package com.ibm.watson.compare_comply.v1;

import com.ibm.cloud.sdk.core.security.Authenticator;
import com.ibm.cloud.sdk.core.security.IamAuthenticator;
import com.ibm.watson.common.WatsonServiceTest;
import org.junit.Assume;
import org.junit.Before;

public class CompareComplyServiceTest extends WatsonServiceTest {
  private static final String VERSION = "2018-10-15";

  private CompareComply service;

  public CompareComply getService() {
    return this.service;
  }

  /*
   * (non-Javadoc)
   * @see com.ibm.watson.common.WatsonServiceTest#setUp()
   */
  @Override
  @Before
  public void setUp() throws Exception {
    super.setUp();
    String apiKey = getProperty("compare_comply.apikey");
    Assume.assumeFalse("config.properties doesn't have valid credentials.", apiKey == null);

    Authenticator authenticator = new IamAuthenticator(apiKey);
    service = new CompareComply(VERSION, authenticator);
    service.setServiceUrl(getProperty("compare_comply.url"));
    service.setDefaultHeaders(getDefaultHeaders());
  }
}
