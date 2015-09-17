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
package com.ibm.watson.developer_cloud.natural_language_classifier.v1.model;

import java.util.Date;

import com.google.gson.annotations.SerializedName;
import com.ibm.watson.developer_cloud.natural_language_classifier.v1.NaturalLanguageClassifier;
import com.ibm.watson.developer_cloud.service.model.GenericModel;

/**
 * Classifier used by the {@link NaturalLanguageClassifier} service.
 *
 * @author German Attanasio Ruiz (germanatt@us.ibm.com)
 */
public class Classifier extends GenericModel {

		  
	/**
	 * The Enum Status.
	 */
	public enum Status {
		
		/** The available. */
		@SerializedName("Available")
		AVAILABLE,
		
		/** The failed. */
		@SerializedName("Failed")
		FAILED,
		
		/** The non existent. */
		@SerializedName("Non Existent")
		NON_EXISTENT,
		
		/** The training. */
		@SerializedName("Training")
		TRAINING,
		
		/** The unavailable. */
		@SerializedName("Unavailable")
		UNAVAILABLE
	}
	
	/** The created. */
	private Date created;

	/** The id. */
	@SerializedName("classifier_id")
	private String id;

	/** The language. */
	private String language;

	/** The name. */
	private String name;

	/** The status. */
	private Status status;

	/** The status description. */
	@SerializedName("status_description")
	private String statusDescription;

	/** The url. */
	private String url;

	/**
	 * Gets the created.
	 *
	 * @return the created
	 */
	public Date getCreated() {
		return created;
	}
	
	/**
	 * Gets the classifier id.
	 * 
	 * @return the classifier id
	 */
	public String getId() {
		return id;
	}
	
	/**
	 * Gets the language.
	 *
	 * @return the language
	 */
	public String getLanguage() {
		return language;
	}

	/**
	 * Gets the name.
	 *
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * Gets the status.
	 * 
	 * @return the status
	 */
	public Status getStatus() {
		return status;
	}

	/**
	 * Gets the status description.
	 * 
	 * @return the status description
	 */
	public String getStatusDescription() {
		return statusDescription;
	}

	/**
	 * Gets the url.
	 * 
	 * @return the url
	 */
	public String getUrl() {
		return url;
	}

	/**
	 * Sets the created.
	 *
	 * @param created the created to set
	 */
	public void setCreated(Date created) {
		this.created = created;
	}

	/**
	 * Sets the classifier id.
	 * 
	 * @param id
	 *            the new classifier id
	 */
	public void setId(String id) {
		this.id = id;
	}

	/**
	 * Sets the language.
	 *
	 * @param language the language to set
	 */
	public void setLanguage(String language) {
		this.language = language;
	}

	/**
	 * Sets the name.
	 *
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Sets the status.
	 * 
	 * @param status
	 *            the new status
	 */
	public void setStatus(Status status) {
		this.status = status;
	}

	/**
	 * Sets the status description.
	 * 
	 * @param statusDescription
	 *            the new status description
	 */
	public void setStatusDescription(String statusDescription) {
		this.statusDescription = statusDescription;
	}

	/**
	 * Sets the url.
	 * 
	 * @param url
	 *            the new url
	 */
	public void setUrl(String url) {
		this.url = url;
	}
}
