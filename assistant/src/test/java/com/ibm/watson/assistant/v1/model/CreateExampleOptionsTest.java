/*
 * (C) Copyright IBM Corp. 2020, 2022.
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

/** Unit test class for the CreateExampleOptions model. */
public class CreateExampleOptionsTest {
  final HashMap<String, InputStream> mockStreamMap = TestUtilities.createMockStreamMap();
  final List<FileWithMetadata> mockListFileWithMetadata =
      TestUtilities.creatMockListFileWithMetadata();

  @Test
  public void testCreateExampleOptions() throws Throwable {
    Mention mentionModel =
        new Mention.Builder()
            .entity("testString")
            .location(java.util.Arrays.asList(Long.valueOf("26")))
            .build();
    assertEquals(mentionModel.entity(), "testString");
    assertEquals(mentionModel.location(), java.util.Arrays.asList(Long.valueOf("26")));

    CreateExampleOptions createExampleOptionsModel =
        new CreateExampleOptions.Builder()
            .workspaceId("testString")
            .intent("testString")
            .text("testString")
            .mentions(java.util.Arrays.asList(mentionModel))
            .includeAudit(false)
            .build();
    assertEquals(createExampleOptionsModel.workspaceId(), "testString");
    assertEquals(createExampleOptionsModel.intent(), "testString");
    assertEquals(createExampleOptionsModel.text(), "testString");
    assertEquals(createExampleOptionsModel.mentions(), java.util.Arrays.asList(mentionModel));
    assertEquals(createExampleOptionsModel.includeAudit(), Boolean.valueOf(false));
  }

  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testCreateExampleOptionsError() throws Throwable {
    new CreateExampleOptions.Builder().build();
  }
}
