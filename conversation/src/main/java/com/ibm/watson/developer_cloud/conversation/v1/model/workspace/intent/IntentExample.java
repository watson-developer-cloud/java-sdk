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

/**
 * An class used to describe the intent example payload object.
 */
public class IntentExample {
    private String text;
    private String created;
    private String updated;

    /**
     * Instantiates a new intent example.
     *
     * @param text the utterance
     * @param created creation time-stamp
     * @param updated last update time-stamp
     */
    public IntentExample(String text, String created, String updated) {
        super();
        this.text = text;
        this.created = created;
        this.updated = updated;
    }

    /**
     * Returns the text for an intent example. This represents an utterance that
     * can be used to trigger an intent.
     *
     * @return a string representing example
     */
    public String getText() {
        return text;
    }

    /**
     * Sets the text for an intent examples.
     *
     * @param text a string representing example
     */
    public void setText(String text) {
        this.text = text;
    }

    /**
     * Returns the time stamp for when the example was created.
     *
     * @return a string representing the time stamp of example creation
     */
    public String getCreated() {
        return created;
    }

    /**
     * Sets the time stamp for when the example was created.
     *
     * @param created a string representing the time stamp of example creation
     */
    public void setCreated(String created) {
        this.created = created;
    }

    /**
     * Returns the time stamp for when the example was last updated.
     *
     * @return a string representing the time stamp of example's last update
     */
    public String getUpdated() {
        return updated;
    }

    /**
     * Sets the time stamp for when the example was last updated.
     *
     * @param updated a string representing the time stamp of example's last update
     */
    public void setUpdated(String updated) {
        this.updated = updated;
    }
}
