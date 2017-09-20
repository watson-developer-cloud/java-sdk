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
 * WordStyle.
 */
public class WordStyle extends GenericModel {

  private Long level;
  private List<String> names;

  /**
   * Gets the level.
   *
   * @return the level
   */
  public Long getLevel() {
    return level;
  }

  /**
   * Gets the names.
   *
   * @return the names
   */
  public List<String> getNames() {
    return names;
  }

  /**
   * Sets the level.
   *
   * @param level the new level
   */
  public void setLevel(final long level) {
    this.level = level;
  }

  /**
   * Sets the names.
   *
   * @param names the new names
   */
  public void setNames(final List<String> names) {
    this.names = names;
  }
}
