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

import com.google.gson.annotations.SerializedName;
import com.ibm.watson.developer_cloud.service.model.GenericModel;

/**
 * Summary of the document usage statistics for the environment.
 */
public class EnvironmentDocuments extends GenericModel {

  private Long indexed;
  @SerializedName("maximum_allowed")
  private Long maximumAllowed;

  /**
   * Gets the indexed.
   *
   * Number of documents indexed for the environment.
   *
   * @return the indexed
   */
  public Long getIndexed() {
    return indexed;
  }

  /**
   * Gets the maximumAllowed.
   *
   * Total number of documents allowed in the environment's capacity.
   *
   * @return the maximumAllowed
   */
  public Long getMaximumAllowed() {
    return maximumAllowed;
  }
}
