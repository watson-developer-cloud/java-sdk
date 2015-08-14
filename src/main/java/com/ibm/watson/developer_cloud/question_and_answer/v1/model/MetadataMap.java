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

package com.ibm.watson.developer_cloud.question_and_answer.v1.model;

import com.ibm.watson.developer_cloud.util.GsonSingleton;

/**
 * The Class MetadataMap.
 */
public class MetadataMap {

	/** The docno. */
	private String DOCNO;
	
	/** The _abstract. */
	private String _abstract;
	
	/** The corpus name. */
	private String corpusName;
	
	/** The deepqaid. */
	private String deepqaid;
	
	/** The description. */
	private String description;
	
	/** The file name. */
	private String fileName;
	
	/** The originalfile. */
	private String originalfile;
	
	/** The title. */
	private String title;

	/**
	 * Gets the abstract.
	 * 
	 * 
	 * @return The _abstract
	 */
	public String getAbstract() {
		return _abstract;
	}

	/**
	 * Gets the corpus name.
	 * 
	 * 
	 * @return The corpusName
	 */
	public String getCorpusName() {
		return corpusName;
	}

	/**
	 * Gets the deepqaid.
	 * 
	 * 
	 * @return The deepqaid
	 */
	public String getDeepqaid() {
		return deepqaid;
	}

	/**
	 * Gets the description.
	 * 
	 * 
	 * @return The description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * Gets the docno.
	 * 
	 * 
	 * @return The DOCNO
	 */
	public String getDOCNO() {
		return DOCNO;
	}

	/**
	 * Gets the file name.
	 * 
	 * 
	 * @return The fileName
	 */
	public String getFileName() {
		return fileName;
	}

	/**
	 * Gets the originalfile.
	 * 
	 * 
	 * @return The originalfile
	 */
	public String getOriginalfile() {
		return originalfile;
	}

	/**
	 * Gets the title.
	 * 
	 * 
	 * @return The title
	 */
	public String getTitle() {
		return title;
	}

	/**
	 * Sets the abstract.
	 * 
	 * @param _abstract
	 *            The abstract
	 */
	public void setAbstract(String _abstract) {
		this._abstract = _abstract;
	}

	/**
	 * Sets the corpus name.
	 * 
	 * @param corpusName
	 *            The corpusName
	 */
	public void setCorpusName(String corpusName) {
		this.corpusName = corpusName;
	}

	/**
	 * Sets the deepqaid.
	 * 
	 * @param deepqaid
	 *            The deepqaid
	 */
	public void setDeepqaid(String deepqaid) {
		this.deepqaid = deepqaid;
	}

	/**
	 * Sets the description.
	 * 
	 * @param description
	 *            The description
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * Sets the docno.
	 * 
	 * @param DOCNO
	 *            The DOCNO
	 */
	public void setDOCNO(String DOCNO) {
		this.DOCNO = DOCNO;
	}

	/**
	 * Sets the file name.
	 * 
	 * @param fileName
	 *            The fileName
	 */
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	/**
	 * Sets the originalfile.
	 * 
	 * @param originalfile
	 *            The originalfile
	 */
	public void setOriginalfile(String originalfile) {
		this.originalfile = originalfile;
	}

	/**
	 * Sets the title.
	 * 
	 * @param title
	 *            The title
	 */
	public void setTitle(String title) {
		this.title = title;
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
