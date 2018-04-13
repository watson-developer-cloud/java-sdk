/*
 * Copyright 2018 IBM Corp. All Rights Reserved.
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
package com.ibm.watson.developer_cloud.speech_to_text.v1.model;

import com.ibm.watson.developer_cloud.service.model.GenericModel;

/**
 * RegisterStatus.
 */
public class RegisterStatus extends GenericModel {

  /**
   * The current status of the job: * `created` if the callback URL was successfully white-listed as a result of the
   * call. * `already created` if the URL was already white-listed.
   */
  public interface Status {
    /** created. */
    String CREATED = "created";
    /** already created. */
    String ALREADY_CREATED = "already created";
  }

  private String status;
  private String url;

  /**
   * Gets the status.
   *
   * The current status of the job: * `created` if the callback URL was successfully white-listed as a result of the
   * call. * `already created` if the URL was already white-listed.
   *
   * @return the status
   */
  public String getStatus() {
    return status;
  }

  /**
   * Gets the url.
   *
   * The callback URL that is successfully registered.
   *
   * @return the url
   */
  public String getUrl() {
    return url;
  }
}
