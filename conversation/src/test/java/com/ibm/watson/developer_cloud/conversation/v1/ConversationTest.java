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

import static org.junit.Assert.*;

import java.io.IOException;
import java.text.MessageFormat;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.junit.Before;
import org.junit.Test;

import com.google.gson.Gson;
import com.ibm.watson.developer_cloud.WatsonServiceUnitTest;
import com.ibm.watson.developer_cloud.conversation.v1.model.Entity;
import com.ibm.watson.developer_cloud.conversation.v1.model.Intent;
import com.ibm.watson.developer_cloud.conversation.v1.model.MessageRequest;
import com.ibm.watson.developer_cloud.conversation.v1.model.MessageResponse;
import com.ibm.watson.developer_cloud.conversation.v1.model.MultipleRecordsOptions;
import com.ibm.watson.developer_cloud.conversation.v1.model.workspace.WorkspaceExportResponse;
import com.ibm.watson.developer_cloud.conversation.v1.model.workspace.WorkspaceListResponse;
import com.ibm.watson.developer_cloud.conversation.v1.model.workspace.WorkspaceRequest;
import com.ibm.watson.developer_cloud.conversation.v1.model.workspace.WorkspaceResponse;
import com.ibm.watson.developer_cloud.conversation.v1.model.workspace.entity.CreateEntity;
import com.ibm.watson.developer_cloud.conversation.v1.model.workspace.intent.IntentExportResponse;
import com.ibm.watson.developer_cloud.conversation.v1.model.workspace.intent.IntentListResponse;
import com.ibm.watson.developer_cloud.conversation.v1.model.workspace.intent.CreateExample;
import com.ibm.watson.developer_cloud.conversation.v1.model.workspace.intent.CreateIntent;
import com.ibm.watson.developer_cloud.conversation.v1.model.workspace.intent.IntentResponse;
import com.ibm.watson.developer_cloud.conversation.v1.model.workspace.nodes.CreateDialogNode;
import com.ibm.watson.developer_cloud.http.HttpHeaders;
import okhttp3.mockwebserver.RecordedRequest;

/**
 * Unit tests for the {@link ConversationService}.
 */
public class ConversationTest extends WatsonServiceUnitTest {
    private ConversationService service;
    private static final String MESSAGES_FIXTURE = "src/test/resources/conversation/message.json";
    private static final String INTENTS_FIXTURE = "src/test/resources/conversation/intents.json";
    private static final String INTENT_FIXTURE = "src/test/resources/conversation/intent.json";
    private static final String WORKSPACES_FIXTURE = "src/test/resources/conversation/workspaces.json";
    private static final String WORKSPACE_FIXTURE = "src/test/resources/conversation/workspace.json";
    private static final String WORKSPACE_ID = "123";
    private static final String INTENT_ID = "ABC";
    private static final String PATH_MESSAGE = "/v1/workspaces/" + WORKSPACE_ID + "/message";
    private static final String PATH_INTENTS = "/v1/workspaces/" + WORKSPACE_ID + "/intents";
    private static final String PATH_INTENT = "/v1/workspaces/" + WORKSPACE_ID + "/intents/" + INTENT_ID;
    private static final String PATH_WORKSPACES = "/v1/workspaces";
    private static final String PATH_WORKSPACE = "/v1/workspaces/" + WORKSPACE_ID;
    private static final String EMPTY = "";
    private static final String VERSION = "version";
    private static final String EXPORT = "export";

    // Test Values
    private static final String TEST_INTENT = "hello";
    private static final String TEST_INTENT_DESCRIPTION = "Test Description";
    private static final String TEST_INTENT_EXAMPLE_TEXT = "good morning";

