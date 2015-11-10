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
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.JsonPrimitive;
import com.ibm.watson.developer_cloud.concept_expansion.v1.model.Concept;
import com.ibm.watson.developer_cloud.concept_expansion.v1.model.ConceptExpansionDataset;
import com.ibm.watson.developer_cloud.concept_expansion.v1.model.Job;
import com.ibm.watson.developer_cloud.concept_expansion.v1.model.Job.Status;
import com.ibm.watson.developer_cloud.http.RequestBuilder;
import com.ibm.watson.developer_cloud.service.WatsonService;
import com.ibm.watson.developer_cloud.util.ResponseUtil;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;

/**
 * The Concept Expansion service analyzes text and interprets its meaning based on usage in other
 * similar contexts.
 * 
 * @author German Attanasio Ruiz (germanatt@us.ibm.com)
 * @version v1
 * @see <a
 *      href="http://www.ibm.com/smarterplanet/us/en/ibmwatson/developercloud/concept-expansion.html">
 *      Concept Expansion</a>
 */
public class ConceptExpansion extends WatsonService {

  /** The Constant DATASET. */
  public static final String DATASET = "dataset";

  /** The Constant decoderHash. */
  private static final Map<String, String> decoderHash = new HashMap<String, String>();

  /** The Constant LABEL. */
  public static final String LABEL = "label";

  /** The Constant PARAM_JOBID. */
  private static final String PARAM_JOBID = "jobid";

  /** The Constant PARAM_STATE. */
  private static final String PARAM_STATE = "state";

  /** The Constant SEEDS. */
  public static final String SEEDS = "seeds";

  /** The url. */
  private static String URL = "https://gateway.watsonplatform.net/concept-expansion-beta/api";

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

  /** The dataset. */
  private ConceptExpansionDataset dataset;

  /**
   * Instantiates a new Concept Expansion service.
   * 
   */
  public ConceptExpansion() {
    super("concept_expansion");
    setEndPoint(URL);
  }

  /**
   * Creates a job.
   * 
   * @param label A conceptual classification of the seed terms.
   * @param seeds List of terms to seed the concept expansion
   * 
   * @return the JSON object
   */
  public Job createJob(final String label, final String[] seeds) {
    if (dataset == null)
      throw new IllegalArgumentException("dataset cannot be null or empty");
    if (label == null)
      throw new IllegalArgumentException("label cannot be null or empty");
    if (seeds == null || seeds.length == 0)
      throw new IllegalArgumentException("seeds cannot be null or empty");

    final JsonArray seedJsonArray = new JsonArray();
    for (final String seed : seeds) {
      seedJsonArray.add(new JsonPrimitive(seed));
    }

    final JsonObject payload = new JsonObject();
    payload.addProperty(LABEL, label);
    payload.addProperty(DATASET, dataset.getId());
    payload.add(SEEDS, seedJsonArray);

    final Request request = RequestBuilder.post("/v1/upload").withBodyJson(payload).build();
    return executeRequest(request, Job.class);
  }

  /**
   * Decodes the <code>result</code> string by removing server-side codes. e.g: zzzCommazzz -> "," @
   * 
   * @param result the result
   * 
   * @return decoded results
   */
  private String decodeResult(String result) {
    for (final String key : decoderHash.keySet()) {
      result = result.replaceAll(" " + key, decoderHash.get(key));
      result = result.replaceAll(key, decoderHash.get(key));
    }
    return result;
  }

  /**
   * Transform a JSON concept to an POJO Object.
   * 
   * @param conceptJson the concept as json
   * 
   *        <pre>
   * <code> { result:"apple", prevalence:"20" }</code>
   * </pre>
   * @return the concept as POJO Object
   */
  private Concept formatConcept(JsonObject conceptJson) {
    return new Concept(conceptJson.get("result").getAsString(), conceptJson.get("prevalence")
        .getAsDouble());
  }

  /**
   * Map JSON concepts to POJO Objects.
   * 
   * @param conceptsJson the concepts as json
   * @return the list
   */
  private List<Concept> formatConcepts(JsonObject conceptsJson) {
    final JsonArray conceptArray = conceptsJson.get("return_seeds").getAsJsonArray();
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
  public ConceptExpansionDataset getDataset() {
    return dataset;
  }

  /**
   * Gets the job result.
   * 
   * @param job the job
   * 
   * @return the list of concepts
   * @see Concept
   * @see Job
   */
  public List<Concept> getJobResult(final Job job) {
    if (job == null)
      throw new IllegalArgumentException("job cannot be null");
    if (job.getId() == null)
      throw new IllegalArgumentException("job.id cannot be null");

    final JsonObject payload = new JsonObject();
    payload.addProperty(PARAM_JOBID, job.getId());

    final Request request = RequestBuilder.put("/v1/result").withBodyJson(payload).build();

    final Response response = execute(request);
    final String encodedResult = ResponseUtil.getString(response);
    final JsonParser parser = new JsonParser();
    return formatConcepts(parser.parse(decodeResult(encodedResult)).getAsJsonObject());
  }

  /**
   * Gets the job status.
   * 
   * @param job the job
   * 
   * @return the job status
   */
  public Status getJobStatus(final Job job) {
    if (job == null)
      throw new IllegalArgumentException("job cannot be null");
    if (job.getId() == null)
      throw new IllegalArgumentException("job.id cannot be null");

    final Request request =
        RequestBuilder.get("/v1/status").withQuery(PARAM_JOBID, job.getId()).build();

    final Response response = execute(request);
    final JsonObject jsonObject = ResponseUtil.getJsonObject(response);
    return Status.fromString(jsonObject.get(PARAM_STATE).getAsString());
  }

  /**
   * Sets the Dataset to run against.
   * 
   * @param dataset the new dataset
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
    final StringBuilder builder = new StringBuilder();
    builder.append("ConceptExpansion [dataset=");
    builder.append(dataset);
    builder.append(", getEndPoint()=");
    builder.append(getEndPoint());
    builder.append("]");
    return builder.toString();
  }

}
