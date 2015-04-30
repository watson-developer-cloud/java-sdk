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
package com.ibm.watson.developer_cloud.concept_expansion.v1;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpRequestBase;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.ibm.watson.developer_cloud.concept_expansion.v1.model.Concept;
import com.ibm.watson.developer_cloud.concept_expansion.v1.model.ConceptExpansionDataset;
import com.ibm.watson.developer_cloud.concept_expansion.v1.model.Job;
import com.ibm.watson.developer_cloud.concept_expansion.v1.model.Job.Status;
import com.ibm.watson.developer_cloud.service.Request;
import com.ibm.watson.developer_cloud.service.WatsonService;
import com.ibm.watson.developer_cloud.util.ResponseUtil;

/**
 * The Concept Expansion service analyzes text and interprets its meaning based
 * on usage in other similar contexts.
 * 
 * @version v1
 * 
 * @see <a
 *      href="http://www.ibm.com/smarterplanet/us/en/ibmwatson/developercloud/concept-expansion.html">
 *      Concept Expansion</a>
 * 
 * @author German Attanasio Ruiz <germanatt@us.ibm.com>
 */
public class ConceptExpansion extends WatsonService {

	private static final String PARAM_STATE = "state";
	private static final String PARAM_JOBID = "jobid";
	private static String URL = "https://gateway.watsonplatform.net/concept-expansion-beta/api";
	private static final Map<String, String> decoderHash = new HashMap<String, String>();
	private ConceptExpansionDataset dataset;

	static {
		decoderHash.put("zZzPeriodzZz", ".");
		decoderHash.put("zZzCommazZz", ",");
		decoderHash.put("zZzSlashzZz", "/");
		decoderHash.put("zZzColonzZz", ":");
		decoderHash.put("zZzHashzZz", "#");
		decoderHash.put("zZzStarzZz", "*");
		decoderHash.put("zZzDashzZz", "-");
		decoderHash.put("zZzAmpersandzZz", "&");
		decoderHash.put("zZzPercentzZz", "%");
		decoderHash.put("zZzSemicolonzZz", ";");
		decoderHash.put("zZzUnderbarzZz", "_");
		decoderHash.put("zZzOpenParenzZz", "(");
		decoderHash.put("zZzCloseParenzZz", ")");
		decoderHash.put("zZzPluszZz", "+");
		decoderHash.put("zZzApostrophezZz", "'");
		decoderHash.put("zZzQuestionMarkzZz", "?");
		decoderHash.put("zZzEqualszZz", "=");
		decoderHash.put("zZzDollarzZz", "$");
		decoderHash.put("zZzBackslashzZz", "\\");
		decoderHash.put("zZzPipezZz", "|");
		decoderHash.put("zZzAtzZz", "@");
		decoderHash.put("zZzExclamationzZz", "!");
		decoderHash.put("zZzQuotezZz", "\"");
		decoderHash.put("zZzSquareOpenzZz", "[");
		decoderHash.put("zZzSquareClosezZz", "]");
	}

	/**
	 * Instantiates a new Concept Expansion service.
	 * 
	 */
	public ConceptExpansion() {
		setEndPoint(URL);
	}

	/**
	 * Creates a job.
	 * 
	 * @param label
	 *            A conceptual classification of the seed terms.
	 * @param seeds
	 *            List of terms to seed the concept expansion
	 * 
	 * @return the JSON object
	 */
	public Job createJob(final String label, final String[] seeds) {
		if (dataset == null)
			throw new IllegalArgumentException("dataset can not be null");
		if (label == null)
			throw new IllegalArgumentException("label can not be null");
		if (seeds == null)
			throw new IllegalArgumentException("seeds can not be null");

		try {
			JSONObject payload = new JSONObject();
			payload.put("label", label);
			payload.put("dataset", dataset.getId());
			payload.put("seeds", seeds);

			HttpRequestBase request = Request.Post("/v1/upload")
					.withContent(payload).build();

			HttpResponse response = execute(request);
			String jsonJob = ResponseUtil.getString(response);
			return getGson().fromJson(jsonJob,Job.class);
		} catch (IOException e) {
			throw new RuntimeException(e);
		} catch (JSONException e) {
			throw new RuntimeException(e);
		}
	}

