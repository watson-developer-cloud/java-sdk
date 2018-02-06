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
package com.ibm.watson.developer_cloud.text_to_speech.v1.model;

import java.util.List;

import com.google.gson.annotations.SerializedName;
import com.ibm.watson.developer_cloud.service.model.GenericModel;

/**
 * VoiceModel.
 */
public class VoiceModel extends GenericModel {

  @SerializedName("customization_id")
  private String customizationId;
  private String name;
  private String language;
  private String owner;
  private String created;
  @SerializedName("last_modified")
  private String lastModified;
  private String description;
  private List<Word> words;

  /**
   * Gets the customizationId.
   *
   * The customization ID (GUID) of the custom voice model. **Note:** When you create a new custom voice model, the
   * service returns only the GUID of the new custom model; it does not return the other fields of this object.
   *
   * @return the customizationId
   */
  public String getCustomizationId() {
    return customizationId;
  }

  /**
   * Gets the name.
   *
   * The name of the custom voice model.
   *
   * @return the name
   */
  public String getName() {
    return name;
  }

  /**
   * Gets the language.
   *
   * The language identifier of the custom voice model (for example, `en-US`).
   *
   * @return the language
   */
  public String getLanguage() {
    return language;
  }

  /**
   * Gets the owner.
   *
   * The GUID of the service credentials for the instance of the service that owns the custom voice model.
   *
   * @return the owner
   */
  public String getOwner() {
    return owner;
  }

  /**
   * Gets the created.
   *
   * The date and time in Coordinated Universal Time (UTC) at which the custom voice model was created. The value is
   * provided in full ISO 8601 format (`YYYY-MM-DDThh:mm:ss.sTZD`).
   *
   * @return the created
   */
  public String getCreated() {
    return created;
  }

  /**
   * Gets the lastModified.
   *
   * The date and time in Coordinated Universal Time (UTC) at which the custom voice model was last modified. Equals
   * `created` when a new voice model is first added but has yet to be updated. The value is provided in full ISO 8601
   * format (`YYYY-MM-DDThh:mm:ss.sTZD`).
   *
   * @return the lastModified
   */
  public String getLastModified() {
    return lastModified;
  }

  /**
   * Gets the description.
   *
   * The description of the custom voice model.
   *
   * @return the description
   */
  public String getDescription() {
    return description;
  }

  /**
   * Gets the words.
   *
   * An array of words and their translations from the custom voice model. The words are listed in alphabetical order,
   * with uppercase letters listed before lowercase letters. The array is empty if the custom model contains no words.
   * **Note:** This field is returned only when you list information about a specific custom voice model.
   *
   * @return the words
   */
  public List<Word> getWords() {
    return words;
  }

  /**
   * Sets the customizationId.
   *
   * @param customizationId the new customizationId
   */
  public void setCustomizationId(final String customizationId) {
    this.customizationId = customizationId;
  }

  /**
   * Sets the name.
   *
   * @param name the new name
   */
  public void setName(final String name) {
    this.name = name;
  }

  /**
   * Sets the language.
   *
   * @param language the new language
   */
  public void setLanguage(final String language) {
    this.language = language;
  }

  /**
   * Sets the owner.
   *
   * @param owner the new owner
   */
  public void setOwner(final String owner) {
    this.owner = owner;
  }

  /**
   * Sets the created.
   *
   * @param created the new created
   */
  public void setCreated(final String created) {
    this.created = created;
  }

  /**
   * Sets the lastModified.
   *
   * @param lastModified the new lastModified
   */
  public void setLastModified(final String lastModified) {
    this.lastModified = lastModified;
  }

  /**
   * Sets the description.
   *
   * @param description the new description
   */
  public void setDescription(final String description) {
    this.description = description;
  }

  /**
   * Sets the words.
   *
   * @param words the new words
   */
  public void setWords(final List<Word> words) {
    this.words = words;
  }
}
