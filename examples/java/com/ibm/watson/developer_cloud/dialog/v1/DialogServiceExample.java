/**
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
package com.ibm.watson.developer_cloud.dialog.v1;

import java.util.List;

import com.ibm.watson.developer_cloud.dialog.v1.model.Dialog;
import com.ibm.watson.developer_cloud.http.ServiceCallback;

public class DialogServiceExample {
  public static void main(String[] args) {
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
      public void onFailure(Exception e) {
      }}
    );    
  }

}
