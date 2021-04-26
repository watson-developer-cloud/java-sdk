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

import com.google.gson.annotations.SerializedName;
import com.google.gson.reflect.TypeToken;
import com.ibm.cloud.sdk.core.service.model.DynamicModel;
import java.util.HashMap;
import java.util.Map;

/** System context data used by the skill. */
public class MessageContextSkillSystem extends DynamicModel<Object> {

  @SerializedName("state")
  protected String state;

  public MessageContextSkillSystem() {
    super(new TypeToken<Object>() {});
  }

  /** Builder. */
  public static class Builder {
    private String state;
    private Map<String, Object> dynamicProperties;

    private Builder(MessageContextSkillSystem messageContextSkillSystem) {
      this.state = messageContextSkillSystem.state;
      this.dynamicProperties = messageContextSkillSystem.getProperties();
    }

    /** Instantiates a new builder. */
    public Builder() {}

    /**
     * Builds a MessageContextSkillSystem.
     *
     * @return the new MessageContextSkillSystem instance
     */
    public MessageContextSkillSystem build() {
      return new MessageContextSkillSystem(this);
    }

    /**
     * Set the state.
     *
     * @param state the state
     * @return the MessageContextSkillSystem builder
     */
    public Builder state(String state) {
      this.state = state;
      return this;
    }

    /**
     * Add an arbitrary property.
     *
     * @param name the name of the property to add
     * @param value the value of the property to add
     * @return the MessageContextSkillSystem builder
     */
    public Builder add(String name, Object value) {
      com.ibm.cloud.sdk.core.util.Validator.notNull(name, "name cannot be null");
      if (this.dynamicProperties == null) {
        this.dynamicProperties = new HashMap<String, Object>();
      }
      this.dynamicProperties.put(name, value);
      return this;
    }
  }

  protected MessageContextSkillSystem(Builder builder) {
    super(new TypeToken<Object>() {});
    state = builder.state;
    this.setProperties(builder.dynamicProperties);
  }

  /**
   * New builder.
   *
   * @return a MessageContextSkillSystem builder
   */
  public Builder newBuilder() {
    return new Builder(this);
  }

  /**
   * Gets the state.
   *
   * <p>An encoded string that represents the current conversation state. By saving this value and
   * then sending it in the context of a subsequent message request, you can return to an earlier
   * point in the conversation. If you are using stateful sessions, you can also use a stored state
   * value to restore a paused conversation whose session is expired.
   *
   * @return the state
   */
  public String getState() {
    return this.state;
  }

  /**
   * Sets the state.
   *
   * @param state the new state
   */
  public void setState(final String state) {
    this.state = state;
  }
}
