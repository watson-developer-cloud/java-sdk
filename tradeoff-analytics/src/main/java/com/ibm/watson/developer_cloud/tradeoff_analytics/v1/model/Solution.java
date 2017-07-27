/**
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
 * Solution used by the {@link TradeoffAnalytics} v1 service.
 */
public class Solution extends GenericModel {

  /**
   * Represent the error when the {@link Solution#getStatus()} is <code>INCOMPLETE</code>.
   */
  public class StatusCause {

    @SerializedName("error_code")
    private String errorCode;

    private String message;
    private List<String> tokens;

    /**
     * Gets the error code.
     *
     * @return the errorCode
     */
    public String getErrorCode() {
      return errorCode;
    }

    /**
     * Gets the message.
     *
     * @return the message
     */
    public String getMessage() {
      return message;
    }

    /**
     * Gets the tokens.
     *
     * @return the tokens
     */
    public List<String> getTokens() {
      return tokens;
    }

    /**
     * Sets the error code.
     *
     * @param errorCode the errorCode to set
     */
    public void setErrorCode(String errorCode) {
      this.errorCode = errorCode;
    }

    /**
     * Sets the message.
     *
     * @param message the message to set
     */
    public void setMessage(String message) {
      this.message = message;
    }

    /**
     * Sets the tokens.
     *
     * @param tokens the tokens to set
     */
    public void setTokens(List<String> tokens) {
      this.tokens = tokens;
    }

  }

  @SerializedName("shadow_me")
  private List<String> shadowMe;

  private List<String> shadows;

  @SerializedName("solution_ref")
  private String solutionRef;


  private String status;

  @SerializedName("status_cause")
  private StatusCause statusCause;

  @SerializedName("excluded_by")
  private List<DominatingOption> excludedBy;

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
   * Gets the status cause.
   *
   * @return the statusCause
   */
  public StatusCause getStatusCause() {
    return statusCause;
  }

  /**
   * Gets the the list of options excluding this option.
   *
   * @return the list of excluding options
   */
  public List<DominatingOption> getExcludedBy() {
    return excludedBy;
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
   * Sets the status cause.
   *
   * @param statusCause the statusCause to set
   */
  public void setStatusCause(StatusCause statusCause) {
    this.statusCause = statusCause;
  }

  /**
   * Sets the list of excluding options.
   *
   * @param excludingOptions the list of excluding options
   */
  public void setExcludedBy(List<DominatingOption> excludingOptions) {
    this.excludedBy = excludingOptions;
  }
}
