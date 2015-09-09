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

import com.google.gson.JsonObject;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.ibm.watson.developer_cloud.document_conversion.v1.DocumentConversion;

import java.util.Date;
import java.util.List;

/**
 * Structure that stores information about a Job that was created in the service
 *
 * @see DocumentConversion
 */
public class Job extends DocumentConversionModel {

    /**
     * The id of the job
     */
    @Expose
    private String id;
    /**
     * The name of the job
     */
    @Expose
    private String name;
    /**
     * The id of the batch that this job processes
     */
    @SerializedName("batch_id")
    private String batchId;
    /**
     * The conversion target that the job will execute
     * @see com.ibm.watson.developer_cloud.document_conversion.v1.model.ConversionTarget
     */
    @SerializedName("conversion_target")
    private ConversionTarget conversionTarget;
    /**
     * The configuration used for the job
     */
    @Expose
    private JsonObject configuration;
    /**
     * The date and time the job was created in ISO 8601 date and time format (YYYY-MM-DDTHH:MM:SSZ)
     */
    @SerializedName("created_on")
    private Date createdOn;
    /**
     * The status of the job
     * @see com.ibm.watson.developer_cloud.document_conversion.v1.model.JobStatus
     */
    @Expose
    private JobStatus status;
    /**
     * The result of the job
     */
    @Expose
    private String result;
    /**
     * The duration of the job in ISO-8601 seconds based representation (example: "PT1H6M18.213S")
     */
    @Expose
    private String duration;
    /**
     * The document counts of the job (total, pending, successful, failed)
     */
    @SerializedName("document_counts")
    private JsonObject documentCounts;
    /**
     * Additional links for the job that includes a self link to the Job itself,
     * a link to the job output and a link to the job logs
     */
    @Expose
    private List<Link> links;


    /**
     * Returns the id for the job
     *
     * @return
     */
    public String getId() {
        return id;
    }

    /**
     * Sets the id for the job
     *
     * @param id
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * Sets the name of the job
     *
     * @return
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the name for the job
     *
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Returns the batch id from the job
     *
     * @return
     */
    public String getBatchId() {
        return batchId;
    }

    /**
     * Sets the batch id for the job
     *
     * @param batchId
     */
    public void setBatchId(String batchId) {
        this.batchId = batchId;
    }

    /**
     * Returns the conversion target for the job
     *
     * @return
     */
    public ConversionTarget getConversionTarget() {
        return conversionTarget;
    }

    /**
     * Sets the conversion target for the job
     *
     * @param conversionTarget
     */
    public void setConversionTarget(ConversionTarget conversionTarget) {
        this.conversionTarget = conversionTarget;
    }

    /**
     * Returns the configuration for the job
     *
     * @return
     */
    public JsonObject getConfiguration() {
        return configuration;
    }

    /**
     * Sets the configuration for the job
     *
     * @param configuration
     */
    public void setConfiguration(JsonObject configuration) {
        this.configuration = configuration;
    }

    /**
     * Returns the date on which the job was created on
     *
     * @return
     */
    public Date getCreatedOn() {
        return createdOn;
    }

    /**
     * Sets the date on which the job was created on
     *
     * @param createdOn
     */
    public void setCreatedOn(Date createdOn) {
        this.createdOn = createdOn;
    }

    /**
     * Returns the status of the job
     *
     * @return
     */
    public JobStatus getStatus() {
        return status;
    }

    /**
     * Sets the status of the job
     *
     * @param status
     */
    public void setStatus(JobStatus status) {
        this.status = status;
    }

    /**
     * Returns the result of the job
     *
     * @return
     */
    public String getResult() {
        return result;
    }

    /**
     * Sets the result of the job
     * @param result
     */
    public void setResult(String result) {
        this.result = result;
    }

    /**
     * Returns the duration for the job
     *
     * @return
     */
    public String getDuration() {
        return duration;
    }

    /**
     * Sets the duration of job execution
     *
     * @param duration
     */
    public void setDuration(String duration) {
        this.duration = duration;
    }

    /**
     * Returns number of documents from the job
     *
     * @return
     */
    public JsonObject getDocumentCounts() {
        return documentCounts;
    }

    /**
     * Sets the number of documents in the job
     *
     * @param documentCounts
     */
    public void setDocumentCounts(JsonObject documentCounts) {
        this.documentCounts = documentCounts;
    }

    /**
     * Returns the links to the jobs
     *
     * @return
     */
    public List<Link> getLinks() {
        return links;
    }

    /**
     * Sets the links to the jobs
     *
     * @param links
     */
    public void setLinks(List<Link> links) {
        this.links = links;
    }
}
