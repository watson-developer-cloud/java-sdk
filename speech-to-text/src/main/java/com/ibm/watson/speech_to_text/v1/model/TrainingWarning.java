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
package com.ibm.watson.speech_to_text.v1.model;

import com.ibm.cloud.sdk.core.service.model.GenericModel;

/**
 * A warning from training of a custom language or custom acoustic model.
 */
public class TrainingWarning extends GenericModel {

  /**
   * An identifier for the type of invalid resources listed in the `description` field.
   */
  public interface Code {
    /** invalid_audio_files. */
    String INVALID_AUDIO_FILES = "invalid_audio_files";
    /** invalid_corpus_files. */
    String INVALID_CORPUS_FILES = "invalid_corpus_files";
    /** invalid_grammar_files. */
    String INVALID_GRAMMAR_FILES = "invalid_grammar_files";
    /** invalid_words. */
    String INVALID_WORDS = "invalid_words";
  }

  protected String code;
  protected String message;

  /**
   * Gets the code.
   *
   * An identifier for the type of invalid resources listed in the `description` field.
   *
   * @return the code
   */
  public String getCode() {
    return code;
  }

  /**
   * Gets the message.
   *
   * A warning message that lists the invalid resources that are excluded from the custom model's training. The message
   * has the following format: `Analysis of the following {resource_type} has not completed successfully:
   * [{resource_names}]. They will be excluded from custom {model_type} model training.`.
   *
   * @return the message
   */
  public String getMessage() {
    return message;
  }
}
