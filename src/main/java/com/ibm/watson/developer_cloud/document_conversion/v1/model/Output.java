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
 * Structure that stores information about the output generated
 * from a source document that was converted in the service.
 *
 * @see DocumentConversion
 */
public class Output extends GenericModel {

    /** The id of the output. */
    @Expose
    private String id;
    
    /** The id of the job which generated the output. */
    @SerializedName("job_id")
    private String jobId;

    /** The id of the source document that was used to generated this output. */
    @SerializedName("source_document_id")
    private String sourceDocumentId;
    
    /** The date and time the job was created in ISO 8601 date and time format (YYYY-MM-DDTHH:MM:SSZ). */
    @SerializedName("created_on")
    private Date createdOn;
    
    /** The Internet media type of the output. */
    @SerializedName("media_type")
    private String mediaType;
    
    /** A self link to the output itself. */
    @Expose
    private List<Link> links;

    /**
     * Returns the id of the output.
     *
     * @return the id
     */
    public String getId() {
        return id;
    }

    /**
     * Sets the id of the output.
     *
     * @param id the new id
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * Returns the id of the job which generated the output.
     *
     * @return the job id
     */
    public String getJobId() {
        return jobId;
    }

    /**
     * Sets the id of the job which generated the output.
     *
     * @param jobId the new job id
     */
    public void setJobId(String jobId) {
        this.jobId = jobId;
    }

    /**
     * Returns the source document for the output.
     *
     * @return the source document id
     */
    public String getSourceDocumentId() {
        return sourceDocumentId;
    }

    /**
     * Sets the source document for the output.
     *
     * @param sourceDocumentId the new source document id
     */
    public void setSourceDocumentId(String sourceDocumentId) {
        this.sourceDocumentId = sourceDocumentId;
    }

    /**
     * Returns the date on which the output was created on.
     *
     * @return the created on
     */
    public Date getCreatedOn() {
        return createdOn;
    }

    /**
     * Sets the date on which the output was created on.
     *
     * @param createdOn the new created on
     */
    public void setCreatedOn(Date createdOn) {
        this.createdOn = createdOn;
    }

    /**
     * Returns the media type for the output jobs.
     *
     * @return the media type
     */
    public String getMediaType() {
        return mediaType;
    }

    /**
     * Sets the media type for the output jobs.
     *
     * @param mediaType the new media type
     */
    public void setMediaType(String mediaType) {
        this.mediaType = mediaType;
    }

    /**
     * Returns the links to the outputs in the collection.
     *
     * @return the links
     */
    public List<Link> getLinks() {
        return links;
    }

    /**
     * Sets the links to the outputs in the collection.
     *
     * @param links the new links
     */
    public void setLinks(List<Link> links) {
        this.links = links;
    }
}
