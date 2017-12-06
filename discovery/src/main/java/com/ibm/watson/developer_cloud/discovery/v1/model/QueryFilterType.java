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
 * QueryFilterType.
 */
public class QueryFilterType extends GenericModel {

  private List<String> exclude;
  private List<String> include;

  /**
   * Gets the exclude.
   *
   * A comma-separated list of types to exclude.
   *
   * @return the exclude
   */
  public List<String> getExclude() {
    return exclude;
  }

  /**
   * Gets the include.
   *
   * A comma-separated list of types to include. All other types are excluded.
   *
   * @return the include
   */
  public List<String> getInclude() {
    return include;
  }

  /**
   * Sets the exclude.
   *
   * @param exclude the new exclude
   */
  public void setExclude(final List<String> exclude) {
    this.exclude = exclude;
  }

  /**
   * Sets the include.
   *
   * @param include the new include
   */
  public void setInclude(final List<String> include) {
    this.include = include;
  }
}
