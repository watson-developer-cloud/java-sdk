/*
 * (C) Copyright IBM Corp. 2022.
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

/** Unit test class for the UpdateIntentOptions model. */
public class UpdateIntentOptionsTest {
  final HashMap<String, InputStream> mockStreamMap = TestUtilities.createMockStreamMap();
  final List<FileWithMetadata> mockListFileWithMetadata =
      TestUtilities.creatMockListFileWithMetadata();

  @Test
  public void testUpdateIntentOptions() throws Throwable {
    Mention mentionModel =
        new Mention.Builder()
            .entity("testString")
            .location(java.util.Arrays.asList(Long.valueOf("26")))
            .build();
    assertEquals(mentionModel.entity(), "testString");
    assertEquals(mentionModel.location(), java.util.Arrays.asList(Long.valueOf("26")));

    Example exampleModel =
        new Example.Builder()
            .text("testString")
            .mentions(java.util.Arrays.asList(mentionModel))
            .build();
    assertEquals(exampleModel.text(), "testString");
    assertEquals(exampleModel.mentions(), java.util.Arrays.asList(mentionModel));

    UpdateIntentOptions updateIntentOptionsModel =
        new UpdateIntentOptions.Builder()
            .workspaceId("testString")
            .intent("testString")
            .newIntent("testString")
            .newDescription("testString")
            .newExamples(java.util.Arrays.asList(exampleModel))
            .append(false)
            .includeAudit(false)
            .build();
    assertEquals(updateIntentOptionsModel.workspaceId(), "testString");
    assertEquals(updateIntentOptionsModel.intent(), "testString");
    assertEquals(updateIntentOptionsModel.newIntent(), "testString");
    assertEquals(updateIntentOptionsModel.newDescription(), "testString");
    assertEquals(updateIntentOptionsModel.newExamples(), java.util.Arrays.asList(exampleModel));
    assertEquals(updateIntentOptionsModel.append(), Boolean.valueOf(false));
    assertEquals(updateIntentOptionsModel.includeAudit(), Boolean.valueOf(false));
  }

  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testUpdateIntentOptionsError() throws Throwable {
    new UpdateIntentOptions.Builder().build();
  }
}
