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

package com.ibm.watson.developer_cloud.tradeoff_analytics.v1.model;

import java.util.HashMap;
import java.util.Map;

import com.google.gson.annotations.SerializedName;
import com.ibm.watson.developer_cloud.service.model.GenericModel;

/**
 * The Class Option.
 */
public class Option extends GenericModel {

  @SerializedName("app_data")
  private Map<String, String> appData;
  @SerializedName("description_html")
  private String descriptionHtml;
  private String key;
  private String name;
  private HashMap<String, Object> values;

  /**
   * Instantiates a new option.
   */
  public Option() {
    super();
  }

  /**
   * Instantiates a new option.
   *
   * @param key the key
   * @param name the name
   */
  public Option(String key, String name) {
    super();
    this.key = key;
    this.name = name;
  }

  /**
   * Instantiates a new option.
   *
   * @param key the key
   * @param name the name
   * @param values the values
   * @param descriptionHtml the description html
   */
  public Option(String key, String name, HashMap<String, Object> values, String descriptionHtml) {
    super();
    this.key = key;
    this.name = name;
    this.values = values;
    this.descriptionHtml = descriptionHtml;
  }

  /**
   * Sets the application data.
   *
   * @param appData the app data
   * @return the option
   */
  public Option appData(HashMap<String, String> appData) {
    this.appData = appData;
    return this;
  }

  /**
   * Sets the HTML description .
   *
   * @param descriptionHtml the HTML description
   * @return the option
   */
  public Option descriptionHtml(String descriptionHtml) {
    this.descriptionHtml = descriptionHtml;
    return this;
  }

  /**
   * Gets the HTML description.
   *
   * @return The HTML description
   */
  public String getDescriptionHtml() {
    return descriptionHtml;
  }

  /**
   * Gets the key.
   *
   * @return The key
   */
  public String getKey() {
    return key;
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
   * Gets the values.
   *
   * @return The values
   */
  public HashMap<String, Object> getValues() {
    return values;
  }

  /**
   * Sets the key.
   *
   * @param key the key
   * @return the option
   */
  public Option key(String key) {
    this.key = key;
    return this;
  }

  /**
   * Sets the name.
   *
   * @param name the name
   * @return the option
   */
  public Option name(String name) {
    this.name = name;
    return this;
  }

  /**
   * Sets the description html.
   *
   * @param descriptionHtml The description_html
   */
  public void setDescriptionHtml(String descriptionHtml) {
    this.descriptionHtml = descriptionHtml;
  }

  /**
   * Sets the key.
   *
   * @param key The key
   */
  public void setKey(String key) {
    this.key = key;
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
   * Sets the values.
   *
   * @param values The values
   */
  public void setValues(HashMap<String, Object> values) {
    this.values = values;
  }

  /**
   * Sets value.
   *
   * @param name the name
   * @param value the value
   * @return the option
   */
  public Option value(String name, Object value) {
    if (values == null) {
      values = new HashMap<String, Object>();
    }

    values.put(name, value);
    return this;
  }

  /**
   * Sets values.
   *
   * @param values the values
   * @return the option
   */
  public Option values(HashMap<String, Object> values) {
    this.values = values;
    return this;
  }

}
