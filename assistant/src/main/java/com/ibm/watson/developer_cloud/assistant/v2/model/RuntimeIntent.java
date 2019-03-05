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
package com.ibm.watson.developer_cloud.assistant.v2.model;

import com.ibm.cloud.sdk.core.service.model.GenericModel;

/**
 * An intent identified in the user input.
 */
public class RuntimeIntent extends GenericModel {

  private String intent;
  private Double confidence;

  /**
   * Gets the intent.
   *
   * The name of the recognized intent.
   *
   * @return the intent
   */
  public String getIntent() {
    return intent;
  }

  /**
   * Gets the confidence.
   *
   * A decimal percentage that represents Watson's confidence in the intent.
   *
   * @return the confidence
   */
  public Double getConfidence() {
    return confidence;
  }

  /**
   * Sets the intent.
   *
   * @param intent the new intent
   */
  public void setIntent(final String intent) {
    this.intent = intent;
  }

  /**
   * Sets the confidence.
   *
   * @param confidence the new confidence
   */
  public void setConfidence(final Double confidence) {
    this.confidence = confidence;
  }
}
