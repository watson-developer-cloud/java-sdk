/*
 * (C) Copyright IBM Corp. 2019, 2020.
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

import com.google.gson.annotations.SerializedName;
import com.google.gson.reflect.TypeToken;
import com.ibm.cloud.sdk.core.service.model.DynamicModel;

/** An input object that includes the input text. */
public class MessageInput extends DynamicModel<Object> {

  @SerializedName("text")
  protected String text;

  @SerializedName("spelling_suggestions")
  protected Boolean spellingSuggestions;

  @SerializedName("spelling_auto_correct")
  protected Boolean spellingAutoCorrect;

  @SerializedName("suggested_text")
  protected String suggestedText;

  @SerializedName("original_text")
  protected String originalText;

  public MessageInput() {
    super(new TypeToken<Object>() {});
  }

  /**
   * Gets the text.
   *
   * <p>The text of the user input. This string cannot contain carriage return, newline, or tab
   * characters.
   *
   * @return the text
   */
  public String getText() {
    return this.text;
  }

  /**
   * Sets the text.
   *
   * @param text the new text
   */
  public void setText(final String text) {
    this.text = text;
  }

  /**
   * Gets the spellingSuggestions.
   *
   * <p>Whether to use spelling correction when processing the input. This property overrides the
   * value of the **spelling_suggestions** property in the workspace settings.
   *
   * @return the spellingSuggestions
   */
  public Boolean isSpellingSuggestions() {
    return this.spellingSuggestions;
  }

  /**
   * Sets the spellingSuggestions.
   *
   * @param spellingSuggestions the new spellingSuggestions
   */
  public void setSpellingSuggestions(final Boolean spellingSuggestions) {
    this.spellingSuggestions = spellingSuggestions;
  }

  /**
   * Gets the spellingAutoCorrect.
   *
   * <p>Whether to use autocorrection when processing the input. If spelling correction is used and
   * this property is `false`, any suggested corrections are returned in the **suggested_text**
   * property of the message response. If this property is `true`, any corrections are automatically
   * applied to the user input, and the original text is returned in the **original_text** property
   * of the message response. This property overrides the value of the **spelling_auto_correct**
   * property in the workspace settings.
   *
   * @return the spellingAutoCorrect
   */
  public Boolean isSpellingAutoCorrect() {
    return this.spellingAutoCorrect;
  }

  /**
   * Sets the spellingAutoCorrect.
   *
   * @param spellingAutoCorrect the new spellingAutoCorrect
   */
  public void setSpellingAutoCorrect(final Boolean spellingAutoCorrect) {
    this.spellingAutoCorrect = spellingAutoCorrect;
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
    return this.suggestedText;
  }

  /**
   * Sets the suggestedText.
   *
   * @param suggestedText the new suggestedText
   */
  public void setSuggestedText(final String suggestedText) {
    this.suggestedText = suggestedText;
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
    return this.originalText;
  }

  /**
   * Sets the originalText.
   *
   * @param originalText the new originalText
   */
  public void setOriginalText(final String originalText) {
    this.originalText = originalText;
  }
}
