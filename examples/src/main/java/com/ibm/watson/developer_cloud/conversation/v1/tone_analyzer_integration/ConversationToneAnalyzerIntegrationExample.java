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
package com.ibm.watson.developer_cloud.conversation.v1.tone_analyzer_integration;

import java.util.HashMap;
import java.util.Map;

import com.ibm.watson.developer_cloud.conversation.v1.ConversationService;
import com.ibm.watson.developer_cloud.conversation.v1.model.MessageRequest;
import com.ibm.watson.developer_cloud.conversation.v1.model.MessageResponse;
import com.ibm.watson.developer_cloud.http.ServiceCallback;
import com.ibm.watson.developer_cloud.tone_analyzer.v3.ToneAnalyzer;
import com.ibm.watson.developer_cloud.tone_analyzer.v3.model.ToneAnalysis;

/**
 * Example of how to call the {@link ConversationService#message(String, MessageRequest)} method synchronous,
 * asynchronous, and using react.
 */
public class ConversationToneAnalyzerIntegrationExample {

  public static void main(String[] args) throws Exception {

    // instantiate the conversation service
    ConversationService conversationService = new ConversationService(ConversationService.VERSION_DATE_2016_07_11);
    conversationService.setUsernameAndPassword("<username>", "<password>");

    // instantiate the tone analyzer service
    ToneAnalyzer toneService = new ToneAnalyzer(ToneAnalyzer.VERSION_DATE_2016_05_19);
    toneService.setUsernameAndPassword("<username>", "<password>");

    // workspace id
    String workspaceId = "<workspace-id>";

    // maintain history in the context variable - will add a history variable to
    // each of the emotion, social
    // and language tones
    Boolean maintainHistory = false;

    /**
     * Input for the conversation service: input (String): an input string (the user's conversation turn) and context
     * (Map<String,Object>: any context that needs to be maintained - either added by the client app or passed in the
     * response from the conversation service on the previous conversation turn.
     */
    String input = "I am happy";
    Map<String, Object> context = new HashMap<String, Object>();

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
