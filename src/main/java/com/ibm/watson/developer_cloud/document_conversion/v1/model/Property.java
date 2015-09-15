/**
 * Copyright 2015 IBM Corp. All Rights Reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.ibm.watson.developer_cloud.document_conversion.v1.model;


import com.google.gson.annotations.Expose;
import com.ibm.watson.developer_cloud.document_conversion.v1.DocumentConversion;
import com.ibm.watson.developer_cloud.service.model.GenericModel;

/**
 * Structure that holds custom properties that are added for a Batch.
 *
 * @see DocumentConversion
 */
public class Property extends GenericModel {
    
    /** The name of the property. */
    @Expose
    String name;

    /** The value of the property. */
    @Expose
    String value;

    /**
     * Constructor to create a property.
     *
     * @param name the name
     * @param value the value
     */
    public Property(String name, String value) {
        this.name = name;
        this.value = value;
    }

    /**
     * Returns the name of property.
     *
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the name of the property.
     *
     * @param name the new name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Returns the value of the property.
     *
     * @return the value
     */
    public String getValue() {
        return value;
    }

    /**
     * Sets the value of the property.
     *
     * @param value the new value
     */
    public void setValue(String value) {
        this.value = value;
    }
}
