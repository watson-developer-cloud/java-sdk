package com.ibm.watson.developer_cloud.visual_insights.v1;


import java.io.FileNotFoundException;
import java.net.URISyntaxException;

import com.ibm.watson.developer_cloud.visual_insights.v1.model.Classifiers;


public class VisualInsightsExample {

	public static void main(String[] args) throws URISyntaxException, FileNotFoundException {
		VisualInsights service = new VisualInsights();
		service.setUsernameAndPassword("<username>", "<password>");

		Classifiers classifiers = service.getClassifiers();

		System.out.println(classifiers);
	}

}
