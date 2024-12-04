/*
 * (C) Copyright IBM Corp. 2024.
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

/** RuntimeResponseGenericRuntimeResponseTypeChannelTransfer. */
public class RuntimeResponseGenericRuntimeResponseTypeChannelTransfer
    extends RuntimeResponseGeneric {

  @SerializedName("transfer_info")
  protected ChannelTransferInfo transferInfo;

  protected RuntimeResponseGenericRuntimeResponseTypeChannelTransfer() {}

  /**
   * Gets the transferInfo.
   *
   * <p>Routing or other contextual information to be used by target service desk systems.
   *
   * @return the transferInfo
   */
  public ChannelTransferInfo transferInfo() {
    return transferInfo;
  }
}
