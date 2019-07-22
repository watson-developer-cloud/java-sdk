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

import com.ibm.cloud.sdk.core.service.model.GenericModel;

/**
 * Workspace settings related to the behavior of system entities.
 */
public class WorkspaceSystemSettingsSystemEntities extends GenericModel {

  private Boolean enabled;

  /**
   * Gets the enabled.
   *
   * Whether the new system entities are enabled for the workspace.
   *
   * New system entities are a beta feature.
   *
   * @return the enabled
   */
  public Boolean isEnabled() {
    return enabled;
  }

  /**
   * Sets the enabled.
   *
   * @param enabled the new enabled
   */
  public void setEnabled(final Boolean enabled) {
    this.enabled = enabled;
  }
}
