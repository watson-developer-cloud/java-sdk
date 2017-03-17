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

package com.ibm.watson.developer_cloud.discovery.v1.model.configuration;

import com.google.gson.annotations.SerializedName;
import com.ibm.watson.developer_cloud.service.model.GenericModel;

/**
 * Configuration options for a JSON document.
 */
public class NormalizationOperation extends GenericModel {
    @SerializedName(ConfigurationManager.OPERATION)
    private Operation operation;
    @SerializedName(ConfigurationManager.SOURCE_FIELD)
    private String sourceField;
    @SerializedName(ConfigurationManager.DESTINATION_FIELD)
    private String destinationField;

    public Operation getOperation() {
        if (operation == null) {
            operation = Operation.UNKNOWN;
        }
        return operation;
    }

    public enum Operation {
        @SerializedName("copy")COPY,
        @SerializedName("move")MOVE,
        @SerializedName("merge")MERGE,
        @SerializedName("remove")REMOVE,
        @SerializedName("remove_nulls")REMOVE_NULLS,
        UNKNOWN
    }

    public String getSourceField() {
        return sourceField;
    }

    public String getDestinationField() {
        return destinationField;
    }
}
