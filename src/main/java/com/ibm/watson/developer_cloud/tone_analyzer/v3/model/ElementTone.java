package com.ibm.watson.developer_cloud.tone_analyzer.v3.model;

import java.util.ArrayList;
import java.util.List;

import com.ibm.watson.developer_cloud.service.model.GenericModel;

/**
 * This object represents the results of Tone analysis on an element; which may be a document or a sentence.
 * Its structure is a 2-level tree, with tone categories in the top level and the individual tones (and their
 * scores) in leaves.
 *
 * @author Hernan Badenes
 *
 */
public class ElementTone extends GenericModel {

	List<ToneCategory> tones = new ArrayList<ToneCategory>();

	public List<ToneCategory> getTones() {
		return tones;
	}

	public void setTones(List<ToneCategory> tones) {
		this.tones = tones;
	}
	
	public void addTone(ToneCategory tone) {
		this.tones.add(tone);
	}
	
}
