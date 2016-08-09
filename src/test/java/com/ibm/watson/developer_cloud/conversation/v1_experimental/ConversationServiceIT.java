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

import static org.junit.Assert.assertNotNull;

import java.util.Map;

import org.junit.Assume;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import com.ibm.watson.developer_cloud.WatsonServiceTest;
import com.ibm.watson.developer_cloud.conversation.v1_experimental.model.MessageRequest;
import com.ibm.watson.developer_cloud.conversation.v1_experimental.model.MessageResponse;

/**
 * Integration test for the {@link ConversationService}.
 */
@Ignore
public class ConversationServiceIT extends WatsonServiceTest {

  private ConversationService service;
  private String workspaceId;

  /*
   * (non-Javadoc)
   *
   * @see com.ibm.watson.developer_cloud.WatsonServiceTest#setUp()
   */
  @Override
  @Before
  public void setUp() throws Exception {
    super.setUp();
    workspaceId = getProperty("conversation.v1_experimental.workspace_id");
    String username = getProperty("conversation.v1_experimental.username");
    String password = getProperty("conversation.v1_experimental.password");

    Assume.assumeFalse("config.properties doesn't have valid credentials.",
        username == null || username.equals(PLACEHOLDER));

    service = new ConversationService(ConversationService.VERSION_DATE_2016_05_19);
    service.setEndPoint(getProperty("conversation.v1_experimental.url"));
    service.setUsernameAndPassword(username, password);
    service.setDefaultHeaders(getDefaultHeaders());
  }

  /**
   * Test start a conversation without message.
   */
  @Test(expected=IllegalArgumentException.class)
  public void testStartAConversationWithoutMessage() {
    service.message(workspaceId, null).execute();
  }

  /**
   * Test send messages.
   *
   * @throws InterruptedException the interrupted exception
   */
  @Test
  public void testSendMessages() throws InterruptedException {
    final String[] messages = new String[] {"turn ac on", "turn right", "no", "yes"};
    Map<String, Object> context = null;
    for (final String message : messages) {
      MessageRequest request = new MessageRequest.Builder().inputText(message).context(context).build();
      MessageResponse response = service.message(workspaceId, request).execute();

      assertMessageFromService(response);
      context = response.getContext();
      Thread.sleep(500);
    }
  }

  /**
   * Assert {@link MessageResponse} from service.
   *
   * @param message the message from the {@link ConversationService}
   */
  private void assertMessageFromService(MessageResponse message) {
    assertNotNull(message);
    //assertNotNull(message.getContext());
    //assertNotNull(message.getOutput());
    assertNotNull(message.getEntities());
    assertNotNull(message.getIntents());
  }

  /**
   * Test message with nulls.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testMessageWithNulls() {
    service.message(null, null).execute();
  }

  /**
   * Test to string.
   */
  @Test
  public void testToString() {
    assertNotNull(service.toString());
  }
}
