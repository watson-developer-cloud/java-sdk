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
package com.ibm.watson.assistant.v1;

import com.ibm.cloud.sdk.core.http.Response;
import com.ibm.cloud.sdk.core.http.ServiceCallback;
import com.ibm.cloud.sdk.core.security.Authenticator;
import com.ibm.cloud.sdk.core.security.IamAuthenticator;
import com.ibm.watson.assistant.v1.model.MessageOptions;
import com.ibm.watson.assistant.v1.model.MessageResponse;
import io.reactivex.Single;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

/**
 * Example of how to call the Assisant message method synchronously, asynchronously, and using
 * RxJava.
 *
 * @version v1-experimental
 */
public class AssistantExample {

  public static void main(String[] args) throws Exception {
    Authenticator authenticator = new IamAuthenticator("<iam_api_key>");
    Assistant service = new Assistant("2019-02-28", authenticator);

    MessageInput input = new MessageInput();
    input.setText("Hi");
    MessageOptions options = new MessageOptions.Builder("<workspaceId>").input(input).build();

    // sync
    MessageResponse response = service.message(options).execute().getResult();
    System.out.println(response);

    // async
    service
        .message(options)
        .enqueue(
            new ServiceCallback<MessageResponse>() {
              @Override
              public void onResponse(Response<MessageResponse> response) {
                System.out.println(response.getResult());
              }

              @Override
              public void onFailure(Exception e) {}
            });

    // RxJava
    Single<Response<MessageResponse>> observableRequest =
        service.message(options).reactiveRequest();
    observableRequest
        .subscribeOn(Schedulers.single())
        .subscribe(
            new Consumer<Response<MessageResponse>>() {
              @Override
              public void accept(Response<MessageResponse> response) throws Exception {
                System.out.println(response.getResult());
              }
            });

    Thread.sleep(5000);
  }
}
