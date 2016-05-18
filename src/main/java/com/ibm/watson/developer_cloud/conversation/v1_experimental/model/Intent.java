/*
 * Copyright 2015 IBM Corp. All Rights Reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except
 * in compliance with the License. You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software distributed under the License
 * is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express
 * or implied. See the License for the specific language governing permissions and limitations under
 * the License.
 */

package com.ibm.watson.developer_cloud.conversation.v1_experimental.model;

/**
 * Intent from a {@link Message}
 */
public class Intent {

    private String intent;
    private Double confidence;

    /**
     * Gets the intent.
     *
     * @return     The intent
     */
    public String getIntent() {
        return intent;
    }

    /**
     * Sets the intent.
     *
     * @param intent     The intent
     */
    public void setIntent(String intent) {
        this.intent = intent;
    }

    /**
     * Gets the confidence.
     *
     * @return     The confidence
     */
    public Double getConfidence() {
        return confidence;
    }

    /**
     * Sets the confidence.
     *
     * @param confidence     The confidence
     */
    public void setConfidence(Double confidence) {
        this.confidence = confidence;
    }

}
