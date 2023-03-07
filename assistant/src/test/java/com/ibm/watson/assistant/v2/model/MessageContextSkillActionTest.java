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

/** Unit test class for the MessageContextSkillAction model. */
public class MessageContextSkillActionTest {
  final HashMap<String, InputStream> mockStreamMap = TestUtilities.createMockStreamMap();
  final List<FileWithMetadata> mockListFileWithMetadata =
      TestUtilities.creatMockListFileWithMetadata();

  @Test
  public void testMessageContextSkillAction() throws Throwable {
    MessageContextSkillSystem messageContextSkillSystemModel =
        new MessageContextSkillSystem.Builder()
            .state("testString")
            .add("foo", "testString")
            .build();
    assertEquals(messageContextSkillSystemModel.getState(), "testString");
    assertEquals(messageContextSkillSystemModel.get("foo"), "testString");

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

    String json = TestUtilities.serialize(messageContextSkillActionModel);

    MessageContextSkillAction messageContextSkillActionModelNew =
        TestUtilities.deserialize(json, MessageContextSkillAction.class);
    assertTrue(messageContextSkillActionModelNew instanceof MessageContextSkillAction);
    assertEquals(
        messageContextSkillActionModelNew.userDefined().toString(),
        java.util.Collections.singletonMap("anyKey", "anyValue").toString());
    assertEquals(
        messageContextSkillActionModelNew.system().toString(),
        messageContextSkillSystemModel.toString());
    assertEquals(
        messageContextSkillActionModelNew.actionVariables().toString(),
        java.util.Collections.singletonMap("anyKey", "anyValue").toString());
    assertEquals(
        messageContextSkillActionModelNew.skillVariables().toString(),
        java.util.Collections.singletonMap("anyKey", "anyValue").toString());
  }
}
