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
package com.ibm.watson.developer_cloud.tradeoff_analytics.v1.model;

/**
 * How much one option is better than another for a particular objective.
 */
public class ObjectiveDominationData {

  private String key;
  private Double difference;
  private String text;

  /**
   * Gets the objective key.
   *
   * @return the key
   */
  public String getObjectiveKey() {
    return key;
  }

  /**
   * Gets the value difference.
   *
   * @return the difference
   */
  public Double getDifference() {
    return difference;
  }

  /**
   * Gets the textual explanation of the difference.
   *
   * @return the text
   */
  public String getText() {
    return text;
  }

  /**
   * Sets the objective key.
   *
   * @param key the objective key
   */
  public void setObjectiveKey(String key) {
    this.key = key;
  }

  /**
   * Sets the value difference.
   *
   * @param difference the difference
   */
  public void setDifference(Double difference) {
    this.difference = difference;
  }

  /**
   * Sets the textual explanation.
   *
   * @param text the text
   */
  public void setText(String text) {
    this.text = text;
  }
}
