/*
 * Copyright 2017 IBM Corp. All Rights Reserved.
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
package com.ibm.watson.assistant.v1;

import com.ibm.cloud.sdk.core.http.HttpHeaders;
import com.ibm.cloud.sdk.core.security.basicauth.BasicAuthConfig;
import com.ibm.watson.assistant.v1.model.Context;
import com.ibm.watson.assistant.v1.model.Counterexample;
import com.ibm.watson.assistant.v1.model.CreateDialogNodeOptions;
import com.ibm.watson.assistant.v1.model.CreateEntity;
import com.ibm.watson.assistant.v1.model.CreateEntityOptions;
import com.ibm.watson.assistant.v1.model.CreateExampleOptions;
import com.ibm.watson.assistant.v1.model.CreateIntent;
import com.ibm.watson.assistant.v1.model.CreateIntentOptions;
import com.ibm.watson.assistant.v1.model.CreateValue;
import com.ibm.watson.assistant.v1.model.CreateValueOptions;
import com.ibm.watson.assistant.v1.model.CreateWorkspaceOptions;
import com.ibm.watson.assistant.v1.model.DeleteUserDataOptions;
import com.ibm.watson.assistant.v1.model.DialogNode;
import com.ibm.watson.assistant.v1.model.DialogNodeAction;
import com.ibm.watson.assistant.v1.model.Example;
import com.ibm.watson.assistant.v1.model.GetWorkspaceOptions;
import com.ibm.watson.assistant.v1.model.ListAllLogsOptions;
import com.ibm.watson.assistant.v1.model.ListMentionsOptions;
import com.ibm.watson.assistant.v1.model.Mention;
import com.ibm.watson.assistant.v1.model.MessageContextMetadata;
import com.ibm.watson.assistant.v1.model.MessageInput;
import com.ibm.watson.assistant.v1.model.MessageOptions;
import com.ibm.watson.assistant.v1.model.MessageRequest;
import com.ibm.watson.assistant.v1.model.MessageResponse;
import com.ibm.watson.assistant.v1.model.OutputData;
import com.ibm.watson.assistant.v1.model.RuntimeEntity;
import com.ibm.watson.assistant.v1.model.RuntimeEntityInterpretation;
import com.ibm.watson.assistant.v1.model.RuntimeEntityRole;
import com.ibm.watson.assistant.v1.model.RuntimeIntent;
import com.ibm.watson.assistant.v1.model.UpdateDialogNodeOptions;
import com.ibm.watson.assistant.v1.model.UpdateEntityOptions;
import com.ibm.watson.assistant.v1.model.UpdateExampleOptions;
import com.ibm.watson.assistant.v1.model.UpdateIntentOptions;
import com.ibm.watson.assistant.v1.model.UpdateValueOptions;
import com.ibm.watson.assistant.v1.model.UpdateWorkspaceOptions;
import com.ibm.watson.assistant.v1.model.WorkspaceSystemSettings;
import com.ibm.watson.assistant.v1.model.WorkspaceSystemSettingsDisambiguation;
import com.ibm.watson.assistant.v1.model.WorkspaceSystemSettingsSystemEntities;
import com.ibm.watson.assistant.v1.model.WorkspaceSystemSettingsTooling;
import com.ibm.watson.common.WatsonServiceUnitTest;
import okhttp3.mockwebserver.RecordedRequest;
import org.apache.commons.lang3.StringUtils;
import org.junit.Before;
import org.junit.Test;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

/**
 * Unit tests for the {@link Assistant}.
 */
public class AssistantTest extends WatsonServiceUnitTest {
  private Assistant service;
  private static final String FIXTURE = "src/test/resources/assistant/assistant.json";
  private static final String WORKSPACE_ID = "123";
  private static final String PATH_MESSAGE = "/v1/workspaces/" + WORKSPACE_ID + "/message";
  private static final String VERSION = "version";

  private static final String CALENDAR_TYPE = "Gregorian";
  private static final String DATETIME_LINK = "datetime_link";
  private static final String FESTIVAL = "christmas";
  private static final String RANGE_LINK = "range_link";
  private static final String RANGE_MODIFIER = "since";
  private static final Double RELATIVE_DAY = 10d;
  private static final Double RELATIVE_MONTH = -2d;
  private static final Double RELATIVE_WEEK = 1d;
  private static final Double RELATIVE_WEEKEND = 2d;
  private static final Double RELATIVE_YEAR = 7d;
  private static final Double SPECIFIC_DAY = 30d;
  private static final String SPECIFIC_DAY_OF_WEEK = "monday";
  private static final Double SPECIFIC_MONTH = 6d;
  private static final Double SPECIFIC_QUARTER = 3d;
  private static final Double SPECIFIC_YEAR = 2019d;
  private static final Double NUMERIC_VALUE = 1986d;
  private static final String SUBTYPE = "integer";
  private static final String PART_OF_DAY = "evening";
  private static final Double RELATIVE_HOUR = 11d;
  private static final Double RELATIVE_MINUTE = 12d;
  private static final Double RELATIVE_SECOND = 13d;
  private static final Double SPECIFIC_HOUR = 14d;
  private static final Double SPECIFIC_MINUTE = 15d;
  private static final Double SPECIFIC_SECOND = 16d;
  private static final String TIMEZONE = "EST";

  /*
   * (non-Javadoc)
   * @see com.ibm.watson.developer_cloud.WatsonServiceTest#setUp()
   */
  @Override
  @Before
  public void setUp() throws Exception {
    super.setUp();
    BasicAuthConfig authConfig = new BasicAuthConfig.Builder()
        .username("")
        .password("")
        .build();
    service = new Assistant("2018-07-10", authConfig);
    service.setEndPoint(getMockWebServerUrl());
  }

