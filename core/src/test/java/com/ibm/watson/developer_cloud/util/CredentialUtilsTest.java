/**
 * Copyright 2017 IBM Corp. All Rights Reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except in compliance with
 * the License. You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software distributed under the License is distributed on
 * an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the License for the
 * specific language governing permissions and limitations under the License.
 */
package com.ibm.watson.developer_cloud.util;

import com.ibm.watson.developer_cloud.WatsonServiceTest;
import org.junit.Before;
import org.junit.Test;

import java.io.InputStream;
import java.util.Hashtable;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

/**
 * The Class CredentialUtilsTest.
 */
public class CredentialUtilsTest extends WatsonServiceTest {
  private static final String SERVICE_NAME = "personality_insights";
  private static final String VCAP_SERVICES = "vcap_services.json";
  private static final String APIKEY = "apikey";
  private static final String USERNAME = "username";
  private static final String OLD_API_KEY = "api_key";
  private static final String NOT_A_USERNAME = "not-a-username";
  private static final String NOT_A_PASSWORD = "not-a-password";
  private static final String NOT_A_FREE_USERNAME = "not-a-free-username";
  private static final String VISUAL_RECOGNITION = "watson_vision_combined";

  /**
   * Setup.
   */
  @Before
  public void setup() {
    final InputStream in = Thread.currentThread().getContextClassLoader().getResourceAsStream(VCAP_SERVICES);
    final String vcapServices = getStringFromInputStream(in);
    CredentialUtils.setServices(vcapServices);

    final Hashtable<String, String> env = new Hashtable<>();
    env.put("java.naming.factory.initial", "org.osjava.sj.SimpleContextFactory");
    env.put("org.osjava.sj.delimiter", "/");
    env.put("org.osjava.sj.root", "src/test/resources");

    CredentialUtils.setContext(env);
  }

  @Test
  public void testGetVcapValueWithNullOrEmptyService() {
    assertNull(CredentialUtils.getVcapValue(null, APIKEY));
    assertNull(CredentialUtils.getVcapValue("", APIKEY));
  }

  @Test
  public void testGetVcapValueWithPlan() {
    assertEquals(NOT_A_USERNAME, CredentialUtils.getVcapValue(SERVICE_NAME, USERNAME, CredentialUtils.PLAN_STANDARD));
  }

  @Test
  public void testGetVcapValueWithoutPlan() {
    assertEquals(NOT_A_PASSWORD, CredentialUtils.getVcapValue(VISUAL_RECOGNITION, OLD_API_KEY));
  }

  @Test
  public void testGetVcapValueWithMultiplePlans() {
    assertEquals(NOT_A_FREE_USERNAME, CredentialUtils.getVcapValue(SERVICE_NAME, USERNAME));
  }
}
