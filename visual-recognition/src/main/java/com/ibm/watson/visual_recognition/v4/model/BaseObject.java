/*
 * (C) Copyright IBM Corp. 2019.
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
 * Details about an object and its location.
 */
public class BaseObject extends GenericModel {

  private String object;
  private Location location;

  /**
   * Builder.
   */
  public static class Builder {
    private String object;
    private Location location;

    private Builder(BaseObject baseObject) {
      this.object = baseObject.object;
      this.location = baseObject.location;
    }

    /**
     * Instantiates a new builder.
     */
    public Builder() {
    }

    /**
     * Builds a BaseObject.
     *
     * @return the baseObject
     */
    public BaseObject build() {
      return new BaseObject(this);
    }

    /**
     * Set the object.
     *
     * @param object the object
     * @return the BaseObject builder
     */
    public Builder object(String object) {
      this.object = object;
      return this;
    }

    /**
     * Set the location.
     *
     * @param location the location
     * @return the BaseObject builder
     */
    public Builder location(Location location) {
      this.location = location;
      return this;
    }
  }

  private BaseObject(Builder builder) {
    object = builder.object;
    location = builder.location;
  }

  /**
   * New builder.
   *
   * @return a BaseObject builder
   */
  public Builder newBuilder() {
    return new Builder(this);
  }

  /**
   * Gets the object.
   *
   * The name of the object. The name can contain alphanumeric, underscore, hyphen, space, and dot characters. It cannot
   * begin with the reserved prefix `sys-`.
   *
   * @return the object
   */
  public String object() {
    return object;
  }

  /**
   * Gets the location.
   *
   * Defines the location of the bounding box around the object.
   *
   * @return the location
   */
  public Location location() {
    return location;
  }
}
