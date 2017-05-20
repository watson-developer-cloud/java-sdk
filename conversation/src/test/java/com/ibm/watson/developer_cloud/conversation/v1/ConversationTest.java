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
package com.ibm.watson.developer_cloud.conversation.v1;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import com.ibm.watson.developer_cloud.conversation.v1.model.CreateDialogNode;
import com.ibm.watson.developer_cloud.conversation.v1.model.CreateEntity;
import com.ibm.watson.developer_cloud.conversation.v1.model.CreateExample;
import com.ibm.watson.developer_cloud.conversation.v1.model.CreateIntent;
import com.ibm.watson.developer_cloud.conversation.v1.model.UpdateWorkspace;
import org.apache.commons.lang3.StringUtils;
import org.junit.Before;
import org.junit.Test;

import com.ibm.watson.developer_cloud.WatsonServiceUnitTest;
import com.ibm.watson.developer_cloud.conversation.v1.model.Entity;
import com.ibm.watson.developer_cloud.conversation.v1.model.Intent;
import com.ibm.watson.developer_cloud.conversation.v1.model.MessageRequest;
import com.ibm.watson.developer_cloud.conversation.v1.model.MessageResponse;
import com.ibm.watson.developer_cloud.http.HttpHeaders;

import okhttp3.mockwebserver.RecordedRequest;

/**
 * Unit tests for the {@link ConversationService}.
 */
public class ConversationTest extends WatsonServiceUnitTest {
  private ConversationService service;
  private static final String FIXTURE = "src/test/resources/conversation/conversation.json";
  private static final String WORKSPACE_ID = "123";
  private static final String PATH_MESSAGE = "/v1/workspaces/" + WORKSPACE_ID + "/message";
  private static final String EMPTY = "";
  private static final String VERSION = "version";


  /*
   * (non-Javadoc)
   *
   * @see com.ibm.watson.developer_cloud.WatsonServiceTest#setUp()
   */
  @Override
  @Before
  public void setUp() throws Exception {
    super.setUp();
    service = new ConversationService(ConversationService.VERSION_DATE_2017_04_21);
    service.setApiKey(EMPTY);
    service.setEndPoint(getMockWebServerUrl());

  }

  /**
   * Negative - Test constructor with null version date.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testConstructorWithNullVersionDate() {
    new ConversationService(null);
  }

  /**
   * Negative - Test constructor with empty version date.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testConstructorWithEmptyVersionDate() {
    new ConversationService("");
  }

  /**
   * Negative - Test conversation with null workspaceId.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testConversationWithNullWorkspaceId() {
    service.message(null, null).execute();
  }

  /**
   * Negative - Test conversation with empty workspaceId.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testConversationWithEmptyWorkspaceId() {
    service.message("", null).execute();
  }

  /**
   * Test send message.
   *
   * @throws IOException Signals that an I/O exception has occurred.
   * @throws InterruptedException the interrupted exception
   */
  @Test
  public void testSendMessage() throws IOException, InterruptedException {
    String text = "I'd like to get insurance to for my home";

    MessageResponse mockResponse = loadFixture(FIXTURE, MessageResponse.class);
    server.enqueue(jsonResponse(mockResponse));

    MessageRequest options = new MessageRequest.Builder().inputText(text).intent(new Intent("turn_off", 0.0))
        .entity(new Entity("car", "ford", null)).alternateIntents(true).build();

    // execute first request
    MessageResponse serviceResponse = service.message(WORKSPACE_ID, options).execute();

    // first request
    RecordedRequest request = server.takeRequest();

    String path = StringUtils.join(PATH_MESSAGE, "?", VERSION, "=", ConversationService.VERSION_DATE_2017_04_21);
    assertEquals(path, request.getPath());
    assertArrayEquals(new String[] { "Do you want to get a quote?" }, serviceResponse.getText().toArray(new String[0]));
    assertEquals("Do you want to get a quote?", serviceResponse.getTextConcatenated(" "));
    assertEquals(request.getMethod(), "POST");
    assertNotNull(request.getHeader(HttpHeaders.AUTHORIZATION));
    assertEquals("{\"alternate_intents\":true,\"entities\":[{\"entity\":\"car\",\"value\":\"ford\"}],"
        + "\"input\":{\"text\":\"I'd like to get insurance to for my home\"},\"intents\":"
        + "[{\"confidence\":0.0,\"intent\":\"turn_off\"}]}", request.getBody().readUtf8());
    assertEquals(serviceResponse, mockResponse);
  }

