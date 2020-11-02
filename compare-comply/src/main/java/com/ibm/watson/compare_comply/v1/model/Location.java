/*
 * (C) Copyright IBM Corp. 2020.
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
package com.ibm.watson.compare_comply.v1.model;

import com.ibm.cloud.sdk.core.service.model.GenericModel;

/**
 * The numeric location of the identified element in the document, represented with two integers
 * labeled `begin` and `end`.
 */
public class Location extends GenericModel {

  protected Long begin;
  protected Long end;

  /** Builder. */
  public static class Builder {
    private Long begin;
    private Long end;

    private Builder(Location location) {
      this.begin = location.begin;
      this.end = location.end;
    }

    /** Instantiates a new builder. */
    public Builder() {}

    /**
     * Instantiates a new builder with required properties.
     *
     * @param begin the begin
     * @param end the end
     */
    public Builder(Long begin, Long end) {
      this.begin = begin;
      this.end = end;
    }

    /**
     * Builds a Location.
     *
     * @return the new Location instance
     */
    public Location build() {
      return new Location(this);
    }

    /**
     * Set the begin.
     *
     * @param begin the begin
     * @return the Location builder
     */
    public Builder begin(long begin) {
      this.begin = begin;
      return this;
    }

    /**
     * Set the end.
     *
     * @param end the end
     * @return the Location builder
     */
    public Builder end(long end) {
      this.end = end;
      return this;
    }
  }

  protected Location(Builder builder) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(builder.begin, "begin cannot be null");
    com.ibm.cloud.sdk.core.util.Validator.notNull(builder.end, "end cannot be null");
    begin = builder.begin;
    end = builder.end;
  }

  /**
   * New builder.
   *
   * @return a Location builder
   */
  public Builder newBuilder() {
    return new Builder(this);
  }

  /**
   * Gets the begin.
   *
   * <p>The element's `begin` index.
   *
   * @return the begin
   */
  public Long begin() {
    return begin;
  }

  /**
   * Gets the end.
   *
   * <p>The element's `end` index.
   *
   * @return the end
   */
  public Long end() {
    return end;
  }
}
