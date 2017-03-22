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

/**
 * Object that represents the intent of a conversation workspace. This is used
 * by the {@link ConversationService#createIntent(String, CreateIntent)} method
 * {@link ConversationService#updateIntent(String, String, CreateIntent)}
 * method
 *
 * @see <a href="http://www.ibm.com/watson/developercloud/conversation.html">
 *      http://www.ibm.com/ watson/developercloud/conversation.html</a>
 *
 */
public class CreateIntent extends Intent {

	
	protected CreateIntent(){}
	
    /**
     * The Class Builder.
     */
    public static class Builder {
    	private String intent;
    	private String description;
    	private List<CreateExample> examples;

        /**
         * Instantiates a new builder.
         *
         * @param intentRequest the intent request
         */
        private Builder(CreateIntent intentRequest) {
            this.intent = intentRequest.intent;
            this.description = intentRequest.description;
            this.examples = intentRequest.examples;
        }

        /**
         * Instantiates a new Builder.
         */
        public Builder() {
        }

        /**
         * Generates a new {@link CreateIntent} object. It will contain the
         * parameters set in the builder.
         *
         * @return a {@link CreateIntent} instance
         */
        public CreateIntent build() {
            return new CreateIntent(this);
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
         * Adds an example {@link ExampleResponse} to the list of examples to be
         * send as part of the request.
         *
         * @param example the example
         * @return the builder
         */
        public Builder addExample(CreateExample example) {
            if (examples == null) {
                examples = new ArrayList<CreateExample>();
            }

            examples.add(example);
            return this;
        }
        
        /**
         * Adds examples {@link ExampleResponse} to the list of examples to be
         * send as part of the request.
         *
         * @param examples examples to add
         * @return the builder
         */
        public Builder addExamples(List<CreateExample> examples) {
            if (this.examples == null) {
            	this.examples = new ArrayList<CreateExample>();
            }

            this.examples.addAll(examples);
            return this;
        }
    }

    protected List<CreateExample> examples;

    /**
     * Creates a new instance of the IntentRequest for the
     * {@link ConversationService} service. Clients must use the {@link Builder}
     * class to construct new instances of the class.
     *
     * @param options a builder configured with the various parameters for the
     *            request
     */
    private CreateIntent(Builder options) {
        intent = options.intent;
        description = options.description;
        examples = options.examples;
    }

    /**
     * Returns an optional list of examples that could be used to trigger an
     * intent.
     *
     * @return the examples list
     */
    public List<? extends CreateExample> getExamples() {
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
