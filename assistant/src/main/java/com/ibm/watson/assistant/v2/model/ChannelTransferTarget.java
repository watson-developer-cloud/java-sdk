/*
 * (C) Copyright IBM Corp. 2021, 2023.
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
 * An object specifying target channels available for the transfer. Each property of this object
 * represents an available transfer target. Currently, the only supported property is **chat**,
 * representing the web chat integration.
 */
public class ChannelTransferTarget extends GenericModel {

  protected ChannelTransferTargetChat chat;

  protected ChannelTransferTarget() {}

  /**
   * Gets the chat.
   *
   * <p>Information for transferring to the web chat integration.
   *
   * @return the chat
   */
  public ChannelTransferTargetChat getChat() {
    return chat;
  }
}
