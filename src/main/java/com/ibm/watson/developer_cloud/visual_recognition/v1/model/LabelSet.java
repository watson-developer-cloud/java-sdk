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

package com.ibm.watson.developer_cloud.visual_recognition.v1.model;

import java.util.ArrayList;
import java.util.List;

import com.google.gson.GsonBuilder;
import com.google.gson.annotations.SerializedName;

public class LabelSet {

	@SerializedName("label_groups")
	private List<String> labelGroups = new ArrayList<String>();
	@SerializedName("labels")
	private List<String> labels = new ArrayList<String>();

	/**
	 * Gets the label groups.
	 * 
	 * @return The labelGroups
	 */
	public List<String> getLabelGroups() {
		return labelGroups;
	}

	/**
	 * Sets the label groups.
	 * 
	 * @param labelGroups
	 *            The label_groups
	 */
	public void setLabelGroups(List<String> labelGroups) {
		this.labelGroups = labelGroups;
	}

	/**
	 * With label groups.
	 * 
	 * @param labelGroups
	 *            the label groups
	 * @return the label set
	 */
	public LabelSet withLabelGroups(List<String> labelGroups) {
		this.labelGroups = labelGroups;
		return this;
	}

	/**
	 * Gets the labels.
	 * 
	 * @return The labels
	 */
	public List<String> getLabels() {
		return labels;
	}

	/**
	 * Sets the labels.
	 * 
	 * @param labels
	 *            The labels
	 */
	public void setLabels(List<String> labels) {
		this.labels = labels;
	}

	/**
	 * With labels.
	 * 
	 * @param labels
	 *            the labels
	 * @return the label set
	 */
	public LabelSet withLabels(List<String> labels) {
		this.labels = labels;
		return this;
	}

	/**
	 * With label group.
	 * 
	 * @param labelGroup
	 *            the label group
	 * @return the label set
	 */
	public LabelSet withLabelGroup(String labelGroup) {
		if (labelGroups == null) {
			labelGroups = new ArrayList<String>();
		}

		labelGroups.add(labelGroup);
		return this;
	}

	/**
	 * With label.
	 * 
	 * @param label
	 *            the label
	 * @return the label set
	 */
	public LabelSet withLabel(String label) {
		if (labels == null) {
			labels = new ArrayList<String>();
		}

		labels.add(label);
		return this;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return getClass().getName() + " "
				+ new GsonBuilder().setPrettyPrinting().create().toJson(this);
	}
}
