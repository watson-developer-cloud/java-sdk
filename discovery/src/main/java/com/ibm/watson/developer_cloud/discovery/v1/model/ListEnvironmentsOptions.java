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
 * The listEnvironments options.
 */
public class ListEnvironmentsOptions extends GenericModel {

  private String name;

  /**
   * Builder.
   */
  public static class Builder {
    private String name;

    private Builder(ListEnvironmentsOptions listEnvironmentsOptions) {
      name = listEnvironmentsOptions.name;
    }

    /**
     * Instantiates a new builder.
     */
    public Builder() {
    }

    /**
     * Builds a ListEnvironmentsOptions.
     *
     * @return the listEnvironmentsOptions
     */
    public ListEnvironmentsOptions build() {
      return new ListEnvironmentsOptions(this);
    }

    /**
     * Set the name.
     *
     * @param name the name
     * @return the ListEnvironmentsOptions builder
     */
    public Builder name(String name) {
      this.name = name;
      return this;
    }
  }

  private ListEnvironmentsOptions(Builder builder) {
    name = builder.name;
  }

  /**
   * New builder.
   *
   * @return a ListEnvironmentsOptions builder
   */
  public Builder newBuilder() {
    return new Builder(this);
  }

  /**
   * Gets the name.
   *
   * Show only the environment with the given name.
   *
   * @return the name
   */
  public String name() {
    return name;
  }
}
