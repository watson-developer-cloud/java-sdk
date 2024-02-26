/*
 * (C) Copyright IBM Corp. 2018, 2024.
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

import com.ibm.cloud.sdk.core.service.model.GenericModel;
import java.util.ArrayList;
import java.util.List;

/** The entity value that was recognized in the user input. */
public class RuntimeEntity extends GenericModel {

  protected String entity;
  protected List<Long> location;
  protected String value;
  protected Double confidence;
  protected List<CaptureGroup> groups;
  protected RuntimeEntityInterpretation interpretation;
  protected List<RuntimeEntityAlternative> alternatives;
  protected RuntimeEntityRole role;
  protected String skill;

  /** Builder. */
  public static class Builder {
    private String entity;
    private List<Long> location;
    private String value;
    private Double confidence;
    private List<CaptureGroup> groups;
    private RuntimeEntityInterpretation interpretation;
    private List<RuntimeEntityAlternative> alternatives;
    private RuntimeEntityRole role;
    private String skill;

    /**
     * Instantiates a new Builder from an existing RuntimeEntity instance.
     *
     * @param runtimeEntity the instance to initialize the Builder with
     */
    private Builder(RuntimeEntity runtimeEntity) {
      this.entity = runtimeEntity.entity;
      this.location = runtimeEntity.location;
      this.value = runtimeEntity.value;
      this.confidence = runtimeEntity.confidence;
      this.groups = runtimeEntity.groups;
      this.interpretation = runtimeEntity.interpretation;
      this.alternatives = runtimeEntity.alternatives;
      this.role = runtimeEntity.role;
      this.skill = runtimeEntity.skill;
    }

    /** Instantiates a new builder. */
    public Builder() {}

    /**
     * Instantiates a new builder with required properties.
     *
     * @param entity the entity
     * @param value the value
     */
    public Builder(String entity, String value) {
      this.entity = entity;
      this.value = value;
    }

    /**
     * Builds a RuntimeEntity.
     *
     * @return the new RuntimeEntity instance
     */
    public RuntimeEntity build() {
      return new RuntimeEntity(this);
    }

    /**
     * Adds a new element to location.
     *
     * @param location the new element to be added
     * @return the RuntimeEntity builder
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
     * Adds a new element to groups.
     *
     * @param groups the new element to be added
     * @return the RuntimeEntity builder
     */
    public Builder addGroups(CaptureGroup groups) {
      com.ibm.cloud.sdk.core.util.Validator.notNull(groups, "groups cannot be null");
      if (this.groups == null) {
        this.groups = new ArrayList<CaptureGroup>();
      }
      this.groups.add(groups);
      return this;
    }

    /**
     * Adds a new element to alternatives.
     *
     * @param alternatives the new element to be added
     * @return the RuntimeEntity builder
     */
    public Builder addAlternatives(RuntimeEntityAlternative alternatives) {
      com.ibm.cloud.sdk.core.util.Validator.notNull(alternatives, "alternatives cannot be null");
      if (this.alternatives == null) {
        this.alternatives = new ArrayList<RuntimeEntityAlternative>();
      }
      this.alternatives.add(alternatives);
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
     * Set the location. Existing location will be replaced.
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
     * Set the groups. Existing groups will be replaced.
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
     * Set the alternatives. Existing alternatives will be replaced.
     *
     * @param alternatives the alternatives
     * @return the RuntimeEntity builder
     */
    public Builder alternatives(List<RuntimeEntityAlternative> alternatives) {
      this.alternatives = alternatives;
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

    /**
     * Set the skill.
     *
     * @param skill the skill
     * @return the RuntimeEntity builder
     */
    public Builder skill(String skill) {
      this.skill = skill;
      return this;
    }
  }

  protected RuntimeEntity() {}

  protected RuntimeEntity(Builder builder) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(builder.entity, "entity cannot be null");
    com.ibm.cloud.sdk.core.util.Validator.notNull(builder.value, "value cannot be null");
    entity = builder.entity;
    location = builder.location;
    value = builder.value;
    confidence = builder.confidence;
    groups = builder.groups;
    interpretation = builder.interpretation;
    alternatives = builder.alternatives;
    role = builder.role;
    skill = builder.skill;
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
   * <p>An entity detected in the input.
   *
   * @return the entity
   */
  public String entity() {
    return entity;
  }

  /**
   * Gets the location.
   *
   * <p>An array of zero-based character offsets that indicate where the detected entity values
   * begin and end in the input text.
   *
   * @return the location
   */
  public List<Long> location() {
    return location;
  }

  /**
   * Gets the value.
   *
   * <p>The term in the input text that was recognized as an entity value.
   *
   * @return the value
   */
  public String value() {
    return value;
  }

  /**
   * Gets the confidence.
   *
   * <p>A decimal percentage that represents confidence in the recognized entity.
   *
   * @return the confidence
   */
  public Double confidence() {
    return confidence;
  }

  /**
   * Gets the groups.
   *
   * <p>The recognized capture groups for the entity, as defined by the entity pattern.
   *
   * @return the groups
   */
  public List<CaptureGroup> groups() {
    return groups;
  }

  /**
   * Gets the interpretation.
   *
   * <p>An object containing detailed information about the entity recognized in the user input.
   * This property is included only if the new system entities are enabled for the skill.
   *
   * <p>For more information about how the new system entities are interpreted, see the
   * [documentation](https://cloud.ibm.com/docs/assistant?topic=assistant-beta-system-entities).
   *
   * @return the interpretation
   */
  public RuntimeEntityInterpretation interpretation() {
    return interpretation;
  }

  /**
   * Gets the alternatives.
   *
   * <p>An array of possible alternative values that the user might have intended instead of the
   * value returned in the **value** property. This property is returned only for `@sys-time` and
   * `@sys-date` entities when the user's input is ambiguous.
   *
   * <p>This property is included only if the new system entities are enabled for the skill.
   *
   * @return the alternatives
   */
  public List<RuntimeEntityAlternative> alternatives() {
    return alternatives;
  }

  /**
   * Gets the role.
   *
   * <p>An object describing the role played by a system entity that is specifies the beginning or
   * end of a range recognized in the user input. This property is included only if the new system
   * entities are enabled for the skill.
   *
   * @return the role
   */
  public RuntimeEntityRole role() {
    return role;
  }

  /**
   * Gets the skill.
   *
   * <p>The skill that recognized the entity value. Currently, the only possible values are `main
   * skill` for the dialog skill (if enabled) and `actions skill` for the action skill.
   *
   * <p>This property is present only if the assistant has both a dialog skill and an action skill.
   *
   * @return the skill
   */
  public String skill() {
    return skill;
  }
}
