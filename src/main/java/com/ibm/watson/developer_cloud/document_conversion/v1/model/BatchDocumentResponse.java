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
 * Structure that provides the response when a Document is added to a Batch.
 *
 * @see DocumentConversion
 */
public class BatchDocumentResponse extends GenericModel {
    
    /** The document of the batch. */
    @Expose
    BatchDocument document;

    /**
     * Retrieves the BatchDocument from the response.
     *
     * @return the document
     */
    public BatchDocument getDocument() {
        return document;
    }

    /**
     * Sets the document for Batch document response.
     *
     * @param document the new document
     */
    public void setDocument(BatchDocument document) {
        this.document = document;
    }
}