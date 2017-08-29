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

import java.util.HashMap;

/**
 * An intent identified in the user input.
 */
public class RuntimeIntent extends HashMap<String, Object> {

  /**
   * Gets the intent.
   *
   * @return the intent
   */
  public String getIntent() {
    return (String) this.get("intent");
  }

  /**
   * Gets the confidence.
   *
   * @return the confidence
   */
  public Double getConfidence() {
    return (Double) this.get("confidence");
  }

  /**
   * Sets the intent.
   *
   * @param intent the new intent
   */
  public void setIntent(final String intent) {
    this.put("intent", intent);
  }

  /**
   * Sets the confidence.
   *
   * @param confidence the new confidence
   */
  public void setConfidence(final Double confidence) {
    this.put("confidence", confidence);
  }
}
