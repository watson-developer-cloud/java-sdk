/*
 * (C) Copyright IBM Corp. 2019, 2020.
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
package com.ibm.watson.natural_language_understanding.v1.model;

import com.google.gson.annotations.SerializedName;
import com.ibm.cloud.sdk.core.service.model.GenericModel;
import java.util.List;

/** TokenResult. */
public class TokenResult extends GenericModel {

  /**
   * The part of speech of the token. For descriptions of the values, see [Universal Dependencies
   * POS tags](https://universaldependencies.org/u/pos/).
   */
  public interface PartOfSpeech {
    /** ADJ. */
    String ADJ = "ADJ";
    /** ADP. */
    String ADP = "ADP";
    /** ADV. */
    String ADV = "ADV";
    /** AUX. */
    String AUX = "AUX";
    /** CCONJ. */
    String CCONJ = "CCONJ";
    /** DET. */
    String DET = "DET";
    /** INTJ. */
    String INTJ = "INTJ";
    /** NOUN. */
    String NOUN = "NOUN";
    /** NUM. */
    String NUM = "NUM";
    /** PART. */
    String PART = "PART";
    /** PRON. */
    String PRON = "PRON";
    /** PROPN. */
    String PROPN = "PROPN";
    /** PUNCT. */
    String PUNCT = "PUNCT";
    /** SCONJ. */
    String SCONJ = "SCONJ";
    /** SYM. */
    String SYM = "SYM";
    /** VERB. */
    String VERB = "VERB";
    /** X. */
    String X = "X";
  }

  protected String text;

  @SerializedName("part_of_speech")
  protected String partOfSpeech;

  protected List<Long> location;
  protected String lemma;

  /**
   * Gets the text.
   *
   * <p>The token as it appears in the analyzed text.
   *
   * @return the text
   */
  public String getText() {
    return text;
  }

  /**
   * Gets the partOfSpeech.
   *
   * <p>The part of speech of the token. For descriptions of the values, see [Universal Dependencies
   * POS tags](https://universaldependencies.org/u/pos/).
   *
   * @return the partOfSpeech
   */
  public String getPartOfSpeech() {
    return partOfSpeech;
  }

  /**
   * Gets the location.
   *
   * <p>Character offsets indicating the beginning and end of the token in the analyzed text.
   *
   * @return the location
   */
  public List<Long> getLocation() {
    return location;
  }

  /**
   * Gets the lemma.
   *
   * <p>The [lemma](https://wikipedia.org/wiki/Lemma_%28morphology%29) of the token.
   *
   * @return the lemma
   */
  public String getLemma() {
    return lemma;
  }
}
