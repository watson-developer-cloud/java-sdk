
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
import com.ibm.watson.developer_cloud.util.GsonSingleton;

/**
 * Relation returned by the {@link AlchemyLanguage} service.
 *
 * @author Nizar Alseddeg (nmalsedd@us.ibm.com)
 */
public class Relation {

    /** The sentence. */
    private String sentence;

    /** The subject. */
    private Subject subject;

    /** The action. */
    private Action action;

    /** The object. */
    private RelationObject object;

    /** The location. */
    private Location location;

    /**
     * Gets the sentence.
     *
     * @return The sentence
     */
    public String getSentence() {
        return sentence;
    }

    /**
     * Sets the sentence.
     *
     * @param sentence The sentence
     */
    public void setSentence(String sentence) {
        this.sentence = sentence;
    }

    /**
     * With sentence.
     *
     * @param sentence the sentence
     * @return the relation
     */
    public Relation withSentence(String sentence) {
        this.sentence = sentence;
        return this;
    }

    /**
     * Gets the subject.
     *
     * @return The subject
     */
    public Subject getSubject() {
        return subject;
    }

    /**
     * Sets the subject.
     *
     * @param subject The subject
     */
    public void setSubject(Subject subject) {
        this.subject = subject;
    }

    /**
     * With subject.
     *
     * @param subject the subject
     * @return the relation
     */
    public Relation withSubject(Subject subject) {
        this.subject = subject;
        return this;
    }

    /**
     * Gets the action.
     *
     * @return The action
     */
    public Action getAction() {
        return action;
    }

    /**
     * Sets the action.
     *
     * @param action The action
     */
    public void setAction(Action action) {
        this.action = action;
    }

    /**
     * With action.
     *
     * @param action the action
     * @return the relation
     */
    public Relation withAction(Action action) {
        this.action = action;
        return this;
    }

    /**
     * Gets the object.
     *
     * @return The object
     */
    public RelationObject getObject() {
        return object;
    }

    /**
     * Sets the object.
     *
     * @param object The object
     */
    public void setObject(RelationObject object) {
        this.object = object;
    }

    /**
     * With object.
     *
     * @param object the object
     * @return the relation
     */
    public Relation withObject(RelationObject object) {
        this.object = object;
        return this;
    }

    /**
     * Gets the location.
     *
     * @return The location
     */
    public Location getLocation() {
        return location;
    }

    /**
     * Sets the location.
     *
     * @param location The location
     */
    public void setLocation(Location location) {
        this.location = location;
    }

    /**
     * With location.
     *
     * @param location the location
     * @return the relation
     */
    public Relation withLocation(Location location) {
        this.location = location;
        return this;
    }

    /* (non-Javadoc)
     * @see java.lang.Object#equals(java.lang.Object)
     */
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

    /* (non-Javadoc)
     * @see java.lang.Object#hashCode()
     */
    @Override
    public int hashCode() {
        int result = sentence != null ? sentence.hashCode() : 0;
        result = 31 * result + (subject != null ? subject.hashCode() : 0);
        result = 31 * result + (action != null ? action.hashCode() : 0);
        result = 31 * result + (object != null ? object.hashCode() : 0);
        result = 31 * result + (location != null ? location.hashCode() : 0);
        return result;
    }

    /* (non-Javadoc)
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return getClass().getName() + " " + GsonSingleton.getGson().toJson(this);
    }
}