    private static final String TEST_WORKSPACE_NAME = "API test";
    private static final String TEST_WORKSPACE_CREATED = "2017-01-31T18:02:19.070Z";
    private static final String TEST_WORKSPACE_UPDATED = "2017-01-31T18:02:19.070Z";
    private static final String TEST_WORKSPACE_LANGUAGE = "en";
    private static final String TEST_WORKSPACE_METADATA = null;
    private static final String TEST_WORKSPACE_DESCRIPTION = "Example workspace created via API.";
    private static final String TEST_WORKSPACE_WORKSPACE_ID = "245edf96-b89f-46ac-b647-c6618b2eb5f0";

    /*
     * (non-Javadoc)
     *
     * @see com.ibm.watson.developer_cloud.WatsonServiceTest#setUp()
     */
    @Override
    @Before
    public void setUp() throws Exception {
        super.setUp();
        service = new ConversationService(ConversationService.VERSION_DATE_2017_02_03);
        service.setApiKey(EMPTY);
        service.setEndPoint(getMockWebServerUrl());
    }

    /**
     * Test get workspace list.
     *
     * @throws IOException Signals that an I/O exception has occurred.
     * @throws InterruptedException the interrupted exception
     */
    @Test
    public void testGetWorkspaces() throws IOException, InterruptedException {
        WorkspaceListResponse mockResponse = loadFixture(WORKSPACES_FIXTURE, WorkspaceListResponse.class);
        server.enqueue(jsonResponse(mockResponse));

        // Execute get intent list
        WorkspaceListResponse serviceResponse = service.listWorkspaces().execute();

        // first request
        RecordedRequest request = server.takeRequest();

        String path = StringUtils.join(PATH_WORKSPACES, "?", VERSION, "=", ConversationService.VERSION_DATE_2017_02_03);
        assertEquals(path, request.getPath());

        assertNotNull(serviceResponse.getworkspaces());
        assertEquals(3, serviceResponse.getworkspaces().size());
        assertEquals("Car_Dashboard", serviceResponse.getworkspaces().get(0).getName());
        assertEquals("2016-07-13T12:26:55.781Z", serviceResponse.getworkspaces().get(0).getCreated());
        assertEquals("2016-11-29T21:46:38.969Z", serviceResponse.getworkspaces().get(0).getUpdated());
        assertEquals("en", serviceResponse.getworkspaces().get(0).getLanguage());
        assertEquals("Cognitive Car workspace which allows multi-turn conversations to perform tasks in the car.",
                serviceResponse.getworkspaces().get(0).getDescription());
        assertEquals("0a0c06c1-8e31-4655-9067-58fcac5134fc", serviceResponse.getworkspaces().get(0).getWorkspaceID());

        assertNotNull(serviceResponse.getPagination());
        assertEquals("/v1/workspaces?version=2017-02-03", serviceResponse.getPagination().getRefreshURL());

        assertEquals("GET", request.getMethod());
        assertNotNull(request.getHeader(HttpHeaders.AUTHORIZATION));
        assertEquals(serviceResponse, mockResponse);
    }

