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

import com.google.gson.annotations.SerializedName;
import com.google.gson.reflect.TypeToken;
import com.ibm.cloud.sdk.core.service.model.DynamicModel;

/**
 * The output of the dialog node. For more information about how to specify dialog node output, see the
 * [documentation](https://cloud.ibm.com/docs/services/assistant?topic=assistant-dialog-overview#dialog-overview-responses).
 */
public class DialogNodeOutput extends DynamicModel<Object> {
  @SerializedName("generic")
  private List<DialogNodeOutputGeneric> generic;
  @SerializedName("modifiers")
  private DialogNodeOutputModifiers modifiers;

  public DialogNodeOutput() {
    super(new TypeToken<Object>() {
    });
  }

  /**
   * Gets the generic.
   *
   * An array of objects describing the output defined for the dialog node.
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
   * Gets the modifiers.
   *
   * Options that modify how specified output is handled.
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
