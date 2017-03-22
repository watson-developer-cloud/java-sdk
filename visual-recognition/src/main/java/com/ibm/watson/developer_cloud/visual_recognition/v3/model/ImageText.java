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

package com.ibm.watson.developer_cloud.visual_recognition.v3.model;

import java.util.List;

import com.ibm.watson.developer_cloud.visual_recognition.v3.VisualRecognition;

/**
 * The recognized text in a processed image after calling
 * {@link VisualRecognition#recognizeText(VisualRecognitionOptions)} .
 *
 * @see VisualRecognition
 */
public class ImageText extends ImageProcessed {

  private String text;
  private List<Word> words;

  /**
   * Gets the text.
   *
   * @return the text
   */
  public String getText() {
    return text;
  }

  /**
   * Gets the words.
   *
   * @return the words
   */
  public List<Word> getWords() {
    return words;
  }

  /**
   * Sets the text.
   *
   * @param text the new text
   */
  public void setText(String text) {
    this.text = text;
  }

  /**
   * Sets the words.
   *
   * @param words the new words
   */
  public void setWords(List<Word> words) {
    this.words = words;
  }
}