    /**
     * Test create workspace.
     *
     * @throws IOException Signals that an I/O exception has occurred.
     * @throws InterruptedException the interrupted exception
     */
    @Test
    public void testCreateWorkspace() throws IOException, InterruptedException {
        WorkspaceResponse mockResponse = loadFixture(WORKSPACE_FIXTURE, WorkspaceResponse.class);
        server.enqueue(jsonResponse(mockResponse));

        WorkspaceRequest options = new WorkspaceRequest.Builder()
        		.setDescription(TEST_WORKSPACE_DESCRIPTION)
                .setName(TEST_WORKSPACE_NAME)
                .setLanguage(TEST_WORKSPACE_LANGUAGE)
                .setMetadata(TEST_WORKSPACE_METADATA)
                .addIntent(new CreateIntent.Builder().setIntent("i0").build())
                .addIntents(Arrays.asList(
                		new CreateIntent.Builder().setIntent("i1").build(),
                		new CreateIntent.Builder().setIntent("i2").build()))
                .addCounterExample(new CreateExample("ex0"))
                .addCounterExamples(Arrays.asList(
                		new CreateExample("ex1"),
                		new CreateExample("ex2")))
                .addDialogNode(new CreateDialogNode("n0"))
                .addDialogNodes(Arrays.asList(
                		new CreateDialogNode("n1"),
                		new CreateDialogNode("n2")))
                .addEntity(new CreateEntity("e0"))
                .addEntities(Arrays.asList(
                		new CreateEntity("e1"),
                		new CreateEntity("e2")))
                .build();

        WorkspaceResponse serviceResponse = service.createWorkspace(options).execute();
        RecordedRequest request = server.takeRequest();

        String path = StringUtils.join(PATH_WORKSPACES, "?", VERSION, "=", ConversationService.VERSION_DATE_2017_02_03);
        assertEquals(path, request.getPath());
//
//        assertNotNull(serviceResponse);
//        assertEquals(TEST_WORKSPACE_NAME, serviceResponse.getName());
//        assertEquals(TEST_WORKSPACE_CREATED, serviceResponse.getCreated());
//        assertEquals(TEST_WORKSPACE_UPDATED, serviceResponse.getUpdated());
//        assertEquals(TEST_WORKSPACE_LANGUAGE, serviceResponse.getLanguage());
//        assertEquals(TEST_WORKSPACE_DESCRIPTION, serviceResponse.getDescription());
//        assertEquals(TEST_WORKSPACE_WORKSPACE_ID, serviceResponse.getWorkspaceID());
//        assertEquals(TEST_WORKSPACE_METADATA, serviceResponse.getMetadata());
//        assertEquals(serviceResponse, mockResponse);

        assertEquals(request.getMethod(), "POST");
        assertNotNull(request.getHeader(HttpHeaders.AUTHORIZATION));
        WorkspaceRequest actual = new Gson().fromJson(request.getBody().readUtf8(), WorkspaceRequest.class);
        assertEquals(TEST_WORKSPACE_NAME, actual.getName());
        assertEquals(TEST_WORKSPACE_LANGUAGE, actual.getLanguage());
        assertEquals(TEST_WORKSPACE_DESCRIPTION, actual.getDescription());
        assertEquals(TEST_WORKSPACE_METADATA, actual.getMetadata());
        
        List<CreateIntent> intents = actual.getIntents();
		assertEquals(3, intents.size());
        assertEquals("i0", intents.get(0).getIntent());
        assertEquals("i1", intents.get(1).getIntent());
        assertEquals("i2", intents.get(2).getIntent());
        
        List<CreateExample> examples = actual.getCounterExamples();
		assertEquals(3, examples.size());
        assertEquals("ex0", examples.get(0).getText());
        assertEquals("ex1", examples.get(1).getText());
        assertEquals("ex2", examples.get(2).getText());
        
        List<CreateDialogNode> nodes = actual.getDialogNodes();
		assertEquals(3, nodes.size());
        assertEquals("n0", nodes.get(0).getDialogNode());
        assertEquals("n1", nodes.get(1).getDialogNode());
        assertEquals("n2", nodes.get(2).getDialogNode());
        
        List<CreateEntity> entities = actual.getEntities();
        assertEquals(3, entities.size());
        assertEquals("e0", entities.get(0).getEntity());
        assertEquals("e1", entities.get(1).getEntity());
        assertEquals("e2", entities.get(2).getEntity());
    }

    /**
     * Test delete workspace.
     *
     * @throws IOException Signals that an I/O exception has occurred.
     * @throws InterruptedException the interrupted exception
     */
    @Test
    public void testDeleteWorkspace() throws IOException, InterruptedException {
        server.enqueue(jsonResponse(null));

        Void serviceResponse = service.deleteWorkspace(WORKSPACE_ID).execute();
        RecordedRequest request = server.takeRequest();

        String path = StringUtils.join(PATH_WORKSPACE, "?", VERSION, "=", ConversationService.VERSION_DATE_2017_02_03);
        assertEquals(path, request.getPath());

        assertEquals(request.getMethod(), "DELETE");
        assertNotNull(request.getHeader(HttpHeaders.AUTHORIZATION));
        assertEquals(serviceResponse, null);
    }

