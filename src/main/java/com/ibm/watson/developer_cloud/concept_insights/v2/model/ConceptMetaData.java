
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
import com.ibm.watson.developer_cloud.concept_insights.v2.ConceptInsights;

import java.util.ArrayList;
import java.util.List;


/**
 * ConceptMetaData returned by the {@link ConceptInsights} service.
 *
 * @author Nizar Alseddeg (nmalsedd@us.ibm.com)
 */
public class ConceptMetaData {

    @SerializedName("abstract")
    private String _abstract;

    private String id;

    private String label;

    private String link;

    private List<String> ontology = new ArrayList<String>();

    private String thumbnail;

    private String type;

    /**
     * @return The _abstract
     */
    public String getAbstract() {
        return _abstract;
    }

    /**
     * @param _abstract The abstract
     */
    public void setAbstract(String _abstract) {
        this._abstract = _abstract;
    }

    public ConceptMetaData withAbstract(String _abstract) {
        this._abstract = _abstract;
        return this;
    }

    /**
     * @return The id
     */
    public String getId() {
        return id;
    }

    /**
     * @param id The id
     */
    public void setId(String id) {
        this.id = id;
    }

    public ConceptMetaData withId(String id) {
        this.id = id;
        return this;
    }

    /**
     * @return The label
     */
    public String getLabel() {
        return label;
    }

    /**
     * @param label The label
     */
    public void setLabel(String label) {
        this.label = label;
    }

    public ConceptMetaData withLabel(String label) {
        this.label = label;
        return this;
    }

    /**
     * @return The link
     */
    public String getLink() {
        return link;
    }

    /**
     * @param link The link
     */
    public void setLink(String link) {
        this.link = link;
    }

    public ConceptMetaData withLink(String link) {
        this.link = link;
        return this;
    }

    /**
     * @return The ontology
     */
    public List<String> getOntology() {
        return ontology;
    }

    /**
     * @param ontology The ontology
     */
    public void setOntology(List<String> ontology) {
        this.ontology = ontology;
    }

    public ConceptMetaData withOntology(List<String> ontology) {
        this.ontology = ontology;
        return this;
    }

    /**
     * @return The thumbnail
     */
    public String getThumbnail() {
        return thumbnail;
    }

    /**
     * @param thumbnail The thumbnail
     */
    public void setThumbnail(String thumbnail) {
        this.thumbnail = thumbnail;
    }

    public ConceptMetaData withThumbnail(String thumbnail) {
        this.thumbnail = thumbnail;
        return this;
    }

    /**
     * @return The type
     */
    public String getType() {
        return type;
    }

    /**
     * @param type The type
     */
    public void setType(String type) {
        this.type = type;
    }

    public ConceptMetaData withType(String type) {
        this.type = type;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ConceptMetaData that = (ConceptMetaData) o;

        if (_abstract != null ? !_abstract.equals(that._abstract) : that._abstract != null) return false;
        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (label != null ? !label.equals(that.label) : that.label != null) return false;
        if (link != null ? !link.equals(that.link) : that.link != null) return false;
        if (thumbnail != null ? !thumbnail.equals(that.thumbnail) : that.thumbnail != null) return false;
        return !(type != null ? !type.equals(that.type) : that.type != null);

    }

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

    @Override
    public String toString() {
        return String.format("ConceptMetaData [id=%s,label=%,link=%,abstract=%,thumnail=%,type=%]", id, label, link, _abstract, thumbnail, type);

    }
}
