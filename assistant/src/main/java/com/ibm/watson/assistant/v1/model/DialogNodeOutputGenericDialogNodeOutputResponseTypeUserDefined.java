/*
 * (C) Copyright IBM Corp. 2021, 2024.
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

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/** DialogNodeOutputGenericDialogNodeOutputResponseTypeUserDefined. */
public class DialogNodeOutputGenericDialogNodeOutputResponseTypeUserDefined
    extends DialogNodeOutputGeneric {

  /** Builder. */
  public static class Builder {
    private String responseType;
    private Map<String, Object> userDefined;
    private List<ResponseGenericChannel> channels;

    /**
     * Instantiates a new Builder from an existing
     * DialogNodeOutputGenericDialogNodeOutputResponseTypeUserDefined instance.
     *
     * @param dialogNodeOutputGenericDialogNodeOutputResponseTypeUserDefined the instance to
     *     initialize the Builder with
     */
    public Builder(
        DialogNodeOutputGeneric dialogNodeOutputGenericDialogNodeOutputResponseTypeUserDefined) {
      this.responseType =
          dialogNodeOutputGenericDialogNodeOutputResponseTypeUserDefined.responseType;
      this.userDefined = dialogNodeOutputGenericDialogNodeOutputResponseTypeUserDefined.userDefined;
      this.channels = dialogNodeOutputGenericDialogNodeOutputResponseTypeUserDefined.channels;
    }

    /** Instantiates a new builder. */
    public Builder() {}

    /**
     * Instantiates a new builder with required properties.
     *
     * @param responseType the responseType
     * @param userDefined the userDefined
     */
    public Builder(String responseType, Map<String, Object> userDefined) {
      this.responseType = responseType;
      this.userDefined = userDefined;
    }

    /**
     * Builds a DialogNodeOutputGenericDialogNodeOutputResponseTypeUserDefined.
     *
     * @return the new DialogNodeOutputGenericDialogNodeOutputResponseTypeUserDefined instance
     */
    public DialogNodeOutputGenericDialogNodeOutputResponseTypeUserDefined build() {
      return new DialogNodeOutputGenericDialogNodeOutputResponseTypeUserDefined(this);
    }

    /**
     * Adds a new element to channels.
     *
     * @param channels the new element to be added
     * @return the DialogNodeOutputGenericDialogNodeOutputResponseTypeUserDefined builder
     */
    public Builder addChannels(ResponseGenericChannel channels) {
      com.ibm.cloud.sdk.core.util.Validator.notNull(channels, "channels cannot be null");
      if (this.channels == null) {
        this.channels = new ArrayList<ResponseGenericChannel>();
      }
      this.channels.add(channels);
      return this;
    }

    /**
     * Set the responseType.
     *
     * @param responseType the responseType
     * @return the DialogNodeOutputGenericDialogNodeOutputResponseTypeUserDefined builder
     */
    public Builder responseType(String responseType) {
      this.responseType = responseType;
      return this;
    }

    /**
     * Set the userDefined.
     *
     * @param userDefined the userDefined
     * @return the DialogNodeOutputGenericDialogNodeOutputResponseTypeUserDefined builder
     */
    public Builder userDefined(Map<String, Object> userDefined) {
      this.userDefined = userDefined;
      return this;
    }

    /**
     * Set the channels. Existing channels will be replaced.
     *
     * @param channels the channels
     * @return the DialogNodeOutputGenericDialogNodeOutputResponseTypeUserDefined builder
     */
    public Builder channels(List<ResponseGenericChannel> channels) {
      this.channels = channels;
      return this;
    }
  }

  protected DialogNodeOutputGenericDialogNodeOutputResponseTypeUserDefined() {}

  protected DialogNodeOutputGenericDialogNodeOutputResponseTypeUserDefined(Builder builder) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(
        builder.responseType, "responseType cannot be null");
    com.ibm.cloud.sdk.core.util.Validator.notNull(
        builder.userDefined, "userDefined cannot be null");
    responseType = builder.responseType;
    userDefined = builder.userDefined;
    channels = builder.channels;
  }

  /**
   * New builder.
   *
   * @return a DialogNodeOutputGenericDialogNodeOutputResponseTypeUserDefined builder
   */
  public Builder newBuilder() {
    return new Builder(this);
  }
}
