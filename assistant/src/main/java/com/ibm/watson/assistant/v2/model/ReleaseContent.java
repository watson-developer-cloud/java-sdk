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
package com.ibm.watson.assistant.v2.model;

import com.ibm.cloud.sdk.core.service.model.GenericModel;
import java.util.List;

/**
 * An object describing the versionable content objects (such as skill snapshots) that are included
 * in the release.
 */
public class ReleaseContent extends GenericModel {

  protected List<ReleaseSkillReference> skills;

  /**
   * Gets the skills.
   *
   * <p>The skill snapshots that are included in the release.
   *
   * @return the skills
   */
  public List<ReleaseSkillReference> getSkills() {
    return skills;
  }
}
