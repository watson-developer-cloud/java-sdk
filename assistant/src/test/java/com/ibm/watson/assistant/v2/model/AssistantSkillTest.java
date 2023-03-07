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

/** Unit test class for the AssistantSkill model. */
public class AssistantSkillTest {
  final HashMap<String, InputStream> mockStreamMap = TestUtilities.createMockStreamMap();
  final List<FileWithMetadata> mockListFileWithMetadata =
      TestUtilities.creatMockListFileWithMetadata();

  @Test
  public void testAssistantSkill() throws Throwable {
    AssistantSkill assistantSkillModel =
        new AssistantSkill.Builder().skillId("testString").type("dialog").build();
    assertEquals(assistantSkillModel.skillId(), "testString");
    assertEquals(assistantSkillModel.type(), "dialog");

    String json = TestUtilities.serialize(assistantSkillModel);

    AssistantSkill assistantSkillModelNew = TestUtilities.deserialize(json, AssistantSkill.class);
    assertTrue(assistantSkillModelNew instanceof AssistantSkill);
    assertEquals(assistantSkillModelNew.skillId(), "testString");
    assertEquals(assistantSkillModelNew.type(), "dialog");
  }

  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testAssistantSkillError() throws Throwable {
    new AssistantSkill.Builder().build();
  }
}
