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

import com.google.gson.annotations.SerializedName;
import com.ibm.cloud.sdk.core.service.model.GenericModel;

/** The search skill orchestration settings for the environment. */
public class BaseEnvironmentOrchestration extends GenericModel {

  @SerializedName("search_skill_fallback")
  protected Boolean searchSkillFallback;

  protected BaseEnvironmentOrchestration() {}

  /**
   * Gets the searchSkillFallback.
   *
   * <p>Whether to fall back to a search skill when responding to messages that do not match any
   * intent or action defined in dialog or action skills. (If no search skill is configured for the
   * environment, this property is ignored.).
   *
   * @return the searchSkillFallback
   */
  public Boolean isSearchSkillFallback() {
    return searchSkillFallback;
  }
}
