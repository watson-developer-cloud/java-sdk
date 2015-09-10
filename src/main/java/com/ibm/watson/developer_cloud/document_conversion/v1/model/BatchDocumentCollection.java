package com.ibm.watson.developer_cloud.document_conversion.v1.model;

import com.google.gson.annotations.Expose;
import com.ibm.watson.developer_cloud.document_conversion.v1.DocumentConversion;
import com.ibm.watson.developer_cloud.model.GenericModel;

import java.util.List;

/**
 * Structure to store collection list of documents in a Batch
 *
 * @see DocumentConversion
 */
public class BatchDocumentCollection extends GenericModel {
   /**
     * List of documents
     */
    @Expose
    List<BatchDocument> documents;

    /**
     * List of links
     */
    @Expose
    List<Link> links;

    /**
     * Returns the batch documents in the store
     *
     * @return
     */
    public List<BatchDocument> getDocuments() {
        return documents;
    }

    /**
     * Sets the batch documents in the store
     *
     * @param documents
     */
    public void setDocuments(List<BatchDocument> documents) {
        this.documents = documents;
    }

    /**
     * Returns the link to the batch documents
     *
     * @return
     */
    public List<Link> getLinks() {
        return links;
    }

    /**
     * Sets the links to the batch documents
     *
     * @param links
     */
    public void setLinks(List<Link> links) {
        this.links = links;
    }
}
