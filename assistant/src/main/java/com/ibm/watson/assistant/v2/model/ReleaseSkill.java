/*
 * (C) Copyright IBM Corp. 2023, 2024.
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

/** ReleaseSkill. */
public class ReleaseSkill extends GenericModel {

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
  protected String snapshot;

  /** Builder. */
  public static class Builder {
    private String skillId;
    private String type;
    private String snapshot;

    /**
     * Instantiates a new Builder from an existing ReleaseSkill instance.
     *
     * @param releaseSkill the instance to initialize the Builder with
     */
    private Builder(ReleaseSkill releaseSkill) {
      this.skillId = releaseSkill.skillId;
      this.type = releaseSkill.type;
      this.snapshot = releaseSkill.snapshot;
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
     * Builds a ReleaseSkill.
     *
     * @return the new ReleaseSkill instance
     */
    public ReleaseSkill build() {
      return new ReleaseSkill(this);
    }

    /**
     * Set the skillId.
     *
     * @param skillId the skillId
     * @return the ReleaseSkill builder
     */
    public Builder skillId(String skillId) {
      this.skillId = skillId;
      return this;
    }

    /**
     * Set the type.
     *
     * @param type the type
     * @return the ReleaseSkill builder
     */
    public Builder type(String type) {
      this.type = type;
      return this;
    }

    /**
     * Set the snapshot.
     *
     * @param snapshot the snapshot
     * @return the ReleaseSkill builder
     */
    public Builder snapshot(String snapshot) {
      this.snapshot = snapshot;
      return this;
    }
  }

  protected ReleaseSkill() {}

  protected ReleaseSkill(Builder builder) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(builder.skillId, "skillId cannot be null");
    skillId = builder.skillId;
    type = builder.type;
    snapshot = builder.snapshot;
  }

  /**
   * New builder.
   *
   * @return a ReleaseSkill builder
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
   * Gets the snapshot.
   *
   * <p>The name of the skill snapshot that is saved as part of the release (for example, `draft` or
   * `1`).
   *
   * @return the snapshot
   */
  public String snapshot() {
    return snapshot;
  }
}