    /**
     * Test get workspace.
     *
     * @throws IOException Signals that an I/O exception has occurred.
     * @throws InterruptedException the interrupted exception
     */
    @Test
    public void testGetWorkspace() throws IOException, InterruptedException {
        WorkspaceResponse mockResponse = loadFixture(WORKSPACE_FIXTURE, WorkspaceExportResponse.class);
        server.enqueue(jsonResponse(mockResponse));

        WorkspaceResponse serviceResponse = service.getWorkspace(WORKSPACE_ID).execute();
        RecordedRequest request = server.takeRequest();

        String path = StringUtils.join(PATH_WORKSPACE, "?", VERSION, "=", ConversationService.VERSION_DATE_2017_02_03);
        assertEquals(path, request.getPath());

        assertNotNull(serviceResponse);
        assertEquals(TEST_WORKSPACE_NAME, serviceResponse.getName());
        assertEquals(TEST_WORKSPACE_CREATED, serviceResponse.getCreated());
        assertEquals(TEST_WORKSPACE_UPDATED, serviceResponse.getUpdated());
        assertEquals(TEST_WORKSPACE_LANGUAGE, serviceResponse.getLanguage());
        assertEquals(TEST_WORKSPACE_DESCRIPTION, serviceResponse.getDescription());
        assertEquals(TEST_WORKSPACE_WORKSPACE_ID, serviceResponse.getWorkspaceID());
        assertEquals(TEST_WORKSPACE_METADATA, serviceResponse.getMetadata());

        assertEquals(request.getMethod(), "GET");
        assertNotNull(request.getHeader(HttpHeaders.AUTHORIZATION));
        assertEquals(serviceResponse, mockResponse);
    }

