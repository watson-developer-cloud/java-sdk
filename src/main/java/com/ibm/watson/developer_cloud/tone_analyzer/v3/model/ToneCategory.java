package com.ibm.watson.developer_cloud.tone_analyzer.v3.model;

import java.util.ArrayList;
import java.util.List;

import com.ibm.watson.developer_cloud.service.model.GenericModel;

/**
 * This object represents a top levle tone (or Tone Category) from the list of Writing Tone, Emotion Tone or Social Tone.
 * It holds a list of scores for individual Tones.
 * 
 * @author Hernan Badenes
 *
 */
public class ToneCategory extends GenericModel {
	
	// The ID of this category. It can referred to from several places in the API input/output.
	String id;
	
	// A human-readable, localized name for this category.
	String name;

	// The list of tone scores in this category
	List<ToneScore> tones = new ArrayList<ToneScore>();

	public ToneCategory() {
	}
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<ToneScore> getTones() {
		return tones;
	}

	public void setTones(List<ToneScore> tones) {
		this.tones = tones;
	}
	
	public void addTone(ToneScore score) {
		this.tones.add(score);
	}
}