  /**
   * Negative - Test constructor with null version date.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testConstructorWithNullVersionDate() {
    new Assistant(null);
  }

  /**
   * Negative - Test constructor with empty version date.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testConstructorWithEmptyVersionDate() {
    new Assistant("");
  }

  /**
   * Negative - Test assistant with null options.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testAssistantWithNullOptions() {
    service.message(null).execute().getResult();
  }

  /**
   * Negative - Test assistant with null workspaceId.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testAssistantWithNullWorkspaceId() {
    MessageOptions options = new MessageOptions.Builder().build();
    service.message(options).execute().getResult();
  }

  /**
   * Negative - Test assistant with empty workspaceId.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testAssistantWithEmptyWorkspaceId() {
    MessageOptions options = new MessageOptions.Builder("").build();
    service.message(options).execute().getResult();
  }

  // --- MODELS ---

  /**
   * Test CreateWorkspace builder.
   */
  @Test
  public void testCreateWorkspaceBuilder() {

    String workspaceName = "Builder Test";
    String workspaceDescription = "Description of " + workspaceName;
    String workspaceLanguage = "en";
    String userLabel = "user_label";

    // intents
    CreateIntent testIntent0 = new CreateIntent.Builder("testIntent0").build();
    CreateIntent testIntent1 = new CreateIntent.Builder("testIntent1").build();

    // entities
    CreateEntity testEntity0 = new CreateEntity.Builder("testEntity0").build();
    CreateEntity testEntity1 = new CreateEntity.Builder("testEntity1").build();

    // counterexamples
    Counterexample testCounterexample0 = new Counterexample.Builder("testCounterexample0").build();
    Counterexample testCounterexample1 = new Counterexample.Builder("testCounterexample1").build();

    // dialognodes
    DialogNode testDialogNode0 = new DialogNode.Builder("dialogNode0")
        .userLabel(userLabel)
        .build();
    DialogNode testDialogNode1 = new DialogNode.Builder("dialogNode1").build();

    // metadata
    Map<String, Object> workspaceMetadata = new HashMap<String, Object>();
    String metadataValue = "value for " + workspaceName;
    workspaceMetadata.put("key", metadataValue);

    // systemSettings
    WorkspaceSystemSettingsDisambiguation disambiguation = new WorkspaceSystemSettingsDisambiguation();
    disambiguation.setEnabled(true);
    disambiguation.setNoneOfTheAbovePrompt("none of the above");
    disambiguation.setPrompt("prompt");
    disambiguation.setSensitivity(WorkspaceSystemSettingsDisambiguation.Sensitivity.HIGH);
    WorkspaceSystemSettingsTooling tooling = new WorkspaceSystemSettingsTooling();
    tooling.setStoreGenericResponses(true);
    Map<String, Object> humanAgentAssist = new HashMap<>();
    humanAgentAssist.put("help", "ok");
    WorkspaceSystemSettingsSystemEntities entities = new WorkspaceSystemSettingsSystemEntities();
    WorkspaceSystemSettings systemSettings = new WorkspaceSystemSettings();
    systemSettings.setDisambiguation(disambiguation);
    systemSettings.setTooling(tooling);
    systemSettings.setHumanAgentAssist(humanAgentAssist);
    systemSettings.setSpellingSuggestions(true);
    systemSettings.setSpellingAutoCorrect(true);
    systemSettings.setSystemEntities(entities);

    CreateWorkspaceOptions createOptions = new CreateWorkspaceOptions.Builder()
        .name(workspaceName)
        .description(workspaceDescription)
        .language(workspaceLanguage)
        .addIntent(testIntent0).addIntent(testIntent1)
        .addEntity(testEntity0).addEntity(testEntity1)
        .addCounterexample(testCounterexample0).addCounterexample(testCounterexample1)
        .addDialogNode(testDialogNode0).addDialogNode(testDialogNode1)
        .metadata(workspaceMetadata)
        .systemSettings(systemSettings)
        .build();

    assertEquals(createOptions.name(), workspaceName);
    assertEquals(createOptions.description(), workspaceDescription);
    assertEquals(createOptions.language(), workspaceLanguage);
    assertNotNull(createOptions.intents());
    assertEquals(createOptions.intents().size(), 2);
    assertEquals(createOptions.intents().get(0), testIntent0);
    assertEquals(createOptions.intents().get(1), testIntent1);
    assertNotNull(createOptions.entities());
    assertEquals(createOptions.entities().size(), 2);
    assertEquals(createOptions.entities().get(0), testEntity0);
    assertEquals(createOptions.entities().get(1), testEntity1);
    assertNotNull(createOptions.counterexamples());
    assertEquals(createOptions.counterexamples().size(), 2);
    assertEquals(createOptions.counterexamples().get(0), testCounterexample0);
    assertEquals(createOptions.counterexamples().get(1), testCounterexample1);
    assertNotNull(createOptions.dialogNodes());
    assertEquals(createOptions.dialogNodes().size(), 2);
    assertEquals(createOptions.dialogNodes().get(0), testDialogNode0);
    assertEquals(createOptions.dialogNodes().get(0).userLabel(), userLabel);
    assertEquals(createOptions.dialogNodes().get(1), testDialogNode1);
    assertNotNull(createOptions.systemSettings());
    assertEquals(createOptions.systemSettings().getDisambiguation().getNoneOfTheAbovePrompt(),
        disambiguation.getNoneOfTheAbovePrompt());
    assertEquals(createOptions.systemSettings().getDisambiguation().getPrompt(), disambiguation.getPrompt());
    assertEquals(createOptions.systemSettings().getDisambiguation().getSensitivity(), disambiguation.getSensitivity());
    assertEquals(createOptions.systemSettings().getDisambiguation().isEnabled(), disambiguation.isEnabled());
    assertEquals(createOptions.systemSettings().getTooling().isStoreGenericResponses(),
        tooling.isStoreGenericResponses());
    assertEquals(createOptions.systemSettings().getHumanAgentAssist(), humanAgentAssist);
    assertTrue(createOptions.systemSettings().isSpellingSuggestions());
    assertTrue(createOptions.systemSettings().isSpellingAutoCorrect());
    assertEquals(entities, createOptions.systemSettings().getSystemEntities());

    CreateWorkspaceOptions.Builder builder = createOptions.newBuilder();

    CreateIntent testIntent2 = new CreateIntent.Builder("testIntent2").build();
    CreateEntity testEntity2 = new CreateEntity.Builder("testEntity2").build();
    Counterexample testCounterexample2 = new Counterexample.Builder("testCounterexample2").build();
    DialogNode testDialogNode2 = new DialogNode.Builder("dialogNode2").build();

    builder.intents(Collections.singletonList(testIntent2));
    builder.entities(Collections.singletonList(testEntity2));
    builder.counterexamples(Collections.singletonList(testCounterexample2));
    builder.dialogNodes(Collections.singletonList(testDialogNode2));

    CreateWorkspaceOptions options2 = builder.build();

    assertNotNull(options2.intents());
    assertEquals(options2.intents().size(), 1);
    assertEquals(options2.intents().get(0), testIntent2);
    assertNotNull(options2.entities());
    assertEquals(options2.entities().size(), 1);
    assertEquals(options2.entities().get(0), testEntity2);
    assertNotNull(options2.counterexamples());
    assertEquals(options2.counterexamples().size(), 1);
    assertEquals(options2.counterexamples().get(0), testCounterexample2);
    assertNotNull(options2.dialogNodes());
    assertEquals(options2.dialogNodes().size(), 1);
    assertEquals(options2.dialogNodes().get(0), testDialogNode2);
  }

