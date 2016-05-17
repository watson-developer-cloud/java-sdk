/*
 * Copyright 2015 IBM Corp. All Rights Reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except
 * in compliance with the License. You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software distributed under the License
 * is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express
 * or implied. See the License for the specific language governing permissions and limitations under
 * the License.
 */

package com.ibm.watson.developer_cloud.alchemy.v1.model;

import com.google.gson.annotations.SerializedName;
import com.ibm.watson.developer_cloud.alchemy.v1.AlchemyLanguage;

/**
 * Recognized entity from {@link AlchemyLanguage#getTypedRelations(java.util.Map)}
 */
public class TypedEntity {

  private String text;
  private String mention;
  private String type;
  @SerializedName("argNum")
  private Integer argumentNumber;
  private String id;

  /**
   * Gets the text.
   *
   * @return The text
   */
  public String getText() {
    return text;
  }

  /**
   * Sets the text.
   *
   * @param text The text
   */
  public void setText(String text) {
    this.text = text;
  }

  /**
   * Gets the mention.
   *
   * @return The mention
   */
  public String getMention() {
    return mention;
  }

  /**
   * Sets the mention.
   *
   * @param mention The mention
   */
  public void setMention(String mention) {
    this.mention = mention;
  }

  /**
   * Gets the type.
   *
   * @return The type
   */
  public String getType() {
    return type;
  }

  /**
   * Sets the type.
   *
   * @param type The type
   */
  public void setType(String type) {
    this.type = type;
  }

  /**
   * Gets the argument number.
   *
   * @return The argument number
   */
  public Integer getArgumentNumber() {
    return argumentNumber;
  }

  /**
   * Sets the argument number.
   *
   * @param argumentNumber the new argument number
   */
  public void setArgumentNumber(Integer argumentNumber) {
    this.argumentNumber = argumentNumber;
  }

  /**
   * Gets the id.
   *
   * @return The id
   */
  public String getId() {
    return id;
  }

  /**
   * Sets the id.
   *
   * @param id The id
   */
  public void setId(String id) {
    this.id = id;
  }

}