    /**
     * Test update intent.
     *
     * @throws IOException Signals that an I/O exception has occurred.
     * @throws InterruptedException the interrupted exception
     */
    @Test
    public void testUpdateWorkspace() throws IOException, InterruptedException {
        WorkspaceResponse mockResponse = loadFixture(WORKSPACE_FIXTURE, WorkspaceResponse.class);
        server.enqueue(jsonResponse(mockResponse));

        WorkspaceRequest options = new WorkspaceRequest.Builder()
                .setDescription(TEST_WORKSPACE_DESCRIPTION)
                .setName(TEST_WORKSPACE_NAME)
                .setLanguage(TEST_WORKSPACE_LANGUAGE)
                .setMetadata(TEST_WORKSPACE_METADATA)
                .addIntent(new CreateIntent.Builder().setIntent("i0").build())
                .addIntents(Arrays.asList(
                		new CreateIntent.Builder().setIntent("i1").build(),
                		new CreateIntent.Builder().setIntent("i2").build()))
                .addCounterExample(new CreateExample("ex0"))
                .addCounterExamples(Arrays.asList(
                		new CreateExample("ex1"),
                		new CreateExample("ex2")))
                .addDialogNode(new CreateDialogNode("n0"))
                .addDialogNodes(Arrays.asList(
                		new CreateDialogNode("n1"),
                		new CreateDialogNode("n2")))
                .addEntity(new CreateEntity("e0"))
                .addEntities(Arrays.asList(
                		new CreateEntity("e1"),
                		new CreateEntity("e2")))
                .build();

        WorkspaceResponse serviceResponse = service.updateWorkspace(WORKSPACE_ID, options).execute();
        RecordedRequest request = server.takeRequest();

        String path = StringUtils.join(PATH_WORKSPACE, "?", VERSION, "=", ConversationService.VERSION_DATE_2017_02_03);
        assertEquals(path, request.getPath());

//        assertNotNull(serviceResponse);
//        assertEquals(TEST_WORKSPACE_NAME, serviceResponse.getName());
//        assertEquals(TEST_WORKSPACE_CREATED, serviceResponse.getCreated());
//        assertEquals(TEST_WORKSPACE_UPDATED, serviceResponse.getUpdated());
//        assertEquals(TEST_WORKSPACE_LANGUAGE, serviceResponse.getLanguage());
//        assertEquals(TEST_WORKSPACE_DESCRIPTION, serviceResponse.getDescription());
//        assertEquals(TEST_WORKSPACE_WORKSPACE_ID, serviceResponse.getWorkspaceID());
//        assertEquals(TEST_WORKSPACE_METADATA, serviceResponse.getMetadata());
        assertEquals(serviceResponse, mockResponse);

        assertEquals(request.getMethod(), "PUT");
        assertNotNull(request.getHeader(HttpHeaders.AUTHORIZATION));

        WorkspaceRequest actual = new Gson().fromJson(request.getBody().readUtf8(), WorkspaceRequest.class);
        assertEquals(TEST_WORKSPACE_NAME, actual.getName());
        assertEquals(TEST_WORKSPACE_LANGUAGE, actual.getLanguage());
        assertEquals(TEST_WORKSPACE_DESCRIPTION, actual.getDescription());
        assertEquals(TEST_WORKSPACE_METADATA, actual.getMetadata());
        
        List<CreateIntent> intents = actual.getIntents();
		assertEquals(3, intents.size());
        assertEquals("i0", intents.get(0).getIntent());
        assertEquals("i1", intents.get(1).getIntent());
        assertEquals("i2", intents.get(2).getIntent());
        
        List<CreateExample> examples = actual.getCounterExamples();
		assertEquals(3, examples.size());
        assertEquals("ex0", examples.get(0).getText());
        assertEquals("ex1", examples.get(1).getText());
        assertEquals("ex2", examples.get(2).getText());
        
        List<CreateDialogNode> nodes = actual.getDialogNodes();
		assertEquals(3, nodes.size());
        assertEquals("n0", nodes.get(0).getDialogNode());
        assertEquals("n1", nodes.get(1).getDialogNode());
        assertEquals("n2", nodes.get(2).getDialogNode());
        
        List<CreateEntity> entities = actual.getEntities();
        assertEquals(3, entities.size());
        assertEquals("e0", entities.get(0).getEntity());
        assertEquals("e1", entities.get(1).getEntity());
        assertEquals("e2", entities.get(2).getEntity());    }

