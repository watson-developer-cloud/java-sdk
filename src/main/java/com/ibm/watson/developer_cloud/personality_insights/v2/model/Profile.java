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
package com.ibm.watson.developer_cloud.personality_insights.v2.model;

import com.google.gson.annotations.SerializedName;
import com.ibm.watson.developer_cloud.util.GsonSingleton;

/**
 * The Class Profile.
 */
public class Profile {

	/** The id. */
	private String id;
	
	/** The source. */
	private String source;
	
	/** The tree. */
	private Trait tree;
	
	/** The word_count. */
	@SerializedName("word_count")
	private int wordCount;

	/** The word count message. */
	@SerializedName("word_count_message")
	private String wordCountMessage;

	/** The word count message. */
	@SerializedName("processed_lang")
	private String processedLanguage;
	
	
	/**
	 * Gets the processed language.
	 *
	 * @return the processed language
	 */
	public String getProcessedLanguage() {
		return processedLanguage;
	}

	/**
	 * Sets the processed language.
	 *
	 * @param processedLanguage the new processed language
	 */
	public void setProcessedLanguage(String processedLanguage) {
		this.processedLanguage = processedLanguage;
	}

	/**
	 * Gets A message indicating the number of words found and where that value
	 * falls in the range of required/suggested number of words.
	 * 
	 * @return the word count message
	 */
	public String getWordCountMessage() {
		return wordCountMessage;
	}

	/**
	 * Sets a message indicating the number of words found and where that
	 * value falls in the range of required/suggested number of words.
	 *
	 * @param wordCountMessage            the new word count message
	 */
	public void setWordCountMessage(String wordCountMessage) {
		this.wordCountMessage = wordCountMessage;
	}

	/**
	 * Gets the unique identifier for which these characteristics were computed,
	 * from the "userid" field of the input {@link ContentItem}.
	 *
	 * @return the unique identifier
	 */
	public String getId() {
		return id;
	}

	/**
	 * Gets the source for which these characteristics were computed,
	 * from the "sourceid" field of the input {@link ContentItem}.
	 *
	 * @return the source
	 */
	public String getSource() {
		return source;
	}

	/**
	 * Gets the personality trait tree.
	 * 
	 * @return the personality trait tree
	 */
	public Trait getTree() {
		return tree;
	}

	/**
	 * Gets the number of words found in the input.
	 *
	 * @return the number of words
	 */
	public int getWordCount() {
		return wordCount;
	}

	/**
	 * Sets the unique identifier for which these characteristics were computed,
	 * from the "userid" field of the input {@link ContentItem}.
	 *
	 * @param id            the unique identifier
	 */
	public void setId(String id) {
		this.id = id;
	}

	/**
	 * Sets the source for which these characteristics were computed,
	 * from the "sourceid" field of the input {@link ContentItem}.
	 *
	 * @param source            the source
	 */
	public void setSource(String source) {
		this.source = source;
	}

	/**
	 * Sets the personality trait tree.
	 * 
	 * @param tree
	 *            the new personality trait tree
	 */
	public void setTree(Trait tree) {
		this.tree = tree;
	}

	/**
	 * Sets the number of words found in the input.
	 *
	 * @param wordCount            the number of words
	 */
	public void setWordCount(int wordCount) {
		this.wordCount = wordCount;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;

		Profile profile = (Profile) o;

		if (wordCount != profile.wordCount) return false;
		if (!id.equals(profile.id)) return false;
		if (source != null ? !source.equals(profile.source) : profile.source != null) return false;
		if (tree != null ? !tree.equals(profile.tree) : profile.tree != null) return false;
		if (wordCountMessage != null ? !wordCountMessage.equals(profile.wordCountMessage) : profile.wordCountMessage != null)
			return false;
		return !(processedLanguage != null ? !processedLanguage.equals(profile.processedLanguage) : profile.processedLanguage != null);

	}

	@Override
	public int hashCode() {
		int result = id.hashCode();
		result = 31 * result + (source != null ? source.hashCode() : 0);
		result = 31 * result + (tree != null ? tree.hashCode() : 0);
		result = 31 * result + wordCount;
		result = 31 * result + (wordCountMessage != null ? wordCountMessage.hashCode() : 0);
		result = 31 * result + (processedLanguage != null ? processedLanguage.hashCode() : 0);
		return result;
	}

	/*
         * (non-Javadoc)
         *
         * @see java.lang.Object#toString()
         */
	@Override
	public String toString() {
		return getClass().getName() + " "
				+ GsonSingleton.getGson().toJson(this);
	}

}
