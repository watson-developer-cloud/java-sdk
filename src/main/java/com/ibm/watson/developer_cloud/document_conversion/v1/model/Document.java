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
import com.google.gson.annotations.SerializedName;
import com.ibm.watson.developer_cloud.document_conversion.v1.DocumentConversion;

import java.util.List;

/**
 * Structure to store a Document that was uploaded to the service
 *
 * @see DocumentConversion
 */
public class Document extends DocumentConversionModel {
    /**
     * The id of the document
     */
    @Expose
    private String id;

    /**
     * Name of the document
     */
    @Expose
    private String name;

    /**
     * Mediatype of the document
     */
    @SerializedName("media_type")
    String mediaType;

    /**
     * Link to the documents
     */
    @Expose
    private List<Link> links;

    /**
     * Returns the id of the document
     *
     * @return
     */
    public String getId() {
        return id;
    }

    /**
     * Sets the id of the document
     *
     * @param id
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * Returns the name of the document
     *
     * @return
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the name of the document
     *
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Returns the links to the document
     *
     * @return
     */
    public List<Link> getLinks() {
        return links;
    }

    /**
     * Sets the links to the document
     *
     *  @param links
     */
    public void setLinks(List<Link> links) {
        this.links = links;
    }

    /**
     * Returns the media type of the document
     *
     * @return
     */
    public String getMediaType() {
        return mediaType;
    }

    /**
     * Sets the media type of the document
     *
     * @param mediaType
     */
    public void setMediaType(String mediaType) {
        this.mediaType = mediaType;
    }
}
