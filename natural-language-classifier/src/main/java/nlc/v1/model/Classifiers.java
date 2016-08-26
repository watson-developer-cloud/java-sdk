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
package nlc.v1.model;

import nlc.v1.NaturalLanguageClassifier;
import service_core.service.model.GenericModel;

import java.util.List;

/**
 * Classifier used by the {@link NaturalLanguageClassifier} service.
 * 
 */
public class Classifiers extends GenericModel {

  private List<Classifier> classifiers;

  /**
   * Gets the classifiers.
   * 
   * @return the classifiers
   */
  public List<Classifier> getClassifiers() {
    return classifiers;
  }

  /**
   * Sets the classifiers.
   * 
   * @param classifiers the classifiers to set
   */
  public void setClassifiers(List<Classifier> classifiers) {
    this.classifiers = classifiers;
  }

}
