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

import java.util.Map;

import com.ibm.watson.developer_cloud.conversation.v1.model.MessageRequest;
import com.ibm.watson.developer_cloud.conversation.v1.model.MessageResponse;
import com.ibm.watson.developer_cloud.conversation.v1.model.OutputData;
import com.ibm.watson.developer_cloud.http.ServiceCallback;

import jersey.repackaged.jsr166e.CompletableFuture;

/**
 * Example of how to call the {@link ConversationService#message(String, MessageRequest)} method synchronous,
 * asynchronous, and using react.
 *
 * @version v1-experimental
 */
public class ConversationExample {

  public static void main(String[] args) throws Exception {
    ConversationService service = new ConversationService(ConversationService.VERSION_DATE_2017_05_26);
    service.setUsernameAndPassword("<username>", "<password>");

    InputData input = new InputData.Builder("Hi").build();
    MessageOptions options = new MessageOptions.Builder(workspaceId).input(input).build();

    // sync
    MessageResponse response = service.message(options).execute();
    System.out.println(response);

    // async
    service.message(options).enqueue(new ServiceCallback<MessageResponse>() {
      @Override
      public void onResponse(MessageResponse response) {
        System.out.println(response);
      }

      @Override
      public void onFailure(Exception e) { }
    });

    // rx callback
    service.message(options).rx()
        .thenApply(new CompletableFuture.Fun<MessageResponse, OutputData>() {
          @Override
          public OutputData apply(MessageResponse message) {
            return message.getOutput();
          }
        }).thenAccept(new CompletableFuture.Action<OutputData>() {
      @Override
      public void accept(OutputData output) {
        System.out.println(output);
      }
    });

    // rx async callback
    service.message(options).rx()
        .thenApplyAsync(new CompletableFuture.Fun<MessageResponse, OutputData>() {
          @Override
          public OutputData apply(MessageResponse message) {
            return message.getOutput();
          }
        }).thenAccept(new CompletableFuture.Action<OutputData>() {
      @Override
      public void accept(OutputData output) {
        System.out.println(output);
      }
    });

    // rx sync
    try {
      MessageResponse rxMessageResponse = service.message(options).rx().get();
      System.out.println(rxMessageResponse);
    } catch (Exception ex) {
      // Handle exception
    }
  }

}
