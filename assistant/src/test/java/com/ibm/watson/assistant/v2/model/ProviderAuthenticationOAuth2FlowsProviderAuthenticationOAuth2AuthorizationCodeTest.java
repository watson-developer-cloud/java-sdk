/*
 * (C) Copyright IBM Corp. 2024.
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

package com.ibm.watson.assistant.v2.model;

import static org.testng.Assert.*;

import com.ibm.cloud.sdk.core.service.model.FileWithMetadata;
import com.ibm.watson.assistant.v2.utils.TestUtilities;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import org.testng.annotations.Test;

/**
 * Unit test class for the
 * ProviderAuthenticationOAuth2FlowsProviderAuthenticationOAuth2AuthorizationCode model.
 */
public class ProviderAuthenticationOAuth2FlowsProviderAuthenticationOAuth2AuthorizationCodeTest {
  final HashMap<String, InputStream> mockStreamMap = TestUtilities.createMockStreamMap();
  final List<FileWithMetadata> mockListFileWithMetadata =
      TestUtilities.creatMockListFileWithMetadata();

  @Test
  public void testProviderAuthenticationOAuth2FlowsProviderAuthenticationOAuth2AuthorizationCode()
      throws Throwable {
    ProviderAuthenticationOAuth2FlowsProviderAuthenticationOAuth2AuthorizationCode
        providerAuthenticationOAuth2FlowsProviderAuthenticationOAuth2AuthorizationCodeModel =
            new ProviderAuthenticationOAuth2FlowsProviderAuthenticationOAuth2AuthorizationCode
                    .Builder()
                .tokenUrl("testString")
                .refreshUrl("testString")
                .clientAuthType("Body")
                .contentType("testString")
                .headerPrefix("testString")
                .authorizationUrl("testString")
                .redirectUri("testString")
                .build();
    assertEquals(
        providerAuthenticationOAuth2FlowsProviderAuthenticationOAuth2AuthorizationCodeModel
            .tokenUrl(),
        "testString");
    assertEquals(
        providerAuthenticationOAuth2FlowsProviderAuthenticationOAuth2AuthorizationCodeModel
            .refreshUrl(),
        "testString");
    assertEquals(
        providerAuthenticationOAuth2FlowsProviderAuthenticationOAuth2AuthorizationCodeModel
            .clientAuthType(),
        "Body");
    assertEquals(
        providerAuthenticationOAuth2FlowsProviderAuthenticationOAuth2AuthorizationCodeModel
            .contentType(),
        "testString");
    assertEquals(
        providerAuthenticationOAuth2FlowsProviderAuthenticationOAuth2AuthorizationCodeModel
            .headerPrefix(),
        "testString");
    assertEquals(
        providerAuthenticationOAuth2FlowsProviderAuthenticationOAuth2AuthorizationCodeModel
            .authorizationUrl(),
        "testString");
    assertEquals(
        providerAuthenticationOAuth2FlowsProviderAuthenticationOAuth2AuthorizationCodeModel
            .redirectUri(),
        "testString");

    String json =
        TestUtilities.serialize(
            providerAuthenticationOAuth2FlowsProviderAuthenticationOAuth2AuthorizationCodeModel);

    ProviderAuthenticationOAuth2FlowsProviderAuthenticationOAuth2AuthorizationCode
        providerAuthenticationOAuth2FlowsProviderAuthenticationOAuth2AuthorizationCodeModelNew =
            TestUtilities.deserialize(
                json,
                ProviderAuthenticationOAuth2FlowsProviderAuthenticationOAuth2AuthorizationCode
                    .class);
    assertTrue(
        providerAuthenticationOAuth2FlowsProviderAuthenticationOAuth2AuthorizationCodeModelNew
            instanceof
            ProviderAuthenticationOAuth2FlowsProviderAuthenticationOAuth2AuthorizationCode);
    assertEquals(
        providerAuthenticationOAuth2FlowsProviderAuthenticationOAuth2AuthorizationCodeModelNew
            .tokenUrl(),
        "testString");
    assertEquals(
        providerAuthenticationOAuth2FlowsProviderAuthenticationOAuth2AuthorizationCodeModelNew
            .refreshUrl(),
        "testString");
    assertEquals(
        providerAuthenticationOAuth2FlowsProviderAuthenticationOAuth2AuthorizationCodeModelNew
            .clientAuthType(),
        "Body");
    assertEquals(
        providerAuthenticationOAuth2FlowsProviderAuthenticationOAuth2AuthorizationCodeModelNew
            .contentType(),
        "testString");
    assertEquals(
        providerAuthenticationOAuth2FlowsProviderAuthenticationOAuth2AuthorizationCodeModelNew
            .headerPrefix(),
        "testString");
    assertEquals(
        providerAuthenticationOAuth2FlowsProviderAuthenticationOAuth2AuthorizationCodeModelNew
            .authorizationUrl(),
        "testString");
    assertEquals(
        providerAuthenticationOAuth2FlowsProviderAuthenticationOAuth2AuthorizationCodeModelNew
            .redirectUri(),
        "testString");
  }
}
