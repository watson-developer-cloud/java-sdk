/*
 * (C) Copyright IBM Corp. 2021.
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

/** Unit test class for the MessageContextStateless model. */
public class MessageContextStatelessTest {
  final HashMap<String, InputStream> mockStreamMap = TestUtilities.createMockStreamMap();
  final List<FileWithMetadata> mockListFileWithMetadata =
      TestUtilities.creatMockListFileWithMetadata();

  @Test
  public void testMessageContextStateless() throws Throwable {
    MessageContextGlobalSystem messageContextGlobalSystemModel =
        new MessageContextGlobalSystem.Builder()
            .timezone("testString")
            .userId("testString")
            .turnCount(Long.valueOf("26"))
            .locale("en-us")
            .referenceTime("testString")
            .sessionStartTime("testString")
            .state("testString")
            .build();
    assertEquals(messageContextGlobalSystemModel.timezone(), "testString");
    assertEquals(messageContextGlobalSystemModel.userId(), "testString");
    assertEquals(messageContextGlobalSystemModel.turnCount(), Long.valueOf("26"));
    assertEquals(messageContextGlobalSystemModel.locale(), "en-us");
    assertEquals(messageContextGlobalSystemModel.referenceTime(), "testString");
    assertEquals(messageContextGlobalSystemModel.sessionStartTime(), "testString");
    assertEquals(messageContextGlobalSystemModel.state(), "testString");

    MessageContextGlobalStateless messageContextGlobalStatelessModel =
        new MessageContextGlobalStateless.Builder()
            .system(messageContextGlobalSystemModel)
            .sessionId("testString")
            .build();
    assertEquals(messageContextGlobalStatelessModel.system(), messageContextGlobalSystemModel);
    assertEquals(messageContextGlobalStatelessModel.sessionId(), "testString");

    MessageContextSkillSystem messageContextSkillSystemModel =
        new MessageContextSkillSystem.Builder()
            .state("testString")
            .add("foo", "testString")
            .build();
    assertEquals(messageContextSkillSystemModel.getState(), "testString");
    assertEquals(messageContextSkillSystemModel.get("foo"), "testString");

    MessageContextSkill messageContextSkillModel =
        new MessageContextSkill.Builder()
            .userDefined(
                new java.util.HashMap<String, Object>() {
                  {
                    put("foo", TestUtilities.createMockMap());
                  }
                })
            .system(messageContextSkillSystemModel)
            .build();
    assertEquals(
        messageContextSkillModel.userDefined(),
        new java.util.HashMap<String, Object>() {
          {
            put("foo", TestUtilities.createMockMap());
          }
        });
    assertEquals(messageContextSkillModel.system(), messageContextSkillSystemModel);

    MessageContextStateless messageContextStatelessModel =
        new MessageContextStateless.Builder()
            .global(messageContextGlobalStatelessModel)
            .skills(
                new java.util.HashMap<String, MessageContextSkill>() {
                  {
                    put("foo", messageContextSkillModel);
                  }
                })
            .build();
    assertEquals(messageContextStatelessModel.global(), messageContextGlobalStatelessModel);
    assertEquals(
        messageContextStatelessModel.skills(),
        new java.util.HashMap<String, MessageContextSkill>() {
          {
            put("foo", messageContextSkillModel);
          }
        });

    String json = TestUtilities.serialize(messageContextStatelessModel);

    MessageContextStateless messageContextStatelessModelNew =
        TestUtilities.deserialize(json, MessageContextStateless.class);
    assertTrue(messageContextStatelessModelNew instanceof MessageContextStateless);
    assertEquals(
        messageContextStatelessModelNew.global().toString(),
        messageContextGlobalStatelessModel.toString());
  }
}
