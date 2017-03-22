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

package com.ibm.watson.developer_cloud.discovery.v1.model.collection.field;

import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import com.ibm.watson.developer_cloud.discovery.v1.model.collection.CollectionManager;
import com.ibm.watson.developer_cloud.service.model.GenericModel;

/**
 * Field contains name and type of an indexed field.
 */
@JsonAdapter(FieldAdapterFactory.class)
public class Field extends GenericModel {
    @SerializedName(CollectionManager.FIELD)
    private String field;
    @SerializedName(CollectionManager.TYPE)
    private Type type;

    public Field(String field, Type type) {
        this.field = field;
        this.type = type;
    }

    public String getField() {
        return field;
    }

    public Type getType() {
        if (type == null) {
            type = Type.UNKNOWN;
        }
        return type;
    }

    public enum Type {
        @SerializedName("nested")NESTED,
        @SerializedName("string")STRING,
        @SerializedName("date")DATE,
        @SerializedName("long")LONG,
        @SerializedName("integer")INTEGER,
        @SerializedName("short")SHORT,
        @SerializedName("byte")BYTE,
        @SerializedName("double")DOUBLE,
        @SerializedName("float")FLOAT,
        @SerializedName("boolean")BOOLEAN,
        @SerializedName("binary")BINARY,
        UNKNOWN
    }
}