  /**
   * Test UpdateWorkspaceOptions builder.
   */
  @Test
  public void testUpdateWorkspaceOptionsBuilder() {

    String workspaceName = "Builder Test";
    String workspaceDescription = "Description of " + workspaceName;
    String workspaceLanguage = "en";

    // intents
    CreateIntent testIntent = new CreateIntent.Builder("testIntent").build();

    // entities
    CreateEntity testEntity = new CreateEntity.Builder("testEntity").build();

    // counterexamples
    Counterexample testCounterexample = new Counterexample.Builder("testCounterexample").build();

    // dialognodes
    DialogNode testDialogNode = new DialogNode.Builder("dialogNode").build();

    // metadata
    Map<String, Object> workspaceMetadata = new HashMap<String, Object>();
    String metadataValue = "value for " + workspaceName;
    workspaceMetadata.put("key", metadataValue);

    // systemSettings
    WorkspaceSystemSettingsDisambiguation disambiguation = new WorkspaceSystemSettingsDisambiguation();
    disambiguation.setEnabled(true);
    disambiguation.setNoneOfTheAbovePrompt("none of the above");
    disambiguation.setPrompt("prompt");
    disambiguation.setSensitivity(WorkspaceSystemSettingsDisambiguation.Sensitivity.HIGH);
    WorkspaceSystemSettingsTooling tooling = new WorkspaceSystemSettingsTooling();
    tooling.setStoreGenericResponses(true);
    Map<String, Object> humanAgentAssist = new HashMap<>();
    humanAgentAssist.put("help", "ok");
    WorkspaceSystemSettings systemSettings = new WorkspaceSystemSettings();
    systemSettings.setDisambiguation(disambiguation);
    systemSettings.setTooling(tooling);
    systemSettings.setHumanAgentAssist(humanAgentAssist);

    UpdateWorkspaceOptions.Builder builder = new UpdateWorkspaceOptions.Builder(WORKSPACE_ID);
    builder.name(workspaceName);
    builder.description(workspaceDescription);
    builder.language(workspaceLanguage);
    builder.addIntent(testIntent);
    builder.addEntity(testEntity);
    builder.addCounterexample(testCounterexample);
    builder.addDialogNode(testDialogNode);
    builder.metadata(workspaceMetadata);
    builder.systemSettings(systemSettings);

    UpdateWorkspaceOptions options = builder.build();

    assertEquals(options.name(), workspaceName);
    assertEquals(options.description(), workspaceDescription);
    assertEquals(options.language(), workspaceLanguage);
    assertNotNull(options.intents());
    assertEquals(options.intents().size(), 1);
    assertEquals(options.intents().get(0), testIntent);
    assertNotNull(options.entities());
    assertEquals(options.entities().size(), 1);
    assertEquals(options.entities().get(0), testEntity);
    assertNotNull(options.counterexamples());
    assertEquals(options.counterexamples().size(), 1);
    assertEquals(options.counterexamples().get(0), testCounterexample);
    assertNotNull(options.dialogNodes());
    assertEquals(options.dialogNodes().size(), 1);
    assertEquals(options.dialogNodes().get(0), testDialogNode);
    assertNotNull(options.metadata());
    assertEquals(options.metadata(), workspaceMetadata);
    assertNotNull(options.systemSettings());
    assertEquals(options.systemSettings().getDisambiguation().getNoneOfTheAbovePrompt(),
        disambiguation.getNoneOfTheAbovePrompt());
    assertEquals(options.systemSettings().getDisambiguation().getSensitivity(), disambiguation.getSensitivity());
    assertEquals(options.systemSettings().getDisambiguation().getPrompt(), disambiguation.getPrompt());
    assertEquals(options.systemSettings().getDisambiguation().isEnabled(), disambiguation.isEnabled());
    assertEquals(options.systemSettings().getTooling().isStoreGenericResponses(), tooling.isStoreGenericResponses());
    assertEquals(options.systemSettings().getHumanAgentAssist(), humanAgentAssist);

    UpdateWorkspaceOptions.Builder builder2 = options.newBuilder();

    CreateIntent testIntent2 = new CreateIntent.Builder("testIntent2").build();
    CreateEntity testEntity2 = new CreateEntity.Builder("testEntity2").build();
    Counterexample testCounterexample2 = new Counterexample.Builder("testCounterexample2").build();
    DialogNode testDialogNode2 = new DialogNode.Builder("dialogNode2").build();

    builder2.intents(new ArrayList<CreateIntent>());
    builder2.addIntent(testIntent2);
    builder2.entities(new ArrayList<CreateEntity>());
    builder2.addEntity(testEntity2);
    builder2.counterexamples(new ArrayList<Counterexample>());
    builder2.addCounterexample(testCounterexample2);
    builder2.dialogNodes(new ArrayList<DialogNode>());
    builder2.addDialogNode(testDialogNode2);

    UpdateWorkspaceOptions options2 = builder2.build();

    assertNotNull(options2.intents());
    assertEquals(options2.intents().size(), 1);
    assertEquals(options2.intents().get(0), testIntent2);
    assertNotNull(options2.entities());
    assertEquals(options2.entities().size(), 1);
    assertEquals(options2.entities().get(0), testEntity2);
    assertNotNull(options2.counterexamples());
    assertEquals(options2.counterexamples().size(), 1);
    assertEquals(options2.counterexamples().get(0), testCounterexample2);
    assertNotNull(options2.dialogNodes());
    assertEquals(options2.dialogNodes().size(), 1);
    assertEquals(options2.dialogNodes().get(0), testDialogNode2);
  }

  @Test
  public void testGetWorkspaceOptionsBuilder() {
    String workspaceId = "workspace_id";
    String sort = GetWorkspaceOptions.Sort.STABLE;

    GetWorkspaceOptions getWorkspaceOptions = new GetWorkspaceOptions.Builder()
        .workspaceId(workspaceId)
        .export(true)
        .includeAudit(true)
        .sort(sort)
        .build();
    getWorkspaceOptions = getWorkspaceOptions.newBuilder().build();

    assertEquals(workspaceId, getWorkspaceOptions.workspaceId());
    assertTrue(getWorkspaceOptions.export());
    assertTrue(getWorkspaceOptions.includeAudit());
    assertEquals(sort, getWorkspaceOptions.sort());
  }

