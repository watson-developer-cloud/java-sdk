/**
 * Copyright 2017 IBM Corp. All Rights Reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except in compliance with
 * the License. You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software distributed under the License is distributed on
 * an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the License for the
 * specific language governing permissions and limitations under the License.
 */
package com.ibm.watson.developer_cloud.retrieve_and_rank.v1;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.google.gson.JsonObject;
import com.ibm.watson.developer_cloud.http.HttpHeaders;
import com.ibm.watson.developer_cloud.http.HttpMediaType;
import com.ibm.watson.developer_cloud.http.RequestBuilder;
import com.ibm.watson.developer_cloud.http.ResponseConverter;
import com.ibm.watson.developer_cloud.http.ServiceCall;
import com.ibm.watson.developer_cloud.retrieve_and_rank.v1.model.Ranker;
import com.ibm.watson.developer_cloud.retrieve_and_rank.v1.model.Rankers;
import com.ibm.watson.developer_cloud.retrieve_and_rank.v1.model.Ranking;
import com.ibm.watson.developer_cloud.retrieve_and_rank.v1.model.SolrCluster;
import com.ibm.watson.developer_cloud.retrieve_and_rank.v1.model.SolrClusterOptions;
import com.ibm.watson.developer_cloud.retrieve_and_rank.v1.model.SolrClusterResizeRequest;
import com.ibm.watson.developer_cloud.retrieve_and_rank.v1.model.SolrClusterSizeResponse;
import com.ibm.watson.developer_cloud.retrieve_and_rank.v1.model.SolrClusterStats;
import com.ibm.watson.developer_cloud.retrieve_and_rank.v1.model.SolrClusters;
import com.ibm.watson.developer_cloud.retrieve_and_rank.v1.model.SolrConfigs;
import com.ibm.watson.developer_cloud.retrieve_and_rank.v1.util.ZipUtils;
import com.ibm.watson.developer_cloud.service.WatsonService;
import com.ibm.watson.developer_cloud.util.GsonSingleton;
import com.ibm.watson.developer_cloud.util.ResponseConverterUtils;
import com.ibm.watson.developer_cloud.util.Validator;

import okhttp3.Headers;
import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

/**
 * The IBM Watson Retrieve and Rank service helps users find the most relevant information for their query by using a
 * combination of search and machine learning to find “signals” in the data. Built on top of Apache Solr, developers
 * load their data into the service, train a machine learning model based on known relevant results, then leverage this
 * model to provide improved results to their end users based on their question or query.
 *
 * @version v1
 * @see <a href= "http://www.ibm.com/watson/developercloud/retrieve-rank.html"> Retrieve and Rank</a>
 */
public class RetrieveAndRank extends WatsonService implements ClusterLifecycleManager, SolrConfigManager {

  private static final String ANSWERS = "answers";
  private static final Logger LOG = Logger.getLogger(RetrieveAndRank.class.getName());
  private static final String NAME = "name";
  private static final String PATH_CREATE_RANKER = "/v1/rankers";
  private static final String PATH_GET_SOLR_CLUSTER = "/v1/solr_clusters/%s";
  private static final String PATH_SOLR = "/v1/solr_clusters/%s/solr";
  private static final String PATH_RANK = "/v1/rankers/%s/rank";
  private static final String PATH_RANKER = "/v1/rankers/%s";
  private static final String PATH_RANKERS = "/v1/rankers";
  private static final String PATH_SOLR_CLUSTERS = "/v1/solr_clusters";
  private static final String PATH_SOLR_CLUSTERS_CONFIG = "/v1/solr_clusters/%s/config";
  private static final String PATH_SOLR_CLUSTERS_CONFIGS = "/v1/solr_clusters/%s/config/%s";
  private static final String URL = "https://gateway.watsonplatform.net/retrieve-and-rank/api";
  private static final String PATH_SOLR_CLUSTERS_SIZE = "/v1/solr_clusters/%s/cluster_size";

  /**
   * Instantiates a new ranker client.
   */
  public RetrieveAndRank() {
    super("retrieve_and_rank");
    if ((getEndPoint() == null) || getEndPoint().isEmpty()) {
      setEndPoint(URL);
    }
  }

  /**
   * Instantiates a new ranker service by username and password.
   *
   * @param username the username
   * @param password the password
   */
  public RetrieveAndRank(String username, String password) {
    this();
    setUsernameAndPassword(username, password);
  }