    /**
     * Test get intent list with records options.
     *
     * @throws IOException Signals that an I/O exception has occurred.
     * @throws InterruptedException the interrupted exception
     */
    @Test
    public void testGetIntentsWOptions() throws IOException, InterruptedException {
        IntentListResponse mockResponse = loadFixture(INTENTS_FIXTURE, IntentListResponse.class);
        server.enqueue(jsonResponse(mockResponse));

        // Execute get intent list
        MultipleRecordsOptions ops = new MultipleRecordsOptions();
        ops.setCursor("c1");
        ops.setIncludeCount(true);
        ops.setPageLimit(50);
        ops.setSort("id");
        IntentListResponse serviceResponse = service.getIntents(WORKSPACE_ID, true, ops).execute();

        // first request
        RecordedRequest request = server.takeRequest();

        String path = request.getPath();
        String qStr = path.substring(path.indexOf("?")+1);
		List<String> parts = Arrays.asList(qStr.split("&"));
		assertTrue(parts.contains(MessageFormat.format("{0}={1}", ConversationService.CURSOR_PARAM, "c1")));
		assertTrue(parts.contains(MessageFormat.format("{0}={1}", ConversationService.INCLUDE_COUNT_PARAM, "true")));
		assertTrue(parts.contains(MessageFormat.format("{0}={1}", ConversationService.PAGE_LIMIT_PARAM, "50")));
		assertTrue(parts.contains(MessageFormat.format("{0}={1}", ConversationService.SORT_PARAM, "id")));
    }
    /**
     * Test get intent list.
     *
     * @throws IOException Signals that an I/O exception has occurred.
     * @throws InterruptedException the interrupted exception
     */
    @Test
    public void testGetIntents() throws IOException, InterruptedException {
        IntentListResponse mockResponse = loadFixture(INTENTS_FIXTURE, IntentListResponse.class);
        server.enqueue(jsonResponse(mockResponse));

        // Execute get intent list
        IntentListResponse serviceResponse = service.getIntents(WORKSPACE_ID).execute();

        // first request
        RecordedRequest request = server.takeRequest();

        String path = StringUtils.join(PATH_INTENTS, "?", VERSION, "=", ConversationService.VERSION_DATE_2017_02_03);
        assertEquals(path, request.getPath());

        assertNotNull(serviceResponse.getIntents());
        assertEquals(1, serviceResponse.getIntents().size());
        IntentExportResponse intent0 = serviceResponse.getIntents().get(0);
		assertEquals("hello", intent0.getIntent());
        assertEquals("2017-02-02T21:04:26.049Z", intent0.getCreated());
        assertEquals("2017-02-02T21:04:26.049Z", intent0.getUpdated());
        assertEquals("A short description for testing.", intent0.getDescription());
        assertEquals(2, intent0.getExamples().size());
        assertEquals("good morning", intent0.getExamples().get(0).getText());
        assertEquals("2017-02-02T21:04:26.049Z", intent0.getExamples().get(0).getCreated());
        assertEquals("2017-02-02T21:04:26.049Z", intent0.getExamples().get(0).getUpdated());

        assertNotNull(serviceResponse.getPagination());
        assertEquals("/v1/workspaces/9978a49e-ea89-4493-b33d-82298d3db20d/intents?version=2017-02-03&export=true",
                serviceResponse.getPagination().getRefreshURL());

        assertEquals("GET", request.getMethod());
        assertNotNull(request.getHeader(HttpHeaders.AUTHORIZATION));
        assertEquals(serviceResponse, mockResponse);
    }

    /**
     * Test create intent.
     *
     * @throws IOException Signals that an I/O exception has occurred.
     * @throws InterruptedException the interrupted exception
     */
    @Test
    public void testCreateIntent() throws IOException, InterruptedException {
        IntentResponse mockResponse = loadFixture(INTENT_FIXTURE, IntentResponse.class);
        server.enqueue(jsonResponse(mockResponse));

        CreateExample example = new CreateExample(TEST_INTENT_EXAMPLE_TEXT);
        CreateExample example2 = new CreateExample("aaa");
        CreateExample example3 = new CreateExample("bbb");
        
		CreateIntent intReq = new CreateIntent.Builder()
                .setDescription(TEST_INTENT_DESCRIPTION)
                .setIntent(TEST_INTENT)
                .addExample(example)
                .addExamples(Arrays.asList(example2, example3))
                .build();
	     
		IntentResponse response = service.createIntent(WORKSPACE_ID, intReq).execute();
        RecordedRequest request = server.takeRequest();

        //assert request
        String path = StringUtils.join(PATH_INTENTS, "?", VERSION, "=", ConversationService.VERSION_DATE_2017_02_03);
        assertEquals(path, request.getPath());

        assertEquals(request.getMethod(), "POST");
        assertNotNull(request.getHeader(HttpHeaders.AUTHORIZATION));
        
        CreateIntent actPayload = new Gson().fromJson(request.getBody().readUtf8(), CreateIntent.class);
        assertEquals(TEST_INTENT, actPayload.getIntent());
        assertEquals(TEST_INTENT_DESCRIPTION, actPayload.getDescription());
        assertEquals(3, actPayload.getExamples().size());
        CreateExample actEx0 = actPayload.getExamples().get(0);
		assertEquals(TEST_INTENT_EXAMPLE_TEXT, actEx0.getText());
		assertEquals("aaa", actPayload.getExamples().get(1).getText());
		assertEquals("bbb", actPayload.getExamples().get(2).getText());  

        //assert response
        assertEquals(TEST_INTENT, response.getIntent());
        assertNotNull(response.getCreated());
        assertNotNull(response.getUpdated());
        assertEquals(TEST_INTENT_DESCRIPTION, response.getDescription());

        assertEquals(response, mockResponse);
    }

