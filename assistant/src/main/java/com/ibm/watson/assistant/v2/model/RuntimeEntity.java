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
package com.ibm.watson.assistant.v2.model;

import java.util.List;
import java.util.Map;

import com.ibm.cloud.sdk.core.service.model.GenericModel;

/**
 * The entity value that was recognized in the user input.
 */
public class RuntimeEntity extends GenericModel {

  private String entity;
  private List<Long> location;
  private String value;
  private Double confidence;
  private Map metadata;
  private List<CaptureGroup> groups;
  private RuntimeEntityInterpretation interpretation;
  private RuntimeEntityRole role;

  /**
   * Gets the entity.
   *
   * An entity detected in the input.
   *
   * @return the entity
   */
  public String getEntity() {
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
  public List<Long> getLocation() {
    return location;
  }

  /**
   * Gets the value.
   *
   * The term in the input text that was recognized as an entity value.
   *
   * @return the value
   */
  public String getValue() {
    return value;
  }

  /**
   * Gets the confidence.
   *
   * A decimal percentage that represents Watson's confidence in the recognized entity.
   *
   * @return the confidence
   */
  public Double getConfidence() {
    return confidence;
  }

  /**
   * Gets the metadata.
   *
   * Any metadata for the entity.
   *
   * @return the metadata
   */
  public Map getMetadata() {
    return metadata;
  }

  /**
   * Gets the groups.
   *
   * The recognized capture groups for the entity, as defined by the entity pattern.
   *
   * @return the groups
   */
  public List<CaptureGroup> getGroups() {
    return groups;
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
    return interpretation;
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
    return role;
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
   * Sets the location.
   *
   * @param location the new location
   */
  public void setLocation(final List<Long> location) {
    this.location = location;
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
   * Sets the confidence.
   *
   * @param confidence the new confidence
   */
  public void setConfidence(final Double confidence) {
    this.confidence = confidence;
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
   * Sets the groups.
   *
   * @param groups the new groups
   */
  public void setGroups(final List<CaptureGroup> groups) {
    this.groups = groups;
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
   * Sets the role.
   *
   * @param role the new role
   */
  public void setRole(final RuntimeEntityRole role) {
    this.role = role;
  }
}
