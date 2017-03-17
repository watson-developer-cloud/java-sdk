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
 * SessionStatus used by {@link SpeechToText}.
 */
public class SpeechSessionStatus extends GenericModel {
  private String model;
  @SerializedName("observe_result")
  private String observeResult;
  private String recognize;
  private String state;

  /**
   * Gets the model.
   *
   * @return The model
   */
  public String getModel() {
    return model;
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
   * Gets the state.
   *
   * @return The state
   */
  public String getState() {
    return state;
  }

  /**
   * Sets the model.
   *
   * @param model The model
   */
  public void setModel(final String model) {
    this.model = model;
  }

  /**
   * Sets the observe result.
   *
   * @param observeResult The observe result
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
   * Sets the state.
   *
   * @param state The state
   */
  public void setState(final String state) {
    this.state = state;
  }

}
