/*
 * (C) Copyright IBM Corp. 2023, 2024.
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

import com.ibm.cloud.sdk.core.service.model.GenericModel;

/** An object describing the release that is currently deployed in the environment. */
public class BaseEnvironmentReleaseReference extends GenericModel {

  protected String release;

  protected BaseEnvironmentReleaseReference() {}

  /**
   * Gets the release.
   *
   * <p>The name of the deployed release.
   *
   * @return the release
   */
  public String getRelease() {
    return release;
  }
}
