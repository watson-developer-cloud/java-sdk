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

import java.util.List;

import com.ibm.watson.developer_cloud.conversation.v1_experimental.ConversationService;

/**
 * The entity from a message returned by the {@link ConversationService}
 */
public class Entity {

    private String entity;
    private String value;
    private List<Integer> location;

    /**
     * Gets the entity.
     *
     * @return     The entity
     */
    public String getEntity() {
        return entity;
    }

    /**
     * Sets the entity.
     *
     * @param entity     The entity
     */
    public void setEntity(String entity) {
        this.entity = entity;
    }

    /**
     * Gets the value.
     *
     * @return     The value
     */
    public String getValue() {
        return value;
    }

    /**
     * Sets the value.
     *
     * @param value     The value
     */
    public void setValue(String value) {
        this.value = value;
    }

    /**
     * Gets the location.
     *
     * @return     The location
     */
    public List<Integer> getLocation() {
        return location;
    }

    /**
     * Sets the location.
     *
     * @param location     The location
     */
    public void setLocation(List<Integer> location) {
        this.location = location;
    }

}
