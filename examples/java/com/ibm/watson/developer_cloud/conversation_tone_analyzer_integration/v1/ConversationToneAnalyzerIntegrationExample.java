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
package com.ibm.watson.developer_cloud.conversation_tone_analyzer_integration.v1;
		 
import com.ibm.watson.developer_cloud.conversation.v1.model.MessageRequest;
import com.ibm.watson.developer_cloud.conversation.v1.model.MessageResponse;
import com.ibm.watson.developer_cloud.http.ServiceCallback;
import com.ibm.watson.developer_cloud.tone_analyzer.v3.model.ToneAnalysis;

import java.util.Map;
import jersey.repackaged.jsr166e.CompletableFuture;


/**
 * Example of how to call the {@link ConversationService#message(String, MessageRequest)} method
 * synchronous, asynchronous, and using react.
 * @version v1-experimental
 */
public class ConversationToneAnalyzerIntegrationExample {

  public static void main(String[] args) throws Exception {
    
	// instantiate the conversation service  
	ConversationService service = new ConversationService(ConversationService.VERSION_DATE_2016_07_11);
    service.setUsernameAndPassword("<username>", "<password>");
    
    // instantiate the tone analyzer service
    ToneAnalyzer service = new ToneAnalyzer(ToneAnalyzer.VERSION_DATE_2016_05_19);
    service.setUsernameAndPassword("<username>", "<password>");

    // sample user input text
    String text ="I am happy";

    // Call the service and get the tone
    ToneAnalysis tone = service.getTone(text, null).execute();
    System.out.println(tone);

    //TODO: add in call to process the retrieved tone using the tone_detection module - need to add these functions
    // UPDATE TONE FUNCTION 
    // GET CONTEXT TOO
    Map<String, Object> context = new Map<String, Object>();
    
    // sync
    MessageRequest newMessage = new MessageRequest.Builder().inputText("Hi").build();
    MessageResponse response = service.message("<workspace-id>", newMessage).execute();
    System.out.println(response);


    // async
    service.message("<workspace-id>", newMessage).enqueue(new ServiceCallback<MessageResponse>() {
      @Override
      public void onResponse(MessageResponse response) {
        System.out.println(response);
      }

      @Override
      public void onFailure(Exception e) {}
    });

    // rx callback
    service.message("<workspace-id>", newMessage).rx()
        .thenApply(new CompletableFuture.Fun<MessageResponse, Map<String, Object>>() {
          @Override
          public Map<String, Object> apply(MessageResponse message) {
            return message.getOutput();
          }
        }).thenAccept(new CompletableFuture.Action<Map<String, Object>>() {
          @Override
          public void accept(Map<String, Object> output) {
            System.out.println(output);
          }
        });

    // rx async callback
    service.message("<workspace-id>", newMessage).rx()
        .thenApplyAsync(new CompletableFuture.Fun<MessageResponse, Map<String, Object>>() {
          @Override
          public Map<String, Object> apply(MessageResponse message) {
            return message.getOutput();
          }
        }).thenAccept(new CompletableFuture.Action<Map<String, Object>>() {
          @Override
          public void accept(Map<String, Object> output) {
            System.out.println(output);
          }
        });

    // rx sync
    MessageResponse rxMessageResponse = service.message("<workspace-id>", newMessage).rx().get();
    System.out.println(rxMessageResponse);
  }

}
