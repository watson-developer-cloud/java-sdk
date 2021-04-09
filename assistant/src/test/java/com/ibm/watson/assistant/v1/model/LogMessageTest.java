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

package com.ibm.watson.assistant.v1.model;

import static org.testng.Assert.*;

import com.ibm.cloud.sdk.core.service.model.FileWithMetadata;
import com.ibm.watson.assistant.v1.utils.TestUtilities;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import org.testng.annotations.Test;

/** Unit test class for the LogMessage model. */
public class LogMessageTest {
  final HashMap<String, InputStream> mockStreamMap = TestUtilities.createMockStreamMap();
  final List<FileWithMetadata> mockListFileWithMetadata =
      TestUtilities.creatMockListFileWithMetadata();

  @Test
  public void testLogMessage() throws Throwable {
    LogMessageSource logMessageSourceModel =
        new LogMessageSource.Builder().type("dialog_node").dialogNode("testString").build();
    assertEquals(logMessageSourceModel.type(), "dialog_node");
    assertEquals(logMessageSourceModel.dialogNode(), "testString");

    LogMessage logMessageModel =
        new LogMessage.Builder()
            .level("info")
            .msg("testString")
            .code("testString")
            .source(logMessageSourceModel)
            .build();
    assertEquals(logMessageModel.level(), "info");
    assertEquals(logMessageModel.msg(), "testString");
    assertEquals(logMessageModel.code(), "testString");
    assertEquals(logMessageModel.source(), logMessageSourceModel);

    String json = TestUtilities.serialize(logMessageModel);

    LogMessage logMessageModelNew = TestUtilities.deserialize(json, LogMessage.class);
    assertTrue(logMessageModelNew instanceof LogMessage);
    assertEquals(logMessageModelNew.level(), "info");
    assertEquals(logMessageModelNew.msg(), "testString");
    assertEquals(logMessageModelNew.code(), "testString");
    assertEquals(logMessageModelNew.source().toString(), logMessageSourceModel.toString());
  }

  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testLogMessageError() throws Throwable {
    new LogMessage.Builder().build();
  }
}
