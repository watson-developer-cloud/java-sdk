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
 * Information that is shared by all skills used by the Assistant.
 */
public class MessageContextGlobal extends GenericModel {

  private MessageContextGlobalSystem system;

  /**
   * Gets the system.
   *
   * Built-in system properties that apply to all skills used by the assistant.
   *
   * @return the system
   */
  public MessageContextGlobalSystem getSystem() {
    return system;
  }

  /**
   * Sets the system.
   *
   * @param system the new system
   */
  public void setSystem(final MessageContextGlobalSystem system) {
    this.system = system;
  }
}
