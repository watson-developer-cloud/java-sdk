/*
 * (C) Copyright IBM Corp. 2017, 2020.
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

import com.ibm.cloud.sdk.core.service.model.GenericModel;

/** The object containing the actions and the objects the actions act upon. */
public class SemanticRolesResult extends GenericModel {

  protected String sentence;
  protected SemanticRolesResultSubject subject;
  protected SemanticRolesResultAction action;
  protected SemanticRolesResultObject object;

  /**
   * Gets the sentence.
   *
   * <p>Sentence from the source that contains the subject, action, and object.
   *
   * @return the sentence
   */
  public String getSentence() {
    return sentence;
  }

  /**
   * Gets the subject.
   *
   * <p>The extracted subject from the sentence.
   *
   * @return the subject
   */
  public SemanticRolesResultSubject getSubject() {
    return subject;
  }

  /**
   * Gets the action.
   *
   * <p>The extracted action from the sentence.
   *
   * @return the action
   */
  public SemanticRolesResultAction getAction() {
    return action;
  }

  /**
   * Gets the object.
   *
   * <p>The extracted object from the sentence.
   *
   * @return the object
   */
  public SemanticRolesResultObject getObject() {
    return object;
  }
}
