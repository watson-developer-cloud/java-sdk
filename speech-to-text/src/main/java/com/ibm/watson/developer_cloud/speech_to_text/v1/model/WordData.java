/*
 * Copyright 2015 IBM Corp. All Rights Reserved.
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

/**
 * Represents a {@link Word} with error and source.
 */
public class WordData extends Word {

  private String error;
  private List<String> source;

  /**
   * Gets the error. If the service discovered a problem with the custom word's definition.
   *
   * @return The error
   */
  public String getError() {
    return error;
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
   * Sets the error.
   *
   * @param error The error
   */
  public void setError(String error) {
    this.error = error;
  }

  /**
   * Sets the array of sources that describes how the word was added to the custom model's words resource.
   *
   * @param source The source
   */
  public void setSource(List<String> source) {
    this.source = source;
  }

}
