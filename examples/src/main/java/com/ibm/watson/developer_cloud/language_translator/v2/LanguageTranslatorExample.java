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
package com.ibm.watson.developer_cloud.language_translator_v2_example;

import com.ibm.watson.developer_cloud.language_translator.v2.LanguageTranslator;
import com.ibm.watson.developer_cloud.language_translator.v2.model.TranslateOptions;
import com.ibm.watson.developer_cloud.language_translator.v2.model.TranslationResult;
import com.ibm.watson.developer_cloud.language_translator.v2.util.Language;

/**
 * Example of how to translate a sentence from English to Spanish.
 */
public class LanguageTranslatorExample {

  public static void main(String[] args) {
    LanguageTranslator service = new LanguageTranslator();
    service.setUsernameAndPassword("<username>", "<password>");

    TranslateOptions translateOptions = new TranslateOptions.Builder()
        .addText("hello").source(Language.ENGLISH).target(Language.SPANISH).build();
    TranslationResult translationResult = service.translate(translateOptions).execute();

    System.out.println(translationResult);
  }

}
