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

import java.util.List;

import com.google.gson.annotations.SerializedName;

/**
 * An option that excluded some other option. The list contains explanation at which objectives this option
 * was better than the other option and by how much.
 */
public class DominatingOption {

  @SerializedName("solution_ref")
  private String solutionRef;
  private List<ObjectiveDominationData> objectives;

  /**
   * Gets the solution key.
   *
   * @return the key
   */
  public String getSolutionKey() {
    return solutionRef;
  }

  /**
   * Gets the list of objectives at which the excluding option was better
   * than this option.
   *
   * @return objective differences
   */
  public List<ObjectiveDominationData> getObjectives() {
    return objectives;
  }

  /**
   * Sets the solution key.
   *
   * @param key the solution key
   */
  public void setSolutionKey(String key) {
    this.solutionRef = key;
  }

  /**
   * Sets the objectives at which the excluding option was better
   * than this option.
   *
   * @param objectives the list of objectives
   */
  public void setObjectives(List<ObjectiveDominationData> objectives) {
    this.objectives = objectives;
  }
}
