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

/** Unit test class for the ProviderPrivateAuthenticationOAuth2PasswordPassword model. */
public class ProviderPrivateAuthenticationOAuth2PasswordPasswordTest {
  final HashMap<String, InputStream> mockStreamMap = TestUtilities.createMockStreamMap();
  final List<FileWithMetadata> mockListFileWithMetadata =
      TestUtilities.creatMockListFileWithMetadata();

  @Test
  public void testProviderPrivateAuthenticationOAuth2PasswordPassword() throws Throwable {
    ProviderPrivateAuthenticationOAuth2PasswordPassword
        providerPrivateAuthenticationOAuth2PasswordPasswordModel =
            new ProviderPrivateAuthenticationOAuth2PasswordPassword.Builder()
                .type("value")
                .value("testString")
                .build();
    assertEquals(providerPrivateAuthenticationOAuth2PasswordPasswordModel.type(), "value");
    assertEquals(providerPrivateAuthenticationOAuth2PasswordPasswordModel.value(), "testString");

    String json = TestUtilities.serialize(providerPrivateAuthenticationOAuth2PasswordPasswordModel);

    ProviderPrivateAuthenticationOAuth2PasswordPassword
        providerPrivateAuthenticationOAuth2PasswordPasswordModelNew =
            TestUtilities.deserialize(
                json, ProviderPrivateAuthenticationOAuth2PasswordPassword.class);
    assertTrue(
        providerPrivateAuthenticationOAuth2PasswordPasswordModelNew
            instanceof ProviderPrivateAuthenticationOAuth2PasswordPassword);
    assertEquals(providerPrivateAuthenticationOAuth2PasswordPasswordModelNew.type(), "value");
    assertEquals(providerPrivateAuthenticationOAuth2PasswordPasswordModelNew.value(), "testString");
  }
}
