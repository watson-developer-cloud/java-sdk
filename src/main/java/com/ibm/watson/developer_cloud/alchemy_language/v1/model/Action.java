
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

package com.ibm.watson.developer_cloud.alchemy_language.v1.model;

import com.ibm.watson.developer_cloud.alchemy_language.v1.AlchemyLanguage;

/**
 * Action returned by the {@link AlchemyLanguage} service.
 *
 * @author Nizar Alseddeg (nmalsedd@us.ibm.com)
 */
public class Action {

    private String text;

    private String lemmatized;

    private Verb verb;

    /**
     * @return The text
     */
    public String getText() {
        return text;
    }

    /**
     * @param text The text
     */
    public void setText(String text) {
        this.text = text;
    }

    public Action withText(String text) {
        this.text = text;
        return this;
    }

    /**
     * @return The lemmatized
     */
    public String getLemmatized() {
        return lemmatized;
    }

    /**
     * @param lemmatized The lemmatized
     */
    public void setLemmatized(String lemmatized) {
        this.lemmatized = lemmatized;
    }

    public Action withLemmatized(String lemmatized) {
        this.lemmatized = lemmatized;
        return this;
    }

    /**
     * @return The verb
     */
    public Verb getVerb() {
        return verb;
    }

    /**
     * @param verb The verb
     */
    public void setVerb(Verb verb) {
        this.verb = verb;
    }

    public Action withVerb(Verb verb) {
        this.verb = verb;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Action action = (Action) o;

        if (text != null ? !text.equals(action.text) : action.text != null) return false;
        if (lemmatized != null ? !lemmatized.equals(action.lemmatized) : action.lemmatized != null) return false;
        return !(verb != null ? !verb.equals(action.verb) : action.verb != null);

    }

    @Override
    public int hashCode() {
        int result = text != null ? text.hashCode() : 0;
        result = 31 * result + (lemmatized != null ? lemmatized.hashCode() : 0);
        result = 31 * result + (verb != null ? verb.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return String.format("Action [text=%s,lemmatized=%s,verb=%s]", text, lemmatized, verb);
    }
}
