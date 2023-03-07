/*
 * (C) Copyright IBM Corp. 2023.
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

/** Unit test class for the AssistantData model. */
public class AssistantDataTest {
  final HashMap<String, InputStream> mockStreamMap = TestUtilities.createMockStreamMap();
  final List<FileWithMetadata> mockListFileWithMetadata =
      TestUtilities.creatMockListFileWithMetadata();

  @Test
  public void testAssistantData() throws Throwable {
    AssistantData assistantDataModel =
        new AssistantData.Builder()
            .name("testString")
            .description("testString")
            .language("testString")
            .build();
    assertEquals(assistantDataModel.name(), "testString");
    assertEquals(assistantDataModel.description(), "testString");
    assertEquals(assistantDataModel.language(), "testString");

    String json = TestUtilities.serialize(assistantDataModel);

    AssistantData assistantDataModelNew = TestUtilities.deserialize(json, AssistantData.class);
    assertTrue(assistantDataModelNew instanceof AssistantData);
    assertEquals(assistantDataModelNew.name(), "testString");
    assertEquals(assistantDataModelNew.description(), "testString");
    assertEquals(assistantDataModelNew.language(), "testString");
  }

  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testAssistantDataError() throws Throwable {
    new AssistantData.Builder().build();
  }
}
