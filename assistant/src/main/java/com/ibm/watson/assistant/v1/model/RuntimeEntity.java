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
package com.ibm.watson.assistant.v1.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.ibm.cloud.sdk.core.service.model.GenericModel;

/**
 * A term from the request that was identified as an entity.
 */
public class RuntimeEntity extends GenericModel {

  protected String entity;
  protected List<Long> location;
  protected String value;
  protected Double confidence;
  protected Map<String, Object> metadata;
  protected List<CaptureGroup> groups;
  protected RuntimeEntityInterpretation interpretation;
  protected RuntimeEntityRole role;

  /**
   * Builder.
   */
  public static class Builder {
    private String entity;
    private List<Long> location;
    private String value;
    private Double confidence;
    private Map<String, Object> metadata;
    private List<CaptureGroup> groups;
    private RuntimeEntityInterpretation interpretation;
    private RuntimeEntityRole role;

    private Builder(RuntimeEntity runtimeEntity) {
      this.entity = runtimeEntity.entity;
      this.location = runtimeEntity.location;
      this.value = runtimeEntity.value;
      this.confidence = runtimeEntity.confidence;
      this.metadata = runtimeEntity.metadata;
      this.groups = runtimeEntity.groups;
      this.interpretation = runtimeEntity.interpretation;
      this.role = runtimeEntity.role;
    }

    /**
     * Instantiates a new builder.
     */
    public Builder() {
    }

    /**
     * Instantiates a new builder with required properties.
     *
     * @param entity the entity
     * @param location the location
     * @param value the value
     */
    public Builder(String entity, List<Long> location, String value) {
      this.entity = entity;
      this.location = location;
      this.value = value;
    }

    /**
     * Builds a RuntimeEntity.
     *
     * @return the runtimeEntity
     */
    public RuntimeEntity build() {
      return new RuntimeEntity(this);
    }

    /**
     * Adds an location to location.
     *
     * @param location the new location
     * @return the RuntimeEntity builder
     */
    public Builder addLocation(Long location) {
      com.ibm.cloud.sdk.core.util.Validator.notNull(location,
        "location cannot be null");
      if (this.location == null) {
        this.location = new ArrayList<Long>();
      }
      this.location.add(location);
      return this;
    }

    /**
     * Adds an groups to groups.
     *
     * @param groups the new groups
     * @return the RuntimeEntity builder
     */
    public Builder addGroups(CaptureGroup groups) {
      com.ibm.cloud.sdk.core.util.Validator.notNull(groups,
        "groups cannot be null");
      if (this.groups == null) {
        this.groups = new ArrayList<CaptureGroup>();
      }
      this.groups.add(groups);
      return this;
    }

    /**
     * Set the entity.
     *
     * @param entity the entity
     * @return the RuntimeEntity builder
     */
    public Builder entity(String entity) {
      this.entity = entity;
      return this;
    }

    /**
     * Set the location.
     * Existing location will be replaced.
     *
     * @param location the location
     * @return the RuntimeEntity builder
     */
    public Builder location(List<Long> location) {
      this.location = location;
      return this;
    }

    /**
     * Set the value.
     *
     * @param value the value
     * @return the RuntimeEntity builder
     */
    public Builder value(String value) {
      this.value = value;
      return this;
    }

    /**
     * Set the confidence.
     *
     * @param confidence the confidence
     * @return the RuntimeEntity builder
     */
    public Builder confidence(Double confidence) {
      this.confidence = confidence;
      return this;
    }

    /**
     * Set the metadata.
     *
     * @param metadata the metadata
     * @return the RuntimeEntity builder
     */
    public Builder metadata(Map<String, Object> metadata) {
      this.metadata = metadata;
      return this;
    }

    /**
     * Set the groups.
     * Existing groups will be replaced.
     *
     * @param groups the groups
     * @return the RuntimeEntity builder
     */
    public Builder groups(List<CaptureGroup> groups) {
      this.groups = groups;
      return this;
    }

    /**
     * Set the interpretation.
     *
     * @param interpretation the interpretation
     * @return the RuntimeEntity builder
     */
    public Builder interpretation(RuntimeEntityInterpretation interpretation) {
      this.interpretation = interpretation;
      return this;
    }

    /**
     * Set the role.
     *
     * @param role the role
     * @return the RuntimeEntity builder
     */
    public Builder role(RuntimeEntityRole role) {
      this.role = role;
      return this;
    }
  }

  protected RuntimeEntity(Builder builder) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(builder.entity,
      "entity cannot be null");
    com.ibm.cloud.sdk.core.util.Validator.notNull(builder.location,
      "location cannot be null");
    com.ibm.cloud.sdk.core.util.Validator.notNull(builder.value,
      "value cannot be null");
    entity = builder.entity;
    location = builder.location;
    value = builder.value;
    confidence = builder.confidence;
    metadata = builder.metadata;
    groups = builder.groups;
    interpretation = builder.interpretation;
    role = builder.role;
  }

  /**
   * New builder.
   *
   * @return a RuntimeEntity builder
   */
  public Builder newBuilder() {
    return new Builder(this);
  }

  /**
   * Gets the entity.
   *
   * An entity detected in the input.
   *
   * @return the entity
   */
  public String entity() {
    return entity;
  }

  /**
   * Gets the location.
   *
   * An array of zero-based character offsets that indicate where the detected entity values begin and end in the input
   * text.
   *
   * @return the location
   */
  public List<Long> location() {
    return location;
  }

  /**
   * Gets the value.
   *
   * The entity value that was recognized in the user input.
   *
   * @return the value
   */
  public String value() {
    return value;
  }

  /**
   * Gets the confidence.
   *
   * A decimal percentage that represents Watson's confidence in the recognized entity.
   *
   * @return the confidence
   */
  public Double confidence() {
    return confidence;
  }

  /**
   * Gets the metadata.
   *
   * Any metadata for the entity.
   *
   * @return the metadata
   */
  public Map<String, Object> metadata() {
    return metadata;
  }

  /**
   * Gets the groups.
   *
   * The recognized capture groups for the entity, as defined by the entity pattern.
   *
   * @return the groups
   */
  public List<CaptureGroup> groups() {
    return groups;
  }

  /**
   * Gets the interpretation.
   *
   * An object containing detailed information about the entity recognized in the user input. This property is included
   * only if the new system entities are enabled for the workspace.
   *
   * For more information about how the new system entities are interpreted, see the
   * [documentation](https://cloud.ibm.com/docs/assistant?topic=assistant-beta-system-entities).
   *
   * @return the interpretation
   */
  public RuntimeEntityInterpretation interpretation() {
    return interpretation;
  }

  /**
   * Gets the role.
   *
   * An object describing the role played by a system entity that is specifies the beginning or end of a range
   * recognized in the user input. This property is included only if the new system entities are enabled for the
   * workspace.
   *
   * @return the role
   */
  public RuntimeEntityRole role() {
    return role;
  }
}

