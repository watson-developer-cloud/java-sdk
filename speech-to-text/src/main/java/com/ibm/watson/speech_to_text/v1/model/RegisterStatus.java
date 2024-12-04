/*
 * (C) Copyright IBM Corp. 2018, 2024.
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

package com.ibm.watson.speech_to_text.v1.model;

import com.ibm.cloud.sdk.core.service.model.GenericModel;

/** Information about a request to register a callback for asynchronous speech recognition. */
public class RegisterStatus extends GenericModel {

  /**
   * The current status of the job: * `created`: The service successfully allowlisted the callback
   * URL as a result of the call. * `already created`: The URL was already allowlisted.
   */
  public interface Status {
    /** created. */
    String CREATED = "created";
    /** already created. */
    String ALREADY_CREATED = "already created";
  }

  protected String status;
  protected String url;

  protected RegisterStatus() {}

  /**
   * Gets the status.
   *
   * <p>The current status of the job: * `created`: The service successfully allowlisted the
   * callback URL as a result of the call. * `already created`: The URL was already allowlisted.
   *
   * @return the status
   */
  public String getStatus() {
    return status;
  }

  /**
   * Gets the url.
   *
   * <p>The callback URL that is successfully registered.
   *
   * @return the url
   */
  public String getUrl() {
    return url;
  }
}
