package com.ibm.watson.developer_cloud.tone_analyzer.v3.model;

import java.util.ArrayList;
import java.util.List;

import com.ibm.watson.developer_cloud.service.model.GenericModel;

/**
 * This element contains the result of analyzing an individual sentence. It contains a list of ToneCategory
 * objects which is the actual result, and also some metadata about the sentence: The original text (if it needs
 * to be tracked back), and the position of the sentence in the original text (as index of first and last
 * character).
 * 
 * @author Hernan Badenes
 *
 */
public class SentenceAnalysis extends GenericModel {

	long sentence_id;
	
	int charFrom;
	
	int charTo;
	
	String text;

	List<ToneCategory> tones = new ArrayList<ToneCategory>();

	public SentenceAnalysis() {
	}
	
	public SentenceAnalysis(long sentence_id, int charFrom, int charTo, String text) {
		super();
		this.sentence_id = sentence_id;
		this.charFrom = charFrom;
		this.charTo = charTo;
		this.text = text;
	}

	public long getSentence_id() {
		return sentence_id;
	}

	public int getCharFrom() {
		return charFrom;
	}

	public int getCharTo() {
		return charTo;
	}

	public String getText() {
		return text;
	}
	
	public void setTones(List<ToneCategory> tones) {
		this.tones = tones;
	}
	
	public void addTone(ToneCategory tone) {
		this.tones.add(tone);
	}


}