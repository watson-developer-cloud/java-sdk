/*
 * (C) Copyright IBM Corp. 2020, 2021.
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

/** Unit test class for the WorkspaceSystemSettings model. */
public class WorkspaceSystemSettingsTest {
  final HashMap<String, InputStream> mockStreamMap = TestUtilities.createMockStreamMap();
  final List<FileWithMetadata> mockListFileWithMetadata =
      TestUtilities.creatMockListFileWithMetadata();

  @Test
  public void testWorkspaceSystemSettings() throws Throwable {
    WorkspaceSystemSettingsTooling workspaceSystemSettingsToolingModel =
        new WorkspaceSystemSettingsTooling.Builder().storeGenericResponses(true).build();
    assertEquals(
        workspaceSystemSettingsToolingModel.storeGenericResponses(), Boolean.valueOf(true));

    WorkspaceSystemSettingsDisambiguation workspaceSystemSettingsDisambiguationModel =
        new WorkspaceSystemSettingsDisambiguation.Builder()
            .prompt("testString")
            .noneOfTheAbovePrompt("testString")
            .enabled(false)
            .sensitivity("auto")
            .randomize(true)
            .maxSuggestions(Long.valueOf("1"))
            .suggestionTextPolicy("testString")
            .build();
    assertEquals(workspaceSystemSettingsDisambiguationModel.prompt(), "testString");
    assertEquals(workspaceSystemSettingsDisambiguationModel.noneOfTheAbovePrompt(), "testString");
    assertEquals(workspaceSystemSettingsDisambiguationModel.enabled(), Boolean.valueOf(false));
    assertEquals(workspaceSystemSettingsDisambiguationModel.sensitivity(), "auto");
    assertEquals(workspaceSystemSettingsDisambiguationModel.randomize(), Boolean.valueOf(true));
    assertEquals(workspaceSystemSettingsDisambiguationModel.maxSuggestions(), Long.valueOf("1"));
    assertEquals(workspaceSystemSettingsDisambiguationModel.suggestionTextPolicy(), "testString");

    WorkspaceSystemSettingsSystemEntities workspaceSystemSettingsSystemEntitiesModel =
        new WorkspaceSystemSettingsSystemEntities.Builder().enabled(false).build();
    assertEquals(workspaceSystemSettingsSystemEntitiesModel.enabled(), Boolean.valueOf(false));

    WorkspaceSystemSettingsOffTopic workspaceSystemSettingsOffTopicModel =
        new WorkspaceSystemSettingsOffTopic.Builder().enabled(false).build();
    assertEquals(workspaceSystemSettingsOffTopicModel.enabled(), Boolean.valueOf(false));

    WorkspaceSystemSettings workspaceSystemSettingsModel =
        new WorkspaceSystemSettings.Builder()
            .tooling(workspaceSystemSettingsToolingModel)
            .disambiguation(workspaceSystemSettingsDisambiguationModel)
            .humanAgentAssist(
                new java.util.HashMap<String, Object>() {
                  {
                    put("foo", "testString");
                  }
                })
            .spellingSuggestions(false)
            .spellingAutoCorrect(false)
            .systemEntities(workspaceSystemSettingsSystemEntitiesModel)
            .offTopic(workspaceSystemSettingsOffTopicModel)
            .build();
    assertEquals(workspaceSystemSettingsModel.tooling(), workspaceSystemSettingsToolingModel);
    assertEquals(
        workspaceSystemSettingsModel.disambiguation(), workspaceSystemSettingsDisambiguationModel);
    assertEquals(
        workspaceSystemSettingsModel.humanAgentAssist(),
        new java.util.HashMap<String, Object>() {
          {
            put("foo", "testString");
          }
        });
    assertEquals(workspaceSystemSettingsModel.spellingSuggestions(), Boolean.valueOf(false));
    assertEquals(workspaceSystemSettingsModel.spellingAutoCorrect(), Boolean.valueOf(false));
    assertEquals(
        workspaceSystemSettingsModel.systemEntities(), workspaceSystemSettingsSystemEntitiesModel);
    assertEquals(workspaceSystemSettingsModel.offTopic(), workspaceSystemSettingsOffTopicModel);

    String json = TestUtilities.serialize(workspaceSystemSettingsModel);

    WorkspaceSystemSettings workspaceSystemSettingsModelNew =
        TestUtilities.deserialize(json, WorkspaceSystemSettings.class);
    assertTrue(workspaceSystemSettingsModelNew instanceof WorkspaceSystemSettings);
    assertEquals(
        workspaceSystemSettingsModelNew.tooling().toString(),
        workspaceSystemSettingsToolingModel.toString());
    assertEquals(
        workspaceSystemSettingsModelNew.disambiguation().toString(),
        workspaceSystemSettingsDisambiguationModel.toString());
    assertEquals(workspaceSystemSettingsModelNew.spellingSuggestions(), Boolean.valueOf(false));
    assertEquals(workspaceSystemSettingsModelNew.spellingAutoCorrect(), Boolean.valueOf(false));
    assertEquals(
        workspaceSystemSettingsModelNew.systemEntities().toString(),
        workspaceSystemSettingsSystemEntitiesModel.toString());
    assertEquals(
        workspaceSystemSettingsModelNew.offTopic().toString(),
        workspaceSystemSettingsOffTopicModel.toString());
  }
}
