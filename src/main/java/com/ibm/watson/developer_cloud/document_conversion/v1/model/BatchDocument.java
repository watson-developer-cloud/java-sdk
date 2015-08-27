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

import java.util.List;

/**
 * Structure to store a batch documents
 *
 * @see com.ibm.watson.developer_cloud.document_conversion.v1.DocumentConversion
 */
public class BatchDocument extends DocumentConversionModel {

    /**
     * The id of the batch document
     */
    @Expose
    private String id;

    /**
     * Date/time at which document is added to the batch
     */
    @Expose
    private String added_to_batch;

    /**
     * Link to the batch documents
     */
    @Expose
    private List<Link> links;

    /**
     * Returns the id to the batch document
     *
     * @return
     */
    public String getId() {
        return id;
    }

    /**
     * Sets the id to the batch document
     * @param id
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * Returns the date/time at which the document was added to the batch
     *
     * @return
     */
    public String getAdded_to_batch() {
        return added_to_batch;
    }

    /**
     * Sets the date/time at which the document was added to the batch
     *
     * @param added_to_batch
     */
    public void setAdded_to_batch(String added_to_batch) {
        this.added_to_batch = added_to_batch;
    }

    /**
     * Returns the link to the batch document
     *
     * @return
     */
    public List<Link> getLinks() {
        return links;
    }

    /**
     * Sets the links to the batch document
     *
     * @param links
     */
    public void setLinks(List<Link> links) {
        this.links = links;
    }
}
