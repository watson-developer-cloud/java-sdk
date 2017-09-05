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

import java.util.List;

import com.ibm.watson.developer_cloud.service.model.GenericModel;

/**
 * ListEnvironmentsResponse.
 */
public class ListEnvironmentsResponse extends GenericModel {

  private List<Environment> environments;

  /**
   * Gets the environments.
   *
   * An array of [environments] that are available for the service instance.
   *
   * @return the environments
   */
  public List<Environment> getEnvironments() {
    return environments;
  }

  /**
   * Sets the environments.
   *
   * @param environments the new environments
   */
  public void setEnvironments(final List<Environment> environments) {
    this.environments = environments;
  }
}
