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

package com.ibm.watson.developer_cloud.tone_analyzer.v1.model;

import java.util.ArrayList;
import java.util.List;

import com.google.gson.annotations.Expose;
import com.ibm.watson.developer_cloud.util.GsonSingleton;

/**
 * Tone.
 */
public class Tone {

    /** Name of the scorecard used to compute this tone.. */
    @Expose
    private String scorecard;
    
    /** The Each of the Tones computed: Social Tone, Emotion Tone and Writing Tone.. */
    @Expose
    private List<ToneDimension> children = new ArrayList<ToneDimension>();

    /**
     * Gets the scorecard.
     *
     * @return     The scorecard
     */
    public String getScorecard() {
        return scorecard;
    }

    /**
     * Sets the scorecard.
     *
     * @param scorecard     The scorecard
     */
    public void setScorecard(final String scorecard) {
        this.scorecard = scorecard;
    }

    /**
     * With scorecard.
     *
     * @param scorecard the scorecard
     * @return the tone
     */
    public Tone withScorecard(final String scorecard) {
        this.scorecard = scorecard;
        return this;
    }

    /**
     * Gets the children.
     *
     * @return     The children
     */
    public List<ToneDimension> getChildren() {
        return children;
    }

    /**
     * Sets the children.
     *
     * @param children     The children
     */
    public void setChildren(final List<ToneDimension> children) {
        this.children = children;
    }

    /**
     * With children.
     *
     * @param children the children
     * @return the tone
     */
    public Tone withChildren(final List<ToneDimension> children) {
        this.children = children;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Tone tone = (Tone) o;

        if (!scorecard.equals(tone.scorecard)) return false;
        return !(children != null ? !children.equals(tone.children) : tone.children != null);

    }

    @Override
    public int hashCode() {
        int result = scorecard.hashCode();
        result = 31 * result + (children != null ? children.hashCode() : 0);
        return result;
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
