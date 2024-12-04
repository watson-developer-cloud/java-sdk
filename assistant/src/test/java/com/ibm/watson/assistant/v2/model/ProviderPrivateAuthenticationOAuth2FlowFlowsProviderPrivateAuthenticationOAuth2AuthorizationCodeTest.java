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
 * ProviderPrivateAuthenticationOAuth2FlowFlowsProviderPrivateAuthenticationOAuth2AuthorizationCode
 * model.
 */
public
class ProviderPrivateAuthenticationOAuth2FlowFlowsProviderPrivateAuthenticationOAuth2AuthorizationCodeTest {
  final HashMap<String, InputStream> mockStreamMap = TestUtilities.createMockStreamMap();
  final List<FileWithMetadata> mockListFileWithMetadata =
      TestUtilities.creatMockListFileWithMetadata();

  @Test
  public void
      testProviderPrivateAuthenticationOAuth2FlowFlowsProviderPrivateAuthenticationOAuth2AuthorizationCode()
          throws Throwable {
    ProviderPrivateAuthenticationOAuth2FlowFlowsProviderPrivateAuthenticationOAuth2AuthorizationCode
        providerPrivateAuthenticationOAuth2FlowFlowsProviderPrivateAuthenticationOAuth2AuthorizationCodeModel =
            new ProviderPrivateAuthenticationOAuth2FlowFlowsProviderPrivateAuthenticationOAuth2AuthorizationCode
                    .Builder()
                .clientId("testString")
                .clientSecret("testString")
                .accessToken("testString")
                .refreshToken("testString")
                .authorizationCode("testString")
                .build();
    assertEquals(
        providerPrivateAuthenticationOAuth2FlowFlowsProviderPrivateAuthenticationOAuth2AuthorizationCodeModel
            .clientId(),
        "testString");
    assertEquals(
        providerPrivateAuthenticationOAuth2FlowFlowsProviderPrivateAuthenticationOAuth2AuthorizationCodeModel
            .clientSecret(),
        "testString");
    assertEquals(
        providerPrivateAuthenticationOAuth2FlowFlowsProviderPrivateAuthenticationOAuth2AuthorizationCodeModel
            .accessToken(),
        "testString");
    assertEquals(
        providerPrivateAuthenticationOAuth2FlowFlowsProviderPrivateAuthenticationOAuth2AuthorizationCodeModel
            .refreshToken(),
        "testString");
    assertEquals(
        providerPrivateAuthenticationOAuth2FlowFlowsProviderPrivateAuthenticationOAuth2AuthorizationCodeModel
            .authorizationCode(),
        "testString");

    String json =
        TestUtilities.serialize(
            providerPrivateAuthenticationOAuth2FlowFlowsProviderPrivateAuthenticationOAuth2AuthorizationCodeModel);

    ProviderPrivateAuthenticationOAuth2FlowFlowsProviderPrivateAuthenticationOAuth2AuthorizationCode
        providerPrivateAuthenticationOAuth2FlowFlowsProviderPrivateAuthenticationOAuth2AuthorizationCodeModelNew =
            TestUtilities.deserialize(
                json,
                ProviderPrivateAuthenticationOAuth2FlowFlowsProviderPrivateAuthenticationOAuth2AuthorizationCode
                    .class);
    assertTrue(
        providerPrivateAuthenticationOAuth2FlowFlowsProviderPrivateAuthenticationOAuth2AuthorizationCodeModelNew
            instanceof
            ProviderPrivateAuthenticationOAuth2FlowFlowsProviderPrivateAuthenticationOAuth2AuthorizationCode);
    assertEquals(
        providerPrivateAuthenticationOAuth2FlowFlowsProviderPrivateAuthenticationOAuth2AuthorizationCodeModelNew
            .clientId(),
        "testString");
    assertEquals(
        providerPrivateAuthenticationOAuth2FlowFlowsProviderPrivateAuthenticationOAuth2AuthorizationCodeModelNew
            .clientSecret(),
        "testString");
    assertEquals(
        providerPrivateAuthenticationOAuth2FlowFlowsProviderPrivateAuthenticationOAuth2AuthorizationCodeModelNew
            .accessToken(),
        "testString");
    assertEquals(
        providerPrivateAuthenticationOAuth2FlowFlowsProviderPrivateAuthenticationOAuth2AuthorizationCodeModelNew
            .refreshToken(),
        "testString");
    assertEquals(
        providerPrivateAuthenticationOAuth2FlowFlowsProviderPrivateAuthenticationOAuth2AuthorizationCodeModelNew
            .authorizationCode(),
        "testString");
  }
}
