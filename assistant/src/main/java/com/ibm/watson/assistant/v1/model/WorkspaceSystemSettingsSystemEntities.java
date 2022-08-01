/*
 * (C) Copyright IBM Corp. 2022.
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

/** Workspace settings related to the behavior of system entities. */
public class WorkspaceSystemSettingsSystemEntities extends GenericModel {

  protected Boolean enabled;

  /** Builder. */
  public static class Builder {
    private Boolean enabled;

    private Builder(WorkspaceSystemSettingsSystemEntities workspaceSystemSettingsSystemEntities) {
      this.enabled = workspaceSystemSettingsSystemEntities.enabled;
    }

    /** Instantiates a new builder. */
    public Builder() {}

    /**
     * Builds a WorkspaceSystemSettingsSystemEntities.
     *
     * @return the new WorkspaceSystemSettingsSystemEntities instance
     */
    public WorkspaceSystemSettingsSystemEntities build() {
      return new WorkspaceSystemSettingsSystemEntities(this);
    }

    /**
     * Set the enabled.
     *
     * @param enabled the enabled
     * @return the WorkspaceSystemSettingsSystemEntities builder
     */
    public Builder enabled(Boolean enabled) {
      this.enabled = enabled;
      return this;
    }
  }

  protected WorkspaceSystemSettingsSystemEntities() {}

  protected WorkspaceSystemSettingsSystemEntities(Builder builder) {
    enabled = builder.enabled;
  }

  /**
   * New builder.
   *
   * @return a WorkspaceSystemSettingsSystemEntities builder
   */
  public Builder newBuilder() {
    return new Builder(this);
  }

  /**
   * Gets the enabled.
   *
   * <p>Whether the new system entities are enabled for the workspace.
   *
   * @return the enabled
   */
  public Boolean enabled() {
    return enabled;
  }
}
