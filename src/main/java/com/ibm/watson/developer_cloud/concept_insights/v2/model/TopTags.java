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
package com.ibm.watson.developer_cloud.concept_insights.v2.model;

import java.util.List;
import java.util.Map;

import com.google.gson.annotations.SerializedName;

/**
 * The Class TopTags.
 */
public class TopTags {

	/** The corpus tags histogram. */
	@SerializedName("corpus_tags_histogram")
	private Map<String, Integer> corpusTagsHistogram;

	/** The document length histogram. */
	@SerializedName("document_length_histogram")
	private Map<String, Integer> documentLengthHistogram;

	/** The documents. */
	private Integer documents;

	/** The document tags histogram. */
	@SerializedName("document_tags_histogram")
	private Map<String, Integer> documentTagsHistogram;

	/** The tags. */
	private List<Tag> tags;

	/** The total tags. */
	@SerializedName("total_tags")
	private Integer totalTags;

	/** The unique tags. */
	@SerializedName("unique_tags")
	private Integer uniqueTags;

	/**
	 * Gets the corpus tags histogram.
	 * 
	 * @return The corpusTagsHistogram
	 */
	public Map<String, Integer> getCorpusTagsHistogram() {
		return corpusTagsHistogram;
	}

	/**
	 * Gets the document length histogram.
	 * 
	 * @return The documentLengthHistogram
	 */
	public Map<String, Integer> getDocumentLengthHistogram() {
		return documentLengthHistogram;
	}

	/**
	 * Gets the documents.
	 * 
	 * @return The documents
	 */
	public Integer getDocuments() {
		return documents;
	}

	/**
	 * Gets the document tags histogram.
	 * 
	 * @return The documentTagsHistogram
	 */
	public Map<String, Integer> getDocumentTagsHistogram() {
		return documentTagsHistogram;
	}

	/**
	 * Gets the tags.
	 * 
	 * @return The tags
	 */
	public List<Tag> getTags() {
		return tags;
	}

	/**
	 * Gets the total tags.
	 * 
	 * @return The totalTags
	 */
	public Integer getTotalTags() {
		return totalTags;
	}

	/**
	 * Gets the unique tags.
	 * 
	 * @return The uniqueTags
	 */
	public Integer getUniqueTags() {
		return uniqueTags;
	}

	/**
	 * Sets the corpus tags histogram.
	 * 
	 * @param corpusTagsHistogram
	 *            The corpus_tags_histogram
	 */
	public void setCorpusTagsHistogram(Map<String, Integer> corpusTagsHistogram) {
		this.corpusTagsHistogram = corpusTagsHistogram;
	}

	/**
	 * Sets the document length histogram.
	 * 
	 * @param documentLengthHistogram
	 *            The document_length_histogram
	 */
	public void setDocumentLengthHistogram(Map<String, Integer> documentLengthHistogram) {
		this.documentLengthHistogram = documentLengthHistogram;
	}

	/**
	 * Sets the documents.
	 * 
	 * @param documents
	 *            The documents
	 */
	public void setDocuments(Integer documents) {
		this.documents = documents;
	}

	/**
	 * Sets the document tags histogram.
	 * 
	 * @param documentTagsHistogram
	 *            The document_tags_histogram
	 */
	public void setDocumentTagsHistogram(Map<String, Integer> documentTagsHistogram) {
		this.documentTagsHistogram = documentTagsHistogram;
	}

	/**
	 * Sets the tags.
	 * 
	 * @param tags
	 *            The tags
	 */
	public void setTags(List<Tag> tags) {
		this.tags = tags;
	}

	/**
	 * Sets the total tags.
	 * 
	 * @param totalTags
	 *            The total_tags
	 */
	public void setTotalTags(Integer totalTags) {
		this.totalTags = totalTags;
	}

	/**
	 * Sets the unique tags.
	 * 
	 * @param uniqueTags
	 *            The unique_tags
	 */
	public void setUniqueTags(Integer uniqueTags) {
		this.uniqueTags = uniqueTags;
	}
}
