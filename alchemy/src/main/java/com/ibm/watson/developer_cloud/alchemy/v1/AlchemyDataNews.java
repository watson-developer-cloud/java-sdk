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
package com.ibm.watson.developer_cloud.alchemy.v1;

import java.util.HashMap;
import java.util.Map;

import com.ibm.watson.developer_cloud.alchemy.v1.model.DocumentsResult;
import com.ibm.watson.developer_cloud.alchemy.v1.model.VolumeResult;
import com.ibm.watson.developer_cloud.http.RequestBuilder;
import com.ibm.watson.developer_cloud.http.ServiceCall;
import com.ibm.watson.developer_cloud.service.AlchemyService;
import com.ibm.watson.developer_cloud.util.ResponseConverterUtils;
import com.ibm.watson.developer_cloud.util.Validator;

/**
 * AlchemyData News indexes 250k to 300k English language news and blog articles every day with historical search
 * available for the past 60 days.
 *
 * @version v1
 * @see <a href="https://alchemyapi.readme.io/v1.0/docs/rest-api-documentation"> Alchemy Data News</a>
 */
public class AlchemyDataNews extends AlchemyService {
  private static final String JSON = "json";
  private static final String NEWS_END_POINT = "/data/GetNews";

  /** The Constant COUNT (value is "count"). */
  public static final String COUNT = "count";

  /**
   * The Constant END. the time (in UTC seconds) of the end of the query duration (value is "end")
   */
  public static final String END = "end";

  /** The Constant String RETURN (value is "return"). */
  public static final String RETURN = "return";

  /**
   * The Constant START. the time (in UTC seconds) of the beginning of the query duration. (value is "start")
   */
  public static final String START = "start";

  /**
   * The Constant TIME_SLICE. the duration (in seconds) of each time slice (value is "timeSlice")
   */
  public static final String TIME_SLICE = "timeSlice";

  /**
   * Instantiates a new alchemy data news service.
   */
  public AlchemyDataNews() {
    super();
  }

  /**
   * Instantiates a new alchemy data news service by apiKey.
   *
   * @param apiKey the api key
   */
  public AlchemyDataNews(String apiKey) {
    super(apiKey);
  }

  /**
   * Gets the news documents.
   *
   * @param parameters the parameters
   * @return the news documents
   */
  public ServiceCall<DocumentsResult> getNewsDocuments(final Map<String, Object> parameters) {
    Validator.notNull(parameters.get(START), "start time cannot be null");
    Validator.notNull(parameters.get(END), "end time cannot be null");
    Validator.notNull(parameters.get(RETURN), "return cannot be null");

    // clone parameters, to prevent errors if the user continues to use the provided Map, or it is
    // immutable
    final Map<String, Object> parametersCopy = new HashMap<String, Object>(parameters);

    // Return json
    parametersCopy.put(OUTPUT_MODE, JSON);

    // Prevent jsonp to be returned
    parametersCopy.remove(JSONP);

    final RequestBuilder requestBuilder = RequestBuilder.get(NEWS_END_POINT);
    for (final String param : parametersCopy.keySet()) {
      requestBuilder.query(param, parametersCopy.get(param));
    }

    return createServiceCall(requestBuilder.build(), ResponseConverterUtils.getObject(DocumentsResult.class));
  }

  /**
   * Get a handle on how many documents are relevant for your query.
   *
   * @param start String the time (in UTC seconds) of the beginning of the query duration,
   * @param end String the time (in UTC seconds) of the end of the query duration.
   * @param timeSlice String the duration (in seconds) of each time slice.
   * @return {@link VolumeResult}
   */
  public ServiceCall<VolumeResult> getVolume(final String start, final String end, final String timeSlice) {
    Validator.notNull(start, "start time cannot be null");
    Validator.notNull(end, "end time cannot be null");

    final RequestBuilder requestBuilder = RequestBuilder.get(NEWS_END_POINT);

    requestBuilder.query(START, start);
    requestBuilder.query(END, end);
    requestBuilder.query(OUTPUT_MODE, JSON);
    if (timeSlice != null) {
      requestBuilder.query(TIME_SLICE, timeSlice);
    }
    return createServiceCall(requestBuilder.build(), ResponseConverterUtils.getObject(VolumeResult.class));
  }

}
