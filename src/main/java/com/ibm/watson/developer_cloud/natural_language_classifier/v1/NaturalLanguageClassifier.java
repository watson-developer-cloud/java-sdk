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
package com.ibm.watson.developer_cloud.natural_language_classifier.v1;

import java.io.IOException;
import java.lang.reflect.Type;
import java.util.List;
import java.util.logging.Logger;

import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpRequestBase;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.reflect.TypeToken;
import com.ibm.watson.developer_cloud.natural_language_classifier.v1.model.Classification;
import com.ibm.watson.developer_cloud.natural_language_classifier.v1.model.Classifier;
import com.ibm.watson.developer_cloud.natural_language_classifier.v1.model.TrainingData;
import com.ibm.watson.developer_cloud.service.Request;
import com.ibm.watson.developer_cloud.service.WatsonService;
import com.ibm.watson.developer_cloud.util.ResponseUtil;

/**
 * The IBM Watson Natural Language Classifier service applies deep learning
 * techniques to make predictions about the best predefined classes for short
 * sentences or phrases. The classes can trigger a corresponding action in an
 * application, such as directing a request to a location or person, or
 * answering a question. After training, the service returns information for
 * texts that it hasn't seen before. The response includes the name of the top
 * classes and confidence values.
 *
 * @author German Attanasio Ruiz (germanatt@us.ibm.com)
 * @version v1
 * @see <a href="http://www.ibm.com/smarterplanet/us/en/ibmwatson/developercloud/nl-classifier.html"> Natural Language Classifier</a>
 */
public class NaturalLanguageClassifier extends WatsonService {

	/** The url. */
	private static String URL = "https://gateway.watsonplatform.net/natural-language-classifier-experimental/api";

	/** The Constant log. */
	private static final Logger log = Logger.getLogger(NaturalLanguageClassifier.class.getName());

	/** The list type. */
	private Type listType = new TypeToken<List<Classifier>>() {}.getType();

	/**
	 * Instantiates a new Natural Language Classifier service.
	 */
	public NaturalLanguageClassifier() {
		setEndPoint(URL);
	}

	/**
	 * Sends data to create and train a classifier, and returns information
	 * about the new classifier. The status has the value of `Training` when the
	 * operation is successful, and might remain at this status for a while.
	 * 
	 * @param language
	 *            IETF primary language for the classifier
	 * @param trainingData
	 *            The set of questions and their "keys" used to adapt a system
	 *            to a domain (the ground truth)
	 * @return the classifier
	 * @see Classifier
	 */
	public Classifier createClassifier(final String language,final List<TrainingData> trainingData) {
		if (trainingData == null)
			throw new IllegalArgumentException("data can not be null");

		if (trainingData.isEmpty())
			throw new IllegalArgumentException(
					"data needs to have TrainingData items.");

		JsonObject contentJson = new JsonObject();

		if (language != null && !language.isEmpty()) {
			contentJson.addProperty("language", language);
		}

		contentJson.addProperty("training_data", getGson().toJson(trainingData));

		log.info("createClassifier with: " + contentJson.getAsString());
		HttpRequestBase request = Request
				.Post("/v1/classifiers")
				.withContent(contentJson).build();

		try {
			HttpResponse response = execute(request);
			String classifierAsJson = ResponseUtil.getString(response);
			Classifier classifier = getGson().fromJson(classifierAsJson,
					Classifier.class);
			return classifier;
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}

	/**
	 * Returns classification information for a classifier on a phrase.
	 *
	 * @param classifierId            The classifier id
	 * @param text            The submitted phrase to classify
	 * @return the classification of a phrase with a given classifier
	 */
	public Classification classify(final String classifierId,final String text) {
		if (classifierId == null || classifierId.isEmpty())
			throw new IllegalArgumentException(
					"classifierId can not be null or empty");

		if (text == null || text.isEmpty())
			throw new IllegalArgumentException("text can not be null or empty");

		JsonObject contentJson = new JsonObject();
		contentJson.addProperty("text", text);

		String path = String
				.format("/v1/classifiers/%s/classify", classifierId);

		HttpRequestBase request = Request
				.Post(path)
				.withContent(contentJson).build();

		try {
			HttpResponse response = execute(request);
			String classifierAsJson = ResponseUtil.getString(response);
			Classification classification = getGson().fromJson(
					classifierAsJson, Classification.class);
			return classification;
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}

	/**
	 * Retrieves the list of classifiers for the user.
	 *
	 * @return the classifier list
	 * @see Classifier
	 */
	public List<Classifier> getClassifiers() {
		HttpRequestBase request = Request.Get("/v1/classifiers").build();

		try {
			HttpResponse response = execute(request);
			JsonObject jsonObject = ResponseUtil.getJsonObject(response);
			List<Classifier> classifiers = new Gson().fromJson(
					jsonObject.get("classifiers"), listType);
			return classifiers;
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}

	/**
	 * Deletes a classifier.
	 *
	 * @param classifierId the classifier ID
	 * @see Classifier
	 */
	public void deleteClassifier(String classifierId) {
		if (classifierId == null || classifierId.isEmpty())
			throw new IllegalArgumentException(
					"classifierId can not be null or empty");

		HttpRequestBase request = Request.Delete("/v1/classifiers/"+ classifierId).build();
		executeWithoutResponse(request);
	}

	/**
	 * Retrieves a classifier.
	 *
	 * @param classifierId the classifier ID
	 * @return the classifier list
	 * @see Classifier
	 */
	public Classifier getClassifier(String classifierId) {
		if (classifierId == null || classifierId.isEmpty())
			throw new IllegalArgumentException(
					"classifierId can not be null or empty");

		HttpRequestBase request = Request.Get("/v1/classifiers/"+classifierId).build();

		try {
			HttpResponse response = execute(request);
			String classifierJson = ResponseUtil.getString(response);
			Classifier classifier = new Gson().fromJson(classifierJson,Classifier.class);
			return classifier;
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("NaturalLanguageClassifier [getEndPoint()=");
		builder.append(getEndPoint());
		builder.append("]");
		return builder.toString();
	}

}
