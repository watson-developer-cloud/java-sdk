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

import com.google.gson.GsonBuilder;
import com.google.gson.annotations.SerializedName;

/**
 * The Class Profile.
 */
public class Profile {

	private String id;
	private String source;
	private Trait tree;
	private int word_count;

	@SerializedName("word_count_message")
	private String wordCountMessage;

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
	 * value falls in the range of required/suggested number of words
	 * 
	 * @param wordCountMessage
	 *            the new word count message
	 */
	public void setWordCountMessage(String wordCountMessage) {
		this.wordCountMessage = wordCountMessage;
	}

	/**
	 * Gets the unique identifier for which these characteristics were computed,
	 * from the "userid" field of the input {@link ContentItem}
	 * 
	 * @return the unique identifier
	 */
	public String getId() {
		return id;
	}

	/**
	 * Gets the source for which these characteristics were computed,
	 * from the "sourceid" field of the input {@link ContentItem}
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
	 * Gets the number of words found in the input
	 * 
	 * @return the number of words
	 */
	public int getWord_count() {
		return word_count;
	}

	/**
	 * Sets the unique identifier for which these characteristics were computed,
	 * from the "userid" field of the input {@link ContentItem}
	 * 
	 * @param id
	 *            the unique identifier
	 */
	public void setId(String id) {
		this.id = id;
	}

	/**
	 * Sets the source for which these characteristics were computed,
	 * from the "sourceid" field of the input {@link ContentItem}
	 * 
	 * @param source
	 *            the source
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
	 * Sets the number of words found in the input
	 * 
	 * @param word_count
	 *            the number of words
	 */
	public void setWord_count(int word_count) {
		this.word_count = word_count;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return getClass().getName() + " "
				+ new GsonBuilder().setPrettyPrinting().create().toJson(this);
	}

}
