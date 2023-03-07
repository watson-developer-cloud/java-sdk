/*
 * (C) Copyright IBM Corp. 2023.
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
 * An object defining the message input to be sent to the assistant if the user selects the
 * corresponding disambiguation option.
 *
 * <p>**Note:** This entire message input object must be included in the request body of the next
 * message sent to the assistant. Do not modify or remove any of the included properties.
 */
public class DialogSuggestionValue extends GenericModel {

  protected MessageInput input;

  protected DialogSuggestionValue() {}

  /**
   * Gets the input.
   *
   * <p>An input object that includes the input text.
   *
   * @return the input
   */
  public MessageInput getInput() {
    return input;
  }
}
