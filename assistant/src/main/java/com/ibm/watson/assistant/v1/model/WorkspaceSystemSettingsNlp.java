/*
 * (C) Copyright IBM Corp. 2022, 2024.
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

/**
 * Workspace settings related to the version of the training algorithms currently used by the skill.
 */
public class WorkspaceSystemSettingsNlp extends GenericModel {

  protected String model;

  /** Builder. */
  public static class Builder {
    private String model;

    /**
     * Instantiates a new Builder from an existing WorkspaceSystemSettingsNlp instance.
     *
     * @param workspaceSystemSettingsNlp the instance to initialize the Builder with
     */
    private Builder(WorkspaceSystemSettingsNlp workspaceSystemSettingsNlp) {
      this.model = workspaceSystemSettingsNlp.model;
    }

    /** Instantiates a new builder. */
    public Builder() {}

    /**
     * Builds a WorkspaceSystemSettingsNlp.
     *
     * @return the new WorkspaceSystemSettingsNlp instance
     */
    public WorkspaceSystemSettingsNlp build() {
      return new WorkspaceSystemSettingsNlp(this);
    }

    /**
     * Set the model.
     *
     * @param model the model
     * @return the WorkspaceSystemSettingsNlp builder
     */
    public Builder model(String model) {
      this.model = model;
      return this;
    }
  }

  protected WorkspaceSystemSettingsNlp() {}

  protected WorkspaceSystemSettingsNlp(Builder builder) {
    model = builder.model;
  }

  /**
   * New builder.
   *
   * @return a WorkspaceSystemSettingsNlp builder
   */
  public Builder newBuilder() {
    return new Builder(this);
  }

  /**
   * Gets the model.
   *
   * <p>The policy the skill follows for selecting the algorithm version to use. For more
   * information, see the
   * [documentation](/docs/watson-assistant?topic=watson-assistant-algorithm-version).
   *
   * <p>On IBM Cloud, you can specify `latest`, `previous`, or `beta`.
   *
   * <p>On IBM Cloud Pak for Data, you can specify either `beta` or the date of the version you want
   * to use, in `YYYY-MM-DD` format.
   *
   * @return the model
   */
  public String model() {
    return model;
  }
}
