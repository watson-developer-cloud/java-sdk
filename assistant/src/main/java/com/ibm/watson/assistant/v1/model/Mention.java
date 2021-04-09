/*
 * (C) Copyright IBM Corp. 2021.
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
package com.ibm.watson.assistant.v1.model;

import com.ibm.cloud.sdk.core.service.model.GenericModel;
import java.util.ArrayList;
import java.util.List;

/** A mention of a contextual entity. */
public class Mention extends GenericModel {

  protected String entity;
  protected List<Long> location;

  /** Builder. */
  public static class Builder {
    private String entity;
    private List<Long> location;

    private Builder(Mention mention) {
      this.entity = mention.entity;
      this.location = mention.location;
    }

    /** Instantiates a new builder. */
    public Builder() {}

    /**
     * Instantiates a new builder with required properties.
     *
     * @param entity the entity
     * @param location the location
     */
    public Builder(String entity, List<Long> location) {
      this.entity = entity;
      this.location = location;
    }

    /**
     * Builds a Mention.
     *
     * @return the new Mention instance
     */
    public Mention build() {
      return new Mention(this);
    }

    /**
     * Adds an location to location.
     *
     * @param location the new location
     * @return the Mention builder
     */
    public Builder addLocation(Long location) {
      com.ibm.cloud.sdk.core.util.Validator.notNull(location, "location cannot be null");
      if (this.location == null) {
        this.location = new ArrayList<Long>();
      }
      this.location.add(location);
      return this;
    }

    /**
     * Set the entity.
     *
     * @param entity the entity
     * @return the Mention builder
     */
    public Builder entity(String entity) {
      this.entity = entity;
      return this;
    }

    /**
     * Set the location. Existing location will be replaced.
     *
     * @param location the location
     * @return the Mention builder
     */
    public Builder location(List<Long> location) {
      this.location = location;
      return this;
    }
  }

  protected Mention(Builder builder) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(builder.entity, "entity cannot be null");
    com.ibm.cloud.sdk.core.util.Validator.notNull(builder.location, "location cannot be null");
    entity = builder.entity;
    location = builder.location;
  }

  /**
   * New builder.
   *
   * @return a Mention builder
   */
  public Builder newBuilder() {
    return new Builder(this);
  }

  /**
   * Gets the entity.
   *
   * <p>The name of the entity.
   *
   * @return the entity
   */
  public String entity() {
    return entity;
  }

  /**
   * Gets the location.
   *
   * <p>An array of zero-based character offsets that indicate where the entity mentions begin and
   * end in the input text.
   *
   * @return the location
   */
  public List<Long> location() {
    return location;
  }
}
