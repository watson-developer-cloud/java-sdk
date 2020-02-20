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
package com.ibm.watson.visual_recognition.v4.model;

import com.ibm.cloud.sdk.core.service.model.GenericModel;

/**
 * Details about the specific area of the problem.
 */
public class ErrorTarget extends GenericModel {

  /**
   * The parameter or property that is the focus of the problem.
   */
  public interface Type {
    /** field. */
    String FIELD = "field";
    /** parameter. */
    String PARAMETER = "parameter";
    /** header. */
    String HEADER = "header";
  }

  protected String type;
  protected String name;

  /**
   * Gets the type.
   *
   * The parameter or property that is the focus of the problem.
   *
   * @return the type
   */
  public String getType() {
    return type;
  }

  /**
   * Gets the name.
   *
   * The property that is identified with the problem.
   *
   * @return the name
   */
  public String getName() {
    return name;
  }
}
