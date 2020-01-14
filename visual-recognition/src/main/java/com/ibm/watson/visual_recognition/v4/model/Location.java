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
package com.ibm.watson.visual_recognition.v4.model;

import com.ibm.cloud.sdk.core.service.model.GenericModel;

/**
 * Defines the location of the bounding box around the object.
 */
public class Location extends GenericModel {

  protected Long top;
  protected Long left;
  protected Long width;
  protected Long height;

  /**
   * Builder.
   */
  public static class Builder {
    private Long top;
    private Long left;
    private Long width;
    private Long height;

    private Builder(Location location) {
      this.top = location.top;
      this.left = location.left;
      this.width = location.width;
      this.height = location.height;
    }

    /**
     * Instantiates a new builder.
     */
    public Builder() {
    }

    /**
     * Instantiates a new builder with required properties.
     *
     * @param top the top
     * @param left the left
     * @param width the width
     * @param height the height
     */
    public Builder(Long top, Long left, Long width, Long height) {
      this.top = top;
      this.left = left;
      this.width = width;
      this.height = height;
    }

    /**
     * Builds a Location.
     *
     * @return the location
     */
    public Location build() {
      return new Location(this);
    }

    /**
     * Set the top.
     *
     * @param top the top
     * @return the Location builder
     */
    public Builder top(long top) {
      this.top = top;
      return this;
    }

    /**
     * Set the left.
     *
     * @param left the left
     * @return the Location builder
     */
    public Builder left(long left) {
      this.left = left;
      return this;
    }

    /**
     * Set the width.
     *
     * @param width the width
     * @return the Location builder
     */
    public Builder width(long width) {
      this.width = width;
      return this;
    }

    /**
     * Set the height.
     *
     * @param height the height
     * @return the Location builder
     */
    public Builder height(long height) {
      this.height = height;
      return this;
    }
  }

  protected Location(Builder builder) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(builder.top,
        "top cannot be null");
    com.ibm.cloud.sdk.core.util.Validator.notNull(builder.left,
        "left cannot be null");
    com.ibm.cloud.sdk.core.util.Validator.notNull(builder.width,
        "width cannot be null");
    com.ibm.cloud.sdk.core.util.Validator.notNull(builder.height,
        "height cannot be null");
    top = builder.top;
    left = builder.left;
    width = builder.width;
    height = builder.height;
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
   * Gets the top.
   *
   * Y-position of top-left pixel of the bounding box.
   *
   * @return the top
   */
  public Long top() {
    return top;
  }

  /**
   * Gets the left.
   *
   * X-position of top-left pixel of the bounding box.
   *
   * @return the left
   */
  public Long left() {
    return left;
  }

  /**
   * Gets the width.
   *
   * Width in pixels of of the bounding box.
   *
   * @return the width
   */
  public Long width() {
    return width;
  }

  /**
   * Gets the height.
   *
   * Height in pixels of the bounding box.
   *
   * @return the height
   */
  public Long height() {
    return height;
  }
}
