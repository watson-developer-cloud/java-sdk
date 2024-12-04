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
 * ProviderPrivateAuthenticationOAuth2FlowFlowsProviderPrivateAuthenticationOAuth2Password model.
 */
public
class ProviderPrivateAuthenticationOAuth2FlowFlowsProviderPrivateAuthenticationOAuth2PasswordTest {
  final HashMap<String, InputStream> mockStreamMap = TestUtilities.createMockStreamMap();
  final List<FileWithMetadata> mockListFileWithMetadata =
      TestUtilities.creatMockListFileWithMetadata();

  @Test
  public void
      testProviderPrivateAuthenticationOAuth2FlowFlowsProviderPrivateAuthenticationOAuth2Password()
          throws Throwable {
    ProviderPrivateAuthenticationOAuth2PasswordPassword
        providerPrivateAuthenticationOAuth2PasswordPasswordModel =
            new ProviderPrivateAuthenticationOAuth2PasswordPassword.Builder()
                .type("value")
                .value("testString")
                .build();
    assertEquals(providerPrivateAuthenticationOAuth2PasswordPasswordModel.type(), "value");
    assertEquals(providerPrivateAuthenticationOAuth2PasswordPasswordModel.value(), "testString");

    ProviderPrivateAuthenticationOAuth2FlowFlowsProviderPrivateAuthenticationOAuth2Password
        providerPrivateAuthenticationOAuth2FlowFlowsProviderPrivateAuthenticationOAuth2PasswordModel =
            new ProviderPrivateAuthenticationOAuth2FlowFlowsProviderPrivateAuthenticationOAuth2Password
                    .Builder()
                .clientId("testString")
                .clientSecret("testString")
                .accessToken("testString")
                .refreshToken("testString")
                .password(providerPrivateAuthenticationOAuth2PasswordPasswordModel)
                .build();
    assertEquals(
        providerPrivateAuthenticationOAuth2FlowFlowsProviderPrivateAuthenticationOAuth2PasswordModel
            .clientId(),
        "testString");
    assertEquals(
        providerPrivateAuthenticationOAuth2FlowFlowsProviderPrivateAuthenticationOAuth2PasswordModel
            .clientSecret(),
        "testString");
    assertEquals(
        providerPrivateAuthenticationOAuth2FlowFlowsProviderPrivateAuthenticationOAuth2PasswordModel
            .accessToken(),
        "testString");
    assertEquals(
        providerPrivateAuthenticationOAuth2FlowFlowsProviderPrivateAuthenticationOAuth2PasswordModel
            .refreshToken(),
        "testString");
    assertEquals(
        providerPrivateAuthenticationOAuth2FlowFlowsProviderPrivateAuthenticationOAuth2PasswordModel
            .password(),
        providerPrivateAuthenticationOAuth2PasswordPasswordModel);

    String json =
        TestUtilities.serialize(
            providerPrivateAuthenticationOAuth2FlowFlowsProviderPrivateAuthenticationOAuth2PasswordModel);

    ProviderPrivateAuthenticationOAuth2FlowFlowsProviderPrivateAuthenticationOAuth2Password
        providerPrivateAuthenticationOAuth2FlowFlowsProviderPrivateAuthenticationOAuth2PasswordModelNew =
            TestUtilities.deserialize(
                json,
                ProviderPrivateAuthenticationOAuth2FlowFlowsProviderPrivateAuthenticationOAuth2Password
                    .class);
    assertTrue(
        providerPrivateAuthenticationOAuth2FlowFlowsProviderPrivateAuthenticationOAuth2PasswordModelNew
            instanceof
            ProviderPrivateAuthenticationOAuth2FlowFlowsProviderPrivateAuthenticationOAuth2Password);
    assertEquals(
        providerPrivateAuthenticationOAuth2FlowFlowsProviderPrivateAuthenticationOAuth2PasswordModelNew
            .clientId(),
        "testString");
    assertEquals(
        providerPrivateAuthenticationOAuth2FlowFlowsProviderPrivateAuthenticationOAuth2PasswordModelNew
            .clientSecret(),
        "testString");
    assertEquals(
        providerPrivateAuthenticationOAuth2FlowFlowsProviderPrivateAuthenticationOAuth2PasswordModelNew
            .accessToken(),
        "testString");
    assertEquals(
        providerPrivateAuthenticationOAuth2FlowFlowsProviderPrivateAuthenticationOAuth2PasswordModelNew
            .refreshToken(),
        "testString");
    assertEquals(
        providerPrivateAuthenticationOAuth2FlowFlowsProviderPrivateAuthenticationOAuth2PasswordModelNew
            .password()
            .toString(),
        providerPrivateAuthenticationOAuth2PasswordPasswordModel.toString());
  }
}
