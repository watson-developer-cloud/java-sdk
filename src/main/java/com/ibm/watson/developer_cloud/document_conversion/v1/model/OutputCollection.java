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
 * Structure to store list of job outputs
 *
 * @see DocumentConversion
 */
public class OutputCollection extends DocumentConversionModel {

    /**
     * List of all outputs in the collection
     */
    @SerializedName("output")
    private List<Output> outputList;
    /**
     * Links for paging through the output. Includes a "first" link for getting the first
     * page of outputs and a "next" link if there are additional pages of outputs
     */
    @Expose
    private List<Link> links;

    /**
     * Returns the list of outputs in the collection
     *
     * @return
     */
    public List<Output> getOutputList() {
        return outputList;
    }

    /**
     * Sets the output list in the collection
     *
     * @param outputList
     */
    public void setOutputList(List<Output> outputList) {
        this.outputList = outputList;
    }

    /**
     * Returns the links to the output in the collection
     *
     * @return
     */
    public List<Link> getLinks() {
        return links;
    }

    /**
     * Sets the links to the output in the collection
     *
     * @param links
     */
    public void setLinks(List<Link> links) {
        this.links = links;
    }
}
