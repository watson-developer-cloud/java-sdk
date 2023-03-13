/*
 * (C) Copyright IBM Corp. 2018, 2023.
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
import com.ibm.cloud.sdk.core.service.model.GenericModel;

/** Workspace settings related to the Watson Assistant user interface. */
public class WorkspaceSystemSettingsTooling extends GenericModel {

  @SerializedName("store_generic_responses")
  protected Boolean storeGenericResponses;

  /** Builder. */
  public static class Builder {
    private Boolean storeGenericResponses;

    /**
     * Instantiates a new Builder from an existing WorkspaceSystemSettingsTooling instance.
     *
     * @param workspaceSystemSettingsTooling the instance to initialize the Builder with
     */
    private Builder(WorkspaceSystemSettingsTooling workspaceSystemSettingsTooling) {
      this.storeGenericResponses = workspaceSystemSettingsTooling.storeGenericResponses;
    }

    /** Instantiates a new builder. */
    public Builder() {}

    /**
     * Builds a WorkspaceSystemSettingsTooling.
     *
     * @return the new WorkspaceSystemSettingsTooling instance
     */
    public WorkspaceSystemSettingsTooling build() {
      return new WorkspaceSystemSettingsTooling(this);
    }

    /**
     * Set the storeGenericResponses.
     *
     * @param storeGenericResponses the storeGenericResponses
     * @return the WorkspaceSystemSettingsTooling builder
     */
    public Builder storeGenericResponses(Boolean storeGenericResponses) {
      this.storeGenericResponses = storeGenericResponses;
      return this;
    }
  }

  protected WorkspaceSystemSettingsTooling() {}

  protected WorkspaceSystemSettingsTooling(Builder builder) {
    storeGenericResponses = builder.storeGenericResponses;
  }

  /**
   * New builder.
   *
   * @return a WorkspaceSystemSettingsTooling builder
   */
  public Builder newBuilder() {
    return new Builder(this);
  }

  /**
   * Gets the storeGenericResponses.
   *
   * <p>Whether the dialog JSON editor displays text responses within the `output.generic` object.
   *
   * @return the storeGenericResponses
   */
  public Boolean storeGenericResponses() {
    return storeGenericResponses;
  }
}
