/*
 * (C) Copyright IBM Corp. 2019.
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

import java.util.List;
import java.util.Map;

import com.ibm.cloud.sdk.core.service.model.GenericModel;

/**
 * DialogSuggestion.
 */
public class DialogSuggestion extends GenericModel {

  private String label;
  private DialogSuggestionValue value;
  private Map<String, Object> output;

  /**
   * Gets the label.
   *
   * The user-facing label for the disambiguation option. This label is taken from the **user_label** property of the
   * corresponding dialog node.
   *
   * @return the label
   */
  public String getLabel() {
    return label;
  }

  /**
   * Gets the value.
   *
   * An object defining the message input to be sent to the assistant if the user selects the corresponding
   * disambiguation option.
   *
   * @return the value
   */
  public DialogSuggestionValue getValue() {
    return value;
  }

  /**
   * Gets the output.
   *
   * The dialog output that will be returned from the Watson Assistant service if the user selects the corresponding
   * option.
   *
   * @return the output
   */
  public Map<String, Object> getOutput() {
    return output;
  }
}
