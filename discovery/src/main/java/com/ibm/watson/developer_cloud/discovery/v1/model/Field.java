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

import com.google.gson.annotations.SerializedName;
import com.ibm.watson.developer_cloud.service.model.GenericModel;

/**
 * Field.
 */
public class Field extends GenericModel {

  /**
   * The type of the field.
   */
  public interface FieldType {
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

  @SerializedName("field")
  private String fieldName;
  @SerializedName("type")
  private String fieldType;

  /**
   * Gets the fieldName.
   *
   * The name of the field.
   *
   * @return the fieldName
   */
  public String getFieldName() {
    return fieldName;
  }

  /**
   * Gets the fieldType.
   *
   * The type of the field.
   *
   * @return the fieldType
   */
  public String getFieldType() {
    return fieldType;
  }
}
