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

import java.util.List;

/**
 * Structure to store a Job
 *
 * @see com.ibm.watson.developer_cloud.document_conversion.v1.DocumentConversion
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
    @Expose
    private String batch_id;
    /**
     * The conversion target that the job will execute
     * @see com.ibm.watson.developer_cloud.document_conversion.v1.model.ConversionTarget
     */
    @Expose
    private ConversionTarget conversion_target;
    /**
     * The configuration used for the job
     */
    @Expose
    private JsonObject configuration;
    /**
     * The date and time the job was created in ISO 8601 date and time format (YYYY-MM-DDTHH:MM:SSZ)
     */
    @Expose
    private String created_on;
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
    @Expose
    private JsonObject document_counts;
    /**
     * Additional links for the job that includes a self link to the Job itself,
     * a link to the job output and a link to the job logs
     */
    @Expose
    private List<Link> links;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBatch_id() {
        return batch_id;
    }

    public void setBatch_id(String batch_id) {
        this.batch_id = batch_id;
    }

    public ConversionTarget getConversion_target() {
        return conversion_target;
    }

    public void setConversion_target(ConversionTarget conversion_target) {
        this.conversion_target = conversion_target;
    }

    public JsonObject getConfiguration() {
        return configuration;
    }

    public void setConfiguration(JsonObject configuration) {
        this.configuration = configuration;
    }

    public String getCreated_on() {
        return created_on;
    }

    public void setCreated_on(String created_on) {
        this.created_on = created_on;
    }

    public JobStatus getStatus() {
        return status;
    }

    public void setStatus(JobStatus status) {
        this.status = status;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public JsonObject getDocument_counts() {
        return document_counts;
    }

    public void setDocument_counts(JsonObject document_counts) {
        this.document_counts = document_counts;
    }

    public List<Link> getLinks() {
        return links;
    }

    public void setLinks(List<Link> links) {
        this.links = links;
    }
}