  @Test
  public void testCreateExampleOptionsBuilder() {
    Mention mentions1 = new Mention();
    mentions1.setEntity("entity");
    mentions1.setLocation(Arrays.asList(0L, 10L));
    List<Mention> mentionsList = new ArrayList<>();
    mentionsList.add(mentions1);
    Mention mentions2 = new Mention();
    mentions2.setEntity("second_entity");
    mentions2.setLocation(Arrays.asList(10L, 20L));
    String text = "text";
    String intent = "intent";

    CreateExampleOptions createExampleOptions = new CreateExampleOptions.Builder()
        .workspaceId(WORKSPACE_ID)
        .mentions(mentionsList)
        .addMentions(mentions2)
        .text(text)
        .intent(intent)
        .build();

    mentionsList.add(mentions2);

    assertEquals(createExampleOptions.workspaceId(), WORKSPACE_ID);
    assertEquals(createExampleOptions.mentions(), mentionsList);
    assertEquals(createExampleOptions.text(), text);
    assertEquals(createExampleOptions.intent(), intent);
  }

  @Test
  public void testUpdateExampleOptionsBuilder() {
    Mention mentions1 = new Mention();
    mentions1.setEntity("entity");
    mentions1.setLocation(Arrays.asList(0L, 10L));
    List<Mention> mentionsList = new ArrayList<>();
    mentionsList.add(mentions1);
    Mention mentions2 = new Mention();
    mentions2.setEntity("second_entity");
    mentions2.setLocation(Arrays.asList(10L, 20L));
    String text = "text";
    String intent = "intent";

    UpdateExampleOptions updateExampleOptions = new UpdateExampleOptions.Builder()
        .workspaceId(WORKSPACE_ID)
        .intent(intent)
        .text(text)
        .newMentions(mentionsList)
        .newText(text)
        .build();

    mentionsList.add(mentions2);

    assertEquals(updateExampleOptions.workspaceId(), WORKSPACE_ID);
    assertEquals(updateExampleOptions.newMentions(), mentionsList);
    assertEquals(updateExampleOptions.newText(), text);
    assertEquals(updateExampleOptions.intent(), intent);
    assertEquals(updateExampleOptions.text(), text);
  }

  /**
   * Test CreateIntentOptions builder.
   */
  @Test
  public void testCreateIntentOptionsBuilder() {
    String intent = "anIntent";
    Example intentExample0 = new Example.Builder().text("intentExample0").build();
    Example intentExample1 = new Example.Builder().text("intentExample1").build();

    CreateIntentOptions createOptions = new CreateIntentOptions.Builder()
        .workspaceId(WORKSPACE_ID)
        .intent(intent)
        .addExample(intentExample0).addExample(intentExample1)
        .build();

    assertEquals(createOptions.workspaceId(), WORKSPACE_ID);
    assertEquals(createOptions.intent(), intent);
    assertEquals(createOptions.examples().size(), 2);
    assertEquals(createOptions.examples().get(0), intentExample0);
    assertEquals(createOptions.examples().get(1), intentExample1);

    CreateIntentOptions.Builder builder = createOptions.newBuilder();

    Example intentExample2 = new Example.Builder().text("intentExample2").build();
    builder.examples(Collections.singletonList(intentExample2));

    CreateIntentOptions options2 = builder.build();

    assertEquals(options2.workspaceId(), WORKSPACE_ID);
    assertEquals(options2.intent(), intent);
    assertEquals(options2.examples().size(), 1);
    assertEquals(options2.examples().get(0), intentExample2);
  }

  /**
   * Test UpdateIntentOptions builder.
   */
  @Test
  public void testUpdateIntentOptionsBuilder() {
    String intent = "anIntent";
    String newIntent = "renamedIntent";
    Example intentExample0 = new Example.Builder().text("intentExample0").build();
    Example intentExample1 = new Example.Builder().text("intentExample1").build();

    UpdateIntentOptions updateOptions = new UpdateIntentOptions.Builder()
        .workspaceId(WORKSPACE_ID)
        .intent(intent)
        .newIntent(newIntent)
        .addExample(intentExample0).addExample(intentExample1)
        .build();

    assertEquals(updateOptions.workspaceId(), WORKSPACE_ID);
    assertEquals(updateOptions.intent(), intent);
    assertEquals(updateOptions.newIntent(), newIntent);
    assertEquals(updateOptions.newExamples().size(), 2);
    assertEquals(updateOptions.newExamples().get(0), intentExample0);
    assertEquals(updateOptions.newExamples().get(1), intentExample1);

    UpdateIntentOptions.Builder builder = updateOptions.newBuilder();

    Example intentExample2 = new Example.Builder().text("intentExample2").build();
    builder.newExamples(Collections.singletonList(intentExample2));

    UpdateIntentOptions options2 = builder.build();

    assertEquals(options2.workspaceId(), WORKSPACE_ID);
    assertEquals(options2.intent(), intent);
    assertEquals(options2.newIntent(), newIntent);
    assertEquals(options2.newExamples().size(), 1);
    assertEquals(options2.newExamples().get(0), intentExample2);
  }

  /**
   * Test CreateEntityOptions builder.
   */
  @Test
  public void testCreateEntityOptionsBuilder() {
    String entity = "anEntity";
    CreateValue entityValue0 = new CreateValue.Builder().value("entityValue0").addPattern("pattern0").build();
    CreateValue entityValue1 = new CreateValue.Builder().value("entityValue1").addPattern("pattern1").build();

    CreateEntityOptions createOptions = new CreateEntityOptions.Builder()
        .workspaceId(WORKSPACE_ID)
        .entity(entity)
        .addValues(entityValue0).addValues(entityValue1)
        .build();

    assertEquals(createOptions.workspaceId(), WORKSPACE_ID);
    assertEquals(createOptions.entity(), entity);
    assertEquals(createOptions.values().size(), 2);
    assertEquals(createOptions.values().get(0), entityValue0);
    assertEquals(createOptions.values().get(1), entityValue1);

    CreateEntityOptions.Builder builder = createOptions.newBuilder();

    CreateValue entityValue2 = new CreateValue.Builder().value("entityValue2").addPattern("pattern2").build();
    builder.values(Collections.singletonList(entityValue2));

    CreateEntityOptions options2 = builder.build();

    assertEquals(options2.workspaceId(), WORKSPACE_ID);
    assertEquals(options2.entity(), entity);
    assertEquals(options2.values().size(), 1);
    assertEquals(options2.values().get(0), entityValue2);
  }

