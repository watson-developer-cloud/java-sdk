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

import java.util.ArrayList;
import java.util.List;

import com.ibm.watson.developer_cloud.conversation.v1.ConversationService;
import com.ibm.watson.developer_cloud.service.model.GenericModel;

/**
 * Object that represents the intent of a conversation workspace. This is used
 * by the {@link ConversationService#createIntent(String, IntentRequest)} method
 * {@link ConversationService#updateIntent(String, String, IntentRequest)}
 * method
 *
 * @see <a href="http://www.ibm.com/watson/developercloud/conversation.html">
 *      http://www.ibm.com/ watson/developercloud/conversation.html</a>
 *
 */
public class IntentRequest extends GenericModel {

    /**
     * The Class Builder.
     */
    public static class Builder {
        private String intent;
        private String created;
        private String updated;
        private String description;
        private List<IntentExample> examples;

        /**
         * Instantiates a new builder.
         *
         * @param intentRequest the intent request
         */
        private Builder(IntentRequest intentRequest) {
            this.intent = intentRequest.intent;
            this.created = intentRequest.created;
            this.updated = intentRequest.updated;
            this.description = intentRequest.description;
            this.examples = intentRequest.examples;
        }

        /**
         * Instantiates a new Builder.
         */
        public Builder() {
        }

        /**
         * Generates a new {@link IntentRequest} object. It will contain the
         * parameters set in the builder.
         *
         * @return a {@link IntentRequest} instance
         */
        public IntentRequest build() {
            return new IntentRequest(this);
        }

        /**
         * Sets the intent name.
         *
         * @param intent the intent name
         * @return a builder object
         */
        public Builder setIntent(final String intent) {
            this.intent = intent;
            return this;
        }

        /**
         * Sets the time that an intent is created.
         *
         * @param created string representing a time stamp for time of creation
         * @return a builder object
         */
        public Builder setCreated(final String created) {
            this.created = created;
            return this;
        }

        /**
         * Sets the time that an intent is created.
         *
         * @param updated string representing a time stamp for time of last creation
         * @return a builder object
         */
        public Builder setUpdated(String updated) {
            this.updated = updated;
            return this;
        }

        /**
         * Sets the description used to elaborate on the purpose and usage of a
         * given intent.
         *
         * @param description string representing the description
         * @return a builder object
         */
        public Builder setDescription(String description) {
            this.description = description;
            return this;
        }

        /**
         * Adds an example {@link IntentExample} to the list of examples to be
         * send as part of the request.
         *
         * @param example the example
         * @return the builder
         */
        public Builder addExample(IntentExample example) {
            if (examples == null) {
                examples = new ArrayList<IntentExample>();
            }

            examples.add(example);
            return this;
        }
    }

    private String intent;
    private String created;
    private String updated;
    private String description;
    private List<IntentExample> examples;

    /**
     * Creates a new instance of the IntentRequest for the
     * {@link ConversationService} service. Clients must use the {@link Builder}
     * class to construct new instances of the class.
     *
     * @param options a builder configured with the various parameters for the
     *            request
     */
    private IntentRequest(Builder options) {
        intent = options.intent;
        created = options.created;
        updated = options.updated;
        description = options.description;
        examples = options.examples;
    }

    /**
     * Identifier of the intent.
     *
     * @return the identifier of the intent
     */
    public String getIntent() {
        return intent;
    }

    /**
     * Returns a time stamp for intent creation.
     *
     * @return a time stamp for intent creation
     */
    public String getCreated() {
        return created;
    }

    /**
     * Returns a time stamp for last update.
     *
     * @return a time stamp for last update
     */
    public String getUpdated() {
        return updated;
    }

    /**
     * Returns the description.
     *
     * @return the description
     */
    public String getDescription() {
        return description;
    }

    /**
     * Returns an optional list of examples that could be used to trigger an
     * intent.
     *
     * @return the examples list
     */
    public List<IntentExample> getExamples() {
        return examples;
    }

    /**
     * New builder.
     *
     * @return the builder
     */
    public Builder newBuilder() {
        return new Builder(this);
    }
}
