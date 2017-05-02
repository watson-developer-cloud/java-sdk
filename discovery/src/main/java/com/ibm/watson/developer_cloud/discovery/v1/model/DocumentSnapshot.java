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
package com.ibm.watson.developer_cloud.discovery.v1.model;

import java.util.Map;

import com.google.gson.annotations.SerializedName;
import com.ibm.watson.developer_cloud.service.model.GenericModel;

/**
 * DocumentSnapshot.
 */
public class DocumentSnapshot extends GenericModel {

  public enum Step {

    /** html_input. */
    @SerializedName("html_input") HTML_INPUT,

    /** html_output. */
    @SerializedName("html_output") HTML_OUTPUT,

    /** json_output. */
    @SerializedName("json_output") JSON_OUTPUT,

    /** json_normalizations_output. */
    @SerializedName("json_normalizations_output") JSON_NORMALIZATIONS_OUTPUT,

    /** enrichments_output. */
    @SerializedName("enrichments_output") ENRICHMENTS_OUTPUT,

    /** normalizations_output. */
    @SerializedName("normalizations_output") NORMALIZATIONS_OUTPUT
  }

  private Step step;
  private Map<String, Object> snapshot;

  /**
   * Gets the step.
   *
   * @return the step
   */
  public Step getStep() {
    return step;
  }

  /**
   * Gets the snapshot.
   *
   * @return the snapshot
   */
  public Map<String, Object> getSnapshot() {
    return snapshot;
  }

  /**
   * Sets the step.
   *
   * @param step the new step
   */
  public void setStep(final Step step) {
    this.step = step;
  }

  /**
   * Sets the snapshot.
   *
   * @param snapshot the new snapshot
   */
  public void setSnapshot(final Map<String, Object> snapshot) {
    this.snapshot = snapshot;
  }
}
