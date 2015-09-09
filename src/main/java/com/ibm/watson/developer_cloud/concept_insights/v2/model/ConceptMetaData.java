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

import java.util.List;

import com.google.gson.annotations.SerializedName;
import com.ibm.watson.developer_cloud.concept_insights.v2.ConceptInsights;
import com.ibm.watson.developer_cloud.util.GsonSingleton;

/**
 * ConceptMetaData returned by the {@link ConceptInsights} service.
 * 
 */
public class ConceptMetaData {

	/** The _abstract. */
	@SerializedName("abstract")
	private String _abstract;

	/** The id. */
	private String id;

	/** The label. */
	private String label;

	/** The link. */
	private String link;

	/** The ontology. */
	private List<String> ontology;

	/** The thumbnail. */
	private String thumbnail;

	/** The type. */
	private String type;

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;

		ConceptMetaData that = (ConceptMetaData) o;

		if (_abstract != null ? !_abstract.equals(that._abstract) : that._abstract != null)
			return false;
		if (id != null ? !id.equals(that.id) : that.id != null)
			return false;
		if (label != null ? !label.equals(that.label) : that.label != null)
			return false;
		if (link != null ? !link.equals(that.link) : that.link != null)
			return false;
		if (thumbnail != null ? !thumbnail.equals(that.thumbnail) : that.thumbnail != null)
			return false;
		return !(type != null ? !type.equals(that.type) : that.type != null);

	}

	/**
	 * Gets the abstract.
	 * 
	 * @return The _abstract
	 */
	public String getAbstract() {
		return _abstract;
	}

	/**
	 * Gets the id.
	 * 
	 * @return The id
	 */
	public String getId() {
		return id;
	}

	/**
	 * Gets the label.
	 * 
	 * @return The label
	 */
	public String getLabel() {
		return label;
	}

	/**
	 * Gets the link.
	 * 
	 * @return The link
	 */
	public String getLink() {
		return link;
	}

	/**
	 * Gets the ontology.
	 * 
	 * @return The ontology
	 */
	public List<String> getOntology() {
		return ontology;
	}

	/**
	 * Gets the thumbnail.
	 * 
	 * @return The thumbnail
	 */
	public String getThumbnail() {
		return thumbnail;
	}

	/**
	 * Gets the type.
	 * 
	 * @return The type
	 */
	public String getType() {
		return type;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		int result = _abstract != null ? _abstract.hashCode() : 0;
		result = 31 * result + (id != null ? id.hashCode() : 0);
		result = 31 * result + (label != null ? label.hashCode() : 0);
		result = 31 * result + (link != null ? link.hashCode() : 0);
		result = 31 * result + (thumbnail != null ? thumbnail.hashCode() : 0);
		result = 31 * result + (type != null ? type.hashCode() : 0);
		return result;
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
	 * Sets the id.
	 * 
	 * @param id
	 *            The id
	 */
	public void setId(String id) {
		this.id = id;
	}

	/**
	 * Sets the label.
	 * 
	 * @param label
	 *            The label
	 */
	public void setLabel(String label) {
		this.label = label;
	}

	/**
	 * Sets the link.
	 * 
	 * @param link
	 *            The link
	 */
	public void setLink(String link) {
		this.link = link;
	}

	/**
	 * Sets the ontology.
	 * 
	 * @param ontology
	 *            The ontology
	 */
	public void setOntology(List<String> ontology) {
		this.ontology = ontology;
	}

	/**
	 * Sets the thumbnail.
	 * 
	 * @param thumbnail
	 *            The thumbnail
	 */
	public void setThumbnail(String thumbnail) {
		this.thumbnail = thumbnail;
	}

	/**
	 * Sets the type.
	 * 
	 * @param type
	 *            The type
	 */
	public void setType(String type) {
		this.type = type;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return getClass().getName() + " " + GsonSingleton.getGson().toJson(this);
	}

	/**
	 * With abstract.
	 * 
	 * @param _abstract
	 *            the _abstract
	 * @return the concept meta data
	 */
	public ConceptMetaData withAbstract(String _abstract) {
		this._abstract = _abstract;
		return this;
	}

	/**
	 * With id.
	 * 
	 * @param id
	 *            the id
	 * @return the concept meta data
	 */
	public ConceptMetaData withId(String id) {
		this.id = id;
		return this;
	}

	/**
	 * With label.
	 * 
	 * @param label
	 *            the label
	 * @return the concept meta data
	 */
	public ConceptMetaData withLabel(String label) {
		this.label = label;
		return this;
	}

	/**
	 * With link.
	 * 
	 * @param link
	 *            the link
	 * @return the concept meta data
	 */
	public ConceptMetaData withLink(String link) {
		this.link = link;
		return this;
	}

	/**
	 * With ontology.
	 * 
	 * @param ontology
	 *            the ontology
	 * @return the concept meta data
	 */
	public ConceptMetaData withOntology(List<String> ontology) {
		this.ontology = ontology;
		return this;
	}

	/**
	 * With thumbnail.
	 * 
	 * @param thumbnail
	 *            the thumbnail
	 * @return the concept meta data
	 */
	public ConceptMetaData withThumbnail(String thumbnail) {
		this.thumbnail = thumbnail;
		return this;
	}

	/**
	 * With type.
	 * 
	 * @param type
	 *            the type
	 * @return the concept meta data
	 */
	public ConceptMetaData withType(String type) {
		this.type = type;
		return this;
	}
}
