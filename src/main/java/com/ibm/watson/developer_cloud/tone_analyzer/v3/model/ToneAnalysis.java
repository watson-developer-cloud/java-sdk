package com.ibm.watson.developer_cloud.tone_analyzer.v3.model;

import java.util.List;

import com.ibm.watson.developer_cloud.service.model.GenericModel;

/**
 * 
 * Main object containing the result of running Tone Analyzer on a document. It contains both
 * the sentence-level and document-level results.
 * 
 * @author Hernan Badenes
 *
 */
public class ToneAnalysis extends GenericModel {

	ElementTone documentTone;

	List<SentenceAnalysis> sentencesTone;

	public ElementTone getDocumentTone() {
		return documentTone;
	}

	public void setDocumentTone(ElementTone documentTone) {
		this.documentTone = documentTone;
	}

	public List<SentenceAnalysis> getSentencesTone() {
		return sentencesTone;
	}

	public void setSentencesTone(List<SentenceAnalysis> sentencesTone) {
		this.sentencesTone = sentencesTone;
	}
	
	public void addSentencesTone(SentenceAnalysis analysis) {
		this.sentencesTone.add(analysis);
	}
	
	
}
