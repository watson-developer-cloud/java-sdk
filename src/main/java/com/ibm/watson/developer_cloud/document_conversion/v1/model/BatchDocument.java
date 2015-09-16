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

import java.util.Date;
import java.util.List;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.ibm.watson.developer_cloud.document_conversion.v1.DocumentConversion;
import com.ibm.watson.developer_cloud.service.model.GenericModel;

/**
 * Structure that stores the metadata of a document that has been added to a Batch.
 *
 * @see DocumentConversion
 */
public class BatchDocument extends GenericModel {

    /** The id of the batch document. */
    @Expose
    private String id;

    /** The date at which document is added to the batch. */
    @SerializedName("added_to_batch")
    private Date addedToBatch;

    /** Link to the batch documents. */
    @Expose
    private List<Link> links;

    /**
     * Returns the id to the batch document.
     *
     * @return the id
     */
    public String getId() {
        return id;
    }

    /**
     * Sets the id to the batch document.
     *
     * @param id the new id
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * Returns the date at which the document was added to the batch.
     *
     * @return the added to batch
     */
    public Date getAddedToBatch() {
        return addedToBatch;
    }

    /**
     * Sets the date at which the document was added to the batch.
     *
     * @param addedToBatch the new added to batch
     */
    public void setAddedToBatch(Date addedToBatch) {
        this.addedToBatch = addedToBatch;
    }

    /**
     * Returns the link to the batch document.
     *
     * @return the links
     */
    public List<Link> getLinks() {
        return links;
    }

    /**
     * Sets the links to the batch document.
     *
     * @param links the new links
     */
    public void setLinks(List<Link> links) {
        this.links = links;
    }
}
