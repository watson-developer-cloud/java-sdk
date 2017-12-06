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
 * The listClassifiers options.
 */
public class ListClassifiersOptions extends GenericModel {

  private Boolean verbose;

  /**
   * Builder.
   */
  public static class Builder {
    private Boolean verbose;

    private Builder(ListClassifiersOptions listClassifiersOptions) {
      verbose = listClassifiersOptions.verbose;
    }

    /**
     * Instantiates a new builder.
     */
    public Builder() {
    }

    /**
     * Builds a ListClassifiersOptions.
     *
     * @return the listClassifiersOptions
     */
    public ListClassifiersOptions build() {
      return new ListClassifiersOptions(this);
    }

    /**
     * Set the verbose.
     *
     * @param verbose the verbose
     * @return the ListClassifiersOptions builder
     */
    public Builder verbose(Boolean verbose) {
      this.verbose = verbose;
      return this;
    }
  }

  private ListClassifiersOptions(Builder builder) {
    verbose = builder.verbose;
  }

  /**
   * New builder.
   *
   * @return a ListClassifiersOptions builder
   */
  public Builder newBuilder() {
    return new Builder(this);
  }

  /**
   * Gets the verbose.
   *
   * Specify `true` to return classifier details. Omit this parameter to return a brief list of classifiers.
   *
   * @return the verbose
   */
  public Boolean verbose() {
    return verbose;
  }
}
