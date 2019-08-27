/*
 * (C) Copyright IBM Corp. 2019.
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
 * Field.
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
    String XLONG = "long";
    /** integer. */
    String INTEGER = "integer";
    /** short. */
    String XSHORT = "short";
    /** byte. */
    String XBYTE = "byte";
    /** double. */
    String XDOUBLE = "double";
    /** float. */
    String XFLOAT = "float";
    /** boolean. */
    String XBOOLEAN = "boolean";
    /** binary. */
    String BINARY = "binary";
  }

  private String field;
  private String type;

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
