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

import com.ibm.watson.developer_cloud.conversation.v1_experimental.model.Message;
import com.ibm.watson.developer_cloud.conversation.v1_experimental.model.NewMessageOptions;
import com.ibm.watson.developer_cloud.http.ServiceCallback;

public class ConversationExample {
  public static void main(String[] args) {
    ConversationService service = new ConversationService(ConversationService.VERSION_DATE_2016_05_19);
    service.setUsernameAndPassword("<username>", "<password>");

    // sync
    NewMessageOptions newMessage = new NewMessageOptions.Builder().inputText("Hi").build();
    Message dialogs = service.message(newMessage).execute();
    System.out.println(dialogs);
    
    
    // async
    service.message(newMessage).enqueue(new ServiceCallback<Message>() {
      @Override
      public void onResponse(Message response) {
        System.out.println(response);
      }

      @Override
      public void onFailure(Exception e) {
      }}
    );    
  }

}