  /**
   * Test UpdateEntityOptions builder.
   */
  @Test
  public void testUpdateEntityOptionsBuilder() {
    String entity = "anEntity";
    String newEntity = "renamedEntity";
    CreateValue entityValue0 = new CreateValue.Builder().value("entityValue0").addPattern("pattern0").build();
    CreateValue entityValue1 = new CreateValue.Builder().value("entityValue1").addPattern("pattern1").build();

    UpdateEntityOptions updateOptions = new UpdateEntityOptions.Builder()
        .workspaceId(WORKSPACE_ID)
        .entity(entity)
        .newEntity(newEntity)
        .addValue(entityValue0).addValue(entityValue1)
        .build();

    assertEquals(updateOptions.workspaceId(), WORKSPACE_ID);
    assertEquals(updateOptions.entity(), entity);
    assertEquals(updateOptions.newEntity(), newEntity);
    assertEquals(updateOptions.newValues().size(), 2);
    assertEquals(updateOptions.newValues().get(0), entityValue0);
    assertEquals(updateOptions.newValues().get(1), entityValue1);

    UpdateEntityOptions.Builder builder = updateOptions.newBuilder();

    CreateValue entityValue2 = new CreateValue.Builder().value("entityValue2").addPattern("pattern2").build();
    builder.newValues(Collections.singletonList(entityValue2));

    UpdateEntityOptions options2 = builder.build();

    assertEquals(options2.workspaceId(), WORKSPACE_ID);
    assertEquals(options2.entity(), entity);
    assertEquals(options2.newEntity(), newEntity);
    assertEquals(options2.newValues().size(), 1);
    assertEquals(options2.newValues().get(0), entityValue2);
  }

  /**
   * Test CreateValueOptions builder.
   */
  @Test
  public void testCreateValueOptionsBuilder() {
    String entity = "anEntity";
    String value = "aValue";
    String valueSynonym0 = "valueSynonym0";
    String valueSynonym1 = "valueSynonym1";
    String valuePattern0 = "valuePattern0";
    String valuePattern1 = "valuePattern1";
    String valueType = "patterns";

    CreateValueOptions createOptions = new CreateValueOptions.Builder()
        .workspaceId(WORKSPACE_ID)
        .entity(entity)
        .value(value)
        .addSynonym(valueSynonym0).addSynonym(valueSynonym1)
        .addPattern(valuePattern0).addPattern(valuePattern1)
        .valueType(valueType)
        .build();

    assertEquals(createOptions.workspaceId(), WORKSPACE_ID);
    assertEquals(createOptions.entity(), entity);
    assertEquals(createOptions.value(), value);
    assertEquals(createOptions.synonyms().size(), 2);
    assertEquals(createOptions.synonyms().get(0), valueSynonym0);
    assertEquals(createOptions.synonyms().get(1), valueSynonym1);
    assertEquals(createOptions.patterns().size(), 2);
    assertEquals(createOptions.patterns().get(0), valuePattern0);
    assertEquals(createOptions.patterns().get(1), valuePattern1);
    assertEquals(createOptions.valueType(), valueType);

    CreateValueOptions.Builder builder = createOptions.newBuilder();

    String valueSynonym2 = "valueSynonym2";
    String valuePattern2 = "valuePattern2";
    builder.synonyms(Collections.singletonList(valueSynonym2));
    builder.patterns(Collections.singletonList(valuePattern2));

    CreateValueOptions options2 = builder.build();

    assertEquals(options2.workspaceId(), WORKSPACE_ID);
    assertEquals(options2.entity(), entity);
    assertEquals(options2.value(), value);
    assertEquals(options2.synonyms().size(), 1);
    assertEquals(options2.synonyms().get(0), valueSynonym2);
    assertEquals(options2.patterns().size(), 1);
    assertEquals(options2.patterns().get(0), valuePattern2);
  }

  /**
   * Test UpdateValueOptions builder.
   */
  @Test
  public void testUpdateValueOptionsBuilder() {
    String entity = "anEntity";
    String value = "aValue";
    String newValue = "renamedValue";
    String valueSynonym0 = "valueSynonym0";
    String valueSynonym1 = "valueSynonym1";

    UpdateValueOptions updateOptions = new UpdateValueOptions.Builder()
        .workspaceId(WORKSPACE_ID)
        .entity(entity)
        .value(value)
        .newValue(newValue)
        .addSynonym(valueSynonym0).addSynonym(valueSynonym1)
        .build();

    assertEquals(updateOptions.workspaceId(), WORKSPACE_ID);
    assertEquals(updateOptions.entity(), entity);
    assertEquals(updateOptions.newValue(), newValue);
    assertEquals(updateOptions.newSynonyms().size(), 2);
    assertEquals(updateOptions.newSynonyms().get(0), valueSynonym0);
    assertEquals(updateOptions.newSynonyms().get(1), valueSynonym1);

    UpdateValueOptions.Builder builder = updateOptions.newBuilder();

    String valueSynonym2 = "valueSynonym2";
    builder.newSynonyms(Collections.singletonList(valueSynonym2));

    UpdateValueOptions options2 = builder.build();

    assertEquals(options2.workspaceId(), WORKSPACE_ID);
    assertEquals(options2.entity(), entity);
    assertEquals(options2.newValue(), newValue);
    assertEquals(options2.newSynonyms().size(), 1);
    assertEquals(options2.newSynonyms().get(0), valueSynonym2);
  }

  /**
   * Test CreateDialogNodeOptions builder.
   */
  @Test
  public void testCreateDialogNodeOptionsBuilder() {
    String dialogNodeName = "aDialogNode";
    DialogNodeAction action0 = new DialogNodeAction();
    action0.setName("action0");
    action0.setCredentials("credential0");
    DialogNodeAction action1 = new DialogNodeAction();
    action1.setName("action1");
    action1.setCredentials("credential1");
    String userLabel = "user_label";

    CreateDialogNodeOptions createOptions = new CreateDialogNodeOptions.Builder()
        .workspaceId(WORKSPACE_ID)
        .dialogNode(dialogNodeName)
        .addActions(action0).addActions(action1)
        .digressIn(CreateDialogNodeOptions.DigressIn.RETURNS)
        .digressOut(CreateDialogNodeOptions.DigressOut.ALLOW_ALL)
        .digressOutSlots(CreateDialogNodeOptions.DigressOutSlots.ALLOW_ALL)
        .userLabel(userLabel)
        .build();

    assertEquals(createOptions.workspaceId(), WORKSPACE_ID);
    assertEquals(createOptions.dialogNode(), dialogNodeName);
    assertEquals(createOptions.actions().size(), 2);
    assertEquals(createOptions.actions().get(0), action0);
    assertEquals(createOptions.actions().get(0).getCredentials(), "credential0");
    assertEquals(createOptions.actions().get(1), action1);
    assertEquals(createOptions.actions().get(1).getCredentials(), "credential1");
    assertEquals(createOptions.digressIn(), CreateDialogNodeOptions.DigressIn.RETURNS);
    assertEquals(createOptions.digressOut(), CreateDialogNodeOptions.DigressOut.ALLOW_ALL);
    assertEquals(createOptions.digressOutSlots(), CreateDialogNodeOptions.DigressOutSlots.ALLOW_ALL);
    assertEquals(createOptions.userLabel(), userLabel);
  }

