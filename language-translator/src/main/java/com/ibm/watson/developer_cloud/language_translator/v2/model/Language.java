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
package com.ibm.watson.developer_cloud.language_translator.v2.model;

import com.ibm.watson.developer_cloud.language_translator.v2.LanguageTranslator;

/**
 * The languages available in {@link LanguageTranslator}.
 */
public enum Language {
  /** Afrikaans. */
  AFRIKAANS("af"),

  /** Arabic. */
  ARABIC("ar"),

  /** Azerbaijani. */
  AZERBAIJANI("az"),

  /** Bashkir. */
  BASHKIR("ba"),

  /** Belarusian. */
  BELARUSIAN("be"),

  /** Bulgarian. */
  BULGARIAN("bg"),

  /** Bengali. */
  BENGALI("bn"),

  /** Bosnian. */
  BOSNIAN("bs"),

  /** Czech. */
  CZECH("cs"),

  /** Chuvash. */
  CHUVASH("cv"),

  /** Danish. */
  DANISH("da"),

  /** German. */
  GERMAN("de"),

  /** Greek. */
  GREEK("el"),

  /** English. */
  ENGLISH("en"),

  /** Esperanto. */
  ESPERANTO("eo"),

  /** Spanish. */
  SPANISH("es"),

  /** Estonian. */
  ESTONIAN("et"),

  /** Basque. */
  BASQUE("eu"),

  /** Persian. */
  PERSIAN("fa"),

  /** Finnish. */
  FINNISH("fi"),

  /** French. */
  FRENCH("fr"),

  /** Gujarati. */
  GUJARATI("gu"),

  /** Hebrew. */
  HEBREW("he"),

  /** Hindi. */
  HINDI("hi"),

  /** Haitian. */
  HAITIAN("ht"),

  /** Hungarian. */
  HUNGARIAN("hu"),

  /** Armenian. */
  ARMENIAN("hy"),

  /** Indonesian. */
  INDONESIAN("id"),

  /** Icelandic. */
  ICELANDIC("is"),

  /** Italian. */
  ITALIAN("it"),

  /** Japanese. */
  JAPANESE("ja"),

  /** Georgian. */
  GEORGIAN("ka"),

  /** Kazakh. */
  KAZAKH("kk"),

  /** Central Khmer. */
  CENTRAL_KHMER("km"),

  /** Korean. */
  KOREAN("ko"),

  /** Kurdish. */
  KURDISH("ku"),

  /** Kirghiz. */
  KIRGHIZ("ky"),

  /** Lithuanian. */
  LITHUANIAN("lt"),

  /** Latvian. */
  LATVIAN("lv"),

  /** Malayalam. */
  MALAYALAM("ml"),

  /** Mongolian. */
  MONGOLIAN("mn"),

  /** Norwegian Bokmal. */
  NORWEGIAN_BOKMAL("nb"),

  /** Dutch. */
  DUTCH("nl"),

  /** Norwegian Nynorsk. */
  NORWEGIAN_NYNORSK("nn"),

  /** Panjabi. */
  PANJABI("pa"),

  /** Polish. */
  POLISH("pl"),

  /** Pushto. */
  PUSHTO("ps"),

  /** Portuguese. */
  PORTUGUESE("pt"),

  /** Romanian. */
  ROMANIAN("ro"),

  /** Russian. */
  RUSSIAN("ru"),

  /** Slovakian. */
  SLOVAKIAN("sk"),

  /** Somali. */
  SOMALI("so"),

  /** Albanian. */
  ALBANIAN("sq"),

  /** Swedish. */
  SWEDISH("sv"),

  /** Tamil. */
  TAMIL("ta"),

  /** Telugu. */
  TELUGU("te"),

  /** Turkish. */
  TURKISH("tr"),

  /** Ukrainian. */
  UKRAINIAN("uk"),

  /** Urdu. */
  URDU("ur"),

  /** Vietnamese. */
  VIETNAMESE("vi"),

  /** Chinese. */
  CHINESE("zh"),

  /** Traditional Chinese. */
  TRADITIONAL_CHINESE("zh-TW");

  /** language. */
  String language;

  /**
   * Instantiates a new language.
   *
   * @param language the language
   */
  Language(String language) {
    this.language = language;
  }

  /*
   * (non-Javadoc)
   *
   * @see java.lang.Enum#toString()
   */
  @Override
  public String toString() {
    return language;
  }
}
