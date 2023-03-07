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
package com.ibm.watson.text_to_speech.v1.model;

import com.google.gson.annotations.SerializedName;
import com.ibm.cloud.sdk.core.service.model.GenericModel;
import java.util.List;

/** Information about an existing custom model. */
public class CustomModel extends GenericModel {

  @SerializedName("customization_id")
  protected String customizationId;

  protected String name;
  protected String language;
  protected String owner;
  protected String created;

  @SerializedName("last_modified")
  protected String lastModified;

  protected String description;
  protected List<Word> words;
  protected List<Prompt> prompts;

  protected CustomModel() {}

  /**
   * Gets the customizationId.
   *
   * <p>The customization ID (GUID) of the custom model. The [Create a custom
   * model](#createcustommodel) method returns only this field. It does not not return the other
   * fields of this object.
   *
   * @return the customizationId
   */
  public String getCustomizationId() {
    return customizationId;
  }

  /**
   * Gets the name.
   *
   * <p>The name of the custom model.
   *
   * @return the name
   */
  public String getName() {
    return name;
  }

  /**
   * Gets the language.
   *
   * <p>The language identifier of the custom model (for example, `en-US`).
   *
   * @return the language
   */
  public String getLanguage() {
    return language;
  }

  /**
   * Gets the owner.
   *
   * <p>The GUID of the credentials for the instance of the service that owns the custom model.
   *
   * @return the owner
   */
  public String getOwner() {
    return owner;
  }

  /**
   * Gets the created.
   *
   * <p>The date and time in Coordinated Universal Time (UTC) at which the custom model was created.
   * The value is provided in full ISO 8601 format (`YYYY-MM-DDThh:mm:ss.sTZD`).
   *
   * @return the created
   */
  public String getCreated() {
    return created;
  }

  /**
   * Gets the lastModified.
   *
   * <p>The date and time in Coordinated Universal Time (UTC) at which the custom model was last
   * modified. The `created` and `updated` fields are equal when a model is first added but has yet
   * to be updated. The value is provided in full ISO 8601 format (`YYYY-MM-DDThh:mm:ss.sTZD`).
   *
   * @return the lastModified
   */
  public String getLastModified() {
    return lastModified;
  }

  /**
   * Gets the description.
   *
   * <p>The description of the custom model.
   *
   * @return the description
   */
  public String getDescription() {
    return description;
  }

  /**
   * Gets the words.
   *
   * <p>An array of `Word` objects that lists the words and their translations from the custom
   * model. The words are listed in alphabetical order, with uppercase letters listed before
   * lowercase letters. The array is empty if no words are defined for the custom model. This field
   * is returned only by the [Get a custom model](#getcustommodel) method.
   *
   * @return the words
   */
  public List<Word> getWords() {
    return words;
  }

  /**
   * Gets the prompts.
   *
   * <p>An array of `Prompt` objects that provides information about the prompts that are defined
   * for the specified custom model. The array is empty if no prompts are defined for the custom
   * model. This field is returned only by the [Get a custom model](#getcustommodel) method.
   *
   * @return the prompts
   */
  public List<Prompt> getPrompts() {
    return prompts;
  }
}
