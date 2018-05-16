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

import com.google.gson.annotations.SerializedName;
import com.ibm.watson.developer_cloud.service.model.GenericModel;

/**
 * SpeechSession.
 */
public class SpeechSession extends GenericModel {

  private String recognize;
  private String recognizeWS;
  @SerializedName("observe_result")
  private String observeResult;
  @SerializedName("session_id")
  private String sessionId;
  @SerializedName("new_session_uri")
  private String newSessionUri;
  private String state;
  private String model;

  /**
   * Gets the recognize.
   *
   * URI for HTTP REST recognition requests.
   *
   * @return the recognize
   */
  public String getRecognize() {
    return recognize;
  }

  /**
   * Gets the recognizeWS.
   *
   * URI for WebSocket recognition requests. **Note:** This field is needed only for working with the WebSocket
   * interface.
   *
   * @return the recognizeWS
   */
  public String getRecognizeWS() {
    return recognizeWS;
  }

  /**
   * Gets the observeResult.
   *
   * URI for HTTP REST results observers.
   *
   * @return the observeResult
   */
  public String getObserveResult() {
    return observeResult;
  }

  /**
   * Gets the sessionId.
   *
   * Identifier for the new session. **Note:** This field is returned only when you create a new session.
   *
   * @return the sessionId
   */
  public String getSessionId() {
    return sessionId;
  }

  /**
   * Gets the newSessionUri.
   *
   * URI for the new session. **Note:** This field is returned only when you create a new session.
   *
   * @return the newSessionUri
   */
  public String getNewSessionUri() {
    return newSessionUri;
  }

  /**
   * Gets the state.
   *
   * State of the session. The state must be `initialized` for the session to accept another recognition request. Other
   * internal states are possible, but they have no meaning for the user. **Note:** This field is returned only when you
   * request the status of an existing session.
   *
   * @return the state
   */
  public String getState() {
    return state;
  }

  /**
   * Gets the model.
   *
   * URI for information about the model that is used with the session. **Note:** This field is returned only when you
   * request the status of an existing session.
   *
   * @return the model
   */
  public String getModel() {
    return model;
  }
}
