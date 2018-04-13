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

import jersey.repackaged.jsr166e.CompletableFuture;

/**
 * Service Call.
 *
 * @param <T> the generic type
 */
public interface ServiceCall<T> {

  /**
   * Add a header to the request before executing.
   *
   * @param name the name of the header
   * @param value the value of the header
   * @return the ServiceCall with updated headers
   */
  ServiceCall<T> addHeader(String name, String value);

  /**
   * Synchronous request.
   *
   * @return the generic type
   * @throws RuntimeException the exception from HTTP request
   */
  T execute() throws RuntimeException;

  /**
   * Synchronous request with added HTTP information.
   *
   * @return a Response object with the generic response model and various HTTP information fields
   * @throws RuntimeException the exception from the HTTP request
   */
  Response<T> executeWithDetails() throws RuntimeException;

  /**
   * Asynchronous requests, in this case, you receive a callback when the data has been received.
   *
   * @param callback the callback
   */
  void enqueue(ServiceCallback<? super T> callback);

  /**
   * Asynchronous requests with added HTTP information. In this case, you receive a callback when the data has been
   * received.
   *
   * @param callback the callback
   */
  void enqueueWithDetails(ServiceCallbackWithDetails<T> callback);

  /**
   * Reactive requests, in this case, you could take advantage both synchronous and asynchronous.
   *
   * @return a CompletableFuture wrapper for your response
   */
  CompletableFuture<T> rx();

  /**
   * Reactive requests with added HTTP information. In this case, you could take advantage both synchronous and
   * asynchronous.
   *
   * @return a CompletableFuture wrapper for your response
   */
  CompletableFuture<Response<T>> rxWithDetails();
}