  /**
   * Test UpdateDialogNodeOptions builder.
   */
  @Test
  public void testUpdateDialogNodeOptionsBuilder() {
    String dialogNodeName = "aDialogNode";
    String newDialogNodeName = "renamedDialogNode";
    DialogNodeAction action0 = new DialogNodeAction();
    action0.setName("action0");
    action0.setCredentials("credential0");
    DialogNodeAction action1 = new DialogNodeAction();
    action1.setName("action1");
    action1.setCredentials("credential1");
    String userLabel = "user_label";

    UpdateDialogNodeOptions updateOptions = new UpdateDialogNodeOptions.Builder()
        .workspaceId(WORKSPACE_ID)
        .dialogNode(dialogNodeName)
        .newDialogNode(newDialogNodeName)
        .addNewActions(action0).addNewActions(action1)
        .newDigressIn(UpdateDialogNodeOptions.NewDigressIn.RETURNS)
        .newDigressOut(UpdateDialogNodeOptions.NewDigressOut.ALLOW_ALL)
        .newDigressOutSlots(UpdateDialogNodeOptions.NewDigressOutSlots.ALLOW_ALL)
        .newUserLabel(userLabel)
        .build();

    assertEquals(updateOptions.workspaceId(), WORKSPACE_ID);
    assertEquals(updateOptions.dialogNode(), dialogNodeName);
    assertEquals(updateOptions.newActions().size(), 2);
    assertEquals(updateOptions.newActions().get(0), action0);
    assertEquals(updateOptions.newActions().get(0).getCredentials(), "credential0");
    assertEquals(updateOptions.newActions().get(1), action1);
    assertEquals(updateOptions.newActions().get(1).getCredentials(), "credential1");
    assertEquals(updateOptions.newDigressIn(), UpdateDialogNodeOptions.NewDigressIn.RETURNS);
    assertEquals(updateOptions.newDigressOut(), UpdateDialogNodeOptions.NewDigressOut.ALLOW_ALL);
    assertEquals(updateOptions.newDigressOutSlots(), UpdateDialogNodeOptions.NewDigressOutSlots.ALLOW_ALL);
    assertEquals(updateOptions.newUserLabel(), userLabel);
  }

  /**
   * Test ListAllLogsOptions builder.
   */
  @Test
  public void testListAllLogsOptionsBuilder() {
    String sort = "sort";
    String filter = "filter";
    Long pageLimit = 5L;
    String cursor = "cursor";

    ListAllLogsOptions listOptions = new ListAllLogsOptions.Builder()
        .sort(sort)
        .filter(filter)
        .pageLimit(pageLimit)
        .cursor(cursor)
        .build();

    assertEquals(listOptions.sort(), sort);
    assertEquals(listOptions.filter(), filter);
    assertEquals(listOptions.pageLimit(), pageLimit);
    assertEquals(listOptions.cursor(), cursor);
  }

  /**
   * Test DeleteUserDataOptions builder.
   */
  @Test
  public void testDeleteUserDataOptionsBuilder() {
    String customerId = "customer_id";

    DeleteUserDataOptions deleteOptions = new DeleteUserDataOptions.Builder()
        .customerId(customerId)
        .build();

    assertEquals(deleteOptions.customerId(), customerId);
  }

  @Test
  public void testListMentionsBuilder() {
    String entity = "entity";

    ListMentionsOptions listMentionsOptions = new ListMentionsOptions.Builder()
        .workspaceId(WORKSPACE_ID)
        .entity(entity)
        .export(true)
        .includeAudit(true)
        .build();

    assertEquals(listMentionsOptions.workspaceId(), WORKSPACE_ID);
    assertEquals(listMentionsOptions.entity(), entity);
    assertEquals(listMentionsOptions.export(), true);
    assertEquals(listMentionsOptions.includeAudit(), true);
  }

  @Test
  public void testMessageContextMetadata() {
    String deployment = "deployment";
    String userId = "user_id";

    MessageContextMetadata messageContextMetadata = new MessageContextMetadata();
    messageContextMetadata.setDeployment(deployment);
    messageContextMetadata.setUserId(userId);

    assertEquals(deployment, messageContextMetadata.getDeployment());
    assertEquals(userId, messageContextMetadata.getUserId());
  }

  @Test
  public void testCreateEntityBuilder() {
    String entity = "entity";
    String description = "Entity description";
    Map<String, Object> metadata = new HashMap<>();
    String metadataKey = "metadata_key";
    String metadataValue = "metadata_value";
    metadata.put(metadataKey, metadataValue);
    Date testDate = new Date();
    String value = "value";
    CreateValue createValue = new CreateValue.Builder(value).build();
    CreateValue secondValue = new CreateValue.Builder().value(value).build();
    List<CreateValue> values = new ArrayList<>();
    values.add(createValue);

    CreateEntity createEntity = new CreateEntity.Builder()
        .entity(entity)
        .description(description)
        .metadata(metadata)
        .values(values)
        .addValues(secondValue)
        .fuzzyMatch(true)
        .created(testDate)
        .updated(testDate)
        .build();
    createEntity = createEntity.newBuilder().build();

    assertEquals(entity, createEntity.entity());
    assertEquals(description, createEntity.description());
    assertTrue(createEntity.metadata().containsKey(metadataKey));
    assertEquals(metadataValue, createEntity.metadata().get(metadataKey));
    assertNotNull(createEntity.values());
    assertEquals(2, createEntity.values().size());
    assertTrue(createEntity.fuzzyMatch());
    assertEquals(testDate, createEntity.created());
    assertEquals(testDate, createEntity.updated());
  }

