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
package com.ibm.watson.developer_cloud.speech_to_text.v1.websocket;

/**
 * The listener interface for receiving response events.
 * The class that is interested in processing a response
 * event implements this interface, and the object created
 * with that class is registered with a component using the
 * component's <code>addResponseListener<code> method. When
 * the response event occurs, that object's appropriate
 * method is invoked.
 *
 * @see ResponseEvent
 */
public interface ResponseListener {
  
  /**
   * On response.
   *
   * @param response the response
   */
  void onResponse(String response);
}
