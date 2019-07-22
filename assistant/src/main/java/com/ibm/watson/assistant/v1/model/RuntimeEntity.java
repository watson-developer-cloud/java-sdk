/*
 * Copyright 2018 IBM Corp. All Rights Reserved.
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

import java.util.List;
import java.util.Map;

import com.google.gson.annotations.SerializedName;
import com.google.gson.reflect.TypeToken;
import com.ibm.cloud.sdk.core.service.model.DynamicModel;

/**
 * A term from the request that was identified as an entity.
 */
public class RuntimeEntity extends DynamicModel<Object> {
  @SerializedName("entity")
  private String entity;
  @SerializedName("location")
  private List<Long> location;
  @SerializedName("value")
  private String value;
  @SerializedName("confidence")
  private Double confidence;
  @SerializedName("metadata")
  private Map metadata;
  @SerializedName("groups")
  private List<CaptureGroup> groups;
  @SerializedName("interpretation")
  private RuntimeEntityInterpretation interpretation;
  @SerializedName("role")
  private RuntimeEntityRole role;

  public RuntimeEntity() {
    super(new TypeToken<Object>() {
    });
  }

  /**
   * Gets the entity.
   *
   * An entity detected in the input.
   *
   * @return the entity
   */
  public String getEntity() {
    return this.entity;
  }

  /**
   * Sets the entity.
   *
   * @param entity the new entity
   */
  public void setEntity(final String entity) {
    this.entity = entity;
  }

  /**
   * Gets the location.
   *
   * An array of zero-based character offsets that indicate where the detected entity values begin and end in the input
   * text.
   *
   * @return the location
   */
  public List<Long> getLocation() {
    return this.location;
  }

  /**
   * Sets the location.
   *
   * @param location the new location
   */
  public void setLocation(final List<Long> location) {
    this.location = location;
  }

  /**
   * Gets the value.
   *
   * The entity value that was recognized in the user input.
   *
   * @return the value
   */
  public String getValue() {
    return this.value;
  }

  /**
   * Sets the value.
   *
   * @param value the new value
   */
  public void setValue(final String value) {
    this.value = value;
  }

  /**
   * Gets the confidence.
   *
   * A decimal percentage that represents Watson's confidence in the recognized entity.
   *
   * @return the confidence
   */
  public Double getConfidence() {
    return this.confidence;
  }

  /**
   * Sets the confidence.
   *
   * @param confidence the new confidence
   */
  public void setConfidence(final Double confidence) {
    this.confidence = confidence;
  }

  /**
   * Gets the metadata.
   *
   * Any metadata for the entity.
   *
   * @return the metadata
   */
  public Map getMetadata() {
    return this.metadata;
  }

  /**
   * Sets the metadata.
   *
   * @param metadata the new metadata
   */
  public void setMetadata(final Map metadata) {
    this.metadata = metadata;
  }

  /**
   * Gets the groups.
   *
   * The recognized capture groups for the entity, as defined by the entity pattern.
   *
   * @return the groups
   */
  public List<CaptureGroup> getGroups() {
    return this.groups;
  }

  /**
   * Sets the groups.
   *
   * @param groups the new groups
   */
  public void setGroups(final List<CaptureGroup> groups) {
    this.groups = groups;
  }

  /**
   * Gets the interpretation.
   *
   * An object containing detailed information about the entity recognized in the user input.
   *
   * This property is a part of the new system entities, which are a beta feature.
   *
   * @return the interpretation
   */
  public RuntimeEntityInterpretation getInterpretation() {
    return this.interpretation;
  }

  /**
   * Sets the interpretation.
   *
   * @param interpretation the new interpretation
   */
  public void setInterpretation(final RuntimeEntityInterpretation interpretation) {
    this.interpretation = interpretation;
  }

  /**
   * Gets the role.
   *
   * An object describing the role played by a system entity that is specifies the beginning or end of a range
   * recognized in the user input.
   *
   * This property is part of the new system entities, which are a beta feature.
   *
   * @return the role
   */
  public RuntimeEntityRole getRole() {
    return this.role;
  }

  /**
   * Sets the role.
   *
   * @param role the new role
   */
  public void setRole(final RuntimeEntityRole role) {
    this.role = role;
  }
}