  @Test
  public void testCreateIntentBuilder() {
    String intent = "intent";
    String description = "Intent description";
    Date testDate = new Date();
    String text = "text";
    Example example = new Example.Builder(text).build();
    Example secondExample = new Example.Builder().text(text).build();
    List<Example> examples = new ArrayList<>();
    examples.add(example);

    CreateIntent createIntent = new CreateIntent.Builder()
        .intent(intent)
        .description(description)
        .examples(examples)
        .addExample(secondExample)
        .created(testDate)
        .updated(testDate)
        .build();
    createIntent = createIntent.newBuilder().build();

    assertEquals(intent, createIntent.intent());
    assertEquals(description, createIntent.description());
    assertNotNull(createIntent.examples());
    assertEquals(2, createIntent.examples().size());
    assertEquals(testDate, createIntent.created());
    assertEquals(testDate, createIntent.updated());
  }

  @Test
  public void testRuntimeEntityInterpretation() {
    RuntimeEntityInterpretation interpretation = new RuntimeEntityInterpretation();

    interpretation.setCalendarType(CALENDAR_TYPE);
    interpretation.setDatetimeLink(DATETIME_LINK);
    interpretation.setFestival(FESTIVAL);
    interpretation.setGranularity(RuntimeEntityInterpretation.Granularity.DAY);
    interpretation.setRangeLink(RANGE_LINK);
    interpretation.setRangeModifier(RANGE_MODIFIER);
    interpretation.setRelativeDay(RELATIVE_DAY);
    interpretation.setRelativeMonth(RELATIVE_MONTH);
    interpretation.setRelativeWeek(RELATIVE_WEEK);
    interpretation.setRelativeWeekend(RELATIVE_WEEKEND);
    interpretation.setRelativeYear(RELATIVE_YEAR);
    interpretation.setSpecificDay(SPECIFIC_DAY);
    interpretation.setSpecificDayOfWeek(SPECIFIC_DAY_OF_WEEK);
    interpretation.setSpecificMonth(SPECIFIC_MONTH);
    interpretation.setSpecificQuarter(SPECIFIC_QUARTER);
    interpretation.setSpecificYear(SPECIFIC_YEAR);
    interpretation.setNumericValue(NUMERIC_VALUE);
    interpretation.setSubtype(SUBTYPE);
    interpretation.setPartOfDay(PART_OF_DAY);
    interpretation.setRelativeHour(RELATIVE_HOUR);
    interpretation.setRelativeMinute(RELATIVE_MINUTE);
    interpretation.setRelativeSecond(RELATIVE_SECOND);
    interpretation.setSpecificHour(SPECIFIC_HOUR);
    interpretation.setSpecificMinute(SPECIFIC_MINUTE);
    interpretation.setSpecificSecond(SPECIFIC_SECOND);
    interpretation.setTimezone(TIMEZONE);

    assertEquals(CALENDAR_TYPE, interpretation.getCalendarType());
    assertEquals(DATETIME_LINK, interpretation.getDatetimeLink());
    assertEquals(FESTIVAL, interpretation.getFestival());
    assertEquals(RuntimeEntityInterpretation.Granularity.DAY, interpretation.getGranularity());
    assertEquals(RANGE_LINK, interpretation.getRangeLink());
    assertEquals(RANGE_MODIFIER, interpretation.getRangeModifier());
    assertEquals(RELATIVE_DAY, interpretation.getRelativeDay());
    assertEquals(RELATIVE_MONTH, interpretation.getRelativeMonth());
    assertEquals(RELATIVE_WEEK, interpretation.getRelativeWeek());
    assertEquals(RELATIVE_WEEKEND, interpretation.getRelativeWeekend());
    assertEquals(RELATIVE_YEAR, interpretation.getRelativeYear());
    assertEquals(SPECIFIC_DAY, interpretation.getSpecificDay());
    assertEquals(SPECIFIC_DAY_OF_WEEK, interpretation.getSpecificDayOfWeek());
    assertEquals(SPECIFIC_MONTH, interpretation.getSpecificMonth());
    assertEquals(SPECIFIC_QUARTER, interpretation.getSpecificQuarter());
    assertEquals(SPECIFIC_YEAR, interpretation.getSpecificYear());
    assertEquals(NUMERIC_VALUE, interpretation.getNumericValue());
    assertEquals(SUBTYPE, interpretation.getSubtype());
    assertEquals(PART_OF_DAY, interpretation.getPartOfDay());
    assertEquals(RELATIVE_HOUR, interpretation.getRelativeHour());
    assertEquals(RELATIVE_MINUTE, interpretation.getRelativeMinute());
    assertEquals(RELATIVE_SECOND, interpretation.getRelativeSecond());
    assertEquals(SPECIFIC_HOUR, interpretation.getSpecificHour());
    assertEquals(SPECIFIC_MINUTE, interpretation.getSpecificMinute());
    assertEquals(SPECIFIC_SECOND, interpretation.getSpecificSecond());
    assertEquals(TIMEZONE, interpretation.getTimezone());
  }

  @Test
  public void testRuntimeEntityRole() {
    RuntimeEntityRole role = new RuntimeEntityRole();
    role.setType(RuntimeEntityRole.Type.DATE_FROM);
    assertEquals(RuntimeEntityRole.Type.DATE_FROM, role.getType());
  }

  @Test
  public void testWorkspaceSystemSettingsSystemEntities() {
    WorkspaceSystemSettingsSystemEntities entities = new WorkspaceSystemSettingsSystemEntities();
    entities.setEnabled(true);
    assertTrue(entities.isEnabled());
  }

  // --- METHODS ---

  /**
   * Test send message.
   *
   * @throws IOException Signals that an I/O exception has occurred.
   * @throws InterruptedException the interrupted exception
   */
  @Test
  public void testSendMessage() throws IOException, InterruptedException {
    String text = "I would love to hear some jazz music.";

    MessageResponse mockResponse = loadFixture(FIXTURE, MessageResponse.class);
    server.enqueue(jsonResponse(mockResponse));

    MessageInput input = new MessageInput();
    input.setText(text);
    RuntimeIntent intent = new RuntimeIntent();
    intent.setIntent("turn_on");
    intent.setConfidence(0.0);
    RuntimeEntity entity = new RuntimeEntity();
    entity.setEntity("genre");
    entity.setValue("jazz");
    MessageOptions options = new MessageOptions.Builder(WORKSPACE_ID)
        .input(input)
        .addIntent(intent)
        .addEntity(entity)
        .alternateIntents(true)
        .build();

    // execute first request
    MessageResponse serviceResponse = service.message(options).execute().getResult();

    // first request
    RecordedRequest request = server.takeRequest();

    String path = StringUtils.join(PATH_MESSAGE, "?", VERSION, "=2018-07-10");
    assertEquals(path, request.getPath());
    assertArrayEquals(new String[]{"Great choice! Playing some jazz for you."},
        serviceResponse.getOutput().getText().toArray(new String[0]));
    assertEquals(request.getMethod(), "POST");
    assertNotNull(request.getHeader(HttpHeaders.AUTHORIZATION));
    assertNotNull(serviceResponse.getActions());
    assertNotNull(serviceResponse.getActions().get(0).getName());
    assertNotNull(serviceResponse.getActions().get(0).getCredentials());
    assertNotNull(serviceResponse.getActions().get(0).getActionType());
    assertNotNull(serviceResponse.getActions().get(0).getParameters());
    assertNotNull(serviceResponse.getActions().get(0).getResultVariable());
    assertNotNull(serviceResponse.getOutput().getLogMessages());
    assertNotNull(serviceResponse.getOutput().getNodesVisited());
    assertNotNull(serviceResponse.getOutput().getNodesVisitedDetails());
    assertNotNull(serviceResponse.getOutput().getNodesVisitedDetails().get(0).getDialogNode());
    assertNotNull(serviceResponse.getOutput().getNodesVisitedDetails().get(0).getTitle());
    assertNotNull(serviceResponse.getOutput().getNodesVisitedDetails().get(0).getConditions());
    assertNotNull(serviceResponse.getOutput().getNodesVisitedDetails().get(0).getConditions());
    assertNotNull(serviceResponse.getEntities().get(0).getInterpretation());
    assertNotNull(serviceResponse.getEntities().get(0).getRole());
  }

