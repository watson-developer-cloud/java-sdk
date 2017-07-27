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
package com.ibm.watson.developer_cloud.service.exception;

import com.ibm.watson.developer_cloud.http.HttpStatus;

import okhttp3.Response;

/**
 * 400 Bad Request (HTTP/1.1 - RFC 2616).
 */
public class BadRequestException extends ServiceResponseException {

  /** The Constant serialVersionUID. */
  private static final long serialVersionUID = 1L;

  /**
   * Instantiates a new BadRequest Exception. HTTP 400
   *
   * @param message the error message
   * @param response the HTTP response
   */
  public BadRequestException(String message, Response response) {
    super(HttpStatus.BAD_REQUEST, message, response);
  }

}
