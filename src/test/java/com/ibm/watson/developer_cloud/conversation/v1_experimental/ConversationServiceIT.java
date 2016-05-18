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

import org.junit.Before;
import org.junit.Test;

import com.ibm.watson.developer_cloud.WatsonServiceTest;
import com.ibm.watson.developer_cloud.conversation.v1_experimental.model.Message;
import com.ibm.watson.developer_cloud.conversation.v1_experimental.model.NewMessageOptions;
import com.ibm.watson.developer_cloud.conversation.v1_experimental.model.Context;

/**
 * Integration test for the {@link ConversationService}.
 */
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
    workspaceId = getValidProperty("conversation.v1_experimental.workspace_id");
    String username = getValidProperty("conversation.v1_experimental.username");
    String password = getValidProperty("conversation.v1_experimental.password");
    
    service = new ConversationService(ConversationService.VERSION_DATE_2016_05_19);
    service.setEndPoint(getValidProperty("conversation.v1_experimental.url"));
    service.setUsernameAndPassword(username, password);
    service.setDefaultHeaders(getDefaultHeaders());
  }

  /**
   * Test start a conversation without message.
   */
  @Test
  public void testStartAConversationWithoutMessage() {
    NewMessageOptions options = new NewMessageOptions.Builder()
        .workspaceId(workspaceId)
        .build();
    Message response = service.message(options).execute();
    assertNotNull(response);
    assertNotNull(response.getContext());
    assertNotNull(response.getOutput());
    assertNotNull(response.getOutput().getText());
  }

  /**
   * Test send messages.
   *
   * @throws InterruptedException the interrupted exception
   */
  @Test
  public void testSendMessages() throws InterruptedException {
    final String[] messages = new String[] {"turn ac on", "turn right", "no", "yes"};
    Context context = null;
    
    for (final String message : messages) {
      NewMessageOptions options = new NewMessageOptions.Builder()
          .workspaceId(workspaceId)
          .context(context)
          .inputText(message)
          .build();
      Message response = service.message(options).execute();

      assertMessageFromService(response);
      context = response.getContext();
      Thread.sleep(500);
    }
  }

  /**
   * Assert {@link Message} from service.
   *
   * @param message the message from the {@link ConversationService}
   */
  private void assertMessageFromService(Message message) {
    assertNotNull(message);
    assertNotNull(message.getContext());
    assertNotNull(message.getOutput());
  }

  /**
   * Test message with nulls.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testMessageWithNulls() {
    service.message(null).execute();
  }

  /**
   * Test to string.
   */
  @Test
  public void testToString() {
    assertNotNull(service.toString());
  }
}
