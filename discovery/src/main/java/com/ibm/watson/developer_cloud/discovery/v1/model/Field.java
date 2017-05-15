/*
 * Copyright 2017 IBM Corp. All Rights Reserved.
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
package com.ibm.watson.developer_cloud.discovery.v1.model;

import com.ibm.watson.developer_cloud.service.model.GenericModel;

/**
 * Field.
 */
public class Field extends GenericModel {

  public interface Type {
    /** nested. */
    String NESTED = "nested";
    /** string. */
    String STRING = "string";
    /** date. */
    String DATE = "date";
    /** long. */
    String LONG = "long";
    /** integer. */
    String INTEGER = "integer";
    /** short. */
    String SHORT = "short";
    /** byte. */
    String BYTE = "byte";
    /** double. */
    String DOUBLE = "double";
    /** float. */
    String FLOAT = "float";
    /** boolean. */
    String BOOLEAN = "boolean";
    /** binary. */
    String BINARY = "binary";
  }

  private String field;
  private String type;

  /**
   * Gets the field.
   *
   * @return the field
   */
  public String getField() {
    return field;
  }

  /**
   * Gets the type.
   *
   * @return the type
   */
  public String getType() {
    return type;
  }

  /**
   * Sets the field.
   *
   * @param field the new field
   */
  public void setField(final String field) {
    this.field = field;
  }

  /**
   * Sets the type.
   *
   * @param type the new type
   */
  public void setType(final String type) {
    this.type = type;
  }
}
