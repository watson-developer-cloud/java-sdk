
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
 * Relation returned by the {@link AlchemyLanguage} service.
 *
 * @author Nizar Alseddeg (nmalsedd@us.ibm.com)
 */
public class Relation {

    private String sentence;

    private Subject subject;

    private Action action;

    private RelationObject object;

    private Location location;

    /**
     * @return The sentence
     */
    public String getSentence() {
        return sentence;
    }

    /**
     * @param sentence The sentence
     */
    public void setSentence(String sentence) {
        this.sentence = sentence;
    }

    public Relation withSentence(String sentence) {
        this.sentence = sentence;
        return this;
    }

    /**
     * @return The subject
     */
    public Subject getSubject() {
        return subject;
    }

    /**
     * @param subject The subject
     */
    public void setSubject(Subject subject) {
        this.subject = subject;
    }

    public Relation withSubject(Subject subject) {
        this.subject = subject;
        return this;
    }

    /**
     * @return The action
     */
    public Action getAction() {
        return action;
    }

    /**
     * @param action The action
     */
    public void setAction(Action action) {
        this.action = action;
    }

    public Relation withAction(Action action) {
        this.action = action;
        return this;
    }

    /**
     * @return The object
     */
    public RelationObject getObject() {
        return object;
    }

    /**
     * @param object The object
     */
    public void setObject(RelationObject object) {
        this.object = object;
    }

    public Relation withObject(RelationObject object) {
        this.object = object;
        return this;
    }

    /**
     * @return The location
     */
    public Location getLocation() {
        return location;
    }

    /**
     * @param location The location
     */
    public void setLocation(Location location) {
        this.location = location;
    }

    public Relation withLocation(Location location) {
        this.location = location;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Relation relation = (Relation) o;

        if (sentence != null ? !sentence.equals(relation.sentence) : relation.sentence != null) return false;
        if (subject != null ? !subject.equals(relation.subject) : relation.subject != null) return false;
        if (action != null ? !action.equals(relation.action) : relation.action != null) return false;
        if (object != null ? !object.equals(relation.object) : relation.object != null) return false;
        return !(location != null ? !location.equals(relation.location) : relation.location != null);

    }

    @Override
    public int hashCode() {
        int result = sentence != null ? sentence.hashCode() : 0;
        result = 31 * result + (subject != null ? subject.hashCode() : 0);
        result = 31 * result + (action != null ? action.hashCode() : 0);
        result = 31 * result + (object != null ? object.hashCode() : 0);
        result = 31 * result + (location != null ? location.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return String.format("Relation [sentence=%s,subject=%s,action=%s,object=%s,location=%s]", sentence, subject, action, object, location);
    }
}
