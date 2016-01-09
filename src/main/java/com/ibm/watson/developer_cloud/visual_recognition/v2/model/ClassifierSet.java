/**
 * Copyright 2015 IBM Corp. All Rights Reserved.
 * <p/>
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except
 * in compliance with the License. You may obtain a copy of the License at
 * <p/>
 * http://www.apache.org/licenses/LICENSE-2.0
 * <p/>
 * Unless required by applicable law or agreed to in writing, software distributed under the License
 * is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express
 * or implied. See the License for the specific language governing permissions and limitations under
 * the License.
 */

package com.ibm.watson.developer_cloud.visual_recognition.v2.model;

import com.google.gson.annotations.SerializedName;
import com.ibm.watson.developer_cloud.service.model.GenericModel;

import java.util.ArrayList;
import java.util.List;

/**
 * The Class ClassifierSet.
 */
public class ClassifierSet extends GenericModel {

    /**
     * The classifier groups.
     */
    @SerializedName("classifier_groups")
    private List<String> classifierGroups;

    /**
     * The classifiers.
     */
    @SerializedName("classifiers")
    private List<String> classifiers;

    /**
     * Gets the classifier groups.
     *
     * @return The classifierGroups
     */
    public List<String> getClassifierGroups() {
        return classifierGroups;
    }

    /**
     * Gets the classifiers.
     *
     * @return The classifiers
     */
    public List<String> getClassifiers() {
        return classifiers;
    }

    /**
     * Sets the classifier groups.
     *
     * @param classifierGroups The classifier_groups
     */
    public void setClassifierGroups(List<String> classifierGroups) {
        this.classifierGroups = classifierGroups;
    }

    /**
     * Sets the classifiers.
     *
     * @param classifiers The classifiers
     */
    public void setClassifiers(List<String> classifiers) {
        this.classifiers = classifiers;
    }

    /**
     * With classifier.
     *
     * @param classifier the classifier
     * @return the classifier set
     */
    public ClassifierSet withClassifier(String classifier) {
        if (classifiers == null) {
            classifiers = new ArrayList<String>();
        }

        classifiers.add(classifier);
        return this;
    }

    /**
     * With classifier group.
     *
     * @param classifierGroup the classifier group
     * @return the classifier set
     */
    public ClassifierSet withClassifierGroup(String classifierGroup) {
        if (classifierGroups == null) {
            classifierGroups = new ArrayList<String>();
        }

        classifierGroups.add(classifierGroup);
        return this;
    }
}