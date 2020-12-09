/*
 * (C) Copyright IBM Corp. 2017, 2020.
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
package com.ibm.watson.visual_recognition.v3.model;

import com.ibm.cloud.sdk.core.service.model.GenericModel;

/** The listClassifiers options. */
public class ListClassifiersOptions extends GenericModel {

  protected Boolean verbose;

  /** Builder. */
  public static class Builder {
    private Boolean verbose;

    private Builder(ListClassifiersOptions listClassifiersOptions) {
      this.verbose = listClassifiersOptions.verbose;
    }

    /** Instantiates a new builder. */
    public Builder() {}

    /**
     * Builds a ListClassifiersOptions.
     *
     * @return the new ListClassifiersOptions instance
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

  protected ListClassifiersOptions(Builder builder) {
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
   * <p>Specify `true` to return details about the classifiers. Omit this parameter to return a
   * brief list of classifiers.
   *
   * @return the verbose
   */
  public Boolean verbose() {
    return verbose;
  }
}
