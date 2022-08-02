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

import com.google.gson.annotations.SerializedName;
import com.ibm.cloud.sdk.core.service.model.GenericModel;

/** ReleaseSkillReference. */
public class ReleaseSkillReference extends GenericModel {

  /** The type of the skill. */
  public interface Type {
    /** dialog. */
    String DIALOG = "dialog";
    /** action. */
    String ACTION = "action";
    /** search. */
    String SEARCH = "search";
  }

  @SerializedName("skill_id")
  protected String skillId;

  protected String type;
  protected String snapshot;

  /**
   * Gets the skillId.
   *
   * <p>The skill ID of the skill.
   *
   * @return the skillId
   */
  public String getSkillId() {
    return skillId;
  }

  /**
   * Gets the type.
   *
   * <p>The type of the skill.
   *
   * @return the type
   */
  public String getType() {
    return type;
  }

  /**
   * Gets the snapshot.
   *
   * <p>The name of the snapshot (skill version) that is saved as part of the release (for example,
   * `draft` or `1`).
   *
   * @return the snapshot
   */
  public String getSnapshot() {
    return snapshot;
  }
}
