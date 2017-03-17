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


import java.util.ArrayList;
import java.util.List;

import com.google.gson.annotations.SerializedName;


/**
 * The Class Node.
 */
public class Node {

  private Position coordinates;

  @SerializedName("solution_refs")
  private List<String> solutionRefs = new ArrayList<String>();

  /**
   * Gets the coordinates.
   *
   * @return the coordinates
   */
  public Position getCoordinates() {
    return coordinates;
  }

  /**
   * Gets the solution refs.
   *
   * @return the solution refs
   */
  public List<String> getSolutionRefs() {
    return solutionRefs;
  }

  /**
   * Sets the coordinates.
   *
   * @param coordinates the new coordinates
   */
  public void setCoordinates(Position coordinates) {
    this.coordinates = coordinates;
  }

  /**
   * Sets the solution refs.
   *
   * @param solutionRefs the new solution refs
   */
  public void setSolutionRefs(List<String> solutionRefs) {
    this.solutionRefs = solutionRefs;
  }

}
