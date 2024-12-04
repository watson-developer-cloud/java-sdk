/*
 * (C) Copyright IBM Corp. 2020, 2024.
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
import java.util.Map;

/** Routing or other contextual information to be used by target service desk systems. */
public class DialogNodeOutputConnectToAgentTransferInfo extends GenericModel {

  protected Map<String, Map<String, Object>> target;

  /** Builder. */
  public static class Builder {
    private Map<String, Map<String, Object>> target;

    /**
     * Instantiates a new Builder from an existing DialogNodeOutputConnectToAgentTransferInfo
     * instance.
     *
     * @param dialogNodeOutputConnectToAgentTransferInfo the instance to initialize the Builder with
     */
    private Builder(
        DialogNodeOutputConnectToAgentTransferInfo dialogNodeOutputConnectToAgentTransferInfo) {
      this.target = dialogNodeOutputConnectToAgentTransferInfo.target;
    }

    /** Instantiates a new builder. */
    public Builder() {}

    /**
     * Builds a DialogNodeOutputConnectToAgentTransferInfo.
     *
     * @return the new DialogNodeOutputConnectToAgentTransferInfo instance
     */
    public DialogNodeOutputConnectToAgentTransferInfo build() {
      return new DialogNodeOutputConnectToAgentTransferInfo(this);
    }

    /**
     * Set the target.
     *
     * @param target the target
     * @return the DialogNodeOutputConnectToAgentTransferInfo builder
     */
    public Builder target(Map<String, Map<String, Object>> target) {
      this.target = target;
      return this;
    }
  }

  protected DialogNodeOutputConnectToAgentTransferInfo() {}

  protected DialogNodeOutputConnectToAgentTransferInfo(Builder builder) {
    target = builder.target;
  }

  /**
   * New builder.
   *
   * @return a DialogNodeOutputConnectToAgentTransferInfo builder
   */
  public Builder newBuilder() {
    return new Builder(this);
  }

  /**
   * Gets the target.
   *
   * @return the target
   */
  public Map<String, Map<String, Object>> target() {
    return target;
  }
}
