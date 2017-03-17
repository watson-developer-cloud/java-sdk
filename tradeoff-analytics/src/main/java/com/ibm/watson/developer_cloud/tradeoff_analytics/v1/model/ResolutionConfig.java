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

import java.util.Map;

/**
 * Resolution config.
 */
public class ResolutionConfig {
  private Map<String, String> drivers;
  private Map<String, String> params;

  /**
   * Gets the drivers.
   *
   * @return the drivers
   */
  public Map<String, String> getDrivers() {
    return drivers;
  }

  /**
   * Gets the params.
   *
   * @return the params
   */
  public Map<String, String> getParams() {
    return params;
  }

  /**
   * Sets the drivers.
   *
   * @param drivers the drivers
   */
  public void setDrivers(Map<String, String> drivers) {
    this.drivers = drivers;
  }

  /**
   * Sets the params.
   *
   * @param params the params
   */
  public void setParams(Map<String, String> params) {
    this.params = params;
  }

}