  /**
   * Creates the Solr configuration path.
   *
   * @param solrClusterId the solr cluster id
   * @param configName the configuration name
   * @return the string
   */
  private String createConfigPath(String solrClusterId, String configName) {
    Validator.isTrue((solrClusterId != null) && !solrClusterId.isEmpty(), "solrClusterId cannot be null or empty");
    Validator.isTrue((configName != null) && !configName.isEmpty(), "configName cannot be null or empty");
    return String.format(PATH_SOLR_CLUSTERS_CONFIGS, solrClusterId, configName);
  }

  /**
   * Sends data to create and train a ranker, and returns information about the new ranker. The status has the value of
   * `Training` when the operation is successful, and might remain at this status for a while.
   *
   * @param name Name of the ranker
   * @param training The file with the training data i.e., the set of (qid, feature values, and rank) tuples
   * @return the ranker object
   * @see Ranker
   */
  public ServiceCall<Ranker> createRanker(final String name, final File training) {
    Validator.notNull(training, "training file cannot be null");
    Validator.isTrue(training.exists(), "training file: " + training.getAbsolutePath() + " not found");

    final JsonObject contentJson = new JsonObject();

    if ((name != null) && !name.isEmpty()) {
      contentJson.addProperty(NAME, name);
    }

    final RequestBody body = new MultipartBody.Builder().setType(MultipartBody.FORM)
        .addPart(Headers.of(HttpHeaders.CONTENT_DISPOSITION, "form-data; name=\"training_data\""),
            RequestBody.create(HttpMediaType.BINARY_FILE, training))
        .addPart(Headers.of(HttpHeaders.CONTENT_DISPOSITION, "form-data; name=\"training_metadata\""),
            RequestBody.create(HttpMediaType.TEXT, contentJson.toString()))
        .build();

    final Request request = RequestBuilder.post(PATH_CREATE_RANKER).body(body).build();

    return createServiceCall(request, ResponseConverterUtils.getObject(Ranker.class));
  }

  /*
   * (non-Javadoc)
   *
   * @see com.ibm.watson.developer_cloud.
   * retrieve_and_rank.v1.ClusterLifecycleManager#createSolrCluster()
   */
  @Override
  public ServiceCall<SolrCluster> createSolrCluster() {
    return createSolrCluster(null);
  }


  /*
   * (non-Javadoc)
   *
   * @see com.ibm.watson.developer_cloud.
   * retrieve_and_rank.v1.ClusterLifecycleManager#createSolrCluster
   * (com.ibm.watson.developer_cloud.
   * retrieve_and_rank.v1.model.SolrClusterOptions)
   */
  @Override
  public ServiceCall<SolrCluster> createSolrCluster(SolrClusterOptions config) {
    final RequestBuilder requestBuilder = RequestBuilder.post(PATH_SOLR_CLUSTERS);

    if (config != null) {
      requestBuilder.bodyContent(GsonSingleton.getGsonWithoutPrettyPrinting().toJson(config),
          HttpMediaType.APPLICATION_JSON);
    }

    return createServiceCall(requestBuilder.build(), ResponseConverterUtils.getObject(SolrCluster.class));
  }

  /**
   * Deletes a ranker.
   *
   * @param rankerID the ranker id
   * @return the service call
   */
  public ServiceCall<Void> deleteRanker(final String rankerID) {
    Validator.isTrue((rankerID != null) && !rankerID.isEmpty(), "rankerId cannot be null or empty");

    final Request request = RequestBuilder.delete(String.format(PATH_RANKER, rankerID)).build();
    return createServiceCall(request, ResponseConverterUtils.getVoid());
  }

  /*
   * (non-Javadoc)
   *
   * @see com.ibm.watson.developer_cloud.
   * retrieve_and_rank.v1.ClusterLifecycleManager#deleteSolrCluster (java.lang.String)
   */
  @Override
  public ServiceCall<Void> deleteSolrCluster(String solrClusterId) {
    Validator.isTrue((solrClusterId != null) && !solrClusterId.isEmpty(), "solrClusterId cannot be null or empty");
    final Request request = RequestBuilder.delete(String.format(PATH_GET_SOLR_CLUSTER, solrClusterId)).build();
    return createServiceCall(request, ResponseConverterUtils.getVoid());

  }

