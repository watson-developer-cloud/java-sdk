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
package com.ibm.watson.developer_cloud.alchemy_language.v1.model;

import com.ibm.watson.developer_cloud.alchemy_news.v1.AlchemyDataNews;
import com.ibm.watson.developer_cloud.util.GsonSingleton;

/**
 * Entity returned by the {@link AlchemyDataNews} service.
 *
 * @author Nizar Alseddeg (nmalsedd@us.ibm.com)
 */
public class KnowledgeGraph {

    private String typeHierarchy;

    /**
     * @return The typeHierarchy
     */
    public String getTypeHierarchy() {
        return typeHierarchy;
    }

    /**
     * @param typeHierarchy The typeHierarchy
     */
    public void setTypeHierarchy(String typeHierarchy) {
        this.typeHierarchy = typeHierarchy;
    }

    public KnowledgeGraph withTypeHierarchy(String typeHierarchy) {
        this.typeHierarchy = typeHierarchy;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        KnowledgeGraph that = (KnowledgeGraph) o;

        return !(typeHierarchy != null ? !typeHierarchy.equals(that.typeHierarchy) : that.typeHierarchy != null);

    }

    @Override
    public int hashCode() {
        return typeHierarchy != null ? typeHierarchy.hashCode() : 0;
    }

    @Override
    public String toString() {
        return getClass().getName() + " " + GsonSingleton.getGson().toJson(this);
    }
}
