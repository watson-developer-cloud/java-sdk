package com.ibm.watson.developer_cloud.tone_analyzer.v3.model;

import com.ibm.watson.developer_cloud.service.model.GenericModel;

/*
 * Object representing scoring of a single Tone (of any category) on our responses. It contains the Tone ID, a score, and optionally
 * a list of evidences.
 * 
 * @author Hernan Badenes
 */
public class ToneScore extends GenericModel {

	String tone_id;
	
	String tone_name;

	Double score;

	public ToneScore() {
		
	}
	
	public ToneScore(String toneId, String toneName, Double score) {
		super();
		this.tone_id = toneId;
		this.tone_name = toneName;
		this.score = score;
	}

	public String getToneId() {
		return tone_id;
	}

	public String getToneName() {
		return tone_name;
	}

	public Double getScore() {
		return score;
	}

	public void setToneId(String toneId) {
		this.tone_id = toneId;
	}

	public void setToneName(String toneName) {
		this.tone_name = toneName;
	}

	public void setScore(Double score) {
		this.score = score;
	}
	
	
}
