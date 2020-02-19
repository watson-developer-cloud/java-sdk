/*
 * (C) Copyright IBM Corp. 2020.
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

import java.util.List;

import com.ibm.cloud.sdk.core.service.model.GenericModel;

/**
 * Information about current asynchronous speech recognition jobs.
 */
public class RecognitionJobs extends GenericModel {

  protected List<RecognitionJob> recognitions;

  /**
   * Gets the recognitions.
   *
   * An array of `RecognitionJob` objects that provides the status for each of the user's current jobs. The array is
   * empty if the user has no current jobs.
   *
   * @return the recognitions
   */
  public List<RecognitionJob> getRecognitions() {
    return recognitions;
  }
}

