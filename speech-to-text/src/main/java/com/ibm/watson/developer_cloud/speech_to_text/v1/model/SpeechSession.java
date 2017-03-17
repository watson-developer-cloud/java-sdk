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

/**
 * Speech session.
 */
public class SpeechSession extends GenericModel {

  /** The new session uri. */
  @SerializedName("new_session_uri")
  private String newSessionUri;

  /** The observe result. */
  @SerializedName("observe_result")
  private String observeResult;

  /** The recognize. */
  private String recognize;

  /** The recognize ws. */
  private String recognizeWS;

  /** The session id. */
  @SerializedName("session_id")
  private String sessionId;

  /**
   * Gets the new session uri.
   *
   * @return The newSessionUri
   */
  public String getNewSessionUri() {
    return newSessionUri;
  }

  /**
   * Gets the observe result.
   *
   * @return The observeResult
   */
  public String getObserveResult() {
    return observeResult;
  }

  /**
   * Gets the recognize.
   *
   * @return The recognize
   */
  public String getRecognize() {
    return recognize;
  }

  /**
   * Gets the recognize ws.
   *
   * @return The recognizeWS
   */
  public String getRecognizeWS() {
    return recognizeWS;
  }

  /**
   * Gets the session id.
   *
   * @return The sessionId
   */
  public String getSessionId() {
    return sessionId;
  }

  /**
   * Sets the new session uri.
   *
   * @param newSessionUri The new_session_uri
   */
  public void setNewSessionUri(final String newSessionUri) {
    this.newSessionUri = newSessionUri;
  }

  /**
   * Sets the observe result.
   *
   * @param observeResult The observe_result
   */
  public void setObserveResult(final String observeResult) {
    this.observeResult = observeResult;
  }

  /**
   * Sets the recognize.
   *
   * @param recognize The recognize
   */
  public void setRecognize(final String recognize) {
    this.recognize = recognize;
  }

  /**
   * Sets the recognize ws.
   *
   * @param recognizeWS The recognizeWS
   */
  public void setRecognizeWS(final String recognizeWS) {
    this.recognizeWS = recognizeWS;
  }

  /**
   * Sets the session id.
   *
   * @param sessionId The session_id
   */
  public void setSessionId(final String sessionId) {
    this.sessionId = sessionId;
  }
}
