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
package com.ibm.watson.developer_cloud.retrieve_and_rank.v1;

import java.io.File;
import java.util.logging.Logger;

import com.google.gson.JsonObject;
import com.ibm.watson.developer_cloud.http.RequestBuilder;
import com.ibm.watson.developer_cloud.retrieve_and_rank.v1.models.Ranker;
import com.ibm.watson.developer_cloud.retrieve_and_rank.v1.models.Rankers;
import com.ibm.watson.developer_cloud.retrieve_and_rank.v1.models.Ranking;
import com.ibm.watson.developer_cloud.service.WatsonService;
import com.ibm.watson.developer_cloud.util.GsonSingleton;
import com.ibm.watson.developer_cloud.util.ResponseUtil;
import com.squareup.okhttp.Headers;
import com.squareup.okhttp.MediaType;
import com.squareup.okhttp.MultipartBuilder;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.RequestBody;
import com.squareup.okhttp.Response;

/**
 * This class provides a set of methods that allow a user to use the ranker API. Specifically, it contains methods that
 * call the following ranker API methods.
 *
 * - Create ranker - Get rankers - Get status - Delete ranker - Rank
 *
 * @author Kazi S. Hasan (kshasan@us.ibm.com)
 * @version v1
 */

public class RetrieveAndRank extends WatsonService {
    /** The Constant log. */
    private static final Logger log = Logger.getLogger(RetrieveAndRank.class.getName());

    /** Path variables */
    private static final String CREATE_RANKER_PATH = "/v1/rankers";
    private static final String GET_RANKERS_PATH = "/v1/rankers";
    private static final String GET_RANKER_PATH = "/v1/rankers/";
    private static final String DELETE_RANKER_PATH = "/v1/rankers/";
    private static final String RANK_PATH = "/v1/rankers/%s/rank";

    /**
     * Instantiates a new ranker client.
     */
    public RetrieveAndRank() {
        super("retrieve_and_rank");
    }

    /**
     * Sends data to create and train a ranker, and returns information about the new ranker. The status has the value
     * of `Training` when the operation is successful, and might remain at this status for a while.
     *
     * @param name
     *            Name of the ranker
     * @param trainingFile
     *            A File with the training data i.e., the set of (qid, feature values, and rank) tuples
     *
     * @return the ranker object
     * @see Ranker
     */
    public Ranker createRanker(final String name, final File trainingFile) {
        if (trainingFile == null) {
            throw new IllegalArgumentException("trainingFile is null");
        }

        final JsonObject contentJson = new JsonObject();

        if (name != null && !name.isEmpty()) {
            contentJson.addProperty("name", name);
        }

        final RequestBody body = new MultipartBuilder()
                .type(MultipartBuilder.FORM)
                .addPart(
                        Headers.of("Content-Disposition", "form-data; name=\"training_data\""),
                        RequestBody.create(MediaType.parse("application/octet-stream"), trainingFile))
                .addPart(
                        Headers.of("Content-Disposition", "form-data; name=\"training_metadata\""),
                        RequestBody.create(MediaType.parse("text/plain"), contentJson.toString()))
                .build();

        final Request request = RequestBuilder.post(CREATE_RANKER_PATH).withBody(body).build();

        final Response response = execute(request);
        final String json = ResponseUtil.getString(response);
        return GsonSingleton.getGson().fromJson(json, Ranker.class);
    }

    /**
     * Retrieves the list of rankers for the user.
     *
     * @return the ranker list
     * @see Ranker
     */
    public Rankers getRankers() {
        final Request request = RequestBuilder.get(GET_RANKERS_PATH).build();

        final Response response = execute(request);
        return ResponseUtil.getObject(response, Rankers.class);
    }

    /**
     * Retrieves the status of a ranker.
     *
     * @param rankerID
     *            the ranker ID
     * @return Ranker object with the status field set
     * @see Ranker
     */
    public Ranker getRankerStatus(String rankerID) {
        if (rankerID == null || rankerID.isEmpty()) {
            throw new IllegalArgumentException("rankerID can not be null or empty");
        }

        final Request request = RequestBuilder.get(GET_RANKER_PATH + rankerID).build();

        final Response response = execute(request);
        return ResponseUtil.getObject(response, Ranker.class);
    }

    /**
     * Deletes a ranker.
     *
     * @param rankerID
     *            the ranker ID
     * @see Ranker
     */
    public void deleteRanker(String rankerID) {
        if (rankerID == null || rankerID.isEmpty()) {
            throw new IllegalArgumentException("rankerID can not be null or empty");
        }

        try {
            final Request request = RequestBuilder.delete(DELETE_RANKER_PATH + rankerID).build();
            executeWithoutResponse(request);
        } catch (final Exception e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Gets and returns the ranked answers.
     *
     * @param rankerID
     *            The ranker ID
     * @param testFile
     *            The File with the test instances to rank
     * @param topAnswers
     *            The number of top answers needed, default is 10
     * @return the ranking of the answers
     */
    public Ranking rank(final String rankerID, final File testFile, int topAnswers) {
        if (rankerID == null || rankerID.isEmpty()) {
            throw new IllegalArgumentException("rankerID can not be null or empty");
        }

        if (testFile == null) {
            throw new IllegalArgumentException("testFile is null");
        }

        final JsonObject contentJson = new JsonObject();
        contentJson.addProperty("answers", (topAnswers > 0) ? topAnswers : 10);

        final RequestBody body = new MultipartBuilder()
                .type(MultipartBuilder.FORM)
                .addPart(
                        Headers.of("Content-Disposition", "form-data; name=\"answer_data\""),
                        RequestBody.create(MediaType.parse("application/octet-stream"), testFile))
                .addPart(
                        Headers.of("Content-Disposition", "form-data; name=\"answer_metadata\""),
                        RequestBody.create(MediaType.parse("text/plain"), contentJson.toString()))
                .build();

        final String path = String.format(RANK_PATH, rankerID);

        final Request request = RequestBuilder.post(path).withBody(body).build();

        final Response response = execute(request);
        final String rankingAsJson = ResponseUtil.getString(response);
        final Ranking ranking = GsonSingleton.getGson().fromJson(rankingAsJson, Ranking.class);

        return ranking;
    }

    /*
     * (non-Javadoc)
     *
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        final StringBuilder builder = new StringBuilder();
        builder.append("RankerClient [getEndPoint()=");
        builder.append(getEndPoint());
        builder.append("]");
        return builder.toString();
    }
}
