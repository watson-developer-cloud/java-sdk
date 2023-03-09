/*
 * (C) Copyright IBM Corp. 2022, 2023.
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

/** Unit test class for the CreateWorkspaceAsyncOptions model. */
public class CreateWorkspaceAsyncOptionsTest {
  final HashMap<String, InputStream> mockStreamMap = TestUtilities.createMockStreamMap();
  final List<FileWithMetadata> mockListFileWithMetadata =
      TestUtilities.creatMockListFileWithMetadata();

  @Test
  public void testCreateWorkspaceAsyncOptions() throws Throwable {
    DialogNodeOutputTextValuesElement dialogNodeOutputTextValuesElementModel =
        new DialogNodeOutputTextValuesElement.Builder().text("testString").build();
    assertEquals(dialogNodeOutputTextValuesElementModel.text(), "testString");

    ResponseGenericChannel responseGenericChannelModel =
        new ResponseGenericChannel.Builder().channel("chat").build();
    assertEquals(responseGenericChannelModel.channel(), "chat");

    DialogNodeOutputGenericDialogNodeOutputResponseTypeText dialogNodeOutputGenericModel =
        new DialogNodeOutputGenericDialogNodeOutputResponseTypeText.Builder()
            .responseType("text")
            .values(java.util.Arrays.asList(dialogNodeOutputTextValuesElementModel))
            .selectionPolicy("sequential")
            .delimiter("\n")
            .channels(java.util.Arrays.asList(responseGenericChannelModel))
            .build();
    assertEquals(dialogNodeOutputGenericModel.responseType(), "text");
    assertEquals(
        dialogNodeOutputGenericModel.values(),
        java.util.Arrays.asList(dialogNodeOutputTextValuesElementModel));
    assertEquals(dialogNodeOutputGenericModel.selectionPolicy(), "sequential");
    assertEquals(dialogNodeOutputGenericModel.delimiter(), "\n");
    assertEquals(
        dialogNodeOutputGenericModel.channels(),
        java.util.Arrays.asList(responseGenericChannelModel));

    DialogNodeOutputModifiers dialogNodeOutputModifiersModel =
        new DialogNodeOutputModifiers.Builder().overwrite(true).build();
    assertEquals(dialogNodeOutputModifiersModel.overwrite(), Boolean.valueOf(true));

    DialogNodeOutput dialogNodeOutputModel =
        new DialogNodeOutput.Builder()
            .generic(java.util.Arrays.asList(dialogNodeOutputGenericModel))
            .integrations(
                java.util.Collections.singletonMap(
                    "foo", java.util.Collections.singletonMap("anyKey", "anyValue")))
            .modifiers(dialogNodeOutputModifiersModel)
            .add("foo", "testString")
            .build();
    assertEquals(
        dialogNodeOutputModel.getGeneric(), java.util.Arrays.asList(dialogNodeOutputGenericModel));
    assertEquals(
        dialogNodeOutputModel.getIntegrations(),
        java.util.Collections.singletonMap(
            "foo", java.util.Collections.singletonMap("anyKey", "anyValue")));
    assertEquals(dialogNodeOutputModel.getModifiers(), dialogNodeOutputModifiersModel);
    assertEquals(dialogNodeOutputModel.get("foo"), "testString");

    DialogNodeContext dialogNodeContextModel =
        new DialogNodeContext.Builder()
            .integrations(
                java.util.Collections.singletonMap(
                    "foo", java.util.Collections.singletonMap("anyKey", "anyValue")))
            .add("foo", "testString")
            .build();
    assertEquals(
        dialogNodeContextModel.getIntegrations(),
        java.util.Collections.singletonMap(
            "foo", java.util.Collections.singletonMap("anyKey", "anyValue")));
    assertEquals(dialogNodeContextModel.get("foo"), "testString");

    DialogNodeNextStep dialogNodeNextStepModel =
        new DialogNodeNextStep.Builder()
            .behavior("get_user_input")
            .dialogNode("testString")
            .selector("condition")
            .build();
    assertEquals(dialogNodeNextStepModel.behavior(), "get_user_input");
    assertEquals(dialogNodeNextStepModel.dialogNode(), "testString");
    assertEquals(dialogNodeNextStepModel.selector(), "condition");

    DialogNodeAction dialogNodeActionModel =
        new DialogNodeAction.Builder()
            .name("testString")
            .type("client")
            .parameters(java.util.Collections.singletonMap("anyKey", "anyValue"))
            .resultVariable("testString")
            .credentials("testString")
            .build();
    assertEquals(dialogNodeActionModel.name(), "testString");
    assertEquals(dialogNodeActionModel.type(), "client");
    assertEquals(
        dialogNodeActionModel.parameters(),
        java.util.Collections.singletonMap("anyKey", "anyValue"));
    assertEquals(dialogNodeActionModel.resultVariable(), "testString");
    assertEquals(dialogNodeActionModel.credentials(), "testString");

    DialogNode dialogNodeModel =
        new DialogNode.Builder()
            .dialogNode("testString")
            .description("testString")
            .conditions("testString")
            .parent("testString")
            .previousSibling("testString")
            .output(dialogNodeOutputModel)
            .context(dialogNodeContextModel)
            .metadata(java.util.Collections.singletonMap("anyKey", "anyValue"))
            .nextStep(dialogNodeNextStepModel)
            .title("testString")
            .type("standard")
            .eventName("focus")
            .variable("testString")
            .actions(java.util.Arrays.asList(dialogNodeActionModel))
            .digressIn("not_available")
            .digressOut("allow_returning")
            .digressOutSlots("not_allowed")
            .userLabel("testString")
            .disambiguationOptOut(false)
            .build();
    assertEquals(dialogNodeModel.dialogNode(), "testString");
    assertEquals(dialogNodeModel.description(), "testString");
    assertEquals(dialogNodeModel.conditions(), "testString");
    assertEquals(dialogNodeModel.parent(), "testString");
    assertEquals(dialogNodeModel.previousSibling(), "testString");
    assertEquals(dialogNodeModel.output(), dialogNodeOutputModel);
    assertEquals(dialogNodeModel.context(), dialogNodeContextModel);
    assertEquals(
        dialogNodeModel.metadata(), java.util.Collections.singletonMap("anyKey", "anyValue"));
    assertEquals(dialogNodeModel.nextStep(), dialogNodeNextStepModel);
    assertEquals(dialogNodeModel.title(), "testString");
    assertEquals(dialogNodeModel.type(), "standard");
    assertEquals(dialogNodeModel.eventName(), "focus");
    assertEquals(dialogNodeModel.variable(), "testString");
    assertEquals(dialogNodeModel.actions(), java.util.Arrays.asList(dialogNodeActionModel));
    assertEquals(dialogNodeModel.digressIn(), "not_available");
    assertEquals(dialogNodeModel.digressOut(), "allow_returning");
    assertEquals(dialogNodeModel.digressOutSlots(), "not_allowed");
    assertEquals(dialogNodeModel.userLabel(), "testString");
    assertEquals(dialogNodeModel.disambiguationOptOut(), Boolean.valueOf(false));

    Counterexample counterexampleModel = new Counterexample.Builder().text("testString").build();
    assertEquals(counterexampleModel.text(), "testString");

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

    WebhookHeader webhookHeaderModel =
        new WebhookHeader.Builder().name("testString").value("testString").build();
    assertEquals(webhookHeaderModel.name(), "testString");
    assertEquals(webhookHeaderModel.value(), "testString");

    Webhook webhookModel =
        new Webhook.Builder()
            .url("testString")
            .name("testString")
            .headers(java.util.Arrays.asList(webhookHeaderModel))
            .build();
    assertEquals(webhookModel.url(), "testString");
    assertEquals(webhookModel.name(), "testString");
    assertEquals(webhookModel.headers(), java.util.Arrays.asList(webhookHeaderModel));

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

    CreateIntent createIntentModel =
        new CreateIntent.Builder()
            .intent("testString")
            .description("testString")
            .examples(java.util.Arrays.asList(exampleModel))
            .build();
    assertEquals(createIntentModel.intent(), "testString");
    assertEquals(createIntentModel.description(), "testString");
    assertEquals(createIntentModel.examples(), java.util.Arrays.asList(exampleModel));

    CreateValue createValueModel =
        new CreateValue.Builder()
            .value("testString")
            .metadata(java.util.Collections.singletonMap("anyKey", "anyValue"))
            .type("synonyms")
            .synonyms(java.util.Arrays.asList("testString"))
            .patterns(java.util.Arrays.asList("testString"))
            .build();
    assertEquals(createValueModel.value(), "testString");
    assertEquals(
        createValueModel.metadata(), java.util.Collections.singletonMap("anyKey", "anyValue"));
    assertEquals(createValueModel.type(), "synonyms");
    assertEquals(createValueModel.synonyms(), java.util.Arrays.asList("testString"));
    assertEquals(createValueModel.patterns(), java.util.Arrays.asList("testString"));

    CreateEntity createEntityModel =
        new CreateEntity.Builder()
            .entity("testString")
            .description("testString")
            .metadata(java.util.Collections.singletonMap("anyKey", "anyValue"))
            .fuzzyMatch(true)
            .values(java.util.Arrays.asList(createValueModel))
            .build();
    assertEquals(createEntityModel.entity(), "testString");
    assertEquals(createEntityModel.description(), "testString");
    assertEquals(
        createEntityModel.metadata(), java.util.Collections.singletonMap("anyKey", "anyValue"));
    assertEquals(createEntityModel.fuzzyMatch(), Boolean.valueOf(true));
    assertEquals(createEntityModel.values(), java.util.Arrays.asList(createValueModel));

    CreateWorkspaceAsyncOptions createWorkspaceAsyncOptionsModel =
        new CreateWorkspaceAsyncOptions.Builder()
            .name("testString")
            .description("testString")
            .language("testString")
            .dialogNodes(java.util.Arrays.asList(dialogNodeModel))
            .counterexamples(java.util.Arrays.asList(counterexampleModel))
            .metadata(java.util.Collections.singletonMap("anyKey", "anyValue"))
            .learningOptOut(false)
            .systemSettings(workspaceSystemSettingsModel)
            .webhooks(java.util.Arrays.asList(webhookModel))
            .intents(java.util.Arrays.asList(createIntentModel))
            .entities(java.util.Arrays.asList(createEntityModel))
            .build();
    assertEquals(createWorkspaceAsyncOptionsModel.name(), "testString");
    assertEquals(createWorkspaceAsyncOptionsModel.description(), "testString");
    assertEquals(createWorkspaceAsyncOptionsModel.language(), "testString");
    assertEquals(
        createWorkspaceAsyncOptionsModel.dialogNodes(), java.util.Arrays.asList(dialogNodeModel));
    assertEquals(
        createWorkspaceAsyncOptionsModel.counterexamples(),
        java.util.Arrays.asList(counterexampleModel));
    assertEquals(
        createWorkspaceAsyncOptionsModel.metadata(),
        java.util.Collections.singletonMap("anyKey", "anyValue"));
    assertEquals(createWorkspaceAsyncOptionsModel.learningOptOut(), Boolean.valueOf(false));
    assertEquals(createWorkspaceAsyncOptionsModel.systemSettings(), workspaceSystemSettingsModel);
    assertEquals(
        createWorkspaceAsyncOptionsModel.webhooks(), java.util.Arrays.asList(webhookModel));
    assertEquals(
        createWorkspaceAsyncOptionsModel.intents(), java.util.Arrays.asList(createIntentModel));
    assertEquals(
        createWorkspaceAsyncOptionsModel.entities(), java.util.Arrays.asList(createEntityModel));
  }
}
