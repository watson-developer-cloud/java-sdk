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

/** Unit test class for the UpdateWorkspaceOptions model. */
public class UpdateWorkspaceOptionsTest {
  final HashMap<String, InputStream> mockStreamMap = TestUtilities.createMockStreamMap();
  final List<FileWithMetadata> mockListFileWithMetadata =
      TestUtilities.creatMockListFileWithMetadata();

  @Test
  public void testUpdateWorkspaceOptions() throws Throwable {
    DialogNodeOutputGenericDialogNodeOutputResponseTypeSearchSkill dialogNodeOutputGenericModel =
        new DialogNodeOutputGenericDialogNodeOutputResponseTypeSearchSkill.Builder()
            .responseType("search_skill")
            .query("testString")
            .queryType("natural_language")
            .filter("testString")
            .discoveryVersion("testString")
            .build();
    assertEquals(dialogNodeOutputGenericModel.responseType(), "search_skill");
    assertEquals(dialogNodeOutputGenericModel.query(), "testString");
    assertEquals(dialogNodeOutputGenericModel.queryType(), "natural_language");
    assertEquals(dialogNodeOutputGenericModel.filter(), "testString");
    assertEquals(dialogNodeOutputGenericModel.discoveryVersion(), "testString");

    DialogNodeOutputModifiers dialogNodeOutputModifiersModel =
        new DialogNodeOutputModifiers.Builder().overwrite(true).build();
    assertEquals(dialogNodeOutputModifiersModel.overwrite(), Boolean.valueOf(true));

    DialogNodeOutput dialogNodeOutputModel =
        new DialogNodeOutput.Builder()
            .generic(
                new java.util.ArrayList<DialogNodeOutputGeneric>(
                    java.util.Arrays.asList(dialogNodeOutputGenericModel)))
            .integrations(
                new java.util.HashMap<String, Map<String, Object>>() {
                  {
                    put(
                        "foo",
                        new java.util.HashMap<String, Object>() {
                          {
                            put("foo", "testString");
                          }
                        });
                  }
                })
            .modifiers(dialogNodeOutputModifiersModel)
            .add("foo", "testString")
            .build();
    assertEquals(
        dialogNodeOutputModel.getGeneric(),
        new java.util.ArrayList<DialogNodeOutputGeneric>(
            java.util.Arrays.asList(dialogNodeOutputGenericModel)));
    assertEquals(
        dialogNodeOutputModel.getIntegrations(),
        new java.util.HashMap<String, Map<String, Object>>() {
          {
            put(
                "foo",
                new java.util.HashMap<String, Object>() {
                  {
                    put("foo", "testString");
                  }
                });
          }
        });
    assertEquals(dialogNodeOutputModel.getModifiers(), dialogNodeOutputModifiersModel);
    assertEquals(dialogNodeOutputModel.get("foo"), "testString");

    DialogNodeContext dialogNodeContextModel =
        new DialogNodeContext.Builder()
            .integrations(
                new java.util.HashMap<String, Map<String, Object>>() {
                  {
                    put(
                        "foo",
                        new java.util.HashMap<String, Object>() {
                          {
                            put("foo", "testString");
                          }
                        });
                  }
                })
            .add("foo", "testString")
            .build();
    assertEquals(
        dialogNodeContextModel.getIntegrations(),
        new java.util.HashMap<String, Map<String, Object>>() {
          {
            put(
                "foo",
                new java.util.HashMap<String, Object>() {
                  {
                    put("foo", "testString");
                  }
                });
          }
        });
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
            .parameters(
                new java.util.HashMap<String, Object>() {
                  {
                    put("foo", "testString");
                  }
                })
            .resultVariable("testString")
            .credentials("testString")
            .build();
    assertEquals(dialogNodeActionModel.name(), "testString");
    assertEquals(dialogNodeActionModel.type(), "client");
    assertEquals(
        dialogNodeActionModel.parameters(),
        new java.util.HashMap<String, Object>() {
          {
            put("foo", "testString");
          }
        });
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
            .metadata(
                new java.util.HashMap<String, Object>() {
                  {
                    put("foo", "testString");
                  }
                })
            .nextStep(dialogNodeNextStepModel)
            .title("testString")
            .type("standard")
            .eventName("focus")
            .variable("testString")
            .actions(
                new java.util.ArrayList<DialogNodeAction>(
                    java.util.Arrays.asList(dialogNodeActionModel)))
            .digressIn("not_available")
            .digressOut("allow_returning")
            .digressOutSlots("not_allowed")
            .userLabel("testString")
            .disambiguationOptOut(true)
            .build();
    assertEquals(dialogNodeModel.dialogNode(), "testString");
    assertEquals(dialogNodeModel.description(), "testString");
    assertEquals(dialogNodeModel.conditions(), "testString");
    assertEquals(dialogNodeModel.parent(), "testString");
    assertEquals(dialogNodeModel.previousSibling(), "testString");
    assertEquals(dialogNodeModel.output(), dialogNodeOutputModel);
    assertEquals(dialogNodeModel.context(), dialogNodeContextModel);
    assertEquals(
        dialogNodeModel.metadata(),
        new java.util.HashMap<String, Object>() {
          {
            put("foo", "testString");
          }
        });
    assertEquals(dialogNodeModel.nextStep(), dialogNodeNextStepModel);
    assertEquals(dialogNodeModel.title(), "testString");
    assertEquals(dialogNodeModel.type(), "standard");
    assertEquals(dialogNodeModel.eventName(), "focus");
    assertEquals(dialogNodeModel.variable(), "testString");
    assertEquals(
        dialogNodeModel.actions(),
        new java.util.ArrayList<DialogNodeAction>(java.util.Arrays.asList(dialogNodeActionModel)));
    assertEquals(dialogNodeModel.digressIn(), "not_available");
    assertEquals(dialogNodeModel.digressOut(), "allow_returning");
    assertEquals(dialogNodeModel.digressOutSlots(), "not_allowed");
    assertEquals(dialogNodeModel.userLabel(), "testString");
    assertEquals(dialogNodeModel.disambiguationOptOut(), Boolean.valueOf(true));

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

    WorkspaceSystemSettingsSystemEntities workspaceSystemSettingsSystemEntitiesModel =
        new WorkspaceSystemSettingsSystemEntities.Builder().enabled(true).build();
    assertEquals(workspaceSystemSettingsSystemEntitiesModel.enabled(), Boolean.valueOf(true));

    WorkspaceSystemSettingsOffTopic workspaceSystemSettingsOffTopicModel =
        new WorkspaceSystemSettingsOffTopic.Builder().enabled(true).build();
    assertEquals(workspaceSystemSettingsOffTopicModel.enabled(), Boolean.valueOf(true));

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
            .spellingSuggestions(true)
            .spellingAutoCorrect(true)
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
    assertEquals(workspaceSystemSettingsModel.spellingSuggestions(), Boolean.valueOf(true));
    assertEquals(workspaceSystemSettingsModel.spellingAutoCorrect(), Boolean.valueOf(true));
    assertEquals(
        workspaceSystemSettingsModel.systemEntities(), workspaceSystemSettingsSystemEntitiesModel);
    assertEquals(workspaceSystemSettingsModel.offTopic(), workspaceSystemSettingsOffTopicModel);

    WebhookHeader webhookHeaderModel =
        new WebhookHeader.Builder().name("testString").value("testString").build();
    assertEquals(webhookHeaderModel.name(), "testString");
    assertEquals(webhookHeaderModel.value(), "testString");

    Webhook webhookModel =
        new Webhook.Builder()
            .url("testString")
            .name("testString")
            .headers(
                new java.util.ArrayList<WebhookHeader>(java.util.Arrays.asList(webhookHeaderModel)))
            .build();
    assertEquals(webhookModel.url(), "testString");
    assertEquals(webhookModel.name(), "testString");
    assertEquals(
        webhookModel.headers(),
        new java.util.ArrayList<WebhookHeader>(java.util.Arrays.asList(webhookHeaderModel)));

    Mention mentionModel =
        new Mention.Builder()
            .entity("testString")
            .location(new java.util.ArrayList<Long>(java.util.Arrays.asList(Long.valueOf("26"))))
            .build();
    assertEquals(mentionModel.entity(), "testString");
    assertEquals(
        mentionModel.location(),
        new java.util.ArrayList<Long>(java.util.Arrays.asList(Long.valueOf("26"))));

    Example exampleModel =
        new Example.Builder()
            .text("testString")
            .mentions(new java.util.ArrayList<Mention>(java.util.Arrays.asList(mentionModel)))
            .build();
    assertEquals(exampleModel.text(), "testString");
    assertEquals(
        exampleModel.mentions(),
        new java.util.ArrayList<Mention>(java.util.Arrays.asList(mentionModel)));

    CreateIntent createIntentModel =
        new CreateIntent.Builder()
            .intent("testString")
            .description("testString")
            .examples(new java.util.ArrayList<Example>(java.util.Arrays.asList(exampleModel)))
            .build();
    assertEquals(createIntentModel.intent(), "testString");
    assertEquals(createIntentModel.description(), "testString");
    assertEquals(
        createIntentModel.examples(),
        new java.util.ArrayList<Example>(java.util.Arrays.asList(exampleModel)));

    CreateValue createValueModel =
        new CreateValue.Builder()
            .value("testString")
            .metadata(
                new java.util.HashMap<String, Object>() {
                  {
                    put("foo", "testString");
                  }
                })
            .type("synonyms")
            .synonyms(new java.util.ArrayList<String>(java.util.Arrays.asList("testString")))
            .patterns(new java.util.ArrayList<String>(java.util.Arrays.asList("testString")))
            .build();
    assertEquals(createValueModel.value(), "testString");
    assertEquals(
        createValueModel.metadata(),
        new java.util.HashMap<String, Object>() {
          {
            put("foo", "testString");
          }
        });
    assertEquals(createValueModel.type(), "synonyms");
    assertEquals(
        createValueModel.synonyms(),
        new java.util.ArrayList<String>(java.util.Arrays.asList("testString")));
    assertEquals(
        createValueModel.patterns(),
        new java.util.ArrayList<String>(java.util.Arrays.asList("testString")));

    CreateEntity createEntityModel =
        new CreateEntity.Builder()
            .entity("testString")
            .description("testString")
            .metadata(
                new java.util.HashMap<String, Object>() {
                  {
                    put("foo", "testString");
                  }
                })
            .fuzzyMatch(true)
            .values(new java.util.ArrayList<CreateValue>(java.util.Arrays.asList(createValueModel)))
            .build();
    assertEquals(createEntityModel.entity(), "testString");
    assertEquals(createEntityModel.description(), "testString");
    assertEquals(
        createEntityModel.metadata(),
        new java.util.HashMap<String, Object>() {
          {
            put("foo", "testString");
          }
        });
    assertEquals(createEntityModel.fuzzyMatch(), Boolean.valueOf(true));
    assertEquals(
        createEntityModel.values(),
        new java.util.ArrayList<CreateValue>(java.util.Arrays.asList(createValueModel)));

    UpdateWorkspaceOptions updateWorkspaceOptionsModel =
        new UpdateWorkspaceOptions.Builder()
            .workspaceId("testString")
            .name("testString")
            .description("testString")
            .language("testString")
            .dialogNodes(
                new java.util.ArrayList<DialogNode>(java.util.Arrays.asList(dialogNodeModel)))
            .counterexamples(
                new java.util.ArrayList<Counterexample>(
                    java.util.Arrays.asList(counterexampleModel)))
            .metadata(
                new java.util.HashMap<String, Object>() {
                  {
                    put("foo", "testString");
                  }
                })
            .learningOptOut(true)
            .systemSettings(workspaceSystemSettingsModel)
            .webhooks(new java.util.ArrayList<Webhook>(java.util.Arrays.asList(webhookModel)))
            .intents(
                new java.util.ArrayList<CreateIntent>(java.util.Arrays.asList(createIntentModel)))
            .entities(
                new java.util.ArrayList<CreateEntity>(java.util.Arrays.asList(createEntityModel)))
            .append(true)
            .includeAudit(true)
            .build();
    assertEquals(updateWorkspaceOptionsModel.workspaceId(), "testString");
    assertEquals(updateWorkspaceOptionsModel.name(), "testString");
    assertEquals(updateWorkspaceOptionsModel.description(), "testString");
    assertEquals(updateWorkspaceOptionsModel.language(), "testString");
    assertEquals(
        updateWorkspaceOptionsModel.dialogNodes(),
        new java.util.ArrayList<DialogNode>(java.util.Arrays.asList(dialogNodeModel)));
    assertEquals(
        updateWorkspaceOptionsModel.counterexamples(),
        new java.util.ArrayList<Counterexample>(java.util.Arrays.asList(counterexampleModel)));
    assertEquals(
        updateWorkspaceOptionsModel.metadata(),
        new java.util.HashMap<String, Object>() {
          {
            put("foo", "testString");
          }
        });
    assertEquals(updateWorkspaceOptionsModel.learningOptOut(), Boolean.valueOf(true));
    assertEquals(updateWorkspaceOptionsModel.systemSettings(), workspaceSystemSettingsModel);
    assertEquals(
        updateWorkspaceOptionsModel.webhooks(),
        new java.util.ArrayList<Webhook>(java.util.Arrays.asList(webhookModel)));
    assertEquals(
        updateWorkspaceOptionsModel.intents(),
        new java.util.ArrayList<CreateIntent>(java.util.Arrays.asList(createIntentModel)));
    assertEquals(
        updateWorkspaceOptionsModel.entities(),
        new java.util.ArrayList<CreateEntity>(java.util.Arrays.asList(createEntityModel)));
    assertEquals(updateWorkspaceOptionsModel.append(), Boolean.valueOf(true));
    assertEquals(updateWorkspaceOptionsModel.includeAudit(), Boolean.valueOf(true));
  }

  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testUpdateWorkspaceOptionsError() throws Throwable {
    new UpdateWorkspaceOptions.Builder().build();
  }
}
