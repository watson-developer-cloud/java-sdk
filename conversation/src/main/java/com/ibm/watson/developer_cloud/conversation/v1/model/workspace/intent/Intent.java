/*
 * Copyright 2015 IBM Corp. All Rights Reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except in compliance with
 * the License. You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software distributed under the License is distributed on
 * an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the License for the
 * specific language governing permissions and limitations under the License.
 */
package com.ibm.watson.developer_cloud.conversation.v1.model.workspace.intent;

import java.util.List;

public class Intent {
    private String intent;
    private String created;
    private String updated;
    private String description;
    private List<IntentExample> examples;

    /**
     * Instantiates a new intent.
     *
     * @param intent name
     * @param created created time-stamp
     * @param updated last updated time-stamp
     * @param description intent description
     * @param examples list of utterances
     */
    public Intent(String intent, String created, String updated, String description,
            List<IntentExample> examples) {
        super();
        this.intent = intent;
        this.created = created;
        this.updated = updated;
        this.description = description;
        this.examples = examples;
    }

    /**
     * Returns the name of the intent.
     *
     * @return the name of the intent
     */
    public String getIntent() {
        return intent;
    }

    /**
     * Sets the name of the intent.
     *
     * @param name the name of the intent
     */
    public void setIntent(String name) {
        this.intent = name;
    }

    /**
     * Returns the time stamp for the intent creation.
     *
     * @return the time stamp for the intent creation
     */
    public String getCreated() {
        return created;
    }

    /**
     * Sets the time stamp for the intent creation.
     *
     * @param created the time stamp for the intent creation
     */
    public void setCreated(String created) {
        this.created = created;
    }

    /**
     * Returns the time stamp for the intent's last update.
     *
     * @return the time stamp for the intent's last update
     */
    public String getUpdated() {
        return updated;
    }

    /**
     * Sets the time stamp for the intent's last update.
     *
     * @param updated the time stamp for the intent's last update
     */
    public void setUpdated(String updated) {
        this.updated = updated;
    }

    /**
     * Returns the intent's description.
     *
     * @return the intent's description
     */
    public String getDescription() {
        return description;
    }

    /**
     * Sets the intent's description.
     *
     * @param description the intent's description
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * Returns the list of intent's example.
     *
     * @return the list of {@link IntentExample}
     */
    public List<IntentExample> getExamples() {
        return examples;
    }

    /**
     * Sets the list of intent's example.
     *
     * @param examples the list of {@link IntentExample}
     */
    public void setExamples(List<IntentExample> examples) {
        this.examples = examples;
    }
}