  /*
   * (non-Javadoc)
   *
   * @see com.ibm.watson.developer_cloud.
   * retrieve_and_rank.v1.SolrConfigManager# deleteSolrClusterConfiguration(java.lang.String, java.lang.String)
   */
  @Override
  public ServiceCall<Void> deleteSolrClusterConfiguration(String solrClusterId, String configName) {
    final String configPath = createConfigPath(solrClusterId, configName);
    final Request request = RequestBuilder.delete(configPath).build();
    return createServiceCall(request, ResponseConverterUtils.getVoid());
  }

  /**
   * retrieves the list of rankers for the user.
   *
   * @return the rankers
   */
  public ServiceCall<Rankers> getRankers() {
    final Request request = RequestBuilder.get(PATH_RANKERS).build();
    return createServiceCall(request, ResponseConverterUtils.getObject(Rankers.class));
  }

  /**
   * Retrieves the status of a ranker.
   *
   * @param rankerID the ranker ID
   * @return Ranker object with the status field set
   * @see Ranker
   */
  public ServiceCall<Ranker> getRankerStatus(final String rankerID) {
    Validator.isTrue((rankerID != null) && !rankerID.isEmpty(), "rankerId cannot be null or empty");

    final Request request = RequestBuilder.get(String.format(PATH_RANKER, rankerID)).build();
    return createServiceCall(request, ResponseConverterUtils.getObject(Ranker.class));
  }

  /*
   * (non-Javadoc)
   *
   * @see com.ibm.watson.developer_cloud.
   * retrieve_and_rank.v1.ClusterLifecycleManager#getSolrCluster( java.lang.String)
   */
  @Override
  public ServiceCall<SolrCluster> getSolrCluster(String solrClusterId) {
    Validator.isTrue((solrClusterId != null) && !solrClusterId.isEmpty(), "solrClusterId cannot be null or empty");

    final Request request = RequestBuilder.get(String.format(PATH_GET_SOLR_CLUSTER, solrClusterId)).build();
    return createServiceCall(request, ResponseConverterUtils.getObject(SolrCluster.class));

  }

  /*
   * (non-Javadoc)
   *
   * @see com.ibm.watson.developer_cloud.
   * retrieve_and_rank.v1.SolrConfigManager# getSolrClusterConfiguration (java.lang.String, java.lang.String)
   */
  @Override
  public ServiceCall<InputStream> getSolrClusterConfiguration(String solrClusterId, String configName) {
    Validator.isTrue((solrClusterId != null) && !solrClusterId.isEmpty(), "solrClusterId cannot be null or empty");
    Validator.isTrue((configName != null) && !configName.isEmpty(), "configName cannot be null or empty");

    final String configPath = createConfigPath(solrClusterId, configName);
    final RequestBuilder requestBuider =
        RequestBuilder.get(configPath).header(HttpHeaders.ACCEPT, HttpMediaType.APPLICATION_ZIP);
    return createServiceCall(requestBuider.build(), ResponseConverterUtils.getInputStream());
  }

  /*
   * (non-Javadoc)
   *
   * @see com.ibm.watson.developer_cloud.
   * retrieve_and_rank.v1.SolrConfigManager# getSolrClusterConfigurations (java.lang.String)
   */
  @Override
  public ServiceCall<SolrConfigs> getSolrClusterConfigurations(String solrClusterId) {
    Validator.isTrue((solrClusterId != null) && !solrClusterId.isEmpty(), "solrClusterId cannot be null or empty");
    final Request request = RequestBuilder.get(String.format(PATH_SOLR_CLUSTERS_CONFIG, solrClusterId)).build();

    return createServiceCall(request, ResponseConverterUtils.getObject(SolrConfigs.class));
  }

  /*
   * (non-Javadoc)
   *
   * @see com.ibm.watson.developer_cloud.
   * retrieve_and_rank.v1.ClusterLifecycleManager#getSolrClusters()
   */
  @Override
  public ServiceCall<SolrClusters> getSolrClusters() {
    final Request request = RequestBuilder.get(PATH_SOLR_CLUSTERS).build();
    return createServiceCall(request, ResponseConverterUtils.getObject(SolrClusters.class));
  }

  /**
   * Gathers memory and disk usage stats from a Solr cluster.
   *
   * @param solrClusterId the ID of the Solr cluster to gather stats from
   * @return stats about the Solr cluster
   */
  public ServiceCall<SolrClusterStats> getSolrClusterStats(String solrClusterId) {
    Validator.isTrue((solrClusterId != null) && !solrClusterId.isEmpty(), "solrClusterId cannot be null or empty");

    final Request request = RequestBuilder.get(String.format(PATH_GET_SOLR_CLUSTER, solrClusterId) + "/stats").build();
    return createServiceCall(request, ResponseConverterUtils.getObject(SolrClusterStats.class));

  }

