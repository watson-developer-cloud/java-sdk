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
import com.ibm.watson.developer_cloud.service.model.GenericModel;
import com.ibm.watson.developer_cloud.tradeoff_analytics.v1.TradeoffAnalytics;

/**
 * Problem {@link Resolution} used by the {@link TradeoffAnalytics} V1 service.
 */
public class Resolution extends GenericModel {
  /** The map. */
  private ResolutionMap map;

  private List<Solution> solutions;

  @SerializedName("preferable_solutions")
  private PreferableSolutions preferableSolutions;

  /**
   * Gets the map.
   *
   * @return the map
   */
  public ResolutionMap getMap() {
    return map;
  }

  /**
   * Gets the solutions.
   *
   * @return The solutions
   */
  public List<Solution> getSolutions() {
    return solutions;
  }

  /**
   * Gets the preferable solutions.
   *
   * @return The preferable solutions
   */
  public PreferableSolutions getPreferableSolutions() {
    return preferableSolutions;
  }

  /**
   * Sets the map.
   *
   * @param map the new map
   */
  public void setMap(ResolutionMap map) {
    this.map = map;
  }

  /**
   * Sets the solutions.
   *
   * @param solutions The solutions
   */
  public void setSolutions(List<Solution> solutions) {
    this.solutions = solutions;
  }

  /**
   * Sets the preferable solutions.
   *
   * @param solutions The preferable solutions
   */
  public void setPreferableSolutions(PreferableSolutions solutions) {
    this.preferableSolutions = solutions;
  }

}
