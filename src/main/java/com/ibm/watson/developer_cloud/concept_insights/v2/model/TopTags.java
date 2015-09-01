
/*
 * *
 *  * Copyright 2015 IBM Corp. All Rights Reserved.
 *  *
 *  * Licensed under the Apache License, Version 2.0 (the "License");
 *  * you may not use this file except in compliance with the License.
 *  * You may obtain a copy of the License at
 *  *
 *  *      http://www.apache.org/licenses/LICENSE-2.0
 *  *
 *  * Unless required by applicable law or agreed to in writing, software
 *  * distributed under the License is distributed on an "AS IS" BASIS,
 *  * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  * See the License for the specific language governing permissions and
 *  * limitations under the License.
 *
 */

package com.ibm.watson.developer_cloud.concept_insights.v2.model;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TopTags {

    private Integer documents;

    @SerializedName("total_tags")
    private Integer totalTags;

    @SerializedName("unique_tags")
    private Integer uniqueTags;

    private List<Tag> tags = new ArrayList<Tag>();

    @SerializedName("corpus_tags_histogram")
    private Map<String,Integer> corpusTagsHistogram = new HashMap<String, Integer>();

    @SerializedName("document_tags_histogram")
    private Map<String,Integer> documentTagsHistogram = new HashMap<String, Integer>();

    @SerializedName("document_length_histogram")
    private Map<String,Integer> documentLengthHistogram = new HashMap<String, Integer>();

    /**
     * 
     * @return
     *     The documents
     */
    public Integer getDocuments() {
        return documents;
    }

    /**
     * 
     * @param documents
     *     The documents
     */
    public void setDocuments(Integer documents) {
        this.documents = documents;
    }

    public TopTags withDocuments(Integer documents) {
        this.documents = documents;
        return this;
    }

    /**
     * 
     * @return
     *     The totalTags
     */
    public Integer getTotalTags() {
        return totalTags;
    }

    /**
     * 
     * @param totalTags
     *     The total_tags
     */
    public void setTotalTags(Integer totalTags) {
        this.totalTags = totalTags;
    }

    public TopTags withTotalTags(Integer totalTags) {
        this.totalTags = totalTags;
        return this;
    }

    /**
     * 
     * @return
     *     The uniqueTags
     */
    public Integer getUniqueTags() {
        return uniqueTags;
    }

    /**
     * 
     * @param uniqueTags
     *     The unique_tags
     */
    public void setUniqueTags(Integer uniqueTags) {
        this.uniqueTags = uniqueTags;
    }

    public TopTags withUniqueTags(Integer uniqueTags) {
        this.uniqueTags = uniqueTags;
        return this;
    }

    /**
     * 
     * @return
     *     The tags
     */
    public List<Tag> getTags() {
        return tags;
    }

    /**
     * 
     * @param tags
     *     The tags
     */
    public void setTags(List<Tag> tags) {
        this.tags = tags;
    }

    public TopTags withTags(List<Tag> tags) {
        this.tags = tags;
        return this;
    }

    /**
     * 
     * @return
     *     The corpusTagsHistogram
     */
    public Map<String,Integer> getCorpusTagsHistogram() {
        return corpusTagsHistogram;
    }

    /**
     * 
     * @param corpusTagsHistogram
     *     The corpus_tags_histogram
     */
    public void setCorpusTagsHistogram(Map<String,Integer> corpusTagsHistogram) {
        this.corpusTagsHistogram = corpusTagsHistogram;
    }

    public TopTags withCorpusTagsHistogram(Map<String,Integer> corpusTagsHistogram) {
        this.corpusTagsHistogram = corpusTagsHistogram;
        return this;
    }

    /**
     * 
     * @return
     *     The documentTagsHistogram
     */
    public Map<String,Integer> getDocumentTagsHistogram() {
        return documentTagsHistogram;
    }

    /**
     * 
     * @param documentTagsHistogram
     *     The document_tags_histogram
     */
    public void setDocumentTagsHistogram(Map<String,Integer> documentTagsHistogram) {
        this.documentTagsHistogram = documentTagsHistogram;
    }

    public TopTags withDocumentTagsHistogram(Map<String,Integer> documentTagsHistogram) {
        this.documentTagsHistogram = documentTagsHistogram;
        return this;
    }

    /**
     * 
     * @return
     *     The documentLengthHistogram
     */
    public Map<String,Integer> getDocumentLengthHistogram() {
        return documentLengthHistogram;
    }

    /**
     * 
     * @param documentLengthHistogram
     *     The document_length_histogram
     */
    public void setDocumentLengthHistogram(Map<String,Integer> documentLengthHistogram) {
        this.documentLengthHistogram = documentLengthHistogram;
    }

    public TopTags withDocumentLengthHistogram(Map<String,Integer> documentLengthHistogram) {
        this.documentLengthHistogram = documentLengthHistogram;
        return this;
    }

}
