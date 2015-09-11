
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

package com.ibm.watson.developer_cloud.alchemy_news.v1.Model;

import com.ibm.watson.developer_cloud.alchemy_news.v1.AlchemyDataNews;
import com.ibm.watson.developer_cloud.util.GsonSingleton;

import java.util.ArrayList;
import java.util.List;

/**
 * EnrichedTitle returned by the {@link AlchemyDataNews} service.
 *
 * @author Nizar Alseddeg (nmalsedd@us.ibm.com)
 */
public class EnrichedTitle {

    private List<Concept> concepts = new ArrayList<Concept>();

    private DocSentiment docSentiment;

    private List<Entity> entities = new ArrayList<Entity>();

    private List<Taxonomy> taxonomy = new ArrayList<Taxonomy>();

    /**
     * @return The concepts
     */
    public List<Concept> getConcepts() {
        return concepts;
    }

    /**
     * @param concepts The concepts
     */
    public void setConcepts(List<Concept> concepts) {
        this.concepts = concepts;
    }

    public EnrichedTitle withConcepts(List<Concept> concepts) {
        this.concepts = concepts;
        return this;
    }

    /**
     * @return The docSentiment
     */
    public DocSentiment getDocSentiment() {
        return docSentiment;
    }

    /**
     * @param docSentiment The docSentiment
     */
    public void setDocSentiment(DocSentiment docSentiment) {
        this.docSentiment = docSentiment;
    }

    public EnrichedTitle withDocSentiment(DocSentiment docSentiment) {
        this.docSentiment = docSentiment;
        return this;
    }

    /**
     * @return The entities
     */
    public List<Entity> getEntities() {
        return entities;
    }

    /**
     * @param entities The entities
     */
    public void setEntities(List<Entity> entities) {
        this.entities = entities;
    }

    public EnrichedTitle withEntities(List<Entity> entities) {
        this.entities = entities;
        return this;
    }

    /**
     * @return The taxonomy
     */
    public List<Taxonomy> getTaxonomy() {
        return taxonomy;
    }

    /**
     * @param taxonomy The taxonomy
     */
    public void setTaxonomy(List<Taxonomy> taxonomy) {
        this.taxonomy = taxonomy;
    }

    public EnrichedTitle withTaxonomy(List<Taxonomy> taxonomy) {
        this.taxonomy = taxonomy;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        EnrichedTitle that = (EnrichedTitle) o;

        if (concepts != null ? !concepts.equals(that.concepts) : that.concepts != null) return false;
        if (docSentiment != null ? !docSentiment.equals(that.docSentiment) : that.docSentiment != null) return false;
        if (entities != null ? !entities.equals(that.entities) : that.entities != null) return false;
        return !(taxonomy != null ? !taxonomy.equals(that.taxonomy) : that.taxonomy != null);

    }

    @Override
    public int hashCode() {
        int result = concepts != null ? concepts.hashCode() : 0;
        result = 31 * result + (docSentiment != null ? docSentiment.hashCode() : 0);
        result = 31 * result + (entities != null ? entities.hashCode() : 0);
        result = 31 * result + (taxonomy != null ? taxonomy.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return getClass().getName() + " " + GsonSingleton.getGson().toJson(this);
    }
}
