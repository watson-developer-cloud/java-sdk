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

/** Unit test class for the MessageContextSkills model. */
public class MessageContextSkillsTest {
  final HashMap<String, InputStream> mockStreamMap = TestUtilities.createMockStreamMap();
  final List<FileWithMetadata> mockListFileWithMetadata =
      TestUtilities.creatMockListFileWithMetadata();

  @Test
  public void testMessageContextSkills() throws Throwable {
    MessageContextSkillSystem messageContextSkillSystemModel =
        new MessageContextSkillSystem.Builder()
            .state("testString")
            .add("foo", "testString")
            .build();
    assertEquals(messageContextSkillSystemModel.getState(), "testString");
    assertEquals(messageContextSkillSystemModel.get("foo"), "testString");

    MessageContextSkillDialog messageContextSkillDialogModel =
        new MessageContextSkillDialog.Builder()
            .userDefined(java.util.Collections.singletonMap("anyKey", "anyValue"))
            .system(messageContextSkillSystemModel)
            .build();
    assertEquals(
        messageContextSkillDialogModel.userDefined(),
        java.util.Collections.singletonMap("anyKey", "anyValue"));
    assertEquals(messageContextSkillDialogModel.system(), messageContextSkillSystemModel);

    MessageContextSkillAction messageContextSkillActionModel =
        new MessageContextSkillAction.Builder()
            .userDefined(java.util.Collections.singletonMap("anyKey", "anyValue"))
            .system(messageContextSkillSystemModel)
            .actionVariables(java.util.Collections.singletonMap("anyKey", "anyValue"))
            .skillVariables(java.util.Collections.singletonMap("anyKey", "anyValue"))
            .build();
    assertEquals(
        messageContextSkillActionModel.userDefined(),
        java.util.Collections.singletonMap("anyKey", "anyValue"));
    assertEquals(messageContextSkillActionModel.system(), messageContextSkillSystemModel);
    assertEquals(
        messageContextSkillActionModel.actionVariables(),
        java.util.Collections.singletonMap("anyKey", "anyValue"));
    assertEquals(
        messageContextSkillActionModel.skillVariables(),
        java.util.Collections.singletonMap("anyKey", "anyValue"));

    MessageContextSkills messageContextSkillsModel =
        new MessageContextSkills.Builder()
            .mainSkill(messageContextSkillDialogModel)
            .actionsSkill(messageContextSkillActionModel)
            .build();
    assertEquals(messageContextSkillsModel.mainSkill(), messageContextSkillDialogModel);
    assertEquals(messageContextSkillsModel.actionsSkill(), messageContextSkillActionModel);

    String json = TestUtilities.serialize(messageContextSkillsModel);

    MessageContextSkills messageContextSkillsModelNew =
        TestUtilities.deserialize(json, MessageContextSkills.class);
    assertTrue(messageContextSkillsModelNew instanceof MessageContextSkills);
    assertEquals(
        messageContextSkillsModelNew.mainSkill().toString(),
        messageContextSkillDialogModel.toString());
    assertEquals(
        messageContextSkillsModelNew.actionsSkill().toString(),
        messageContextSkillActionModel.toString());
  }
}
