/*
 * (C) Copyright IBM Corp. 2021.
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

import com.ibm.cloud.sdk.core.service.model.GenericModel;

/** Options that modify how specified output is handled. */
public class DialogNodeOutputModifiers extends GenericModel {

  protected Boolean overwrite;

  /** Builder. */
  public static class Builder {
    private Boolean overwrite;

    private Builder(DialogNodeOutputModifiers dialogNodeOutputModifiers) {
      this.overwrite = dialogNodeOutputModifiers.overwrite;
    }

    /** Instantiates a new builder. */
    public Builder() {}

    /**
     * Builds a DialogNodeOutputModifiers.
     *
     * @return the new DialogNodeOutputModifiers instance
     */
    public DialogNodeOutputModifiers build() {
      return new DialogNodeOutputModifiers(this);
    }

    /**
     * Set the overwrite.
     *
     * @param overwrite the overwrite
     * @return the DialogNodeOutputModifiers builder
     */
    public Builder overwrite(Boolean overwrite) {
      this.overwrite = overwrite;
      return this;
    }
  }

  protected DialogNodeOutputModifiers(Builder builder) {
    overwrite = builder.overwrite;
  }

  /**
   * New builder.
   *
   * @return a DialogNodeOutputModifiers builder
   */
  public Builder newBuilder() {
    return new Builder(this);
  }

  /**
   * Gets the overwrite.
   *
   * <p>Whether values in the output will overwrite output values in an array specified by
   * previously executed dialog nodes. If this option is set to `false`, new values will be appended
   * to previously specified values.
   *
   * @return the overwrite
   */
  public Boolean overwrite() {
    return overwrite;
  }
}
