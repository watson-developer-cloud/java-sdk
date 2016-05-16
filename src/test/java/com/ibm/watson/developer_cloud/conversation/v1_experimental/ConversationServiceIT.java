/**
 * Copyright 2016 IBM Corp. All Rights Reserved.
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

import com.ibm.watson.developer_cloud.WatsonServiceTest;
import com.ibm.watson.developer_cloud.conversation.v1_experimental.Conversation;
import com.ibm.watson.developer_cloud.conversation.v1_experimental.model.ConversationRequest;
import com.ibm.watson.developer_cloud.conversation.v1_experimental.model.ConversationResponse;

import java.text.ParseException;
import java.util.Collections;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertNotNull;

/**
 * The Class ConversationServiceTest.
 */
public class ConversationServiceIT extends WatsonServiceTest {

  /** The service. */
  private Conversation service;

  /** The workspace id. */
  private String workspaceId;

  /** The Response object. */
  private ConversationResponse response;

  /*
   * (non-Javadoc)
   *
   * @see com.ibm.watson.developer_cloud.WatsonServiceTest#setUp()
   */
  @Override @Before public void setUp() throws Exception {
    super.setUp();
    service = new Conversation(Conversation.VERSION_DATE_2016_01_24);
    service.setUsernameAndPassword(getValidProperty("conversation.username"),
        getValidProperty("conversation.password"));
    service.setEndPoint(getValidProperty("conversation.url"));
    service.setDefaultHeaders(getDefaultHeaders());
    workspaceId = getValidProperty("conversation.workspace_id");
    response = service.message(workspaceId, new ConversationRequest("", Collections.<String, Object>emptyMap())).execute();
  }

  /**
   * Test conversation.
   *
   */
  private void testConversationResponse() {
    assertNotNull(response);
    assertNotNull(response.getContext());
    assertNotNull(response.getOutput());
    assertNotNull(response.getOutput().get("text"));
  }

  /**
   * Test create conversation.
   *
   * @throws ParseException the parse exception
   * @throws InterruptedException the interrupted exception
   */
  @Test public void testMessage() throws ParseException, InterruptedException {
    final String[] messages = new String[] {"large", "onions, pepperoni, cheese", "pickup", "yes"};
    for (final String message : messages) {
      response = service.message(workspaceId, new ConversationRequest(message, response.getContext())).execute();
      testConversationResponse();
      Thread.sleep(500);
    }
  }

  /**
   * Test message with nulls.
   */
  @Test(expected = IllegalArgumentException.class) public void testMessageWithNulls() {
    service.message(null, null).execute();
  }

  /**
   * Test to string.
   */
  @Test public void testToString() {
    assertNotNull(service.toString());
  }
}
