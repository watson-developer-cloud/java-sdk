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
package com.ibm.watson.developer_cloud.alchemy.v1;

import java.util.Map;

import com.ibm.watson.developer_cloud.alchemy.v1.model.DocumentsResult;
import com.ibm.watson.developer_cloud.alchemy.v1.model.VolumeResult;
import com.ibm.watson.developer_cloud.http.RequestBuilder;
import com.ibm.watson.developer_cloud.service.AlchemyService;
import com.ibm.watson.developer_cloud.util.Validate;

/**
 * AlchemyData News indexes 250k to 300k English language news and blog articles every day with
 * historical search available for the past 60 days.
 * 
 * @author Nizar Alseddeg (nmalsedd@us.ibm.com)
 * @version v1
 * @see <a href="https://alchemyapi.readme.io/v1.0/docs/rest-api-documentation"> Alchemy Data
 *      News</a>
 */
public class AlchemyDataNews extends AlchemyService {

  /**
   * TIME FORMAT.
   */
  public static enum TimeFormat {

    /** The d. */
    d,
    /** The h. */
    h,
    /** The m. */
    m,
    /** The m. */
    M,
    /** The now. */
    NOW,
    /** The s. */
    s,
    /** The y. */
    y
  }

  /** The Constant COUNT. (value is "count") */
  public static final String COUNT = "count";

  /**
   * The Constant END. the time (in UTC seconds) of the end of the query duration
   */
  public static final String END = "end";

  /** The Constant NEWS_END_POINT. */
  private static final String NEWS_END_POINT = "/data/GetNews";

  /** The Constant RETURN. */
  public static final String RETURN = "return";

  /**
   * The Constant START. the time (in UTC seconds) of the beginning of the query duration
   */
  public static final String START = "start";

  /**
   * The Constant TIME_SLICE. the duration (in seconds) of each time slice
   */
  public static final String TIME_SLICE = "timeSlice";

  /**
   * Gets the news documents.
   * 
   * @param parameters the parameters
   * @return the news documents
   */
  public DocumentsResult getNewsDocuments(Map<String, Object> parameters) {
    Validate.notNull(parameters.get(START), "start time cannot be null");
    Validate.notNull(parameters.get(END), "end time cannot be null");
    Validate.notNull(parameters.get(RETURN), "return cannot be null");

    // Return json
    parameters.put(OUTPUT_MODE, "json");

    // Prevent jsonp to be returned
    parameters.remove(JSONP);

    final RequestBuilder requestBuilder = RequestBuilder.get(NEWS_END_POINT);
    for (final String param : parameters.keySet()) {
      requestBuilder.withQuery(param, parameters.get(param));
    }

    return executeRequest(requestBuilder.build(), DocumentsResult.class);
  }

  /**
   * Get a handle on how many documents are relevant for your query.
   * 
   * @param start String the time (in UTC seconds) of the beginning of the query duration,
   * @param end String the time (in UTC seconds) of the end of the query duration.
   * @param timeSlice String the duration (in seconds) of each time slice.
   * @return {@link VolumeResult}
   */
  public VolumeResult getVolume(final String start, final String end, final String timeSlice) {
    Validate.notNull(start, "start time cannot be null");
    Validate.notNull(end, "end time cannot be null");

    final RequestBuilder requestBuilder = RequestBuilder.get(NEWS_END_POINT);

    requestBuilder.withQuery(START, start);
    requestBuilder.withQuery(END, end);
    requestBuilder.withQuery(OUTPUT_MODE, "json");
    if (timeSlice != null)
      requestBuilder.withQuery(TIME_SLICE, timeSlice);

    return executeRequest(requestBuilder.build(), VolumeResult.class);
  }

}
