/*
 * (C) Copyright IBM Corp. 2020.
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

/** Unit test class for the MessageContextSkillSystem model. */
public class MessageContextSkillSystemTest {
  final HashMap<String, InputStream> mockStreamMap = TestUtilities.createMockStreamMap();
  final List<FileWithMetadata> mockListFileWithMetadata =
      TestUtilities.creatMockListFileWithMetadata();

  @Test
  public void testMessageContextSkillSystem() throws Throwable {
    MessageContextSkillSystem messageContextSkillSystemModel =
        new MessageContextSkillSystem.Builder()
            .state("testString")
            .add("foo", "testString")
            .build();
    assertEquals(messageContextSkillSystemModel.getState(), "testString");
    assertEquals(messageContextSkillSystemModel.get("foo"), "testString");

    String json = TestUtilities.serialize(messageContextSkillSystemModel);

    MessageContextSkillSystem messageContextSkillSystemModelNew =
        TestUtilities.deserialize(json, MessageContextSkillSystem.class);
    assertTrue(messageContextSkillSystemModelNew instanceof MessageContextSkillSystem);
    assertEquals(messageContextSkillSystemModelNew.getState(), "testString");
    assertEquals(messageContextSkillSystemModelNew.get("foo"), "testString");
  }
}
