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

/** Unit test class for the Assistant model. */
public class AssistantTest {
  final HashMap<String, InputStream> mockStreamMap = TestUtilities.createMockStreamMap();
  final List<FileWithMetadata> mockListFileWithMetadata =
      TestUtilities.creatMockListFileWithMetadata();

  @Test
  public void testAssistant() throws Throwable {
    Assistant assistantModel =
        new Assistant.Builder()
            .name("testString")
            .description("testString")
            .language("testString")
            .build();
    assertEquals(assistantModel.name(), "testString");
    assertEquals(assistantModel.description(), "testString");
    assertEquals(assistantModel.language(), "testString");

    String json = TestUtilities.serialize(assistantModel);

    Assistant assistantModelNew = TestUtilities.deserialize(json, Assistant.class);
    assertTrue(assistantModelNew instanceof Assistant);
    assertEquals(assistantModelNew.name(), "testString");
    assertEquals(assistantModelNew.description(), "testString");
    assertEquals(assistantModelNew.language(), "testString");
  }

  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testAssistantError() throws Throwable {
    new Assistant.Builder().build();
  }
}
