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
package com.ibm.watson.developer_cloud.conversation.v1.model.workspace;

import java.util.ArrayList;
import java.util.List;

import com.google.gson.annotations.SerializedName;
import com.ibm.watson.developer_cloud.conversation.v1.ConversationService;
import com.ibm.watson.developer_cloud.conversation.v1.model.workspace.entity.CreateEntity;
import com.ibm.watson.developer_cloud.conversation.v1.model.workspace.intent.CreateExample;
import com.ibm.watson.developer_cloud.conversation.v1.model.workspace.intent.CreateIntent;
import com.ibm.watson.developer_cloud.conversation.v1.model.workspace.nodes.CreateDialogNode;
import com.ibm.watson.developer_cloud.service.model.GenericModel;

/**
 * Object that represents the workspace of a conversation workspace. This is
 * used by the
 * {@link ConversationService#createWorkspace(WorkspaceRequest)} method
 * {@link ConversationService#updateWorkspace(String, WorkspaceRequest)}
 * method
 *
 * @see <a href="http://www.ibm.com/watson/developercloud/conversation.html">
 *      http://www.ibm.com/ watson/developercloud/conversation.html</a>
 *
 */
public class WorkspaceRequest extends Workspace {

	protected WorkspaceRequest(){}
    /**
     * The Class Builder.
     */
    public static class Builder {
        private String name;
        private String description;
        private String language;
        private Object metadata;
        private List<CreateExample> counterExamples;
        private List<CreateDialogNode> dialogNodes;
        private List<CreateEntity> entities;
        private List<CreateIntent> intents;
        
        public Builder() {}

        public Builder(WorkspaceRequest workspaceRequest) {
			name = workspaceRequest.getName();
			description = workspaceRequest.getDescription();
			language = workspaceRequest.getLanguage();
			metadata = workspaceRequest.getMetadata();
			counterExamples = workspaceRequest.getCounterExamples();
			dialogNodes = workspaceRequest.getDialogNodes();
			entities = workspaceRequest.getEntities();
			intents = workspaceRequest.getIntents();
		}

		/**
         * Generates a new {@link WorkspaceRequest} object. It will contain the
         * parameters set in the builder.
         *
         * @return a {@link WorkspaceRequest} instance
         */
        public WorkspaceRequest build() {
            return new WorkspaceRequest(this);
        }

        /**
         * Sets the workspace name.
         *
         * @param name the workspace name
         * @return a builder object
         */
        public Builder setName(final String name) {
            this.name = name;
            return this;
        }

        /**
         * Sets the description used to elaborate on the purpose and usage of a
         * given workspace.
         *
         * @param description string representing the description
         * @return a builder object
         */
        public Builder setDescription(final String description) {
            this.description = description;
            return this;
        }

        /**
         * Sets the language setting for the workspace.
         *
         * @param language string representing the language
         * @return a builder object
         */
        public Builder setLanguage(final String language) {
            this.language = language;
            return this;
        }

        /**
         * Sets the metadata associated with a workspace.
         *
         * @param metadata string representing the description
         * @return a builder object
         */
        public Builder setMetadata(Object metadata) {
            this.metadata = metadata;
            return this;
        }

        /**
         * 
         * @param example input text that have been marked as irrelevant input.
         * @return the builder
         */
        public Builder addCounterExample(CreateExample example){
        	if(counterExamples==null){
        		counterExamples = new ArrayList<CreateExample>();
        	}
        	counterExamples.add(example);
            return this;
        }
        
        /**
         * 
         * @param examples An array of CreateExample objects defining input examples that have been marked as irrelevant input.
         * @return  the builder
         */        
        public Builder addCounterExamples(List<CreateExample> examples){
        	if(counterExamples==null){
        		counterExamples = new ArrayList<CreateExample>();
        	}
        	counterExamples.addAll(examples);
            return this;
        }
        
        /**
         * 
         * @param node a node in the workspace dialog.
         * @return the builder
         */
        public Builder addDialogNode(CreateDialogNode node){
        	if(dialogNodes==null){
        		dialogNodes = new ArrayList<CreateDialogNode>();
        	}
        	dialogNodes.add(node);
            return this;
        }
        
        
        /**
         * 
         * @param nodes An array of CreateDialogNode objects defining the nodes in the workspace dialog.
         * @return the builder
         */
        public Builder addDialogNodes(List<CreateDialogNode> nodes){
        	if(dialogNodes==null){
        		dialogNodes = new ArrayList<CreateDialogNode>();
        	}
        	dialogNodes.addAll(nodes);
            return this;
        }
        
        /**
         * 
         * @param entity defines an entity for the workspace.
         * @return the builder
         */
        public Builder addEntity(CreateEntity entity){
        	if(entities==null){
        		entities = new ArrayList<CreateEntity>();
        	}
        	entities.add(entity);
            return this;
        }
        
        /**
         * 
         * @param entities An array of CreateEntity objects defining the entities for the workspace.
         * @return the builder
         */
        public Builder addEntities(List<CreateEntity> entities){
        	if(entities==null){
        		entities = new ArrayList<CreateEntity>();
        	}
        	entities.addAll(entities);
            return this;
        }
        
        /**
         * 
         * @param intent defines an intent for the workspace.
         * @return the builder
         */
        public Builder addIntent(CreateIntent intent){
        	if(intents==null){
        		intents = new ArrayList<CreateIntent>();
        	}
        	intents.add(intent);
            return this;        	
        }
        
        /**
         * 
         * @param intents An array of CreateIntent objects defining the intents for the workspace.
         * @return the builder
         */
        public Builder addIntents(List<CreateIntent> intents){
        	if(intents==null){
        		intents = new ArrayList<CreateIntent>();
        	}
        	intents.addAll(intents);
            return this;        	
        }
    }

    
    @SerializedName("counterexamples")
    private List<CreateExample> counterExamples;
    
    @SerializedName("dialog_nodes")
    private List<CreateDialogNode> dialogNodes;
    
    private List<CreateEntity> entities;
    
    private List<CreateIntent> intents;
    

    /**
     * Creates a new instance of the WorkspaceRequest for the
     * {@link ConversationService} service. Clients must use the {@link Builder}
     * class to construct new instances of the class.
     *
     * @param options a builder configured with the various parameters for the
     *            request
     */
    private WorkspaceRequest(Builder options) {
        super(options.name, options.description, options.language, options.metadata);
        counterExamples = options.counterExamples;
        dialogNodes = options.dialogNodes;
        entities = options.entities;
        intents = options.intents;
    }

    /**
     * 
     * @return An array of CreateExample objects defining input examples that have been marked as irrelevant input.
     */
    public List<CreateExample> getCounterExamples(){
    	return counterExamples;
    }
    
    /**
     * 
     * @return An array of CreateDialogNode objects defining the nodes in the workspace dialog.
     */
    public List<CreateDialogNode> getDialogNodes(){
    	return dialogNodes;
    }
    
    
    /**
     * 
     * @return An array of CreateEntity objects defining the entities for the workspace.
     */
    public List<CreateEntity> getEntities(){
    	return entities;
    }
    
    
    /**
     * 
     * @return An array of CreateIntent objects defining the intents for the workspace.
     */
    public List<CreateIntent> getIntents(){
    	return intents;
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
