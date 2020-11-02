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

package com.ibm.watson.assistant.v1.model;

import static org.testng.Assert.*;

import com.ibm.cloud.sdk.core.service.model.FileWithMetadata;
import com.ibm.watson.assistant.v1.utils.TestUtilities;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import org.testng.annotations.Test;

/** Unit test class for the UpdateExampleOptions model. */
public class UpdateExampleOptionsTest {
  final HashMap<String, InputStream> mockStreamMap = TestUtilities.createMockStreamMap();
  final List<FileWithMetadata> mockListFileWithMetadata =
      TestUtilities.creatMockListFileWithMetadata();

  @Test
  public void testUpdateExampleOptions() throws Throwable {
    Mention mentionModel =
        new Mention.Builder()
            .entity("testString")
            .location(new java.util.ArrayList<Long>(java.util.Arrays.asList(Long.valueOf("26"))))
            .build();
    assertEquals(mentionModel.entity(), "testString");
    assertEquals(
        mentionModel.location(),
        new java.util.ArrayList<Long>(java.util.Arrays.asList(Long.valueOf("26"))));

    UpdateExampleOptions updateExampleOptionsModel =
        new UpdateExampleOptions.Builder()
            .workspaceId("testString")
            .intent("testString")
            .text("testString")
            .newText("testString")
            .newMentions(new java.util.ArrayList<Mention>(java.util.Arrays.asList(mentionModel)))
            .includeAudit(true)
            .build();
    assertEquals(updateExampleOptionsModel.workspaceId(), "testString");
    assertEquals(updateExampleOptionsModel.intent(), "testString");
    assertEquals(updateExampleOptionsModel.text(), "testString");
    assertEquals(updateExampleOptionsModel.newText(), "testString");
    assertEquals(
        updateExampleOptionsModel.newMentions(),
        new java.util.ArrayList<Mention>(java.util.Arrays.asList(mentionModel)));
    assertEquals(updateExampleOptionsModel.includeAudit(), Boolean.valueOf(true));
  }

  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testUpdateExampleOptionsError() throws Throwable {
    new UpdateExampleOptions.Builder().build();
  }
}
