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

import com.google.gson.annotations.SerializedName;
import com.google.gson.reflect.TypeToken;
import com.ibm.cloud.sdk.core.service.model.DynamicModel;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * The output of the dialog node. For more information about how to specify dialog node output, see
 * the
 * [documentation](https://cloud.ibm.com/docs/assistant?topic=assistant-dialog-overview#dialog-overview-responses).
 */
public class DialogNodeOutput extends DynamicModel<Object> {

  @SerializedName("generic")
  protected List<DialogNodeOutputGeneric> generic;

  @SerializedName("integrations")
  protected Map<String, Map<String, Object>> integrations;

  @SerializedName("modifiers")
  protected DialogNodeOutputModifiers modifiers;

  public DialogNodeOutput() {
    super(new TypeToken<Object>() {});
  }

  /** Builder. */
  public static class Builder {
    private List<DialogNodeOutputGeneric> generic;
    private Map<String, Map<String, Object>> integrations;
    private DialogNodeOutputModifiers modifiers;
    private Map<String, Object> dynamicProperties;

    private Builder(DialogNodeOutput dialogNodeOutput) {
      this.generic = dialogNodeOutput.generic;
      this.integrations = dialogNodeOutput.integrations;
      this.modifiers = dialogNodeOutput.modifiers;
      this.dynamicProperties = dialogNodeOutput.getProperties();
    }

    /** Instantiates a new builder. */
    public Builder() {}

    /**
     * Builds a DialogNodeOutput.
     *
     * @return the new DialogNodeOutput instance
     */
    public DialogNodeOutput build() {
      return new DialogNodeOutput(this);
    }

    /**
     * Adds an generic to generic.
     *
     * @param generic the new generic
     * @return the DialogNodeOutput builder
     */
    public Builder addGeneric(DialogNodeOutputGeneric generic) {
      com.ibm.cloud.sdk.core.util.Validator.notNull(generic, "generic cannot be null");
      if (this.generic == null) {
        this.generic = new ArrayList<DialogNodeOutputGeneric>();
      }
      this.generic.add(generic);
      return this;
    }

    /**
     * Set the generic. Existing generic will be replaced.
     *
     * @param generic the generic
     * @return the DialogNodeOutput builder
     */
    public Builder generic(List<DialogNodeOutputGeneric> generic) {
      this.generic = generic;
      return this;
    }

    /**
     * Set the integrations.
     *
     * @param integrations the integrations
     * @return the DialogNodeOutput builder
     */
    public Builder integrations(Map<String, Map<String, Object>> integrations) {
      this.integrations = integrations;
      return this;
    }

    /**
     * Set the modifiers.
     *
     * @param modifiers the modifiers
     * @return the DialogNodeOutput builder
     */
    public Builder modifiers(DialogNodeOutputModifiers modifiers) {
      this.modifiers = modifiers;
      return this;
    }

    /**
     * Add an arbitrary property.
     *
     * @param name the name of the property to add
     * @param value the value of the property to add
     * @return the DialogNodeOutput builder
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

  protected DialogNodeOutput(Builder builder) {
    super(new TypeToken<Object>() {});
    generic = builder.generic;
    integrations = builder.integrations;
    modifiers = builder.modifiers;
    this.setProperties(builder.dynamicProperties);
  }

  /**
   * New builder.
   *
   * @return a DialogNodeOutput builder
   */
  public Builder newBuilder() {
    return new Builder(this);
  }

  /**
   * Gets the generic.
   *
   * <p>An array of objects describing the output defined for the dialog node.
   *
   * @return the generic
   */
  public List<DialogNodeOutputGeneric> getGeneric() {
    return this.generic;
  }

  /**
   * Sets the generic.
   *
   * @param generic the new generic
   */
  public void setGeneric(final List<DialogNodeOutputGeneric> generic) {
    this.generic = generic;
  }

  /**
   * Gets the integrations.
   *
   * <p>Output intended for specific integrations. For more information, see the
   * [documentation](https://cloud.ibm.com/docs/assistant?topic=assistant-dialog-responses-json).
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

  /**
   * Gets the modifiers.
   *
   * <p>Options that modify how specified output is handled.
   *
   * @return the modifiers
   */
  public DialogNodeOutputModifiers getModifiers() {
    return this.modifiers;
  }

  /**
   * Sets the modifiers.
   *
   * @param modifiers the new modifiers
   */
  public void setModifiers(final DialogNodeOutputModifiers modifiers) {
    this.modifiers = modifiers;
  }
}
