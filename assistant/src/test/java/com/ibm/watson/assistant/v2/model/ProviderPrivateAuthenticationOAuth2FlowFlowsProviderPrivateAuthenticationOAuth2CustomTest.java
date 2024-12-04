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
 * ProviderPrivateAuthenticationOAuth2FlowFlowsProviderPrivateAuthenticationOAuth2Custom model.
 */
public
class ProviderPrivateAuthenticationOAuth2FlowFlowsProviderPrivateAuthenticationOAuth2CustomTest {
  final HashMap<String, InputStream> mockStreamMap = TestUtilities.createMockStreamMap();
  final List<FileWithMetadata> mockListFileWithMetadata =
      TestUtilities.creatMockListFileWithMetadata();

  @Test
  public void
      testProviderPrivateAuthenticationOAuth2FlowFlowsProviderPrivateAuthenticationOAuth2Custom()
          throws Throwable {
    ProviderPrivateAuthenticationOAuth2CustomCustomOauth2PropertyCustomSecretsCustomOauth2Secret
        providerPrivateAuthenticationOAuth2CustomCustomOauth2PropertyCustomSecretsCustomOauth2SecretModel =
            new ProviderPrivateAuthenticationOAuth2CustomCustomOauth2PropertyCustomSecretsCustomOauth2Secret
                    .Builder()
                .type("value")
                .value("testString")
                .build();
    assertEquals(
        providerPrivateAuthenticationOAuth2CustomCustomOauth2PropertyCustomSecretsCustomOauth2SecretModel
            .type(),
        "value");
    assertEquals(
        providerPrivateAuthenticationOAuth2CustomCustomOauth2PropertyCustomSecretsCustomOauth2SecretModel
            .value(),
        "testString");

    ProviderPrivateAuthenticationOAuth2CustomCustomOauth2PropertyCustomSecrets
        providerPrivateAuthenticationOAuth2CustomCustomOauth2PropertyCustomSecretsModel =
            new ProviderPrivateAuthenticationOAuth2CustomCustomOauth2PropertyCustomSecrets.Builder()
                .customOauth2Secret(
                    providerPrivateAuthenticationOAuth2CustomCustomOauth2PropertyCustomSecretsCustomOauth2SecretModel)
                .build();
    assertEquals(
        providerPrivateAuthenticationOAuth2CustomCustomOauth2PropertyCustomSecretsModel
            .customOauth2Secret(),
        providerPrivateAuthenticationOAuth2CustomCustomOauth2PropertyCustomSecretsCustomOauth2SecretModel);

    ProviderPrivateAuthenticationOAuth2CustomCustomOauth2Property
        providerPrivateAuthenticationOAuth2CustomCustomOauth2PropertyModel =
            new ProviderPrivateAuthenticationOAuth2CustomCustomOauth2Property.Builder()
                .accessToken("testString")
                .refreshToken("testString")
                .customSecrets(
                    providerPrivateAuthenticationOAuth2CustomCustomOauth2PropertyCustomSecretsModel)
                .build();
    assertEquals(
        providerPrivateAuthenticationOAuth2CustomCustomOauth2PropertyModel.accessToken(),
        "testString");
    assertEquals(
        providerPrivateAuthenticationOAuth2CustomCustomOauth2PropertyModel.refreshToken(),
        "testString");
    assertEquals(
        providerPrivateAuthenticationOAuth2CustomCustomOauth2PropertyModel.customSecrets(),
        providerPrivateAuthenticationOAuth2CustomCustomOauth2PropertyCustomSecretsModel);

    ProviderPrivateAuthenticationOAuth2FlowFlowsProviderPrivateAuthenticationOAuth2Custom
        providerPrivateAuthenticationOAuth2FlowFlowsProviderPrivateAuthenticationOAuth2CustomModel =
            new ProviderPrivateAuthenticationOAuth2FlowFlowsProviderPrivateAuthenticationOAuth2Custom
                    .Builder()
                .customOauth2Property(
                    providerPrivateAuthenticationOAuth2CustomCustomOauth2PropertyModel)
                .build();
    assertEquals(
        providerPrivateAuthenticationOAuth2FlowFlowsProviderPrivateAuthenticationOAuth2CustomModel
            .customOauth2Property(),
        providerPrivateAuthenticationOAuth2CustomCustomOauth2PropertyModel);

    String json =
        TestUtilities.serialize(
            providerPrivateAuthenticationOAuth2FlowFlowsProviderPrivateAuthenticationOAuth2CustomModel);

    ProviderPrivateAuthenticationOAuth2FlowFlowsProviderPrivateAuthenticationOAuth2Custom
        providerPrivateAuthenticationOAuth2FlowFlowsProviderPrivateAuthenticationOAuth2CustomModelNew =
            TestUtilities.deserialize(
                json,
                ProviderPrivateAuthenticationOAuth2FlowFlowsProviderPrivateAuthenticationOAuth2Custom
                    .class);
    assertTrue(
        providerPrivateAuthenticationOAuth2FlowFlowsProviderPrivateAuthenticationOAuth2CustomModelNew
            instanceof
            ProviderPrivateAuthenticationOAuth2FlowFlowsProviderPrivateAuthenticationOAuth2Custom);
    assertEquals(
        providerPrivateAuthenticationOAuth2FlowFlowsProviderPrivateAuthenticationOAuth2CustomModelNew
            .customOauth2Property()
            .toString(),
        providerPrivateAuthenticationOAuth2CustomCustomOauth2PropertyModel.toString());
  }
}
