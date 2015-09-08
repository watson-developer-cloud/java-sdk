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

import java.util.List;

/**
 * Structure to store a collection list of Jobs in the service
 *
 * @see DocumentConversion
 */
public class JobCollection extends DocumentConversionModel {

    /**
     * List of all jobs
     */
    @Expose
    private List<Job> jobs;
    /**
     * Links for paging through the jobs. Includes a "first" link for getting the first
     * page of jobs and a "next" link if there are additional pages of jobs
     */
    @Expose
    private List<Link> links;

    /**
     * Returns the jobs in the collection
     * @return
     */
    public List<Job> getJobs() {
        return jobs;
    }

    /**
     * Sets the jobs in the collection
     * @param jobs
     */
    public void setJobs(List<Job> jobs) {
        this.jobs = jobs;
    }

    /**
     * Returns the links to the jobs in the collection
     *
     * @return
     */
    public List<Link> getLinks() {
        return links;
    }

    /**
     * Sets the links to the jobs in the collection
     *
     * @param links
     */
    public void setLinks(List<Link> links) {
        this.links = links;
    }
}
