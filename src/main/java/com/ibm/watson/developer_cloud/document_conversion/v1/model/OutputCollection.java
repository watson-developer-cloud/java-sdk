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
 * Structure to store the collection list of outputs that were generated in the service.
 *
 * @see DocumentConversion
 */
public class OutputCollection extends GenericModel {

    /** List of all outputs in the collection. */
    @SerializedName("output")
    private List<Output> outputs;
    /**
     * Links for paging through the output. Includes a "first" link for getting the first
     * page of outputs and a "next" link if there are additional pages of outputs
     */
    @Expose
    private List<Link> links;

    /**
     * Returns the list of outputs in the collection.
     *
     * @return the outputs
     */
    public List<Output> getOutputs() {
        return outputs;
    }

    /**
     * Sets the output list in the collection.
     *
     * @param outputs the new outputs
     */
    public void setOutputs(List<Output> outputs) {
        this.outputs = outputs;
    }

    /**
     * Returns the links to the output in the collection.
     *
     * @return the links
     */
    public List<Link> getLinks() {
        return links;
    }

    /**
     * Sets the links to the output in the collection.
     *
     * @param links the new links
     */
    public void setLinks(List<Link> links) {
        this.links = links;
    }
}
