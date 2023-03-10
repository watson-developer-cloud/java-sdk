/*
 * (C) Copyright IBM Corp. 2023.
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

/** An entity that corresponds with an argument in a relation. */
public class RelationEntity extends GenericModel {

  protected String text;
  protected String type;

  protected RelationEntity() {}

  /**
   * Gets the text.
   *
   * <p>Text that corresponds to the entity.
   *
   * @return the text
   */
  public String getText() {
    return text;
  }

  /**
   * Gets the type.
   *
   * <p>Entity type.
   *
   * @return the type
   */
  public String getType() {
    return type;
  }
}
