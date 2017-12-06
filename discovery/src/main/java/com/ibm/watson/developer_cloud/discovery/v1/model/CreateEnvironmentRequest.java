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

import com.ibm.watson.developer_cloud.service.model.GenericModel;

/**
 * CreateEnvironmentRequest.
 */
public class CreateEnvironmentRequest extends GenericModel {

  private String name;
  private String description;
  private Long size;

  /**
   * Gets the name.
   *
   * Name that identifies the environment.
   *
   * @return the name
   */
  public String getName() {
    return name;
  }

  /**
   * Gets the description.
   *
   * Description of the environment.
   *
   * @return the description
   */
  public String getDescription() {
    return description;
  }

  /**
   * Gets the size.
   *
   * **Deprecated**: Size of the environment.
   *
   * @return the size
   */
  public Long getSize() {
    return size;
  }

  /**
   * Sets the name.
   *
   * @param name the new name
   */
  public void setName(final String name) {
    this.name = name;
  }

  /**
   * Sets the description.
   *
   * @param description the new description
   */
  public void setDescription(final String description) {
    this.description = description;
  }

  /**
   * Sets the size.
   *
   * @param size the new size
   */
  public void setSize(final long size) {
    this.size = size;
  }
}
