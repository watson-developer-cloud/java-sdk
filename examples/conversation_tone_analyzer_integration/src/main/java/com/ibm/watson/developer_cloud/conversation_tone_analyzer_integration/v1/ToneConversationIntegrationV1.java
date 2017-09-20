/**
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
package com.ibm.watson.developer_cloud.conversation_tone_analyzer_integration.v1;

import java.io.File;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import org.apache.commons.io.FileUtils;

import com.ibm.watson.developer_cloud.conversation.v1.ConversationService;
import com.ibm.watson.developer_cloud.conversation.v1.model.MessageRequest;
import com.ibm.watson.developer_cloud.conversation.v1.model.MessageResponse;
import com.ibm.watson.developer_cloud.http.ServiceCallback;
import com.ibm.watson.developer_cloud.tone_analyzer.v3.ToneAnalyzer;
import com.ibm.watson.developer_cloud.tone_analyzer.v3.model.ToneAnalysis;

/**
 * Example of how to call the {@link ConversationService#message(String, MessageRequest)}
 * method asynchronously.
 *
 * @version v1
 */
public class ToneConversationIntegrationV1 {

  public static void main(String[] args) throws Exception {

    // load the properties file
    Properties props = new Properties();
    props.load(FileUtils.openInputStream(new File("tone_conversation_integration.properties.example")));

    // instantiate the conversation service
    final ConversationService conversationService = new ConversationService(ConversationService
        .VERSION_DATE_2016_07_11);
    conversationService.setUsernameAndPassword(
        props.getProperty("CONVERSATION_USERNAME", "<conversation_username>"),
        props.getProperty("CONVERSATION_PASSWORD", "<conversation_password>")
    );

    // instantiate the tone analyzer service
    ToneAnalyzer toneService = new ToneAnalyzer(ToneAnalyzer.VERSION_DATE_2016_05_19);
    toneService.setUsernameAndPassword(
        props.getProperty("TONE_ANALYZER_USERNAME", "<tone_analyzer_username>"),
        props.getProperty("TONE_ANALYZER_PASSWORD", "<tone_analyzer_password>")
    );

    // workspace id
    final String workspaceId = props.getProperty("WORKSPACE_ID", "<workspace_id>");

    // maintain history in the context variable - will add a history variable to
    // each of the emotion, social and language tones
    final Boolean maintainHistory = false;

    /**
     * Input for the conversation service: input (String): an input string (the user's conversation turn) and context
     * (Map<String,Object>: any context that needs to be maintained - either added by the client app or passed in the
     * response from the conversation service on the previous conversation turn.
     */
    final String input = "I am happy";
    final Map<String, Object> context = new HashMap<String, Object>();

    // UPDATE CONTEXT HERE IF CONTINUING AN ONGOING CONVERSATION
    // set local context variable to the context from the last response from the
    // Conversation Service
    // (see the getContext() method of the MessageResponse class in
    // com.ibm.watson.developer_cloud.conversation.v1.model)

    // async call to Tone Analyzer
    toneService.getTone(input, null).enqueue(new ServiceCallback<ToneAnalysis>() {
      @Override
      public void onResponse(ToneAnalysis toneResponsePayload) {

        // update context with the tone data returned by the Tone Analyzer
        ToneDetection.updateUserTone(context, toneResponsePayload, maintainHistory);

        // call Conversation Service with the input and tone-aware context
        MessageRequest newMessage = new MessageRequest.Builder().inputText(input).context(context).build();
        conversationService.message(workspaceId, newMessage).enqueue(new ServiceCallback<MessageResponse>() {
          @Override
          public void onResponse(MessageResponse response) {
            System.out.println(response);
          }

          @Override
          public void onFailure(Exception e) { }
        });
      }

      @Override
      public void onFailure(Exception e) { }
    });
  }
}
