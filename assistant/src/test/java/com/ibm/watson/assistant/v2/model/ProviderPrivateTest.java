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

/** Unit test class for the ProviderPrivate model. */
public class ProviderPrivateTest {
  final HashMap<String, InputStream> mockStreamMap = TestUtilities.createMockStreamMap();
  final List<FileWithMetadata> mockListFileWithMetadata =
      TestUtilities.creatMockListFileWithMetadata();

  @Test
  public void testProviderPrivate() throws Throwable {
    ProviderAuthenticationTypeAndValue providerAuthenticationTypeAndValueModel =
        new ProviderAuthenticationTypeAndValue.Builder().type("value").value("testString").build();
    assertEquals(providerAuthenticationTypeAndValueModel.type(), "value");
    assertEquals(providerAuthenticationTypeAndValueModel.value(), "testString");

    ProviderPrivateAuthenticationBearerFlow providerPrivateAuthenticationModel =
        new ProviderPrivateAuthenticationBearerFlow.Builder()
            .token(providerAuthenticationTypeAndValueModel)
            .build();
    assertEquals(
        providerPrivateAuthenticationModel.token(), providerAuthenticationTypeAndValueModel);

    ProviderPrivate providerPrivateModel =
        new ProviderPrivate.Builder().authentication(providerPrivateAuthenticationModel).build();
    assertEquals(providerPrivateModel.authentication(), providerPrivateAuthenticationModel);

    String json = TestUtilities.serialize(providerPrivateModel);

    ProviderPrivate providerPrivateModelNew =
        TestUtilities.deserialize(json, ProviderPrivate.class);
    assertTrue(providerPrivateModelNew instanceof ProviderPrivate);
    assertEquals(
        providerPrivateModelNew.authentication().toString(),
        providerPrivateAuthenticationModel.toString());
  }

  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testProviderPrivateError() throws Throwable {
    new ProviderPrivate.Builder().build();
  }
}
