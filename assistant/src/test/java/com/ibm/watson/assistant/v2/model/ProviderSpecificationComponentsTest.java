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

/** Unit test class for the ProviderSpecificationComponents model. */
public class ProviderSpecificationComponentsTest {
  final HashMap<String, InputStream> mockStreamMap = TestUtilities.createMockStreamMap();
  final List<FileWithMetadata> mockListFileWithMetadata =
      TestUtilities.creatMockListFileWithMetadata();

  @Test
  public void testProviderSpecificationComponents() throws Throwable {
    ProviderAuthenticationTypeAndValue providerAuthenticationTypeAndValueModel =
        new ProviderAuthenticationTypeAndValue.Builder().type("value").value("testString").build();
    assertEquals(providerAuthenticationTypeAndValueModel.type(), "value");
    assertEquals(providerAuthenticationTypeAndValueModel.value(), "testString");

    ProviderSpecificationComponentsSecuritySchemesBasic
        providerSpecificationComponentsSecuritySchemesBasicModel =
            new ProviderSpecificationComponentsSecuritySchemesBasic.Builder()
                .username(providerAuthenticationTypeAndValueModel)
                .build();
    assertEquals(
        providerSpecificationComponentsSecuritySchemesBasicModel.username(),
        providerAuthenticationTypeAndValueModel);

    ProviderAuthenticationOAuth2PasswordUsername providerAuthenticationOAuth2PasswordUsernameModel =
        new ProviderAuthenticationOAuth2PasswordUsername.Builder()
            .type("value")
            .value("testString")
            .build();
    assertEquals(providerAuthenticationOAuth2PasswordUsernameModel.type(), "value");
    assertEquals(providerAuthenticationOAuth2PasswordUsernameModel.value(), "testString");

    ProviderAuthenticationOAuth2FlowsProviderAuthenticationOAuth2Password
        providerAuthenticationOAuth2FlowsModel =
            new ProviderAuthenticationOAuth2FlowsProviderAuthenticationOAuth2Password.Builder()
                .tokenUrl("testString")
                .refreshUrl("testString")
                .clientAuthType("Body")
                .contentType("testString")
                .headerPrefix("testString")
                .username(providerAuthenticationOAuth2PasswordUsernameModel)
                .build();
    assertEquals(providerAuthenticationOAuth2FlowsModel.tokenUrl(), "testString");
    assertEquals(providerAuthenticationOAuth2FlowsModel.refreshUrl(), "testString");
    assertEquals(providerAuthenticationOAuth2FlowsModel.clientAuthType(), "Body");
    assertEquals(providerAuthenticationOAuth2FlowsModel.contentType(), "testString");
    assertEquals(providerAuthenticationOAuth2FlowsModel.headerPrefix(), "testString");
    assertEquals(
        providerAuthenticationOAuth2FlowsModel.username(),
        providerAuthenticationOAuth2PasswordUsernameModel);

    ProviderAuthenticationOAuth2 providerAuthenticationOAuth2Model =
        new ProviderAuthenticationOAuth2.Builder()
            .preferredFlow("password")
            .flows(providerAuthenticationOAuth2FlowsModel)
            .build();
    assertEquals(providerAuthenticationOAuth2Model.preferredFlow(), "password");
    assertEquals(providerAuthenticationOAuth2Model.flows(), providerAuthenticationOAuth2FlowsModel);

    ProviderSpecificationComponentsSecuritySchemes
        providerSpecificationComponentsSecuritySchemesModel =
            new ProviderSpecificationComponentsSecuritySchemes.Builder()
                .authenticationMethod("basic")
                .basic(providerSpecificationComponentsSecuritySchemesBasicModel)
                .oauth2(providerAuthenticationOAuth2Model)
                .build();
    assertEquals(
        providerSpecificationComponentsSecuritySchemesModel.authenticationMethod(), "basic");
    assertEquals(
        providerSpecificationComponentsSecuritySchemesModel.basic(),
        providerSpecificationComponentsSecuritySchemesBasicModel);
    assertEquals(
        providerSpecificationComponentsSecuritySchemesModel.oauth2(),
        providerAuthenticationOAuth2Model);

    ProviderSpecificationComponents providerSpecificationComponentsModel =
        new ProviderSpecificationComponents.Builder()
            .securitySchemes(providerSpecificationComponentsSecuritySchemesModel)
            .build();
    assertEquals(
        providerSpecificationComponentsModel.securitySchemes(),
        providerSpecificationComponentsSecuritySchemesModel);

    String json = TestUtilities.serialize(providerSpecificationComponentsModel);

    ProviderSpecificationComponents providerSpecificationComponentsModelNew =
        TestUtilities.deserialize(json, ProviderSpecificationComponents.class);
    assertTrue(providerSpecificationComponentsModelNew instanceof ProviderSpecificationComponents);
    assertEquals(
        providerSpecificationComponentsModelNew.securitySchemes().toString(),
        providerSpecificationComponentsSecuritySchemesModel.toString());
  }
}
