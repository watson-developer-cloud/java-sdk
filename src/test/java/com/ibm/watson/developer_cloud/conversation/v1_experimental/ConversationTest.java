/*
 * Copyright 2015 IBM Corp. All Rights Reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except
 * in compliance with the License. You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software distributed under the License
 * is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express
 * or implied. See the License for the specific language governing permissions and limitations under
 * the License.
 */
package com.ibm.watson.developer_cloud.conversation.v1_experimental;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.io.IOException;

import org.apache.commons.lang3.StringUtils;
import org.junit.Before;
import org.junit.Test;

import com.ibm.watson.developer_cloud.WatsonServiceUnitTest;
import com.ibm.watson.developer_cloud.conversation.v1_experimental.model.MessageRequest;
import com.ibm.watson.developer_cloud.conversation.v1_experimental.model.MessageResponse;
import com.ibm.watson.developer_cloud.http.HttpHeaders;

import okhttp3.mockwebserver.RecordedRequest;

/**
 * Unit tests for the {@link ConversationService}
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
    service = new ConversationService(ConversationService.VERSION_DATE_2016_05_19);
    service.setApiKey(EMPTY);
    service.setEndPoint(getMockWebServerUrl());

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

    MessageRequest options = new MessageRequest.Builder().inputText(text).build();

    // execute first request
    MessageResponse serviceResponse = service.message(WORKSPACE_ID, options).execute();

    // first request
    RecordedRequest request = server.takeRequest();

    String path = StringUtils.join(PATH_MESSAGE, "?", VERSION, "=", ConversationService.VERSION_DATE_2016_05_19);
    assertEquals(path, request.getPath());
    assertArrayEquals(new String[] {"Do you want to get a quote?"}, serviceResponse.getText().toArray(new String[0]));
    assertEquals("Do you want to get a quote?", serviceResponse.getTextConcatenated(" "));
    assertEquals(request.getMethod(), "POST");
    assertNotNull(request.getHeader(HttpHeaders.AUTHORIZATION));
    assertEquals("{\"input\":{\"text\":\"I'd like to get insurance to for my home\"}}", request.getBody().readUtf8());
    assertEquals(serviceResponse, mockResponse);
  }
}
