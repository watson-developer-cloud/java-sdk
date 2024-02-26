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

/** Unit test class for the StatelessMessageContextGlobal model. */
public class StatelessMessageContextGlobalTest {
  final HashMap<String, InputStream> mockStreamMap = TestUtilities.createMockStreamMap();
  final List<FileWithMetadata> mockListFileWithMetadata =
      TestUtilities.creatMockListFileWithMetadata();

  @Test
  public void testStatelessMessageContextGlobal() throws Throwable {
    MessageContextGlobalSystem messageContextGlobalSystemModel =
        new MessageContextGlobalSystem.Builder()
            .timezone("testString")
            .userId("testString")
            .turnCount(Long.valueOf("26"))
            .locale("en-us")
            .referenceTime("testString")
            .sessionStartTime("testString")
            .state("testString")
            .skipUserInput(true)
            .build();
    assertEquals(messageContextGlobalSystemModel.timezone(), "testString");
    assertEquals(messageContextGlobalSystemModel.userId(), "testString");
    assertEquals(messageContextGlobalSystemModel.turnCount(), Long.valueOf("26"));
    assertEquals(messageContextGlobalSystemModel.locale(), "en-us");
    assertEquals(messageContextGlobalSystemModel.referenceTime(), "testString");
    assertEquals(messageContextGlobalSystemModel.sessionStartTime(), "testString");
    assertEquals(messageContextGlobalSystemModel.state(), "testString");
    assertEquals(messageContextGlobalSystemModel.skipUserInput(), Boolean.valueOf(true));

    StatelessMessageContextGlobal statelessMessageContextGlobalModel =
        new StatelessMessageContextGlobal.Builder()
            .system(messageContextGlobalSystemModel)
            .sessionId("testString")
            .build();
    assertEquals(statelessMessageContextGlobalModel.system(), messageContextGlobalSystemModel);
    assertEquals(statelessMessageContextGlobalModel.sessionId(), "testString");

    String json = TestUtilities.serialize(statelessMessageContextGlobalModel);

    StatelessMessageContextGlobal statelessMessageContextGlobalModelNew =
        TestUtilities.deserialize(json, StatelessMessageContextGlobal.class);
    assertTrue(statelessMessageContextGlobalModelNew instanceof StatelessMessageContextGlobal);
    assertEquals(
        statelessMessageContextGlobalModelNew.system().toString(),
        messageContextGlobalSystemModel.toString());
    assertEquals(statelessMessageContextGlobalModelNew.sessionId(), "testString");
  }
}