  /**
   * This URL can be used with the SolrJ library to access Solr functionality.
   *
   * @param solrClusterId the ID of the Solr cluster to connect to
   * @return URL to access Solr
   */
  public String getSolrUrl(String solrClusterId) {
    Validator.isTrue((solrClusterId != null) && !solrClusterId.isEmpty(), "solrClusterId cannot be null or empty");
    return getEndPoint() + String.format(PATH_SOLR, solrClusterId);
  }

  /**
   * Gets and returns the ranked answers.
   *
   * @param rankerID The ranker ID
   * @param answers The CSV file that contains the search results that you want to rank.
   * @param topAnswers The number of top answers needed, default is 10
   * @return the ranking of the answers
   */
  public ServiceCall<Ranking> rank(final String rankerID, final File answers, Integer topAnswers) {
    Validator.isTrue((rankerID != null) && !rankerID.isEmpty(), "rankerID cannot be null or empty");
    Validator.notNull(answers, "answers file cannot be null");
    Validator.isTrue(answers.exists(), "answers file: " + answers.getAbsolutePath() + " not found");

    final okhttp3.MultipartBody.Builder builder = new MultipartBody.Builder()
        .setType(MultipartBody.FORM)
        .addPart(Headers.of(
            HttpHeaders.CONTENT_DISPOSITION, "form-data; name=\"answer_data\""),
            RequestBody.create(HttpMediaType.BINARY_FILE, answers));

    if (topAnswers != null) {
      builder.addFormDataPart(ANSWERS, topAnswers.toString());
    }

    final String path = String.format(PATH_RANK, rankerID);
    final Request request = RequestBuilder.post(path).body(builder.build()).build();
    return createServiceCall(request, ResponseConverterUtils.getObject(Ranking.class));
  }

  /**
   * Gets and returns the ranked answers.
   *
   * @param rankerID The ranker ID
   * @param answers The CSV input that contains the search results that you want to rank.
   * @param topAnswers The number of top answers needed, default is 10
   * @return the ranking of the answers
   */
  public ServiceCall<Ranking> rank(final String rankerID, final InputStream answers, Integer topAnswers) {
    Validator.isTrue((rankerID != null) && !rankerID.isEmpty(), "rankerID cannot be null or empty");
    Validator.notNull(answers, "answers file cannot be null");

    final ByteArrayOutputStream answersBuffer = new ByteArrayOutputStream();
    int bytesRead;
    final byte[] data = new byte[10000];
    try {
      while ((bytesRead = answers.read(data, 0, data.length)) != -1) {
        answersBuffer.write(data, 0, bytesRead);
      }
    } catch (final IOException e) {
      throw new RuntimeException("Error reading search results input", e);
    }

    final okhttp3.MultipartBody.Builder builder = new MultipartBody.Builder()
        .setType(MultipartBody.FORM)
        .addPart(Headers.of(
            HttpHeaders.CONTENT_DISPOSITION, "form-data; name=\"answer_data\""),
            RequestBody.create(HttpMediaType.BINARY_FILE, answersBuffer.toByteArray()));

    if (topAnswers != null) {
      builder.addFormDataPart(ANSWERS, topAnswers.toString());
    }

    final String path = String.format(PATH_RANK, rankerID);
    final Request request = RequestBuilder.post(path).body(builder.build()).build();
    return createServiceCall(request, ResponseConverterUtils.getObject(Ranking.class));
  }

  /*
   * (non-Javadoc)
   *
   * @see com.ibm.watson.developer_cloud.
   * retrieve_and_rank.v1.SolrConfigManager# uploadSolrClusterConfigurationDirectory(java.lang.String, java.lang.String,
   * java.io.File)
   */
  @Override
  public ServiceCall<Void> uploadSolrClusterConfigurationDirectory(String solrClusterId, String configName,
      File directory) {
    Validator.isTrue((solrClusterId != null) && !solrClusterId.isEmpty(), "solrClusterId cannot be null or empty");
    Validator.isTrue((configName != null) && !configName.isEmpty(), "configName cannot be null or empty");
    Validator.notNull(directory, "directory cannot be null");
    Validator.isTrue(directory.exists(), "directory: " + directory.getAbsolutePath() + " not found");
    Validator.isTrue(directory.isDirectory(), "directory is not a directory");

    final File zipFile = ZipUtils.buildConfigZip(configName, directory);
    final RequestBuilder requestBuilder = createUploadSolrConfigurationRequest(solrClusterId, configName, zipFile);
    return createServiceCall(requestBuilder.build(), new ResponseConverter<Void>() {

      @Override
      public Void convert(Response response) {
        if (!zipFile.delete()) {
          zipFile.deleteOnExit();
          LOG.log(Level.WARNING, "Unable to delete the Solr cluster configuration file.");
        }
        return null;
      }
    });
  }

