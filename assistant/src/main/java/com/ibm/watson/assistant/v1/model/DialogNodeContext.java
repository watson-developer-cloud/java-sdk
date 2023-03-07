/*
 * (C) Copyright IBM Corp. 2023.
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

import com.google.gson.annotations.SerializedName;
import com.google.gson.reflect.TypeToken;
import com.ibm.cloud.sdk.core.service.model.DynamicModel;
import java.util.HashMap;
import java.util.Map;

/** The context for the dialog node. */
public class DialogNodeContext extends DynamicModel<Object> {

  @SerializedName("integrations")
  protected Map<String, Map<String, Object>> integrations;

  public DialogNodeContext() {
    super(new TypeToken<Object>() {});
  }

  /** Builder. */
  public static class Builder {
    private Map<String, Map<String, Object>> integrations;
    private Map<String, Object> dynamicProperties;

    /**
     * Instantiates a new Builder from an existing DialogNodeContext instance.
     *
     * @param dialogNodeContext the instance to initialize the Builder with
     */
    private Builder(DialogNodeContext dialogNodeContext) {
      this.integrations = dialogNodeContext.integrations;
      this.dynamicProperties = dialogNodeContext.getProperties();
    }

    /** Instantiates a new builder. */
    public Builder() {}

    /**
     * Builds a DialogNodeContext.
     *
     * @return the new DialogNodeContext instance
     */
    public DialogNodeContext build() {
      return new DialogNodeContext(this);
    }

    /**
     * Set the integrations.
     *
     * @param integrations the integrations
     * @return the DialogNodeContext builder
     */
    public Builder integrations(Map<String, Map<String, Object>> integrations) {
      this.integrations = integrations;
      return this;
    }

    /**
     * Add an arbitrary property.
     *
     * @param name the name of the property to add
     * @param value the value of the property to add
     * @return the DialogNodeContext builder
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

  protected DialogNodeContext(Builder builder) {
    super(new TypeToken<Object>() {});
    integrations = builder.integrations;
    this.setProperties(builder.dynamicProperties);
  }

  /**
   * New builder.
   *
   * @return a DialogNodeContext builder
   */
  public Builder newBuilder() {
    return new Builder(this);
  }

  /**
   * Gets the integrations.
   *
   * <p>Context data intended for specific integrations.
   *
   * @return the integrations
   */
  public Map<String, Map<String, Object>> getIntegrations() {
    return this.integrations;
  }

  /**
   * Sets the integrations.
   *
   * @param integrations the new integrations
   */
  public void setIntegrations(final Map<String, Map<String, Object>> integrations) {
    this.integrations = integrations;
  }
}
