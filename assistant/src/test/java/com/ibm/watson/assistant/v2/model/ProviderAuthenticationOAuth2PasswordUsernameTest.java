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

/** Unit test class for the ProviderAuthenticationOAuth2PasswordUsername model. */
public class ProviderAuthenticationOAuth2PasswordUsernameTest {
  final HashMap<String, InputStream> mockStreamMap = TestUtilities.createMockStreamMap();
  final List<FileWithMetadata> mockListFileWithMetadata =
      TestUtilities.creatMockListFileWithMetadata();

  @Test
  public void testProviderAuthenticationOAuth2PasswordUsername() throws Throwable {
    ProviderAuthenticationOAuth2PasswordUsername providerAuthenticationOAuth2PasswordUsernameModel =
        new ProviderAuthenticationOAuth2PasswordUsername.Builder()
            .type("value")
            .value("testString")
            .build();
    assertEquals(providerAuthenticationOAuth2PasswordUsernameModel.type(), "value");
    assertEquals(providerAuthenticationOAuth2PasswordUsernameModel.value(), "testString");

    String json = TestUtilities.serialize(providerAuthenticationOAuth2PasswordUsernameModel);

    ProviderAuthenticationOAuth2PasswordUsername
        providerAuthenticationOAuth2PasswordUsernameModelNew =
            TestUtilities.deserialize(json, ProviderAuthenticationOAuth2PasswordUsername.class);
    assertTrue(
        providerAuthenticationOAuth2PasswordUsernameModelNew
            instanceof ProviderAuthenticationOAuth2PasswordUsername);
    assertEquals(providerAuthenticationOAuth2PasswordUsernameModelNew.type(), "value");
    assertEquals(providerAuthenticationOAuth2PasswordUsernameModelNew.value(), "testString");
  }
}
