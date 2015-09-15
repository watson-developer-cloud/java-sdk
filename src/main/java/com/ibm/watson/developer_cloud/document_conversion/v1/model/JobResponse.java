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
 * Structure that provides the response when a Job is created in the service.
 *
 * @see DocumentConversion
 */
public class JobResponse extends GenericModel {
    
    /** The id of the job. */
    @Expose
    private String id;

    /** The name of the job. */
    @Expose
    private String name;

    /** Link to the job. */
    @Expose
    private List<Link> links;

    /**
     * Returns the id of the job.
     *
     * @return id of the job
     */
    public String getId() {
        return id;
    }

    /**
     * Sets the id for the job.
     *
     * @param id for the job
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * Returns the name of the job.
     *
     * @return name of the job
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the name of the job.
     *
     * @param name of the job
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Returns the links to the job.
     *
     * @return list of links
     */
    public List<Link> getLinks() {
        return links;
    }

    /**
     * Sets the links for the jobs.
     *
     * @param links the new links
     */
    public void setLinks(List<Link> links) {
        this.links = links;
    }
}
