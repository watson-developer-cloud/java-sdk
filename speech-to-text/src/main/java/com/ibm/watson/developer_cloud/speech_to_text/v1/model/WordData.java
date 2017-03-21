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

import java.util.List;
import java.util.Map;

import com.google.gson.annotations.SerializedName;

/**
 * Represents a {@link Word} with error and source.
 */
public class WordData extends Word {

  private Integer count;
  private List<String> source;

  @SerializedName("error")
  private List<Map<String, String>> errors;

  /**
   * Gets the count for the number of sources from which the word has been added to the model's words resource.
   *
   * @return The count
   */
  public Integer getCount() {
    return count;
  }

  /**
   * Gets the array of sources that describes how the word was added to the custom model's words resource.
   *
   * @return The source
   */
  public List<String> getSource() {
    return source;
  }

  /**
   * Gets the errors if present.
   *
   * @return The errors
   */
  public List<Map<String, String>> getErrors() {
    return errors;
  }

  /**
   * Sets the array of sources that describes how the word was added to the custom model's words resource.
   *
   * @param source The source
   */
  public void setSource(List<String> source) {
    this.source = source;
  }

  /**
   * Sets the count.
   *
   * @param count The count
   */
  public void setCount(Integer count) {
    this.count = count;
  }

  /**
   * Sets the errors if present.
   *
   * @param errors The errors
   */
  public void setErrors(List<Map<String, String>> errors) {
    this.errors = errors;
  }

}
