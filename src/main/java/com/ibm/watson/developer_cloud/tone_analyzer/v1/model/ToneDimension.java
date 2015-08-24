/**
 * Copyright 2015 IBM Corp. All Rights Reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.ibm.watson.developer_cloud.tone_analyzer.v1.model;

import java.util.ArrayList;
import java.util.List;

import com.ibm.watson.developer_cloud.util.GsonSingleton;

/**
 * The Class ToneDimension.
 */
public class ToneDimension {

    /** The name. */
    private String name;
    
    /** The id. */
    private String id;
    
    /** The children. */
    private List<ToneTrait> children = new ArrayList<ToneTrait>();

    /**
     * Gets the name.
     *
     * @return     The name
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the name.
     *
     * @param name     The name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * With name.
     *
     * @param name the name
     * @return the tone dimension
     */
    public ToneDimension withName(String name) {
        this.name = name;
        return this;
    }

    /**
     * Gets the id.
     *
     * @return     The id
     */
    public String getId() {
        return id;
    }

    /**
     * Sets the id.
     *
     * @param id     The id
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * With id.
     *
     * @param id the id
     * @return the tone dimension
     */
    public ToneDimension withId(String id) {
        this.id = id;
        return this;
    }

    /**
     * Gets the children.
     *
     * @return     The children
     */
    public List<ToneTrait> getChildren() {
        return children;
    }

    /**
     * Sets the children.
     *
     * @param children     The children
     */
    public void setChildren(List<ToneTrait> children) {
        this.children = children;
    }

    /**
     * With children.
     *
     * @param children the children
     * @return the tone dimension
     */
    public ToneDimension withChildren(List<ToneTrait> children) {
        this.children = children;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ToneDimension that = (ToneDimension) o;

        if (name != null ? !name.equals(that.name) : that.name != null) return false;
        if (!id.equals(that.id)) return false;
        return !(children != null ? !children.equals(that.children) : that.children != null);

    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + id.hashCode();
        result = 31 * result + (children != null ? children.hashCode() : 0);
        return result;
    }

    /*
         * (non-Javadoc)
         *
         * @see java.lang.Object#toString()
         */
	@Override
	public String toString() {
		return getClass().getName() + " "
				+ GsonSingleton.getGson().toJson(this);
	}
}
