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
package com.ibm.watson.developer_cloud.conversation.v1.model;

/**
 * A class representing an Intent as detected by the service. The intent is the 'intent' of the user utterance, e.g.
 * "pay_bill", "check_balance" etc.. The intent is accompanied by a confidence score ranging between 0.0 and 1.0, with
 * 1.0 being the most confident.
 */
public class Intent {

  /**
   * Instantiates a new intent.
   *
   * @param intent the intent
   * @param confidence the confidence
   */
  public Intent(String intent, Double confidence) {
    super();
    this.confidence = confidence;
    this.intent = intent;
  }

  private Double confidence;
  private String intent;

  /**
   * Returns the confidence associated with the intent. When the service parses/analyzes the user input it tries to
   * determine the 'intent' of what the user said. The service will be trained to expect n different intents and the
   * service tries to match the input with one of the intents. The confidence is the value assigned by the system to the
   * returned intent. High confidence scores (close to 1.0) imply that the system is very confident that the user meant
   * the returned intent. Low confidence scores indicate that the system is not confident in its response.
   *
   * @return a float representing system confidence
   */
  public Double getConfidence() {
    return confidence;
  }

  /**
   * Returns the name of the intent that the system detected in the user input.
   *
   * @return a string representing an intent name
   */
  public String getIntent() {
    return intent;
  }

  /**
   * Sets the system confidence in the intent.
   *
   * @param confidence a float between 0.0 and 1.0
   */
  public void setConfidence(Double confidence) {
    this.confidence = confidence;
  }

  /**
   * Sets the name of the intent the system understood the user to have 'said'.
   *
   * @param intent a string representing one of the trained intents
   */
  public void setIntent(String intent) {
    this.intent = intent;
  }
}
