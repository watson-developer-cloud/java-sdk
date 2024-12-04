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
 * Unit test class for the ProviderAuthenticationOAuth2FlowsProviderAuthenticationOAuth2Custom
 * model.
 */
public class ProviderAuthenticationOAuth2FlowsProviderAuthenticationOAuth2CustomTest {
  final HashMap<String, InputStream> mockStreamMap = TestUtilities.createMockStreamMap();
  final List<FileWithMetadata> mockListFileWithMetadata =
      TestUtilities.creatMockListFileWithMetadata();

  @Test
  public void testProviderAuthenticationOAuth2FlowsProviderAuthenticationOAuth2Custom()
      throws Throwable {
    ProviderAuthenticationOAuth2CustomCustomOauth2PropertyParamsCustomOauth2Parameter
        providerAuthenticationOAuth2CustomCustomOauth2PropertyParamsCustomOauth2ParameterModel =
            new ProviderAuthenticationOAuth2CustomCustomOauth2PropertyParamsCustomOauth2Parameter
                    .Builder()
                .type("value")
                .value("testString")
                .build();
    assertEquals(
        providerAuthenticationOAuth2CustomCustomOauth2PropertyParamsCustomOauth2ParameterModel
            .type(),
        "value");
    assertEquals(
        providerAuthenticationOAuth2CustomCustomOauth2PropertyParamsCustomOauth2ParameterModel
            .value(),
        "testString");

    ProviderAuthenticationOAuth2CustomCustomOauth2PropertyParams
        providerAuthenticationOAuth2CustomCustomOauth2PropertyParamsModel =
            new ProviderAuthenticationOAuth2CustomCustomOauth2PropertyParams.Builder()
                .customOauth2Parameter(
                    providerAuthenticationOAuth2CustomCustomOauth2PropertyParamsCustomOauth2ParameterModel)
                .build();
    assertEquals(
        providerAuthenticationOAuth2CustomCustomOauth2PropertyParamsModel.customOauth2Parameter(),
        providerAuthenticationOAuth2CustomCustomOauth2PropertyParamsCustomOauth2ParameterModel);

    ProviderAuthenticationOAuth2CustomCustomOauth2Property
        providerAuthenticationOAuth2CustomCustomOauth2PropertyModel =
            new ProviderAuthenticationOAuth2CustomCustomOauth2Property.Builder()
                .tokenUrl("testString")
                .refreshUrl("testString")
                .clientAuthType("Body")
                .contentType("testString")
                .headerPrefix("testString")
                .grantType("testString")
                .params(providerAuthenticationOAuth2CustomCustomOauth2PropertyParamsModel)
                .build();
    assertEquals(
        providerAuthenticationOAuth2CustomCustomOauth2PropertyModel.tokenUrl(), "testString");
    assertEquals(
        providerAuthenticationOAuth2CustomCustomOauth2PropertyModel.refreshUrl(), "testString");
    assertEquals(
        providerAuthenticationOAuth2CustomCustomOauth2PropertyModel.clientAuthType(), "Body");
    assertEquals(
        providerAuthenticationOAuth2CustomCustomOauth2PropertyModel.contentType(), "testString");
    assertEquals(
        providerAuthenticationOAuth2CustomCustomOauth2PropertyModel.headerPrefix(), "testString");
    assertEquals(
        providerAuthenticationOAuth2CustomCustomOauth2PropertyModel.grantType(), "testString");
    assertEquals(
        providerAuthenticationOAuth2CustomCustomOauth2PropertyModel.params(),
        providerAuthenticationOAuth2CustomCustomOauth2PropertyParamsModel);

    ProviderAuthenticationOAuth2FlowsProviderAuthenticationOAuth2Custom
        providerAuthenticationOAuth2FlowsProviderAuthenticationOAuth2CustomModel =
            new ProviderAuthenticationOAuth2FlowsProviderAuthenticationOAuth2Custom.Builder()
                .customOauth2Property(providerAuthenticationOAuth2CustomCustomOauth2PropertyModel)
                .build();
    assertEquals(
        providerAuthenticationOAuth2FlowsProviderAuthenticationOAuth2CustomModel
            .customOauth2Property(),
        providerAuthenticationOAuth2CustomCustomOauth2PropertyModel);

    String json =
        TestUtilities.serialize(
            providerAuthenticationOAuth2FlowsProviderAuthenticationOAuth2CustomModel);

    ProviderAuthenticationOAuth2FlowsProviderAuthenticationOAuth2Custom
        providerAuthenticationOAuth2FlowsProviderAuthenticationOAuth2CustomModelNew =
            TestUtilities.deserialize(
                json, ProviderAuthenticationOAuth2FlowsProviderAuthenticationOAuth2Custom.class);
    assertTrue(
        providerAuthenticationOAuth2FlowsProviderAuthenticationOAuth2CustomModelNew
            instanceof ProviderAuthenticationOAuth2FlowsProviderAuthenticationOAuth2Custom);
    assertEquals(
        providerAuthenticationOAuth2FlowsProviderAuthenticationOAuth2CustomModelNew
            .customOauth2Property()
            .toString(),
        providerAuthenticationOAuth2CustomCustomOauth2PropertyModel.toString());
  }
}