  /**
   * Test send message. use some different MessageRequest options like context and other public methods
   *
   * @throws IOException Signals that an I/O exception has occurred.
   * @throws InterruptedException the interrupted exception
   */
  @Test
  public void testSendMessageWithAlternateIntents() throws IOException, InterruptedException {
    MessageResponse mockResponse = loadFixture(FIXTURE, MessageResponse.class);
    server.enqueue(jsonResponse(mockResponse));

    Map<String, Object> contextTemp = new HashMap<String, Object>();
    contextTemp.put("name", "Myname");
    Map<String, Object> inputTemp = new HashMap<String, Object>();
    inputTemp.put("text", "My text");

    MessageRequest options = new MessageRequest.Builder().input(inputTemp).alternateIntents(false).context(contextTemp)
        .entities(null).intents(null).build();

    // execute first request
    MessageResponse serviceResponse = service.message(WORKSPACE_ID, options).execute();

    // first request
    RecordedRequest request = server.takeRequest();

    String path = StringUtils.join(PATH_MESSAGE, "?", VERSION, "=", ConversationService.VERSION_DATE_2017_04_21);
    assertEquals(path, request.getPath());
    assertArrayEquals(new String[] { "Do you want to get a quote?" }, serviceResponse.getText().toArray(new String[0]));
    assertEquals("Do you want to get a quote?", serviceResponse.getTextConcatenated(" "));
    assertEquals(request.getMethod(), "POST");
    assertNotNull(request.getHeader(HttpHeaders.AUTHORIZATION));
    assertEquals(
        "{\"alternate_intents\":false," + "\"context\":{\"name\":\"Myname\"},\"input\":{\"text\":\"My text\"}}",
        request.getBody().readUtf8());
    assertEquals(serviceResponse, mockResponse);
  }


  /**
   * Negative - Test message with null workspace id.
   *
   * @throws InterruptedException the interrupted exception
   */
  @Test(expected = IllegalArgumentException.class)
  public void testSendMessageWithNullWorkspaceId() throws InterruptedException {
    String text = "I'd like to get insurance to for my home";

    MessageRequest options = new MessageRequest.Builder().inputText(text).alternateIntents(true).build();

    service.message(null, options).execute();
  }

  /**
   * Negative - Test message with null input text. BUG?
   *
   * @throws InterruptedException the interrupted exception
   */
  @Test(expected = IllegalArgumentException.class)
  public void testSendMessageWithInputTextNull() throws InterruptedException {
    MessageRequest options = new MessageRequest.Builder().inputText(null).alternateIntents(true).build();

    service.message(WORKSPACE_ID, options).execute();
  }

  /**
   * Test UpdateWorkspace builder.
   *
   */
  @Test
  public void testUpdateWorkspaceBuilder() {

    String workspaceName = "Builder Test";
    String workspaceDescription = "Description of " + workspaceName;
    String workspaceLanguage = "en";

    // intents
    CreateIntent testIntent = new CreateIntent.Builder("testIntent").build();

    // entities
    CreateEntity testEntity = new CreateEntity.Builder("testEntity").build();

    // counterexamples
    CreateExample testCounterexample = new CreateExample.Builder("testCounterexample").build();

    // dialognodes
    CreateDialogNode testDialogNode = new CreateDialogNode.Builder().dialogNode("testDialogNode").build();

    // metadata
    Map<String, Object> workspaceMetadata = new HashMap<String, Object>();
    String metadataValue = "value for " + workspaceName;
    workspaceMetadata.put("key", metadataValue);

    UpdateWorkspace.Builder builder = new UpdateWorkspace.Builder();
    builder.name(workspaceName);
    builder.description(workspaceDescription);
    builder.language(workspaceLanguage);
    builder.intents(testIntent);
    builder.entities(testEntity);
    builder.counterexamples(testCounterexample);
    builder.dialogNodes(testDialogNode);
    builder.metadata(workspaceMetadata);

    UpdateWorkspace options = builder.build();

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

    UpdateWorkspace.Builder builder2 = options.newBuilder();

    CreateIntent testIntent2 = new CreateIntent.Builder("testIntent2").build();
    CreateEntity testEntity2 = new CreateEntity.Builder("testEntity2").build();
    CreateExample testCounterexample2 = new CreateExample.Builder("testCounterexample2").build();
    CreateDialogNode testDialogNode2 = new CreateDialogNode.Builder().dialogNode("testDialogNode2").build();

    builder2.intents(new ArrayList<CreateIntent>());
    builder2.intents(testIntent2);
    builder2.entities(new ArrayList<CreateEntity>());
    builder2.entities(testEntity2);
    builder2.counterexamples(new ArrayList<CreateExample>());
    builder2.counterexamples(testCounterexample2);
    builder2.dialogNodes(new ArrayList<CreateDialogNode>());
    builder2.dialogNodes(testDialogNode2);

    UpdateWorkspace options2 = builder2.build();

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
}
