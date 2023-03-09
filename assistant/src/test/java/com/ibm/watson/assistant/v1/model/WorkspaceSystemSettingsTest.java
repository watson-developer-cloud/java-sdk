/*
 * (C) Copyright IBM Corp. 2020, 2023.
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

    WorkspaceSystemSettingsNlp workspaceSystemSettingsNlpModel =
        new WorkspaceSystemSettingsNlp.Builder().model("testString").build();
    assertEquals(workspaceSystemSettingsNlpModel.model(), "testString");

    WorkspaceSystemSettings workspaceSystemSettingsModel =
        new WorkspaceSystemSettings.Builder()
            .tooling(workspaceSystemSettingsToolingModel)
            .disambiguation(workspaceSystemSettingsDisambiguationModel)
            .humanAgentAssist(java.util.Collections.singletonMap("anyKey", "anyValue"))
            .spellingSuggestions(false)
            .spellingAutoCorrect(false)
            .systemEntities(workspaceSystemSettingsSystemEntitiesModel)
            .offTopic(workspaceSystemSettingsOffTopicModel)
            .nlp(workspaceSystemSettingsNlpModel)
            .add("foo", "testString")
            .build();
    assertEquals(workspaceSystemSettingsModel.getTooling(), workspaceSystemSettingsToolingModel);
    assertEquals(
        workspaceSystemSettingsModel.getDisambiguation(),
        workspaceSystemSettingsDisambiguationModel);
    assertEquals(
        workspaceSystemSettingsModel.getHumanAgentAssist(),
        java.util.Collections.singletonMap("anyKey", "anyValue"));
    assertEquals(workspaceSystemSettingsModel.isSpellingSuggestions(), Boolean.valueOf(false));
    assertEquals(workspaceSystemSettingsModel.isSpellingAutoCorrect(), Boolean.valueOf(false));
    assertEquals(
        workspaceSystemSettingsModel.getSystemEntities(),
        workspaceSystemSettingsSystemEntitiesModel);
    assertEquals(workspaceSystemSettingsModel.getOffTopic(), workspaceSystemSettingsOffTopicModel);
    assertEquals(workspaceSystemSettingsModel.getNlp(), workspaceSystemSettingsNlpModel);
    assertEquals(workspaceSystemSettingsModel.get("foo"), "testString");

    String json = TestUtilities.serialize(workspaceSystemSettingsModel);

    WorkspaceSystemSettings workspaceSystemSettingsModelNew =
        TestUtilities.deserialize(json, WorkspaceSystemSettings.class);
    assertTrue(workspaceSystemSettingsModelNew instanceof WorkspaceSystemSettings);
    assertEquals(
        workspaceSystemSettingsModelNew.getTooling().toString(),
        workspaceSystemSettingsToolingModel.toString());
    assertEquals(
        workspaceSystemSettingsModelNew.getDisambiguation().toString(),
        workspaceSystemSettingsDisambiguationModel.toString());
    assertEquals(
        workspaceSystemSettingsModelNew.getHumanAgentAssist().toString(),
        java.util.Collections.singletonMap("anyKey", "anyValue").toString());
    assertEquals(workspaceSystemSettingsModelNew.isSpellingSuggestions(), Boolean.valueOf(false));
    assertEquals(workspaceSystemSettingsModelNew.isSpellingAutoCorrect(), Boolean.valueOf(false));
    assertEquals(
        workspaceSystemSettingsModelNew.getSystemEntities().toString(),
        workspaceSystemSettingsSystemEntitiesModel.toString());
    assertEquals(
        workspaceSystemSettingsModelNew.getOffTopic().toString(),
        workspaceSystemSettingsOffTopicModel.toString());
    assertEquals(
        workspaceSystemSettingsModelNew.getNlp().toString(),
        workspaceSystemSettingsNlpModel.toString());
    assertEquals(workspaceSystemSettingsModelNew.get("foo"), "testString");
  }
}
