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
 * An object containing properties that indicate how many intents, entities, and dialog nodes are
 * defined in the workspace. This property is included only in responses from the **Export workspace
 * asynchronously** method, and only when the **verbose** query parameter is set to `true`.
 */
public class WorkspaceCounts extends GenericModel {

  protected Long intent;
  protected Long entity;
  protected Long node;

  protected WorkspaceCounts() {}

  /**
   * Gets the intent.
   *
   * <p>The number of intents defined in the workspace.
   *
   * @return the intent
   */
  public Long getIntent() {
    return intent;
  }

  /**
   * Gets the entity.
   *
   * <p>The number of entities defined in the workspace.
   *
   * @return the entity
   */
  public Long getEntity() {
    return entity;
  }

  /**
   * Gets the node.
   *
   * <p>The number of nodes defined in the workspace.
   *
   * @return the node
   */
  public Long getNode() {
    return node;
  }
}
