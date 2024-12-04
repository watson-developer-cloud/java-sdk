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
 * Unit test class for the ProviderAuthenticationOAuth2FlowsProviderAuthenticationOAuth2Password
 * model.
 */
public class ProviderAuthenticationOAuth2FlowsProviderAuthenticationOAuth2PasswordTest {
  final HashMap<String, InputStream> mockStreamMap = TestUtilities.createMockStreamMap();
  final List<FileWithMetadata> mockListFileWithMetadata =
      TestUtilities.creatMockListFileWithMetadata();

  @Test
  public void testProviderAuthenticationOAuth2FlowsProviderAuthenticationOAuth2Password()
      throws Throwable {
    ProviderAuthenticationOAuth2PasswordUsername providerAuthenticationOAuth2PasswordUsernameModel =
        new ProviderAuthenticationOAuth2PasswordUsername.Builder()
            .type("value")
            .value("testString")
            .build();
    assertEquals(providerAuthenticationOAuth2PasswordUsernameModel.type(), "value");
    assertEquals(providerAuthenticationOAuth2PasswordUsernameModel.value(), "testString");

    ProviderAuthenticationOAuth2FlowsProviderAuthenticationOAuth2Password
        providerAuthenticationOAuth2FlowsProviderAuthenticationOAuth2PasswordModel =
            new ProviderAuthenticationOAuth2FlowsProviderAuthenticationOAuth2Password.Builder()
                .tokenUrl("testString")
                .refreshUrl("testString")
                .clientAuthType("Body")
                .contentType("testString")
                .headerPrefix("testString")
                .username(providerAuthenticationOAuth2PasswordUsernameModel)
                .build();
    assertEquals(
        providerAuthenticationOAuth2FlowsProviderAuthenticationOAuth2PasswordModel.tokenUrl(),
        "testString");
    assertEquals(
        providerAuthenticationOAuth2FlowsProviderAuthenticationOAuth2PasswordModel.refreshUrl(),
        "testString");
    assertEquals(
        providerAuthenticationOAuth2FlowsProviderAuthenticationOAuth2PasswordModel.clientAuthType(),
        "Body");
    assertEquals(
        providerAuthenticationOAuth2FlowsProviderAuthenticationOAuth2PasswordModel.contentType(),
        "testString");
    assertEquals(
        providerAuthenticationOAuth2FlowsProviderAuthenticationOAuth2PasswordModel.headerPrefix(),
        "testString");
    assertEquals(
        providerAuthenticationOAuth2FlowsProviderAuthenticationOAuth2PasswordModel.username(),
        providerAuthenticationOAuth2PasswordUsernameModel);

    String json =
        TestUtilities.serialize(
            providerAuthenticationOAuth2FlowsProviderAuthenticationOAuth2PasswordModel);

    ProviderAuthenticationOAuth2FlowsProviderAuthenticationOAuth2Password
        providerAuthenticationOAuth2FlowsProviderAuthenticationOAuth2PasswordModelNew =
            TestUtilities.deserialize(
                json, ProviderAuthenticationOAuth2FlowsProviderAuthenticationOAuth2Password.class);
    assertTrue(
        providerAuthenticationOAuth2FlowsProviderAuthenticationOAuth2PasswordModelNew
            instanceof ProviderAuthenticationOAuth2FlowsProviderAuthenticationOAuth2Password);
    assertEquals(
        providerAuthenticationOAuth2FlowsProviderAuthenticationOAuth2PasswordModelNew.tokenUrl(),
        "testString");
    assertEquals(
        providerAuthenticationOAuth2FlowsProviderAuthenticationOAuth2PasswordModelNew.refreshUrl(),
        "testString");
    assertEquals(
        providerAuthenticationOAuth2FlowsProviderAuthenticationOAuth2PasswordModelNew
            .clientAuthType(),
        "Body");
    assertEquals(
        providerAuthenticationOAuth2FlowsProviderAuthenticationOAuth2PasswordModelNew.contentType(),
        "testString");
    assertEquals(
        providerAuthenticationOAuth2FlowsProviderAuthenticationOAuth2PasswordModelNew
            .headerPrefix(),
        "testString");
    assertEquals(
        providerAuthenticationOAuth2FlowsProviderAuthenticationOAuth2PasswordModelNew
            .username()
            .toString(),
        providerAuthenticationOAuth2PasswordUsernameModel.toString());
  }
}
