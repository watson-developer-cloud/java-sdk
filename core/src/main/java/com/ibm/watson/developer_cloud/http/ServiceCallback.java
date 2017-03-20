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
package com.ibm.watson.developer_cloud.http;

/**
 * Callback with the response for an Asynchronous request.
 *
 * @param <T> the generic type
 */
public interface ServiceCallback<T> {

  /**
   * Called with the response.
   *
   * @param response the response
   */
  void onResponse(T response);

  /**
   * Called if there is an error during the request.
   *
   * @param e the exception thrown during the request
   */
  void onFailure(Exception e);
}
