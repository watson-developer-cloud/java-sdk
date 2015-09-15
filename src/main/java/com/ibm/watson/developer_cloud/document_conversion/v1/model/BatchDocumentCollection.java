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
 * Structure to store collection list of documents in a Batch.
 *
 * @see DocumentConversion
 */
public class BatchDocumentCollection extends GenericModel {
   
   /** List of documents. */
    @Expose
    List<BatchDocument> documents;

    /** List of links. */
    @Expose
    List<Link> links;

    /**
     * Returns the batch documents in the store.
     *
     * @return the documents
     */
    public List<BatchDocument> getDocuments() {
        return documents;
    }

    /**
     * Sets the batch documents in the store.
     *
     * @param documents the new documents
     */
    public void setDocuments(List<BatchDocument> documents) {
        this.documents = documents;
    }

    /**
     * Returns the link to the batch documents.
     *
     * @return the links
     */
    public List<Link> getLinks() {
        return links;
    }

    /**
     * Sets the links to the batch documents.
     *
     * @param links the new links
     */
    public void setLinks(List<Link> links) {
        this.links = links;
    }
}
