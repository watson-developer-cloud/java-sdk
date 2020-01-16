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
package com.ibm.watson.discovery.v1.model;

import com.ibm.cloud.sdk.core.service.model.GenericModel;

/**
 * Object containing field details.
 */
public class Field extends GenericModel {

  /**
   * The type of the field.
   */
  public interface Type {
    /** nested. */
    String NESTED = "nested";
    /** string. */
    String STRING = "string";
    /** date. */
    String DATE = "date";
    /** long. */
    String X_LONG = "long";
    /** integer. */
    String INTEGER = "integer";
    /** short. */
    String X_SHORT = "short";
    /** byte. */
    String X_BYTE = "byte";
    /** double. */
    String X_DOUBLE = "double";
    /** float. */
    String X_FLOAT = "float";
    /** boolean. */
    String X_BOOLEAN = "boolean";
    /** binary. */
    String BINARY = "binary";
  }

  protected String field;
  protected String type;

  /**
   * Gets the field.
   *
   * The name of the field.
   *
   * @return the field
   */
  public String getField() {
    return field;
  }

  /**
   * Gets the type.
   *
   * The type of the field.
   *
   * @return the type
   */
  public String getType() {
    return type;
  }
}