  /**
   * Test send message. use some different MessageOptions options like context and other public methods
   *
   * @throws IOException Signals that an I/O exception has occurred.
   * @throws InterruptedException the interrupted exception
   */
  @Test
  public void testSendMessageWithAlternateIntents() throws IOException, InterruptedException {
    MessageResponse mockResponse = loadFixture(FIXTURE, MessageResponse.class);
    server.enqueue(jsonResponse(mockResponse));

    MessageContextMetadata metadata = new MessageContextMetadata();
    Context contextTemp = new Context();
    contextTemp.put("name", "Myname");
    contextTemp.setMetadata(metadata);
    MessageInput inputTemp = new MessageInput();
    inputTemp.setText("My text");

    assertEquals("Myname", contextTemp.get("name"));
    assertEquals(metadata, contextTemp.getMetadata());

    MessageOptions options = new MessageOptions.Builder(WORKSPACE_ID)
        .input(inputTemp)
        .alternateIntents(false)
        .context(contextTemp)
        .entities(null).intents(null).build();

    // execute first request
    MessageResponse serviceResponse = service.message(options).execute().getResult();

    // first request
    RecordedRequest request = server.takeRequest();

    String path = StringUtils.join(PATH_MESSAGE, "?", VERSION, "=2018-07-10");
    assertEquals(path, request.getPath());
    assertArrayEquals(new String[] { "Great choice! Playing some jazz for you." },
        serviceResponse.getOutput().getText().toArray(new String[0]));
    assertEquals(request.getMethod(), "POST");
    assertNotNull(request.getHeader(HttpHeaders.AUTHORIZATION));
  }

  @Test
  public void testSendMessageWithMessageRequest() throws FileNotFoundException, InterruptedException {
    String text = "I would love to hear some jazz music.";

    MessageResponse mockResponse = loadFixture(FIXTURE, MessageResponse.class);
    server.enqueue(jsonResponse(mockResponse));

    MessageInput input = new MessageInput();
    input.setText(text);
    RuntimeIntent intent = new RuntimeIntent();
    intent.setIntent("turn_on");
    intent.setConfidence(0.0);
    RuntimeEntity entity = new RuntimeEntity();
    entity.setEntity("genre");
    entity.setValue("jazz");
    Context context = new Context();
    OutputData outputData = new OutputData();


    MessageRequest messageRequest = new MessageRequest();
    messageRequest.setInput(input);
    messageRequest.setIntents(Collections.singletonList(intent));
    messageRequest.setEntities(Collections.singletonList(entity));
    messageRequest.setAlternateIntents(true);
    messageRequest.setContext(context);
    messageRequest.setOutput(outputData);

    assertEquals(input, messageRequest.getInput());
    assertEquals(intent, messageRequest.getIntents().get(0));
    assertEquals(entity, messageRequest.getEntities().get(0));
    assertEquals(context, messageRequest.getContext());
    assertEquals(outputData, messageRequest.getOutput());

    MessageOptions options = new MessageOptions.Builder()
        .workspaceId(WORKSPACE_ID)
        .messageRequest(messageRequest)
        .build();

    // execute first request
    MessageResponse serviceResponse = service.message(options).execute().getResult();

    // first request
    RecordedRequest request = server.takeRequest();

    String path = StringUtils.join(PATH_MESSAGE, "?", VERSION, "=2018-07-10");
    assertEquals(path, request.getPath());
    assertArrayEquals(new String[]{"Great choice! Playing some jazz for you."},
        serviceResponse.getOutput().getText().toArray(new String[0]));
    assertEquals(request.getMethod(), "POST");
    assertNotNull(request.getHeader(HttpHeaders.AUTHORIZATION));
    assertNotNull(serviceResponse.getActions());
    assertNotNull(serviceResponse.getActions().get(0).getName());
    assertNotNull(serviceResponse.getActions().get(0).getCredentials());
    assertNotNull(serviceResponse.getActions().get(0).getActionType());
    assertNotNull(serviceResponse.getActions().get(0).getParameters());
    assertNotNull(serviceResponse.getActions().get(0).getResultVariable());
    assertNotNull(serviceResponse.getOutput().getLogMessages());
    assertNotNull(serviceResponse.getOutput().getNodesVisited());
    assertNotNull(serviceResponse.getOutput().getNodesVisitedDetails());
    assertNotNull(serviceResponse.getOutput().getNodesVisitedDetails().get(0).getDialogNode());
    assertNotNull(serviceResponse.getOutput().getNodesVisitedDetails().get(0).getTitle());
    assertNotNull(serviceResponse.getOutput().getNodesVisitedDetails().get(0).getConditions());
    assertNotNull(serviceResponse.getOutput().getNodesVisitedDetails().get(0).getConditions());
  }

  /**
   * Negative - Test message with null workspace id.
   *
   * @throws InterruptedException the interrupted exception
   */
  @Test(expected = IllegalArgumentException.class)
  public void testSendMessageWithNullWorkspaceId() throws InterruptedException {
    String text = "I'd like to get insurance to for my home";

    MessageInput input = new MessageInput();
    input.setText(text);
    MessageOptions options = new MessageOptions.Builder().input(input).alternateIntents(true).build();

    service.message(options).execute().getResult();
  }
}
