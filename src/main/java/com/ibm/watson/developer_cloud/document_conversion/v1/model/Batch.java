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

import java.util.List;

/**
 * Structure to store a collection of documents and execute jobs
 *
 * @see DocumentConversion
 */
public class Batch extends DocumentConversionModel {

    /**
     * The id of the batch
     */
    //@Expose
    private String batchId;

    /**
     * Name of the batch
     */
    //@Expose
    private String name;

    private List<Link> links;

    public String getBatchId() {
        return batchId;
    }

    public void setBatchId(String batchId) {
        this.batchId = batchId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Link> getLinks() {
        return links;
    }

    public void setLinks(List<Link> links) {
        this.links = links;
    }

}
