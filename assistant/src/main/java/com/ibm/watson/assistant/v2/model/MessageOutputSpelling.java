/*
 * (C) Copyright IBM Corp. 2020, 2023.
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

/** Properties describing any spelling corrections in the user input that was received. */
public class MessageOutputSpelling extends GenericModel {

  protected String text;

  @SerializedName("original_text")
  protected String originalText;

  @SerializedName("suggested_text")
  protected String suggestedText;

  protected MessageOutputSpelling() {}

  /**
   * Gets the text.
   *
   * <p>The user input text that was used to generate the response. If spelling autocorrection is
   * enabled, this text reflects any spelling corrections that were applied.
   *
   * @return the text
   */
  public String getText() {
    return text;
  }

  /**
   * Gets the originalText.
   *
   * <p>The original user input text. This property is returned only if autocorrection is enabled
   * and the user input was corrected.
   *
   * @return the originalText
   */
  public String getOriginalText() {
    return originalText;
  }

  /**
   * Gets the suggestedText.
   *
   * <p>Any suggested corrections of the input text. This property is returned only if spelling
   * correction is enabled and autocorrection is disabled.
   *
   * @return the suggestedText
   */
  public String getSuggestedText() {
    return suggestedText;
  }
}
