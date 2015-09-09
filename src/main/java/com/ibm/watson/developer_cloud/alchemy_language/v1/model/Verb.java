
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
 * Verb returned by the {@link AlchemyLanguage} service.
 *
 * @author Nizar Alseddeg (nmalsedd@us.ibm.com)
 */
public class Verb {


    private String text;

    private String tense;

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

    public Verb withText(String text) {
        this.text = text;
        return this;
    }

    /**
     * @return The tense
     */
    public String getTense() {
        return tense;
    }

    /**
     * @param tense The tense
     */
    public void setTense(String tense) {
        this.tense = tense;
    }

    public Verb withTense(String tense) {
        this.tense = tense;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Verb verb = (Verb) o;

        if (text != null ? !text.equals(verb.text) : verb.text != null) return false;
        return !(tense != null ? !tense.equals(verb.tense) : verb.tense != null);

    }

    @Override
    public int hashCode() {
        int result = text != null ? text.hashCode() : 0;
        result = 31 * result + (tense != null ? tense.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return String.format("Verb [text=%s,tense=%s]", text, tense);
    }
}
