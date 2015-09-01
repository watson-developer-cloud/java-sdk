
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

package com.ibm.watson.developer_cloud.concept_insights.v2.model;

import com.ibm.watson.developer_cloud.concept_insights.v2.ConceptInsights;

import java.util.ArrayList;
import java.util.List;

/**
 * Graphs returned by the {@link ConceptInsights} service.
 *
 * @author Nizar Alseddeg (nmalsedd@us.ibm.com)
 */
public class Corpus {

    private String id;

    private String access;

    private List<User> users = new ArrayList<User>();

    /**
     * @return The id
     */
    public String getId() {
        return id;
    }

    /**
     * @param id The id
     */
    public void setId(String id) {
        this.id = id;
    }

    public Corpus withId(String id) {
        this.id = id;
        return this;
    }

    /**
     * @return The access
     */
    public String getAccess() {
        return access;
    }

    /**
     * @param access The access
     */
    public void setAccess(String access) {
        this.access = access;
    }

    public Corpus withAccess(String access) {
        this.access = access;
        return this;
    }

    /**
     * @return The users
     */
    public List<User> getUsers() {
        return users;
    }

    /**
     * @param users The users
     */
    public void setUsers(List<User> users) {
        this.users = users;
    }

    public Corpus withUsers(List<User> users) {
        this.users = users;
        return this;
    }

}