    /**
     * Test delete intent.
     *
     * @throws IOException Signals that an I/O exception has occurred.
     * @throws InterruptedException the interrupted exception
     */
    @Test
    public void testDeleteIntent() throws IOException, InterruptedException {
        IntentListResponse mockResponse = null;
        server.enqueue(jsonResponse(null));

        Void serviceResponse = service.deleteIntent(WORKSPACE_ID, INTENT_ID).execute();
        RecordedRequest request = server.takeRequest();

        String path = StringUtils.join(PATH_INTENT, "?", VERSION, "=", ConversationService.VERSION_DATE_2017_02_03);
        assertEquals(path, request.getPath());

        assertEquals(request.getMethod(), "DELETE");
        assertNotNull(request.getHeader(HttpHeaders.AUTHORIZATION));
        assertEquals(serviceResponse, mockResponse);
    }

    /**
     * Test get intent.
     *
     * @throws IOException Signals that an I/O exception has occurred.
     * @throws InterruptedException the interrupted exception
     */
    @Test
    public void testGetIntent() throws IOException, InterruptedException {
        IntentResponse mockResponse = loadFixture(INTENT_FIXTURE, IntentExportResponse.class);
        server.enqueue(jsonResponse(mockResponse));

        IntentResponse serviceResponse = service.getIntent(WORKSPACE_ID, INTENT_ID).execute();
        RecordedRequest request = server.takeRequest();

        String path = StringUtils.join(PATH_INTENT, "?", VERSION, "=", ConversationService.VERSION_DATE_2017_02_03,
            "&", EXPORT, "=", "false");
        assertEquals(path, request.getPath());

        assertEquals(TEST_INTENT, serviceResponse.getIntent());
        assertNotNull(serviceResponse.getCreated());
        assertNotNull(serviceResponse.getUpdated());
        assertEquals(TEST_INTENT_DESCRIPTION, serviceResponse.getDescription());

        assertEquals(request.getMethod(), "GET");
        assertNotNull(request.getHeader(HttpHeaders.AUTHORIZATION));
        assertEquals(serviceResponse, mockResponse);
    }