  /*
   * (non-Javadoc)
   *
   * @see com.ibm.watson.developer_cloud.
   * retrieve_and_rank.v1.SolrConfigManager# uploadSolrClusterConfigurationZip(java.lang.String, java.lang.String,
   * java.io.File)
   */
  @Override
  public ServiceCall<Void> uploadSolrClusterConfigurationZip(String solrClusterId, String configName,
      File zippedConfig) {
    Validator.isTrue((solrClusterId != null) && !solrClusterId.isEmpty(), "solrClusterId cannot be null or empty");
    Validator.notNull(configName, "configName cannot be null");
    Validator.notNull(zippedConfig, "zippedConfig cannot be null");
    Validator.isTrue(zippedConfig.exists(), "zippedConfig: " + zippedConfig.getAbsolutePath() + " not found");
    Validator.isTrue(zippedConfig.isFile(), "directory is not a file");

    final RequestBuilder requestBuilder = createUploadSolrConfigurationRequest(solrClusterId, configName, zippedConfig);
    return createServiceCall(requestBuilder.build(), ResponseConverterUtils.getVoid());
  }

  private RequestBuilder createUploadSolrConfigurationRequest(String solrClusterId, String configName,
      File zippedConfig) {
    final String configPath = createConfigPath(solrClusterId, configName);
    final RequestBuilder requestBuilder = RequestBuilder.post(configPath);
    requestBuilder.body(RequestBody.create(MediaType.parse(HttpMediaType.APPLICATION_ZIP), zippedConfig));
    return requestBuilder;
  }

  /*
   * (non-Javadoc)
   *
   * @see com.ibm.watson.developer_cloud.
   * retrieve_and_rank.v1.ClusterLifecycleManager#resizeSolrCluster (java.lang.String)
   */
  @Override
  public ServiceCall<SolrClusterSizeResponse> resizeSolrCluster(String solrClusterId, int requestedSize) {
    Validator.isTrue((solrClusterId != null) && !solrClusterId.isEmpty(), "solrClusterId cannot be null or empty");
    Validator.isTrue((requestedSize > 0), "clusterSize cannot be lower than 0");

    final Request request = buildResizeRequest(solrClusterId, requestedSize);
    return createServiceCall(request, ResponseConverterUtils.getObject(SolrClusterSizeResponse.class));
  }

  /*
   * (non-Javadoc)
   *
   * @see com.ibm.watson.developer_cloud.
   * retrieve_and_rank.v1.ClusterLifecycleManager# getSolrClusterResizeStatus (java.lang.String)
   */
  @Override
  public ServiceCall<SolrClusterSizeResponse> getSolrClusterResizeStatus(String solrClusterId) {
    Validator.isTrue((solrClusterId != null) && !solrClusterId.isEmpty(), "solrClusterId cannot be null or empty");

    final Request request = buildGetSizeRequest(solrClusterId);
    return createServiceCall(request, ResponseConverterUtils.getObject(SolrClusterSizeResponse.class));
  }

  private Request buildResizeRequest(String solrClusterId, int desiredSize) {
    final String resizePath = createSizePath(solrClusterId);
    final SolrClusterResizeRequest resizeRequest = new SolrClusterResizeRequest(desiredSize);
    final RequestBuilder requestBuilder = RequestBuilder.put(resizePath);
    requestBuilder.bodyContent(GsonSingleton.getGsonWithoutPrettyPrinting().toJson(resizeRequest),
        HttpMediaType.APPLICATION_JSON);
    return requestBuilder.build();
  }

  private String createSizePath(String solrClusterId) {
    Validator.isTrue((solrClusterId != null) && !solrClusterId.isEmpty(), "solrClusterId cannot be null or empty");
    return String.format(PATH_SOLR_CLUSTERS_SIZE, solrClusterId);
  }

  private Request buildGetSizeRequest(String solrClusterId) {
    final String resizePath = createSizePath(solrClusterId);
    final RequestBuilder requestBuilder = RequestBuilder.get(resizePath);
    return requestBuilder.build();
  }
}
