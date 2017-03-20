/*
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
package com.ibm.watson.developer_cloud.speech_to_text.v1.model;

import com.google.gson.annotations.SerializedName;
import com.ibm.watson.developer_cloud.service.model.GenericModel;
import com.ibm.watson.developer_cloud.speech_to_text.v1.SpeechToText;

/**
 * Used in {@link SpeechToText#registerCallback(String, String)} to register a callback URL to be notified by the
 * service of the recognition status and, optionally, the results automatically.
 */
public class RecognitionCallback extends GenericModel {
  private Status status;
  private String url;

  /**
   * Register Callback Status.
   */
  public enum Status {

    /** failed. */
    @SerializedName("created") CREATED,

    /** processing. */
    @SerializedName("already created") ALREADY_CREATED
  }

  /**
   * Gets the status.
   *
   * @return the status
   */
  public Status getStatus() {
    return status;
  }

  /**
   * Sets the status.
   *
   * @param status the new status
   */
  public void setStatus(Status status) {
    this.status = status;
  }

  /**
   * Gets the url.
   *
   * @return the url
   */
  public String getUrl() {
    return url;
  }

  /**
   * Sets the url.
   *
   * @param url the new url
   */
  public void setUrl(String url) {
    this.url = url;
  }

}