    /**
     * Test update intent.
     *
     * @throws IOException Signals that an I/O exception has occurred.
     * @throws InterruptedException the interrupted exception
     */
    @Test
    public void testUpdateIntent() throws IOException, InterruptedException {
        IntentResponse mockResponse = loadFixture(INTENT_FIXTURE, IntentResponse.class);
        server.enqueue(jsonResponse(mockResponse));

         CreateIntent options = new CreateIntent.Builder()
                .setDescription(TEST_INTENT_DESCRIPTION)
                .setIntent(TEST_INTENT)
                .addExample(new CreateExample(TEST_INTENT_EXAMPLE_TEXT))
                .build();

        IntentResponse serviceResponse = service.updateIntent(WORKSPACE_ID, INTENT_ID, options).execute();
        RecordedRequest request = server.takeRequest();

        String path = StringUtils.join(PATH_INTENT, "?", VERSION, "=", ConversationService.VERSION_DATE_2017_02_03);
        assertEquals(path, request.getPath());

        assertEquals(TEST_INTENT, serviceResponse.getIntent());
        assertNotNull(serviceResponse.getCreated());
        assertNotNull(serviceResponse.getUpdated());
        assertEquals(TEST_INTENT_DESCRIPTION, serviceResponse.getDescription());

        assertEquals(request.getMethod(), "PUT");
        assertNotNull(request.getHeader(HttpHeaders.AUTHORIZATION));
        IntentExportResponse fromJson = new Gson().fromJson(request.getBody().readUtf8(), IntentExportResponse.class);
        
        assertEquals(TEST_INTENT, fromJson.getIntent());
        assertEquals(TEST_INTENT_DESCRIPTION, fromJson.getDescription());
        assertEquals(TEST_INTENT_EXAMPLE_TEXT, fromJson.getExamples().get(0).getText());
        assertEquals(serviceResponse, mockResponse);
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

        MessageResponse mockResponse = loadFixture(MESSAGES_FIXTURE, MessageResponse.class);
        server.enqueue(jsonResponse(mockResponse));

        MessageRequest options = new MessageRequest.Builder().inputText(text).intent(new Intent("turn_off", 0.0))
                .entity(new Entity("car", "ford", null)).alternateIntents(true).build();

        // execute first request
        MessageResponse serviceResponse = service.message(WORKSPACE_ID, options).execute();

        // first request
        RecordedRequest request = server.takeRequest();

        String path = StringUtils.join(PATH_MESSAGE, "?", VERSION, "=", ConversationService.VERSION_DATE_2017_02_03);
        assertEquals(path, request.getPath());
        assertArrayEquals(new String[]{"Do you want to get a quote?"},
                serviceResponse.getText().toArray(new String[0]));
        assertEquals("Do you want to get a quote?", serviceResponse.getTextConcatenated(" "));
        assertEquals(request.getMethod(), "POST");
        assertNotNull(request.getHeader(HttpHeaders.AUTHORIZATION));
        assertEquals("{\"alternate_intents\":true,\"entities\":[{\"entity\":\"car\",\"value\":\"ford\"}],"
                + "\"input\":{\"text\":\"I'd like to get insurance to for my home\"},\"intents\":"
                + "[{\"confidence\":0.0,\"intent\":\"turn_off\"}]}", request.getBody().readUtf8());
        assertEquals(serviceResponse, mockResponse);
    }

    /**
     * Test send message. use some different MessageRequest options like context
     * and other public methods
     *
     * @throws IOException Signals that an I/O exception has occurred.
     * @throws InterruptedException the interrupted exception
     */
    @Test
    public void testSendMessageWithAlternateIntents() throws IOException, InterruptedException {
        MessageResponse mockResponse = loadFixture(MESSAGES_FIXTURE, MessageResponse.class);
        server.enqueue(jsonResponse(mockResponse));

        Map<String, Object> contextTemp = new HashMap<String, Object>();
        contextTemp.put("name", "Myname");
        Map<String, Object> inputTemp = new HashMap<String, Object>();
        inputTemp.put("text", "My text");

        MessageRequest options = new MessageRequest.Builder().input(inputTemp).alternateIntents(false)
                .context(contextTemp).entities(null).intents(null).build();

        // execute first request
        MessageResponse serviceResponse = service.message(WORKSPACE_ID, options).execute();

        // first request
        RecordedRequest request = server.takeRequest();

        String path = StringUtils.join(PATH_MESSAGE, "?", VERSION, "=", ConversationService.VERSION_DATE_2017_02_03);
        assertEquals(path, request.getPath());
        assertArrayEquals(new String[]{"Do you want to get a quote?"},
                serviceResponse.getText().toArray(new String[0]));
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
     * Negative - Test constructor with null version date.
     *
     * @throws InterruptedException the interrupted exception
     */
    @Test(expected = IllegalArgumentException.class)
    public void testConstructorWithNull() throws InterruptedException {
        new ConversationService(null);
    }

}
