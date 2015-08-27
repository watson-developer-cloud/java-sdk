package com.ibm.watson.developer_cloud.document_conversion.v1.model;

import com.google.gson.annotations.Expose;

import java.util.List;

/**
 * Structure to store a document collection
 *
 * @see com.ibm.watson.developer_cloud.document_conversion.v1.DocumentConversion
 */
public class DocumentCollection extends DocumentConversionModel {
    /**
     * List of documents
     */
    @Expose
    List<Document> documents;
    /**
     * List of links
     */
    @Expose
    List<Link> links;

    /**
     * Returns the documents
     *
     * @return
     */
    public List<Document> getDocuments() {
        return documents;
    }

    /**
     * Sets the documents
     *
     * @param documents
     */
    public void setDocuments(List<Document> documents) {
        this.documents = documents;
    }

    /**
     * Returns the links to the documents
     *
     * @return
     */
    public List<Link> getLinks() {
        return links;
    }

    /**
     * Sets the links to the documents
     *
     * @param links
     */
    public void setLinks(List<Link> links) {
        this.links = links;
    }
}
