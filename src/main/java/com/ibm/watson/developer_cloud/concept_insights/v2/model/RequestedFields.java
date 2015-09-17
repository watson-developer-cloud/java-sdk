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
package com.ibm.watson.developer_cloud.concept_insights.v2.model;

import java.util.HashMap;
import java.util.Map;

import com.ibm.watson.developer_cloud.concept_insights.v2.ConceptInsights;
import com.ibm.watson.developer_cloud.service.model.GenericModel;

/**
 * RequestedFields returned by the {@link ConceptInsights} service.
 */
public class RequestedFields extends GenericModel {

    /** The fields. */
    private Map<String, Object> fields;

    /**
     * Include.
     *
     * @param field the field
     */
    public void include(String field) {
        init();
        fields.put(field, 1);
    }

    /**
     * Exclude.
     *
     * @param field the field
     */
    public void exclude(String field) {
        init();
        fields.put(field, 0);
    }

    /**
     * Initialize the fields map.
     */
    private void init() {
        if (fields == null)
            fields = new HashMap<String, Object>();
    }

    /**
     * Gets the fields.
     *
     * @return the fields
     */
    public Map<String, Object> getFields() {
        return fields;
    }

}
