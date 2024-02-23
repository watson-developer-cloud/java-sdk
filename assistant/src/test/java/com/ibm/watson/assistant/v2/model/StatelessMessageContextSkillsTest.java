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

/** Unit test class for the StatelessMessageContextSkills model. */
public class StatelessMessageContextSkillsTest {
  final HashMap<String, InputStream> mockStreamMap = TestUtilities.createMockStreamMap();
  final List<FileWithMetadata> mockListFileWithMetadata =
      TestUtilities.creatMockListFileWithMetadata();

  @Test
  public void testStatelessMessageContextSkills() throws Throwable {
    MessageContextSkillSystem messageContextSkillSystemModel =
        new MessageContextSkillSystem.Builder()
            .state("testString")
            .add("foo", "testString")
            .build();
    assertEquals(messageContextSkillSystemModel.getState(), "testString");
    assertEquals(messageContextSkillSystemModel.get("foo"), "testString");

    MessageContextDialogSkill messageContextDialogSkillModel =
        new MessageContextDialogSkill.Builder()
            .userDefined(java.util.Collections.singletonMap("anyKey", "anyValue"))
            .system(messageContextSkillSystemModel)
            .build();
    assertEquals(
        messageContextDialogSkillModel.userDefined(),
        java.util.Collections.singletonMap("anyKey", "anyValue"));
    assertEquals(messageContextDialogSkillModel.system(), messageContextSkillSystemModel);

    StatelessMessageContextSkillsActionsSkill statelessMessageContextSkillsActionsSkillModel =
        new StatelessMessageContextSkillsActionsSkill.Builder()
            .userDefined(java.util.Collections.singletonMap("anyKey", "anyValue"))
            .system(messageContextSkillSystemModel)
            .actionVariables(java.util.Collections.singletonMap("anyKey", "anyValue"))
            .skillVariables(java.util.Collections.singletonMap("anyKey", "anyValue"))
            .privateActionVariables(java.util.Collections.singletonMap("anyKey", "anyValue"))
            .privateSkillVariables(java.util.Collections.singletonMap("anyKey", "anyValue"))
            .build();
    assertEquals(
        statelessMessageContextSkillsActionsSkillModel.userDefined(),
        java.util.Collections.singletonMap("anyKey", "anyValue"));
    assertEquals(
        statelessMessageContextSkillsActionsSkillModel.system(), messageContextSkillSystemModel);
    assertEquals(
        statelessMessageContextSkillsActionsSkillModel.actionVariables(),
        java.util.Collections.singletonMap("anyKey", "anyValue"));
    assertEquals(
        statelessMessageContextSkillsActionsSkillModel.skillVariables(),
        java.util.Collections.singletonMap("anyKey", "anyValue"));
    assertEquals(
        statelessMessageContextSkillsActionsSkillModel.privateActionVariables(),
        java.util.Collections.singletonMap("anyKey", "anyValue"));
    assertEquals(
        statelessMessageContextSkillsActionsSkillModel.privateSkillVariables(),
        java.util.Collections.singletonMap("anyKey", "anyValue"));

    StatelessMessageContextSkills statelessMessageContextSkillsModel =
        new StatelessMessageContextSkills.Builder()
            .mainSkill(messageContextDialogSkillModel)
            .actionsSkill(statelessMessageContextSkillsActionsSkillModel)
            .build();
    assertEquals(statelessMessageContextSkillsModel.mainSkill(), messageContextDialogSkillModel);
    assertEquals(
        statelessMessageContextSkillsModel.actionsSkill(),
        statelessMessageContextSkillsActionsSkillModel);

    String json = TestUtilities.serialize(statelessMessageContextSkillsModel);

    StatelessMessageContextSkills statelessMessageContextSkillsModelNew =
        TestUtilities.deserialize(json, StatelessMessageContextSkills.class);
    assertTrue(statelessMessageContextSkillsModelNew instanceof StatelessMessageContextSkills);
    assertEquals(
        statelessMessageContextSkillsModelNew.mainSkill().toString(),
        messageContextDialogSkillModel.toString());
    assertEquals(
        statelessMessageContextSkillsModelNew.actionsSkill().toString(),
        statelessMessageContextSkillsActionsSkillModel.toString());
  }
}
