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
import com.google.gson.annotations.SerializedName;
import com.ibm.watson.developer_cloud.document_conversion.v1.DocumentConversion;
import com.ibm.watson.developer_cloud.service.model.GenericModel;

/**
 * Structure to store a Document that was uploaded to the service.
 *
 * @see DocumentConversion
 */
public class Document extends GenericModel {
    
    /** The id of the document. */
    @Expose
    private String id;

    /** Name of the document. */
    @Expose
    private String name;

    /** Mediatype of the document. */
    @SerializedName("media_type")
    String mediaType;

    /** Link to the documents. */
    @Expose
    private List<Link> links;

    /**
     * Returns the id of the document.
     *
     * @return the id
     */
    public String getId() {
        return id;
    }

    /**
     * Sets the id of the document.
     *
     * @param id the new id
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * Returns the name of the document.
     *
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the name of the document.
     *
     * @param name the new name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Returns the links to the document.
     *
     * @return the links
     */
    public List<Link> getLinks() {
        return links;
    }

    /**
     * Sets the links to the document.
     *
     * @param links the new links
     */
    public void setLinks(List<Link> links) {
        this.links = links;
    }

    /**
     * Returns the media type of the document.
     *
     * @return the media type
     */
    public String getMediaType() {
        return mediaType;
    }

    /**
     * Sets the media type of the document.
     *
     * @param mediaType the new media type
     */
    public void setMediaType(String mediaType) {
        this.mediaType = mediaType;
    }
}
