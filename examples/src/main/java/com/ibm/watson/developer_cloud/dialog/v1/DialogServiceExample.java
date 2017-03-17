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
package com.ibm.watson.developer_cloud.dialog.v1;

import java.util.List;

import com.ibm.watson.developer_cloud.dialog.v1.model.Dialog;
import com.ibm.watson.developer_cloud.http.ServiceCallback;

import jersey.repackaged.jsr166e.CompletableFuture;

public class DialogServiceExample {
  public static void main(String[] args) throws Exception {
    DialogService service = new DialogService();
    service.setUsernameAndPassword("<username>", "<password>");

    // sync
    List<Dialog> dialogs = service.getDialogs().execute();
    System.out.println(dialogs);


    // async
    service.getDialogs().enqueue(new ServiceCallback<List<Dialog>>() {
      @Override
      public void onResponse(List<Dialog> response) {
        System.out.println(response);
      }

      @Override
      public void onFailure(Exception e) { }
    });

    // rx callback
    service.getDialogs().rx().thenApply(new CompletableFuture.Fun<List<Dialog>, Integer>() {
      @Override
      public Integer apply(List<Dialog> dialogs) {
        return dialogs.size();
      }
    }).thenAccept(new CompletableFuture.Action<Integer>() {
      @Override
      public void accept(Integer integer) {
        System.out.println(integer);
      }
    });

    // rx async callback
    service.getDialogs().rx().thenApplyAsync(new CompletableFuture.Fun<List<Dialog>, Integer>() {
      @Override
      public Integer apply(List<Dialog> dialogs) {
        return dialogs.size();
      }
    }).thenAccept(new CompletableFuture.Action<Integer>() {
      @Override
      public void accept(Integer size) {
        System.out.println(size);
      }
    });

    // rx sync
    Integer size = service.getDialogs().rx().get().size();
    System.out.println(size);
  }

}
