/*
 * (C) Copyright IBM Corp. 2018, 2020.
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
package com.ibm.watson.discovery.v1.model;

import com.google.gson.annotations.SerializedName;
import com.ibm.cloud.sdk.core.service.model.GenericModel;
import java.util.Date;

/** Information about the Continuous Relevancy Training for this environment. */
public class SearchStatus extends GenericModel {

  /** The current status of Continuous Relevancy Training for this environment. */
  public interface Status {
    /** NO_DATA. */
    String NO_DATA = "NO_DATA";
    /** INSUFFICENT_DATA. */
    String INSUFFICENT_DATA = "INSUFFICENT_DATA";
    /** TRAINING. */
    String TRAINING = "TRAINING";
    /** TRAINED. */
    String TRAINED = "TRAINED";
    /** NOT_APPLICABLE. */
    String NOT_APPLICABLE = "NOT_APPLICABLE";
  }

  protected String scope;
  protected String status;

  @SerializedName("status_description")
  protected String statusDescription;

  @SerializedName("last_trained")
  protected Date lastTrained;

  /**
   * Gets the scope.
   *
   * <p>Current scope of the training. Always returned as `environment`.
   *
   * @return the scope
   */
  public String getScope() {
    return scope;
  }

  /**
   * Gets the status.
   *
   * <p>The current status of Continuous Relevancy Training for this environment.
   *
   * @return the status
   */
  public String getStatus() {
    return status;
  }

  /**
   * Gets the statusDescription.
   *
   * <p>Long description of the current Continuous Relevancy Training status.
   *
   * @return the statusDescription
   */
  public String getStatusDescription() {
    return statusDescription;
  }

  /**
   * Gets the lastTrained.
   *
   * <p>The date stamp of the most recent completed training for this environment.
   *
   * @return the lastTrained
   */
  public Date getLastTrained() {
    return lastTrained;
  }
}
