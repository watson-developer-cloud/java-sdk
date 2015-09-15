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
 * Structure that is used to store a collection of documents which can then be passed to a Job for processing.
 *
 * @see DocumentConversion
 */
public class Batch extends GenericModel {

    /** The id of the batch. */
    @Expose
    private String id;

    /** Name of the batch. */
    @Expose
    private String name;

    /** The date on which batch was created on. */
    @SerializedName("created_on")
    private Date createdOn;

    /** The date on which batch was updated on. */
    @SerializedName("updated_on")
    private Date updatedOn;


    /** Properties of the batch. */
    @Expose
    private List<Property> properties;

    /** Link to the batch. */
    @Expose
    private List<Link> links;


    /**
     * Returns the id of the batch.
     *
     * @return the id
     */
    public String getId() { return id; }

    /**
     * Sets the id for the batch.
     *
     * @param id the new id
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * Returns the name of the batch.
     *
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the name of the batch.
     *
     * @param name the new name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Returns the date on which the batch was created on.
     *
     * @return the created on
     */
    public Date getCreatedOn() {
        return createdOn;
    }

    /**
     * Sets the date on which the batch was created on.
     *
     * @param createdOn the new created on
     */
    public void setCreatedOn(Date createdOn) {
        this.createdOn = createdOn;
    }

    /**
     * Returns the date on which the batch was updated on.
     *
     * @return the updated on
     */
    public Date getUpdatedOn() {
        return updatedOn;
    }

    /**
     * Sets the date on which batch was updated on.
     *
     * @param updatedOn the new updated on
     */
    public void setUpdatedOn(Date updatedOn) {
        this.updatedOn = updatedOn;
    }

    /**
     * Returns the properties of the batch.
     *
     * @return the properties
     */
    public List<Property> getProperties() {
        return properties;
    }

    /**
     * Sets the properties for the batch.
     *
     * @param properties the new properties
     */
    public void setProperties(List<Property> properties) {
        this.properties = properties;
    }

    /**
     * Returns the links to the batch.
     *
     * @return the links
     */
    public List<Link> getLinks() {
        return links;
    }

    /**
     * Sets the links to the batch.
     *
     * @param links the new links
     */
    public void setLinks(List<Link> links) {
        this.links = links;
    }
}
