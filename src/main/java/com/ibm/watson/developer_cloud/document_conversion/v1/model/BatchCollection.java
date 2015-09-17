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

import java.util.List;

import com.google.gson.annotations.Expose;
import com.ibm.watson.developer_cloud.document_conversion.v1.DocumentConversion;
import com.ibm.watson.developer_cloud.service.model.GenericModel;

/**
 * Structure to store a collection list of batches.
 *
 * @see DocumentConversion
 */
public class BatchCollection extends GenericModel {
    
    /** List of batches. */
    @Expose
    List<Batch> batches;
    
    /** 1 List of links. */
    @Expose
    List<Link> links;

    /**
     * Returns the batches in the store.
     *
     * @return the batches
     */
    public List<Batch> getBatches() {
        return batches;
    }

    /**
     * Sets the batches in the store.
     *
     * @param batches the new batches
     */
    public void setBatches(List<Batch> batches) {
        this.batches = batches;
    }

    /**
     * Returns the links to the batches.
     *
     * @return the links
     */
    public List<Link> getLinks() {
        return links;
    }

    /**
     * Sets the links to the batches.
     *
     * @param links the new links
     */
    public void setLinks(List<Link> links) {
        this.links = links;
    }
}