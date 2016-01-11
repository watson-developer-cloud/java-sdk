/**
 * Copyright 2015 IBM Corp. All Rights Reserved.
 * 
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except
 * in compliance with the License. You may obtain a copy of the License at
 * 
 * http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software distributed under the License
 * is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express
 * or implied. See the License for the specific language governing permissions and limitations under
 * the License.
 */

package com.ibm.watson.developer_cloud.tradeoff_analytics.v1.model;

import java.util.List;

import com.google.gson.annotations.SerializedName;
import com.ibm.watson.developer_cloud.service.model.GenericModel;



/**
 * The Class Solution.
 */
public class Solution extends GenericModel {

  @SerializedName("shadow_me")
  private List<String> shadowMe;

  private List<String> shadows;

  @SerializedName("solution_ref")
  private String solutionRef;

  private String status;


  /**
   * Gets the solution ids of those that shadow this solution.
   * 
   * @return The highlights
   */
  public List<String> getShadowMe() {
    return shadowMe;
  }

  /**
   * Gets the shadows of a solution.
   * 
   * @return The shadows
   */
  public List<String> getShadows() {
    return shadows;
  }

  /**
   * Gets the solution ref.
   * 
   * @return the solutionRef
   */
  public String getSolutionRef() {
    return solutionRef;
  }

  /**
   * Gets the status.
   * 
   * @return The status
   */
  public String getStatus() {
    return status;
  }

  /**
   * Sets the shadow me.
   * 
   * @param shadowMe The highlights
   */
  public void setShadowMe(List<String> shadowMe) {
    this.shadowMe = shadowMe;
  }

  /**
   * Sets the shadows.
   * 
   * @param shadows The shadows
   */
  public void setShadows(List<String> shadows) {
    this.shadows = shadows;
  }

  /**
   * Sets the solution ref.
   * 
   * @param solutionRef the solutionRef to set
   */
  public void setSolutionRef(String solutionRef) {
    this.solutionRef = solutionRef;
  }

  /**
   * Sets the status.
   * 
   * @param status the status to set
   */
  public void setStatus(String status) {
    this.status = status;
  }


  /**
   * With shadowME.
   * 
   * @param shadowMe the highlights
   * @return the solution
   */
  public Solution withShadowMe(List<String> shadowMe) {
    this.shadowMe = shadowMe;
    return this;
  }

  /**
   * With shadows.
   * 
   * @param shadows the shadows
   * @return the solution
   */
  public Solution withShadows(List<String> shadows) {
    this.shadows = shadows;
    return this;
  }
}