	/**
	 * Decodes the <code>result</code> string by removing server-side codes.
	 * e.g: zzzCommazzz -> "," @
	 * 
	 * @param result
	 *            the result
	 * 
	 * @return decoded results
	 */
	private String decodeResult(String result) {
		for (String key : decoderHash.keySet()) {
			result = result.replaceAll(" " + key, decoderHash.get(key));
			result = result.replaceAll(key, decoderHash.get(key));
		}
		return result;
	}

	/**
	 * Transform a JSON concept to an POJO Object.
	 * 
	 * @param conceptJson
	 *            the concept as json
	 * 
	 *            <pre>
	 * <code> { result:"apple", prevalence:"20" }</code>
	 * </pre>
	 * @return the concept as POJO Object
	 * @throws JSONException
	 *             the JSON exception
	 */
	private Concept formatConcept(JSONObject conceptJson) throws JSONException {
		return new Concept(conceptJson.getString("result"),
				conceptJson.getInt("prevalence"));
	}

	/**
	 * Map JSON concepts to POJO Objects.
	 * 
	 * @param conceptsJson
	 *            the concepts as json
	 * @return the list
	 * @throws JSONException
	 *             the JSON exception
	 */
	private List<Concept> formatConcepts(JSONObject conceptsJson)
			throws JSONException {
		JSONArray conceptArray = conceptsJson.getJSONArray("return_seeds");
		List<Concept> concepts = new ArrayList<Concept>();

		for (int i = 0; i < conceptArray.length(); i++) {
			concepts.add(formatConcept(conceptArray.getJSONObject(i)));
		}
		return concepts;
	}

	/**
	 * Gets the dataset.
	 * 
	 * @return the dataset
	 */
	public ConceptExpansionDataset getDataset() {
		return dataset;
	}

	/**
	 * Gets the job result.
	 * 
	 * @param job
	 *            the job
	 * 
	 * @return the list of concepts
	 * @see Concept
	 * @see Job
	 */
	public List<Concept> getJobResult(final Job job) {
		if (job == null)
			throw new IllegalArgumentException("job can not be null");
		if (job.getId() == null)
			throw new IllegalArgumentException("job.id can not be null");

		try {
			JSONObject payload = new JSONObject();
			payload.put(PARAM_JOBID, job.getId());

			HttpRequestBase request = Request.Put("/v1/result")
					.withContent(payload).build();

			HttpResponse response = execute(request);
			String encodedResult = ResponseUtil.getString(response);
			return formatConcepts(new JSONObject(decodeResult(encodedResult)));
		} catch (IOException e) {
			throw new RuntimeException(e);
		} catch (JSONException e) {
			throw new RuntimeException(e);
		}
	}

	/**
	 * Gets the job status.
	 * 
	 * @param job
	 *            the job
	 * 
	 * @return the job status
	 */
	public Status getJobStatus(final Job job) {
		if (job == null)
			throw new IllegalArgumentException("job can not be null");
		if (job.getId() == null)
			throw new IllegalArgumentException("job.id can not be null");

		HttpRequestBase request = Request.Get("/v1/status")
				.withQuery(PARAM_JOBID, job.getId()).build();

		try {
			HttpResponse response = execute(request);
			JSONObject ret = ResponseUtil.getJSON(response);
			return Status.fromString(ret.getString(PARAM_STATE));
		} catch (final IOException e) {
			throw new RuntimeException(e);
		} catch (JSONException e) {
			throw new RuntimeException(e);
		}
	}

	/**
	 * Sets the Dataset to run against.
	 * 
	 * @param dataset
	 *            the new dataset
	 */
	public void setDataset(final ConceptExpansionDataset dataset) {
		this.dataset = dataset;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("ConceptExpansion [dataset=");
		builder.append(dataset);
		builder.append(", getEndPoint()=");
		builder.append(getEndPoint());
		builder.append("]");
		return builder.toString();
	}

}
