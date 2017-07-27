/**
 * Copyright 2017 IBM Corp. All Rights Reserved.
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

import java.util.Date;
import java.util.List;

import com.google.gson.annotations.SerializedName;
import com.ibm.watson.developer_cloud.service.model.GenericModel;

/**
 * A customized voice model that allows users to specify custom pronunciations for Waton's Text to Speech API.
 *
 * @see <a href= "http://www.ibm.com/watson/developercloud/doc/text-to-speech/custom-intro.shtml"> Customization</a>
 */
public class CustomVoiceModel extends GenericModel {

  @SerializedName("customization_id")
  private String id;

  private String name;
  private String description;
  private String language;
  private String owner;
  private Date created;

  @SerializedName("last_modified")
  private Date lastModified;

  @SerializedName("words")
  private List<CustomTranslation> customTranslations;

  /**
   * Returns the id.
   *
   * @return the id, or null if the voice model has not been saved yet.
   */
  public String getId() {
    return id;
  }

  /**
   * Sets the id.
   *
   * @param id the id
   */
  public void setId(String id) {
    this.id = id;
  }

  /**
   * Returns the name.
   *
   * @return the name
   */
  public String getName() {
    return name;
  }

  /**
   * Sets the name.
   *
   * @param name the name
   */
  public void setName(String name) {
    this.name = name;
  }

  /**
   * Returns the description.
   *
   * @return the description
   */
  public String getDescription() {
    return description;
  }

  /**
   * Sets the description.
   *
   * @param description the description
   */
  public void setDescription(String description) {
    this.description = description;
  }

  /**
   * Returns the language code (for example, en-us).
   *
   * @return the language code
   */
  public String getLanguage() {
    return language;
  }

  /**
   * Sets the language code (for example, en-us).
   *
   * @param language the language code
   */
  public void setLanguage(String language) {
    this.language = language;
  }

  /**
   * Returns the owner id.
   *
   * @return the owner id
   */
  public String getOwner() {
    return owner;
  }

  /**
   * Returns the creation date.
   *
   * @return the creation date
   */
  public Date getCreated() {
    return created;
  }

  /**
   * Returns the last modification date.
   *
   * @return the last modification date
   */
  public Date getLastModified() {
    return lastModified;
  }

  /**
   * Returns the custom translations for a custom voice model.
   *
   * @return the list of custom translations for the model
   */
  public List<CustomTranslation> getCustomTranslations() {
    return customTranslations;
  }

  /**
   * Sets the custom translations for a custom voice model.
   *
   * @param customTranslations the list of custom translations for the model
   */
  public void setCustomTranslations(List<CustomTranslation> customTranslations) {
    this.customTranslations = customTranslations;
  }

}
