/**
 * Copyright 2015 IBM Corp. All Rights Reserved.
 * 
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except
 * in compliance with the License. You may obtain a copy of the License at
 * 
 * http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software distributed under the License
 * is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express
 * or implied. See the License for the specific language governing permissions and limitations under
 * the License.
 */
package com.ibm.watson.developer_cloud.concept_expansion.v1;

import java.util.ArrayList;
import java.util.List;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.JsonPrimitive;
import com.ibm.watson.developer_cloud.concept_expansion.v1.model.Concept;
import com.ibm.watson.developer_cloud.concept_expansion.v1.model.Dataset;
import com.ibm.watson.developer_cloud.concept_expansion.v1.model.Job;
import com.ibm.watson.developer_cloud.concept_expansion.v1.model.Job.Status;
import com.ibm.watson.developer_cloud.http.RequestBuilder;
import com.ibm.watson.developer_cloud.service.WatsonService;
import com.ibm.watson.developer_cloud.util.ResponseUtil;
import com.ibm.watson.developer_cloud.util.Validate;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;

/**
 * The Concept Expansion service analyzes text and interprets its meaning based on usage in other
 * similar contexts.
 * 
 * @version v1
 * @see <a href=
 *      "http://www.ibm.com/smarterplanet/us/en/ibmwatson/developercloud/concept-expansion.html">
 *      Concept Expansion</a>
 */
public class ConceptExpansion extends WatsonService {
  private static final String DATASET = "dataset";
  private static final String LABEL = "label";
  private static final String PARAM_JOBID = "jobid";
  private static final String PARAM_STATE = "state";
  private static final String PREVALENCE = "prevalence";
  private static final String RESULT = "result";
  private static final String RETURN_SEEDS = "return_seeds";
  private static final String SEEDS = "seeds";
  private static String URL = "https://gateway.watsonplatform.net/concept-expansion-beta/api";
  private static final String V1_RESULT = "/v1/result";
  private static final String V1_STATUS = "/v1/status";
  private static final String V1_UPLOAD = "/v1/upload";

  private Dataset dataset;

  /**
   * Instantiates a new Concept Expansion service.
   * 
   */
  public ConceptExpansion() {
    super("concept_expansion");
    setEndPoint(URL);
    setDataset(Dataset.MT_SAMPLES);
  }

  /**
   * Creates a {@link Job}.
   * 
   * @param seeds List of terms to be used as seeds
   * 
   * @return the {@link Job}
   */
  public Job createJob(final String[] seeds) {
    return createJob(null, seeds);
  }

  /**
   * Creates a {@link Job}.
   * 
   * @param label A conceptual classification of the seed terms.
   * @param seeds List of terms to be used as seeds
   * 
   * @return the {@link Job}
   */
  public Job createJob(final String label, final String[] seeds) {
    Validate.notEmpty(seeds, "seeds cannot be null or empty");
    Validate.notNull(dataset, "dataset cannot be null");

    final JsonArray seedJsonArray = new JsonArray();
    for (final String seed : seeds) {
      seedJsonArray.add(new JsonPrimitive(seed));
    }

    final JsonObject payload = new JsonObject();
    payload.addProperty(LABEL, label);
    payload.addProperty(DATASET, dataset.getId());
    payload.add(SEEDS, seedJsonArray);

    final Request request = RequestBuilder.post(V1_UPLOAD).withBodyJson(payload).build();
    return executeRequest(request, Job.class);
  }

  /**
   * Formats a concept {@link JsonObject} as a {@link Concept} object
   * 
   * @param conceptJson the concept as {@link JsonObject}
   * 
   *        <pre>
   * <code> { result:"apple", prevalence:"20" }</code>
   *        </pre>
   * 
   * @return the concept as POJO Object
   */
  private Concept formatConcept(JsonObject conceptJson) {
    return new Concept(conceptJson.get(RESULT).getAsString(),
        conceptJson.get(PREVALENCE).getAsDouble());
  }

  /**
   * Map JSON concepts to POJO Objects.
   * 
   * @param conceptsJson the concepts as json
   * @return the list
   */
  private List<Concept> formatConcepts(JsonObject conceptsJson) {
    final JsonArray conceptArray = conceptsJson.get(RETURN_SEEDS).getAsJsonArray();
    final List<Concept> concepts = new ArrayList<Concept>();

    for (final JsonElement conceptJson : conceptArray) {
      concepts.add(formatConcept(conceptJson.getAsJsonObject()));
    }
    return concepts;
  }

  /**
   * Gets the dataset.
   * 
   * @return the dataset
   */
  public Dataset getDataset() {
    return dataset;
  }

  /**
   * Gets the {@link Job} result.
   * 
   * @param job the {@link Job}
   * 
   * @return the list of concepts
   * @see Concept
   * @see Job
   */
  public List<Concept> getJobResult(final Job job) {
    Validate.notNull(job, "job cannot be null");

    final JsonObject payload = new JsonObject();
    payload.addProperty(PARAM_JOBID, job.getId());

    final Request request = RequestBuilder.put(V1_RESULT).withBodyJson(payload).build();

    final String resultAsString = ResponseUtil.getString(execute(request));
    return formatConcepts(new JsonParser().parse(resultAsString).getAsJsonObject());
  }

  /**
   * Gets the {@link Job} status.
   * 
   * @param job the {@link Job}
   * 
   * @return the job status
   */
  public Status getJobStatus(final Job job) {
    Validate.notNull(job, "job cannot be null");

    final Request request =
        RequestBuilder.get(V1_STATUS).withQuery(PARAM_JOBID, job.getId()).build();

    final Response response = execute(request);
    final JsonObject jsonObject = ResponseUtil.getJsonObject(response);
    return Status.fromString(jsonObject.get(PARAM_STATE).getAsString());
  }

  /**
   * Sets the Dataset to run against.
   * 
   * @param dataset the new dataset
   */
  public void setDataset(final Dataset dataset) {
    this.dataset = dataset;
  }

}
