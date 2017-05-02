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

  public enum Type {

    /** nested. */
    @SerializedName("nested") NESTED,

    /** string. */
    @SerializedName("string") STRING,

    /** date. */
    @SerializedName("date") DATE,

    /** long. */
    @SerializedName("long") LONG,

    /** integer. */
    @SerializedName("integer") INTEGER,

    /** short. */
    @SerializedName("short") SHORT,

    /** byte. */
    @SerializedName("byte") BYTE,

    /** double. */
    @SerializedName("double") DOUBLE,

    /** float. */
    @SerializedName("float") FLOAT,

    /** boolean. */
    @SerializedName("boolean") BOOLEAN,

    /** binary. */
    @SerializedName("binary") BINARY
  }

  private String field;
  private Type type;

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
  public Type getType() {
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
  public void setType(final Type type) {
    this.type = type;
  }
}
