
/*
 * *
 *  * Copyright 2015 IBM Corp. All Rights Reserved.
 *  *
 *  * Licensed under the Apache License, Version 2.0 (the "License");
 *  * you may not use this file except in compliance with the License.
 *  * You may obtain a copy of the License at
 *  *
 *  *      http://www.apache.org/licenses/LICENSE-2.0
 *  *
 *  * Unless required by applicable law or agreed to in writing, software
 *  * distributed under the License is distributed on an "AS IS" BASIS,
 *  * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  * See the License for the specific language governing permissions and
 *  * limitations under the License.
 *
 */

package com.ibm.watson.developer_cloud.concept_insights.v2.model;

import com.google.gson.annotations.SerializedName;
import com.ibm.watson.developer_cloud.concept_insights.v2.ConceptInsights;

import java.util.ArrayList;
import java.util.List;

/**
 * Document returned by the {@link ConceptInsights} service.
 *
 * @author Nizar Alseddeg (nmalsedd@us.ibm.com)
 */

public class Document {

    private String id;

    private String label;

    @SerializedName("last_modified")
    private String lastModified;

    private List<Part> parts = new ArrayList<Part>();

    /**
     * 
     * @return
     *     The id
     */
    public String getId() {
        return id;
    }

    /**
     * 
     * @param id
     *     The id
     */
    public void setId(String id) {
        this.id = id;
    }

    public Document withId(String id) {
        this.id = id;
        return this;
    }

    /**
     * 
     * @return
     *     The label
     */
    public String getLabel() {
        return label;
    }

    /**
     * 
     * @param label
     *     The label
     */
    public void setLabel(String label) {
        this.label = label;
    }

    public Document withLabel(String label) {
        this.label = label;
        return this;
    }

    /**
     * 
     * @return
     *     The lastModified
     */
    public String getLastModified() {
        return lastModified;
    }

    /**
     * 
     * @param lastModified
     *     The last_modified
     */
    public void setLastModified(String lastModified) {
        this.lastModified = lastModified;
    }

    public Document withLastModified(String lastModified) {
        this.lastModified = lastModified;
        return this;
    }

    /**
     * 
     * @return
     *     The parts
     */
    public List<Part> getParts() {
        return parts;
    }

    /**
     * 
     * @param parts
     *     The parts
     */
    public void setParts(List<Part> parts) {
        this.parts = parts;
    }

    public Document withParts(List<Part> parts) {
        this.parts = parts;
        return this;
    }

}
