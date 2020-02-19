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
package com.ibm.watson.assistant.v2.model;

import java.util.Map;

import com.google.gson.annotations.SerializedName;
import com.ibm.cloud.sdk.core.service.model.GenericModel;

/**
 * Contains information specific to a particular skill used by the Assistant.
 */
public class MessageContextSkill extends GenericModel {

  @SerializedName("user_defined")
  protected Map<String, Object> userDefined;
  protected Map<String, Object> system;

  /**
   * Builder.
   */
  public static class Builder {
    private Map<String, Object> userDefined;
    private Map<String, Object> system;

    private Builder(MessageContextSkill messageContextSkill) {
      this.userDefined = messageContextSkill.userDefined;
      this.system = messageContextSkill.system;
    }

    /**
     * Instantiates a new builder.
     */
    public Builder() {
    }

    /**
     * Builds a MessageContextSkill.
     *
     * @return the messageContextSkill
     */
    public MessageContextSkill build() {
      return new MessageContextSkill(this);
    }

    /**
     * Set the userDefined.
     *
     * @param userDefined the userDefined
     * @return the MessageContextSkill builder
     */
    public Builder userDefined(Map<String, Object> userDefined) {
      this.userDefined = userDefined;
      return this;
    }

    /**
     * Set the system.
     *
     * @param system the system
     * @return the MessageContextSkill builder
     */
    public Builder system(Map<String, Object> system) {
      this.system = system;
      return this;
    }
  }

  protected MessageContextSkill(Builder builder) {
    userDefined = builder.userDefined;
    system = builder.system;
  }

  /**
   * New builder.
   *
   * @return a MessageContextSkill builder
   */
  public Builder newBuilder() {
    return new Builder(this);
  }

  /**
   * Gets the userDefined.
   *
   * Arbitrary variables that can be read and written by a particular skill.
   *
   * @return the userDefined
   */
  public Map<String, Object> userDefined() {
    return userDefined;
  }

  /**
   * Gets the system.
   *
   * For internal use only.
   *
   * @return the system
   */
  public Map<String, Object> system() {
    return system;
  }
}

