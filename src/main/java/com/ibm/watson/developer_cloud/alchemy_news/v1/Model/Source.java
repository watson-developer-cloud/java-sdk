
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

/**
 * Source by the {@link AlchemyDataNews} service.
 *
 * @author Nizar Alseddeg (nmalsedd@us.ibm.com)
 */
public class Source {

    private Enriched enriched;

    /**
     * @return The enriched
     */
    public Enriched getEnriched() {
        return enriched;
    }

    /**
     * @param enriched The enriched
     */
    public void setEnriched(Enriched enriched) {
        this.enriched = enriched;
    }

    public Source withEnriched(Enriched enriched) {
        this.enriched = enriched;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Source source = (Source) o;

        return !(enriched != null ? !enriched.equals(source.enriched) : source.enriched != null);

    }

    @Override
    public int hashCode() {
        return enriched != null ? enriched.hashCode() : 0;
    }
}
