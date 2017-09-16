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
package com.ibm.watson.developer_cloud.visual_recognition.v3.model;

import com.ibm.watson.developer_cloud.service.model.GenericModel;

/**
 * The listCollections options.
 */
public class ListCollectionsOptions extends GenericModel {

  /**
   * Builder.
   */
  public static class Builder {

    private Builder(ListCollectionsOptions listCollectionsOptions) {
    }

    /**
     * Instantiates a new builder.
     */
    public Builder() {
    }

    /**
     * Builds a ListCollectionsOptions.
     *
     * @return the listCollectionsOptions
     */
    public ListCollectionsOptions build() {
      return new ListCollectionsOptions(this);
    }
  }

  private ListCollectionsOptions(Builder builder) {
  }

  /**
   * New builder.
   *
   * @return a ListCollectionsOptions builder
   */
  public Builder newBuilder() {
    return new Builder(this);
  }
}
