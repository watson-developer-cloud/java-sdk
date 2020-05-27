/*
 * (C) Copyright IBM Corp. 2019, 2020.
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
package com.ibm.watson.assistant.v2;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import com.ibm.watson.assistant.v2.model.CreateSessionOptions;
import com.ibm.watson.assistant.v2.model.DeleteSessionOptions;
import com.ibm.watson.assistant.v2.model.MessageContext;
import com.ibm.watson.assistant.v2.model.MessageContextStateless;
import com.ibm.watson.assistant.v2.model.MessageInput;
import com.ibm.watson.assistant.v2.model.MessageInputOptions;
import com.ibm.watson.assistant.v2.model.MessageInputOptionsStateless;
import com.ibm.watson.assistant.v2.model.MessageInputStateless;
import com.ibm.watson.assistant.v2.model.MessageOptions;
import com.ibm.watson.assistant.v2.model.MessageResponse;
import com.ibm.watson.assistant.v2.model.MessageResponseStateless;
import com.ibm.watson.assistant.v2.model.MessageStatelessOptions;
import com.ibm.watson.assistant.v2.model.RuntimeResponseGeneric;
import com.ibm.watson.assistant.v2.model.SessionResponse;
import com.ibm.watson.common.RetryRunner;
import java.util.Arrays;
import java.util.List;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

/** Integration tests for Assistant v2. */
@RunWith(RetryRunner.class)
public class AssistantServiceIT extends AssistantServiceTest {
  private Assistant service;
  private String assistantId;

  @Override
  @Before
  public void setUp() throws Exception {
    super.setUp();
    this.service = getService();
    this.assistantId = getAssistantId();
  }

  
  @Test
  public void testSendMessages() {
    // get session ID
    CreateSessionOptions createSessionOptions =
        new CreateSessionOptions.Builder().assistantId(assistantId).build();
    SessionResponse sessionResponse =
        service.createSession(createSessionOptions).execute().getResult();
    String sessionId = sessionResponse.getSessionId();

    final List<String> messages =
        Arrays.asList("I want some pizza.", "I'd like 3 pizzas.", "Large");
    MessageContext context = new MessageContext.Builder().build();

    try {
      // send messages
      for (String message : messages) {
        MessageInputOptions inputOptions = new MessageInputOptions.Builder().debug(true).build();
        MessageInput input =
            new MessageInput.Builder()
                .text(message)
                .messageType(MessageInput.MessageType.TEXT)
                .options(inputOptions)
                .build();
        MessageOptions messageOptions =
            new MessageOptions.Builder()
                .assistantId(assistantId)
                .sessionId(sessionId)
                .input(input)
                .context(context)
                .build();
        MessageResponse messageResponse = service.message(messageOptions).execute().getResult();

        // message assertions
        List<RuntimeResponseGeneric> genericResponses = messageResponse.getOutput().getGeneric();
        assertNotNull(genericResponses);
        boolean foundTextResponse = false;
        for (RuntimeResponseGeneric generic : genericResponses) {
          if (generic.responseType().equals(RuntimeResponseGeneric.ResponseType.TEXT)) {
            foundTextResponse = true;
            break;
          }
        }
        assertTrue(foundTextResponse);
        assertNotNull(messageResponse.getOutput().getEntities());
        assertNotNull(messageResponse.getOutput().getIntents());
        assertNotNull(messageResponse.getOutput().getDebug());

        context = messageResponse.getContext();
      }
    } finally {
      // delete session
      DeleteSessionOptions deleteSessionOptions =
          new DeleteSessionOptions.Builder().assistantId(assistantId).sessionId(sessionId).build();
      service.deleteSession(deleteSessionOptions).execute();
    }
  }
  
  @Test
  public void testSendMessageStateless() {
    // get session ID
    CreateSessionOptions createSessionOptions =
        new CreateSessionOptions.Builder().assistantId(assistantId).build();
    SessionResponse sessionResponse =
        service.createSession(createSessionOptions).execute().getResult();
    String sessionId = sessionResponse.getSessionId();

    final List<String> messages =
        Arrays.asList("I want some pizza.", "I'd like 3 pizzas.", "Large");
    MessageContextStateless context = new MessageContextStateless.Builder().build();

    try {
      // send messages
      for (String message : messages) {
        MessageInputOptionsStateless inputOptions = new MessageInputOptionsStateless.Builder().debug(true).build();
        MessageInputStateless input =
            new MessageInputStateless.Builder()
                .text(message)
                .messageType(MessageInput.MessageType.TEXT)
                .options(inputOptions)
                .build();
        MessageStatelessOptions messageOptions =
            new MessageStatelessOptions.Builder()
                .assistantId(assistantId)
                .input(input)
                .context(context)
                .build();
        MessageResponseStateless messageResponse = service.messageStateless(messageOptions).execute().getResult();

        // message assertions
        List<RuntimeResponseGeneric> genericResponses = messageResponse.getOutput().getGeneric();
        assertNotNull(genericResponses);
        boolean foundTextResponse = false;
        for (RuntimeResponseGeneric generic : genericResponses) {
          if (generic.responseType().equals(RuntimeResponseGeneric.ResponseType.TEXT)) {
            foundTextResponse = true;
            break;
          }
        }
        assertTrue(foundTextResponse);
        assertNotNull(messageResponse.getOutput().getEntities());
        assertNotNull(messageResponse.getOutput().getIntents());
        assertNotNull(messageResponse.getOutput().getDebug());

        context = messageResponse.getContext();
      }
    } finally {
      // delete session
      DeleteSessionOptions deleteSessionOptions =
          new DeleteSessionOptions.Builder().assistantId(assistantId).sessionId(sessionId).build();
      service.deleteSession(deleteSessionOptions).execute();
    }
  }
}
