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
 * ProviderPrivateAuthenticationOAuth2FlowFlowsProviderPrivateAuthenticationOAuth2ClientCredentials
 * model.
 */
public
class ProviderPrivateAuthenticationOAuth2FlowFlowsProviderPrivateAuthenticationOAuth2ClientCredentialsTest {
  final HashMap<String, InputStream> mockStreamMap = TestUtilities.createMockStreamMap();
  final List<FileWithMetadata> mockListFileWithMetadata =
      TestUtilities.creatMockListFileWithMetadata();

  @Test
  public void
      testProviderPrivateAuthenticationOAuth2FlowFlowsProviderPrivateAuthenticationOAuth2ClientCredentials()
          throws Throwable {
    ProviderPrivateAuthenticationOAuth2FlowFlowsProviderPrivateAuthenticationOAuth2ClientCredentials
        providerPrivateAuthenticationOAuth2FlowFlowsProviderPrivateAuthenticationOAuth2ClientCredentialsModel =
            new ProviderPrivateAuthenticationOAuth2FlowFlowsProviderPrivateAuthenticationOAuth2ClientCredentials
                    .Builder()
                .clientId("testString")
                .clientSecret("testString")
                .accessToken("testString")
                .refreshToken("testString")
                .build();
    assertEquals(
        providerPrivateAuthenticationOAuth2FlowFlowsProviderPrivateAuthenticationOAuth2ClientCredentialsModel
            .clientId(),
        "testString");
    assertEquals(
        providerPrivateAuthenticationOAuth2FlowFlowsProviderPrivateAuthenticationOAuth2ClientCredentialsModel
            .clientSecret(),
        "testString");
    assertEquals(
        providerPrivateAuthenticationOAuth2FlowFlowsProviderPrivateAuthenticationOAuth2ClientCredentialsModel
            .accessToken(),
        "testString");
    assertEquals(
        providerPrivateAuthenticationOAuth2FlowFlowsProviderPrivateAuthenticationOAuth2ClientCredentialsModel
            .refreshToken(),
        "testString");

    String json =
        TestUtilities.serialize(
            providerPrivateAuthenticationOAuth2FlowFlowsProviderPrivateAuthenticationOAuth2ClientCredentialsModel);

    ProviderPrivateAuthenticationOAuth2FlowFlowsProviderPrivateAuthenticationOAuth2ClientCredentials
        providerPrivateAuthenticationOAuth2FlowFlowsProviderPrivateAuthenticationOAuth2ClientCredentialsModelNew =
            TestUtilities.deserialize(
                json,
                ProviderPrivateAuthenticationOAuth2FlowFlowsProviderPrivateAuthenticationOAuth2ClientCredentials
                    .class);
    assertTrue(
        providerPrivateAuthenticationOAuth2FlowFlowsProviderPrivateAuthenticationOAuth2ClientCredentialsModelNew
            instanceof
            ProviderPrivateAuthenticationOAuth2FlowFlowsProviderPrivateAuthenticationOAuth2ClientCredentials);
    assertEquals(
        providerPrivateAuthenticationOAuth2FlowFlowsProviderPrivateAuthenticationOAuth2ClientCredentialsModelNew
            .clientId(),
        "testString");
    assertEquals(
        providerPrivateAuthenticationOAuth2FlowFlowsProviderPrivateAuthenticationOAuth2ClientCredentialsModelNew
            .clientSecret(),
        "testString");
    assertEquals(
        providerPrivateAuthenticationOAuth2FlowFlowsProviderPrivateAuthenticationOAuth2ClientCredentialsModelNew
            .accessToken(),
        "testString");
    assertEquals(
        providerPrivateAuthenticationOAuth2FlowFlowsProviderPrivateAuthenticationOAuth2ClientCredentialsModelNew
            .refreshToken(),
        "testString");
  }
}
