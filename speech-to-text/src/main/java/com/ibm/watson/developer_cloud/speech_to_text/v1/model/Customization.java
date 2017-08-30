/*
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

package com.ibm.watson.developer_cloud.speech_to_text.v1.model;

import java.util.Date;

import com.google.gson.annotations.SerializedName;
import com.ibm.watson.developer_cloud.service.model.GenericModel;

/**
 * Information about a customization language model.
 */
public class Customization extends GenericModel {

  /**
   * The type of words from the custom model's words resource on which to train the model:
   * <ul>
   * <li>ALL (the default): trains the model on all new words, regardless of whether they were extracted from corpora or
   * were added or modified by the user.</li>
   * <li>USER: trains the model only on new words that were added or modified by the user; the model is not trained on
   * new words extracted from corpora.</li>
   * </ul>
   */
  public enum WordTypeToAdd {
    /** The corpora and user words. */
    ALL,
    /** The user words. */
    USER
  }

  /**
   * Customization Status.
   */
  public enum Status {

    /** The pending. */
    @SerializedName("pending") PENDING,

    /** The ready. */
    @SerializedName("ready") READY,

    /** The training. */
    @SerializedName("training") TRAINING,

    /** The failed. */
    @SerializedName("failed") FAILED,

    /** The available. */
    @SerializedName("available") AVAILABLE
  }

  @SerializedName("customization_id")
  private String id;

  private Date created;

  private String language;

  private String owner;

  private String name;

  private String description;

  @SerializedName("base_model_name")
  private String baseModelName;

  private Status status;

  private Integer progress;

  private String warnings;

  private String dialect;

  /**
   * Gets the customization id.
   *
   * @return The customizationId
   */
  public String getId() {
    return id;
  }

  /**
   * Gets the dialect of the language that is to be used with the custom model.
   *
   * @return the dialect
   */
  public String getDialect() {
    return dialect;
  }

  /**
   * Sets the dialect of the language that is to be used with the custom model.
   *
   * @param dialect the new dialect
   */
  public void setDialect(String dialect) {
    this.dialect = dialect;
  }

  /**
   * Sets the customization id.
   *
   * @param id The customization id
   */
  public void setId(String id) {
    this.id = id;
  }

  /**
   * Gets the created.
   *
   * @return The created
   */
  public Date getCreated() {
    return created;
  }

  /**
   * Sets the created.
   *
   * @param created The created
   */
  public void setCreated(Date created) {
    this.created = created;
  }

  /**
   * Gets the language.
   *
   * @return The language
   */
  public String getLanguage() {
    return language;
  }

  /**
   * Sets the language.
   *
   * @param language The language
   */
  public void setLanguage(String language) {
    this.language = language;
  }

  /**
   * Gets the owner.
   *
   * @return The owner
   */
  public String getOwner() {
    return owner;
  }

  /**
   * Sets the owner.
   *
   * @param owner The owner
   */
  public void setOwner(String owner) {
    this.owner = owner;
  }

  /**
   * Gets the name.
   *
   * @return The name
   */
  public String getName() {
    return name;
  }

  /**
   * Sets the name.
   *
   * @param name The name
   */
  public void setName(String name) {
    this.name = name;
  }

  /**
   * Gets the description.
   *
   * @return The description
   */
  public String getDescription() {
    return description;
  }

  /**
   * Sets the description.
   *
   * @param description The description
   */
  public void setDescription(String description) {
    this.description = description;
  }

  /**
   * Gets the base model name.
   *
   * @return The baseModelName
   */
  public String getBaseModelName() {
    return baseModelName;
  }

  /**
   * Sets the base model name.
   *
   * @param baseModelName The base_model_name
   */
  public void setBaseModelName(String baseModelName) {
    this.baseModelName = baseModelName;
  }

  /**
   * Gets the status.
   *
   * @return The status
   */
  public Status getStatus() {
    return status;
  }

  /**
   * Sets the status.
   *
   * @param status The status
   */
  public void setStatus(Status status) {
    this.status = status;
  }

  /**
   * Gets the progress.
   *
   * @return The progress
   */
  public Integer getProgress() {
    return progress;
  }

  /**
   * Sets the progress.
   *
   * @param progress The progress
   */
  public void setProgress(Integer progress) {
    this.progress = progress;
  }

  /**
   * Gets the warnings.
   *
   * @return The warnings
   */
  public String getWarnings() {
    return warnings;
  }

  /**
   * Sets the warnings.
   *
   * @param warnings The warnings
   */
  public void setWarnings(String warnings) {
    this.warnings = warnings;
  }

}
