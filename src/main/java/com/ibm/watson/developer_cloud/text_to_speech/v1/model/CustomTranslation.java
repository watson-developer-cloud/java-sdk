/**
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
package com.ibm.watson.developer_cloud.text_to_speech.v1.model;

import com.ibm.watson.developer_cloud.service.model.GenericModel;
import com.ibm.watson.developer_cloud.util.Validator;

/**
 * A customized word translation, assigning a specific pronunciation to a given
 * word. The translation can be either a simple String of the desired
 * pronunciation ({@code "Sunday"} as translation for {@code "Sun."}), an
 * International Phonetic Alphabet (IPA) representation ({@code 
 * <phoneme alphabet="ipa" ph="tɹaɪnˈaɪtɹəglɪsəɹɨn"></phoneme>}), an IBM
 * Symbolic Phonetic Representation (SPR) ({@code 
 * <phoneme alphabet="spr" ph="trYn1YtrxglIsxrXn"></phoneme>}), or a mix of them
 * ({@code try<phoneme alphabet="ipa" ph="nˈaɪtɹəglɪsəɹɨn"></phoneme>})
 * 
 * @see <a href=
 *      "http://www.ibm.com/watson/developercloud/doc/text-to-speech/custom-intro.shtml">
 *      Customization</a>
 *
 */
public class CustomTranslation extends GenericModel {

  private String word;

  private String translation;

  /**
   * Instantiates a new custom translation.
   */
  public CustomTranslation() {
    super();
  }

  /**
   * Creates a new CustomTranslation.
   *
   * @param word          the word
   * @param translation          the custom translation
   */
  public CustomTranslation(String word, String translation) {
    this();
    setWord(word);
    setTranslation(translation);
  }

  /**
   * Returns the original word.
   *
   * @return the word
   */
  public String getWord() {
    return word;
  }

  /**
   * Sets the original word.
   *
   * @param word          the word
   */
  public void setWord(String word) {
    Validator.notEmpty(word, "word must not be empty");
    this.word = word;
  }

  /**
   * Returns the custom translation.
   *
   * @return the translation
   */
  public String getTranslation() {
    return translation;
  }

  /**
   * Sets the custom translation. It can be either a simple String of the
   * desired pronunciation, an International Phonetic Alphabet (IPA)
   * representation an IBM Symbolic Phonetic Representation (SPR), or a mix of
   * them.
   * 
   * Examples:
   * 
   * <ul>
   * <li>{@code sunday}
   * <li>{@code <phoneme alphabet="ipa" ph="tɹaɪnˈaɪtɹəglɪsəɹɨn"></phoneme>}
   * </li>
   * <li>{@code try<phoneme alphabet="ipa" ph="nˈaɪtɹəglɪsəɹɨn"></phoneme>}</li>
   * <li>{@code <phoneme alphabet="spr" ph="trYn1YtrxglIsxrXn"></phoneme>}</li>
   * 
   * @param translation
   *          the translation
   * @see <a href=
   *      "http://www.ibm.com/watson/developercloud/doc/text-to-speech/custom-intro.shtml">
   *      Customization</a>
   */
  public void setTranslation(String translation) {
    this.translation = translation;
  }

}
