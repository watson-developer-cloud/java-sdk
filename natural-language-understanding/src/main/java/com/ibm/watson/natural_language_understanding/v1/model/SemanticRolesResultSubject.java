/*
 * (C) Copyright IBM Corp. 2019, 2023.
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
import java.util.List;

/** The extracted subject from the sentence. */
public class SemanticRolesResultSubject extends GenericModel {

  protected String text;
  protected List<SemanticRolesEntity> entities;
  protected List<SemanticRolesKeyword> keywords;

  protected SemanticRolesResultSubject() {}

  /**
   * Gets the text.
   *
   * <p>Text that corresponds to the subject role.
   *
   * @return the text
   */
  public String getText() {
    return text;
  }

  /**
   * Gets the entities.
   *
   * <p>An array of extracted entities.
   *
   * @return the entities
   */
  public List<SemanticRolesEntity> getEntities() {
    return entities;
  }

  /**
   * Gets the keywords.
   *
   * <p>An array of extracted keywords.
   *
   * @return the keywords
   */
  public List<SemanticRolesKeyword> getKeywords() {
    return keywords;
  }
}
