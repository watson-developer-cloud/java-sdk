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

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assume.assumeTrue;

import java.io.InputStream;
import java.util.Hashtable;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.ibm.watson.developer_cloud.WatsonServiceTest;
import com.ibm.watson.developer_cloud.util.CredentialUtils.ServiceCredentials;

/**
 * The Class CredentialUtilsTest.
 */
public class CredentialUtilsTest extends WatsonServiceTest {

  /** The Constant API_KEY_FREE. */
  private static final String API_KEY_FREE = "Basic bm90LWEtZnJlZS11c2VybmFtZTpub3QtYS1mcmVlLXBhc3N3b3Jk";

  /** The Constant API_KEY_STANDARD. */
  private static final String API_KEY_STANDARD = "Basic bm90LWEtdXNlcm5hbWU6bm90LWEtcGFzc3dvcmQ=";

  /** The Constant SERVICE_NAME. */
  private static final String SERVICE_NAME = "personality_insights";

  /** The Constant VCAP_SERVICES. */
  private static final String VCAP_SERVICES = "vcap_services.json";

  private static final String NOT_A_USERNAME = "not-a-username";
  private static final String NOT_A_PASSWORD = "not-a-password";
  private static final String NOT_A_FREE_USERNAME = "not-a-free-username";
  private static final String NOT_A_FREE_PASSWORD = "not-a-free-password";
  private static final String PLAN = "standard";

  private static final String VISUAL_RECOGNITION = "watson_vision_combined";

  private static final String PERSONALITY_INSIGHTS_URL = "https://gateway.watsonplatform.net/personality-insights/api";

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

  /**
   * Test get api key with null or empty service. There are two instances of Personality Insights: ['free', 'standard']
   */
  @Test
  public void testGetAPIKeyWithNullOrEmptyService() {
    assertNull(CredentialUtils.getAPIKey(null, null));
    assertNull(CredentialUtils.getAPIKey("", ""));

    assertEquals(API_KEY_FREE, CredentialUtils.getAPIKey(SERVICE_NAME, null));
    assertEquals(API_KEY_FREE, CredentialUtils.getAPIKey(SERVICE_NAME, CredentialUtils.PLAN_FREE));
    assertEquals(API_KEY_STANDARD, CredentialUtils.getAPIKey(SERVICE_NAME, CredentialUtils.PLAN_STANDARD));
  }

  /**
   * Test get api key for visual recognition.
   */
  @Test
  public void testGetApiKeyForVisualRecognition() {
    assertNull(CredentialUtils.getAPIKey(VISUAL_RECOGNITION, NOT_A_PASSWORD));
  }

  /**
   * Test get user name and password without plan.
   */
  @Test
  public void testGetUserNameAndPasswordWithoutPlan() {
    assertNull(CredentialUtils.getUserNameAndPassword(null));
    assertNull(CredentialUtils.getUserNameAndPassword(null, null));

    ServiceCredentials credentials = CredentialUtils.getUserNameAndPassword(SERVICE_NAME);
    Assert.assertTrue(credentials != null);
    assertEquals(credentials.getUsername(), NOT_A_FREE_USERNAME);
    assertEquals(credentials.getPassword(), NOT_A_FREE_PASSWORD);

    credentials = CredentialUtils.getUserNameAndPassword(SERVICE_NAME, null);
    assertTrue(credentials != null);
    assertEquals(credentials.getUsername(), NOT_A_FREE_USERNAME);
    assertEquals(credentials.getPassword(), NOT_A_FREE_PASSWORD);
  }

  /**
   * Test get user credentials with plan.
   */
  @Test
  public void testGetUserCredentialsWithPlan() {
    assertNull(CredentialUtils.getUserNameAndPassword(null));
    assertNull(CredentialUtils.getUserNameAndPassword(null, null));

    ServiceCredentials credentials = CredentialUtils.getUserNameAndPassword(SERVICE_NAME, PLAN);
    assertTrue(credentials != null);
    assertEquals(credentials.getUsername(), NOT_A_USERNAME);
    assertEquals(credentials.getPassword(), NOT_A_PASSWORD);
  }

  /**
   * Test getting the API URL using JDNI. We ignore this test in Travis because
   * it always fails there.
   */
  @Test
  public void testGetAPIUrlFromJDNI() {
    assumeTrue(!System.getenv().containsKey("TRAVIS"));
    assertEquals(CredentialUtils.getAPIUrlTest(SERVICE_NAME), PERSONALITY_INSIGHTS_URL);
  }
}
