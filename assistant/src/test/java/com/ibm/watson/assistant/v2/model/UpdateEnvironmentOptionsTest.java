/*
 * (C) Copyright IBM Corp. 2023, 2024.
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

/** Unit test class for the UpdateEnvironmentOptions model. */
public class UpdateEnvironmentOptionsTest {
  final HashMap<String, InputStream> mockStreamMap = TestUtilities.createMockStreamMap();
  final List<FileWithMetadata> mockListFileWithMetadata =
      TestUtilities.creatMockListFileWithMetadata();

  @Test
  public void testUpdateEnvironmentOptions() throws Throwable {
    BaseEnvironmentOrchestration baseEnvironmentOrchestrationModel =
        new BaseEnvironmentOrchestration.Builder().searchSkillFallback(true).build();
    assertEquals(baseEnvironmentOrchestrationModel.searchSkillFallback(), Boolean.valueOf(true));

    EnvironmentSkill environmentSkillModel =
        new EnvironmentSkill.Builder()
            .skillId("testString")
            .type("dialog")
            .disabled(true)
            .snapshot("testString")
            .skillReference("testString")
            .build();
    assertEquals(environmentSkillModel.skillId(), "testString");
    assertEquals(environmentSkillModel.type(), "dialog");
    assertEquals(environmentSkillModel.disabled(), Boolean.valueOf(true));
    assertEquals(environmentSkillModel.snapshot(), "testString");
    assertEquals(environmentSkillModel.skillReference(), "testString");

    UpdateEnvironmentOptions updateEnvironmentOptionsModel =
        new UpdateEnvironmentOptions.Builder()
            .assistantId("testString")
            .environmentId("testString")
            .name("testString")
            .description("testString")
            .orchestration(baseEnvironmentOrchestrationModel)
            .sessionTimeout(Long.valueOf("10"))
            .skillReferences(java.util.Arrays.asList(environmentSkillModel))
            .build();
    assertEquals(updateEnvironmentOptionsModel.assistantId(), "testString");
    assertEquals(updateEnvironmentOptionsModel.environmentId(), "testString");
    assertEquals(updateEnvironmentOptionsModel.name(), "testString");
    assertEquals(updateEnvironmentOptionsModel.description(), "testString");
    assertEquals(updateEnvironmentOptionsModel.orchestration(), baseEnvironmentOrchestrationModel);
    assertEquals(updateEnvironmentOptionsModel.sessionTimeout(), Long.valueOf("10"));
    assertEquals(
        updateEnvironmentOptionsModel.skillReferences(),
        java.util.Arrays.asList(environmentSkillModel));
  }

  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testUpdateEnvironmentOptionsError() throws Throwable {
    new UpdateEnvironmentOptions.Builder().build();
  }
}
