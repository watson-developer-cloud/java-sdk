/**
 * Copyright 2015 IBM Corp. All Rights Reserved.
 * 
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except
 * in compliance with the License. You may obtain a copy of the License at
 * 
 * http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software distributed under the License
 * is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express
 * or implied. See the License for the specific language governing permissions and limitations under
 * the License.
 */
package com.ibm.watson.developer_cloud.util;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import java.io.InputStream;

import org.junit.Before;
import org.junit.Test;

import com.ibm.watson.developer_cloud.WatsonServiceTest;

/**
 * The Class CredentialUtilsTest.
 */
public class CredentialUtilsTest extends WatsonServiceTest {

  /** The Constant API_KEY_FREE. */
  private static final String API_KEY_FREE =
      "Basic bm90LWEtZnJlZS11c2VybmFtZTpub3QtYS1mcmVlLXBhc3N3b3Jk";

  /** The Constant API_KEY_STANDARD. */
  private static final String API_KEY_STANDARD = "Basic bm90LWEtdXNlcm5hbWU6bm90LWEtcGFzc3dvcmQ=";

  /** The Constant SERVICE_NAME. */
  private static final String SERVICE_NAME = "personality_insights";

  /** The Constant VCAP_SERVICES. */
  private static final String VCAP_SERVICES = "vcap_services.json";

  /**
   * Setup.
   */
  @Before
  public void setup() {
    final InputStream in = Thread.currentThread().getContextClassLoader().getResourceAsStream(VCAP_SERVICES);
    final String vcapServices = getStringFromInputStream(in);
    CredentialUtils.setServices(vcapServices);
  }

  /**
   * Test get api key with null or empty service. There are two instances of Personality Insights:
   * ['free', 'standard']
   */
  @Test
  public void testGetAPIKeyWithNullOrEmptyService() {
    assertNull(CredentialUtils.getAPIKey(null, null));
    assertNull(CredentialUtils.getAPIKey("", ""));

    assertEquals(API_KEY_FREE, CredentialUtils.getAPIKey(SERVICE_NAME, null));
    assertEquals(API_KEY_FREE, CredentialUtils.getAPIKey(SERVICE_NAME, CredentialUtils.PLAN_FREE));
    assertEquals(API_KEY_STANDARD, CredentialUtils.getAPIKey(SERVICE_NAME, CredentialUtils.PLAN_STANDARD));
  }
}
