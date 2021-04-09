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

/** Unit test class for the WorkspaceSystemSettingsDisambiguation model. */
public class WorkspaceSystemSettingsDisambiguationTest {
  final HashMap<String, InputStream> mockStreamMap = TestUtilities.createMockStreamMap();
  final List<FileWithMetadata> mockListFileWithMetadata =
      TestUtilities.creatMockListFileWithMetadata();

  @Test
  public void testWorkspaceSystemSettingsDisambiguation() throws Throwable {
    WorkspaceSystemSettingsDisambiguation workspaceSystemSettingsDisambiguationModel =
        new WorkspaceSystemSettingsDisambiguation.Builder()
            .prompt("testString")
            .noneOfTheAbovePrompt("testString")
            .enabled(true)
            .sensitivity("auto")
            .randomize(true)
            .maxSuggestions(Long.valueOf("1"))
            .suggestionTextPolicy("testString")
            .build();
    assertEquals(workspaceSystemSettingsDisambiguationModel.prompt(), "testString");
    assertEquals(workspaceSystemSettingsDisambiguationModel.noneOfTheAbovePrompt(), "testString");
    assertEquals(workspaceSystemSettingsDisambiguationModel.enabled(), Boolean.valueOf(true));
    assertEquals(workspaceSystemSettingsDisambiguationModel.sensitivity(), "auto");
    assertEquals(workspaceSystemSettingsDisambiguationModel.randomize(), Boolean.valueOf(true));
    assertEquals(workspaceSystemSettingsDisambiguationModel.maxSuggestions(), Long.valueOf("1"));
    assertEquals(workspaceSystemSettingsDisambiguationModel.suggestionTextPolicy(), "testString");

    String json = TestUtilities.serialize(workspaceSystemSettingsDisambiguationModel);

    WorkspaceSystemSettingsDisambiguation workspaceSystemSettingsDisambiguationModelNew =
        TestUtilities.deserialize(json, WorkspaceSystemSettingsDisambiguation.class);
    assertTrue(
        workspaceSystemSettingsDisambiguationModelNew
            instanceof WorkspaceSystemSettingsDisambiguation);
    assertEquals(workspaceSystemSettingsDisambiguationModelNew.prompt(), "testString");
    assertEquals(
        workspaceSystemSettingsDisambiguationModelNew.noneOfTheAbovePrompt(), "testString");
    assertEquals(workspaceSystemSettingsDisambiguationModelNew.enabled(), Boolean.valueOf(true));
    assertEquals(workspaceSystemSettingsDisambiguationModelNew.sensitivity(), "auto");
    assertEquals(workspaceSystemSettingsDisambiguationModelNew.randomize(), Boolean.valueOf(true));
    assertEquals(workspaceSystemSettingsDisambiguationModelNew.maxSuggestions(), Long.valueOf("1"));
    assertEquals(
        workspaceSystemSettingsDisambiguationModelNew.suggestionTextPolicy(), "testString");
  }
}
