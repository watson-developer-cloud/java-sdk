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
package com.ibm.watson.assistant.v2.model;

import com.ibm.cloud.sdk.core.service.model.GenericModel;

/**
 * MessageContext.
 */
public class MessageContext extends GenericModel {

  private MessageContextGlobal global;
  private MessageContextSkills skills;

  /**
   * Gets the global.
   *
   * Information that is shared by all skills used by the Assistant.
   *
   * @return the global
   */
  public MessageContextGlobal getGlobal() {
    return global;
  }

  /**
   * Gets the skills.
   *
   * Information specific to particular skills used by the Assistant.
   *
   * **Note:** Currently, only a single property named `main skill` is supported. This object contains variables that
   * apply to the dialog skill used by the assistant.
   *
   * @return the skills
   */
  public MessageContextSkills getSkills() {
    return skills;
  }

  /**
   * Sets the global.
   *
   * @param global the new global
   */
  public void setGlobal(final MessageContextGlobal global) {
    this.global = global;
  }

  /**
   * Sets the skills.
   *
   * @param skills the new skills
   */
  public void setSkills(final MessageContextSkills skills) {
    this.skills = skills;
  }
}
