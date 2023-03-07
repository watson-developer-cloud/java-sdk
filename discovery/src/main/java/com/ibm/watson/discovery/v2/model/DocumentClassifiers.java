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
package com.ibm.watson.discovery.v2.model;

import com.ibm.cloud.sdk.core.service.model.GenericModel;
import java.util.List;

/** An object that contains a list of document classifier definitions. */
public class DocumentClassifiers extends GenericModel {

  protected List<DocumentClassifier> classifiers;

  protected DocumentClassifiers() {}

  /**
   * Gets the classifiers.
   *
   * <p>An array of document classifier definitions.
   *
   * @return the classifiers
   */
  public List<DocumentClassifier> getClassifiers() {
    return classifiers;
  }
}
