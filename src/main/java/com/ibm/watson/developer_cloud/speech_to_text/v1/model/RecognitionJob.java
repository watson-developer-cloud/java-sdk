/*
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
package com.ibm.watson.developer_cloud.speech_to_text.v1.model;

import com.google.gson.annotations.SerializedName;
import com.ibm.watson.developer_cloud.service.model.GenericModel;

/**
 * Information about an asynchronous recognition. If the status is completed, the response includes
 * the results of the recognition request; otherwise, the response includes the <code>id</code>.
 */
public class RecognitionJob extends GenericModel {
  
  /**
   * RecognitionJob Status.
   */
  public enum Status {

    /** completed. */
    @SerializedName("completed") COMPLETED,

    /** failed. */
    @SerializedName("failed") FAILED,

    /** processing. */
    @SerializedName("processing") PROCESSING,

    /** waiting. */
    @SerializedName("waiting") WAITING
  }

  private String id;
  private SpeechResults results;
  private Status status;

  private String url;

  @SerializedName("user_token")
  private String userToken;

  /**
   * Gets the id.
   *
   * @return the id
   */
  public String getId() {
    return id;
  }

  /**
   * Gets the recognition results.
   *
   * @return the results
   */
  public SpeechResults getResults() {
    return results;
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
   * Gets the url.
   *
   * @return the url
   */
  public String getUrl() {
    return url;
  }

  /**
   * Gets the user token.
   *
   * @return the user token
   */
  public String getUserToken() {
    return userToken;
  }

  /**
   * Sets the id.
   *
   * @param id the new id
   */
  public void setId(String id) {
    this.id = id;
  }

  /**
   * Sets the recognition results.
   *
   * @param results the new results
   */
  public void setResults(SpeechResults results) {
    this.results = results;
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
   * Sets the callback url.
   *
   * @param url the new callback url
   */
  public void setUrl(String url) {
    this.url = url;
  }

  /**
   * Sets the user token.
   *
   * @param userToken the new user token
   */
  public void setUserToken(String userToken) {
    this.userToken = userToken;
  }
}
