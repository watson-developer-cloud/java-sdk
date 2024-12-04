/*
 * (C) Copyright IBM Corp. 2024.
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

import com.google.gson.annotations.SerializedName;
import com.ibm.cloud.sdk.core.service.model.GenericModel;

/** EnvironmentSkill. */
public class EnvironmentSkill extends GenericModel {

  /** The type of the skill. */
  public interface Type {
    /** dialog. */
    String DIALOG = "dialog";
    /** action. */
    String ACTION = "action";
    /** search. */
    String SEARCH = "search";
  }

  @SerializedName("skill_id")
  protected String skillId;

  protected String type;
  protected Boolean disabled;
  protected String snapshot;

  @SerializedName("skill_reference")
  protected String skillReference;

  /** Builder. */
  public static class Builder {
    private String skillId;
    private String type;
    private Boolean disabled;
    private String snapshot;
    private String skillReference;

    /**
     * Instantiates a new Builder from an existing EnvironmentSkill instance.
     *
     * @param environmentSkill the instance to initialize the Builder with
     */
    private Builder(EnvironmentSkill environmentSkill) {
      this.skillId = environmentSkill.skillId;
      this.type = environmentSkill.type;
      this.disabled = environmentSkill.disabled;
      this.snapshot = environmentSkill.snapshot;
      this.skillReference = environmentSkill.skillReference;
    }

    /** Instantiates a new builder. */
    public Builder() {}

    /**
     * Instantiates a new builder with required properties.
     *
     * @param skillId the skillId
     */
    public Builder(String skillId) {
      this.skillId = skillId;
    }

    /**
     * Builds a EnvironmentSkill.
     *
     * @return the new EnvironmentSkill instance
     */
    public EnvironmentSkill build() {
      return new EnvironmentSkill(this);
    }

    /**
     * Set the skillId.
     *
     * @param skillId the skillId
     * @return the EnvironmentSkill builder
     */
    public Builder skillId(String skillId) {
      this.skillId = skillId;
      return this;
    }

    /**
     * Set the type.
     *
     * @param type the type
     * @return the EnvironmentSkill builder
     */
    public Builder type(String type) {
      this.type = type;
      return this;
    }

    /**
     * Set the disabled.
     *
     * @param disabled the disabled
     * @return the EnvironmentSkill builder
     */
    public Builder disabled(Boolean disabled) {
      this.disabled = disabled;
      return this;
    }

    /**
     * Set the snapshot.
     *
     * @param snapshot the snapshot
     * @return the EnvironmentSkill builder
     */
    public Builder snapshot(String snapshot) {
      this.snapshot = snapshot;
      return this;
    }

    /**
     * Set the skillReference.
     *
     * @param skillReference the skillReference
     * @return the EnvironmentSkill builder
     */
    public Builder skillReference(String skillReference) {
      this.skillReference = skillReference;
      return this;
    }
  }

  protected EnvironmentSkill() {}

  protected EnvironmentSkill(Builder builder) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(builder.skillId, "skillId cannot be null");
    skillId = builder.skillId;
    type = builder.type;
    disabled = builder.disabled;
    snapshot = builder.snapshot;
    skillReference = builder.skillReference;
  }

  /**
   * New builder.
   *
   * @return a EnvironmentSkill builder
   */
  public Builder newBuilder() {
    return new Builder(this);
  }

  /**
   * Gets the skillId.
   *
   * <p>The skill ID of the skill.
   *
   * @return the skillId
   */
  public String skillId() {
    return skillId;
  }

  /**
   * Gets the type.
   *
   * <p>The type of the skill.
   *
   * @return the type
   */
  public String type() {
    return type;
  }

  /**
   * Gets the disabled.
   *
   * <p>Whether the skill is disabled. A disabled skill in the draft environment does not handle any
   * messages at run time, and it is not included in saved releases.
   *
   * @return the disabled
   */
  public Boolean disabled() {
    return disabled;
  }

  /**
   * Gets the snapshot.
   *
   * <p>The name of the skill snapshot that is deployed to the environment (for example, `draft` or
   * `1`).
   *
   * @return the snapshot
   */
  public String snapshot() {
    return snapshot;
  }

  /**
   * Gets the skillReference.
   *
   * <p>The type of skill identified by the skill reference. The possible values are `main skill`
   * (for a dialog skill), `actions skill`, and `search skill`.
   *
   * @return the skillReference
   */
  public String skillReference() {
    return skillReference;
  }
}
