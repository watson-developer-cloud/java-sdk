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

package com.ibm.watson.developer_cloud.discovery.v1.model.environment;

import com.google.gson.annotations.SerializedName;
import com.ibm.watson.developer_cloud.service.model.GenericModel;

/**
 * Request to create an {@link Environment}.
 *
 * A JSON object where you define an environment name and an environment description.
 */
public class CreateEnvironmentRequest extends GenericModel {
    private final String name;
    private final Size size;
    private final String description;

    private CreateEnvironmentRequest(Builder builder) {
        this.name = builder.name;
        this.size = builder.size;
        this.description = builder.description;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public Size getSize() {
        return size;
    }

    public static class Builder {
        private final String name;
        private final Size size;
        private String description;

        public Builder(String name, Size size) {
            this.name = name;
            this.size = size;
        }

        public Builder description(String description) {
            this.description = description;
            return this;
        }

        public CreateEnvironmentRequest build() {
            return new CreateEnvironmentRequest(this);
        }
    }

    public enum Size {
        @SerializedName("0")
        FREE(0),   //free plan
        @SerializedName("1")
        ONE(1),    //standard plan
        @SerializedName("2")
        TWO(2),    //standard plan
        @SerializedName("3")
        THREE(3);  //standard plan

        private final int size;

        Size(int size) {
            this.size = size;
        }

        public int getSize() {
            return size;
        }
    }
}
