/*
 * *
 *  * Copyright 2015 IBM Corp. All Rights Reserved.
 *  *
 *  * Licensed under the Apache License, Version 2.0 (the "License");
 *  * you may not use this file except in compliance with the License.
 *  * You may obtain a copy of the License at
 *  *
 *  *      http://www.apache.org/licenses/LICENSE-2.0
 *  *
 *  * Unless required by applicable law or agreed to in writing, software
 *  * distributed under the License is distributed on an "AS IS" BASIS,
 *  * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  * See the License for the specific language governing permissions and
 *  * limitations under the License.
 *
 */

package com.ibm.watson.developer_cloud.alchemy_news.v1;

import com.ibm.watson.developer_cloud.alchemy_news.v1.Model.Result;
import com.ibm.watson.developer_cloud.alchemy_news.v1.Model.VolumeResult;
import com.ibm.watson.developer_cloud.service.AlchemyService;
import com.ibm.watson.developer_cloud.service.Request;
import com.ibm.watson.developer_cloud.util.GsonSingleton;
import com.ibm.watson.developer_cloud.util.ResponseUtil;
import com.ibm.watson.developer_cloud.util.Validate;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpRequestBase;

import java.io.IOException;
import java.util.Map;

/**
 * AlchemyData News indexes 250k to 300k English language news and blog articles every day with historical search available for the past 60 days.
 *
 * @author Nizar Alseddeg (nmalsedd@us.ibm.com)
 * @version v1
 * @see <a
 *      href="http://www.ibm.com/smarterplanet/us/en/ibmwatson/developercloud/alchemy-news.html">
 *      Speech to Text</a>
 */
public class AlchemyDataNews extends AlchemyService{
    // TODO how to deal with these queries
    // api doc https://alchemyapi.readme.io/v1.0/docs/rest-api-documentation

    private String NEWS_END_POINT = "/data/GetNews";

    /** The Constant OUT_PUT_MODE. desired API output format */
    private String RETURN = "return";

    /** The Constant START. the time (in UTC seconds) of the beginning of the query duration */
    private String START = "start";

    /** The Constant END. the time (in UTC seconds) of the end of the query duration */
    private String END = "end";

    /** The Constant TIME_SLICE. the duration (in seconds) of each time slice */
    private String TIME_SLICE = "timeSlice";

    /** The Constant OUT_PUT_MODE. desired API output format */
    public static final String OUT_PUT_MODE = "outputMode";

    /**  enum TIME FORMAT */
    public enum TimeFormat {s,m,h,d,M,y,NOW}

    public AlchemyDataNews() {
        setEndPoint(URL);;
    }

    /**
     * Calculates the sentiment for text, a URL or HTML.
     * @param parameters start String the time (in UTC seconds) of the beginning of the query duration,,
     *                   end String the time (in UTC seconds) of the end of the query duration.
     *                   timeSlice String the duration (in seconds) of each time slice.
     *                   count Integer number of results
     *                   return String This parameter specifies that we want to see the article titles and urls in the response.
     *                   (parameter String /value String ) Specify the targeted search. i.e.
      * @return the Result
     */
    public Result getNews(Map<String, Object> parameters) {
         Validate.notNull(parameters.get(START), "start time can't be null");
        Validate.notNull(parameters.get(END), "end time can't be null");
        Validate.notNull(parameters.get(RETURN), "return can't be null");
        Request request = Request.Get(NEWS_END_POINT);
        // What if they don't pass the return, any default value
        // default value for start. end and count, TimeSlice
        for (Map.Entry<String, Object> parameter : parameters.entrySet()) {
            String name = parameter.getKey();
            Object value = parameter.getValue();
            request.withQuery(name, value);
        }
        request.withQuery(OUT_PUT_MODE,"json");
        HttpRequestBase requestBase = request.build();
        try {
            HttpResponse response = execute(requestBase);
            String jsonString = ResponseUtil.getString(response);
            Result result = GsonSingleton.getGson().fromJson(
                    jsonString, Result.class);
            return result;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


    /**
     * Get a handle on how many documents are relevant for your query
     * @param start     String the time (in UTC seconds) of the beginning of the query duration,
     * @param end       String the time (in UTC seconds) of the end of the query duration.
     * @param timeSlice String the duration (in seconds) of each time slice.
     * @return the Corpus
     */
    public VolumeResult getVolume(final String start, final String end,final String timeSlice) {
        Validate.notNull(start, "start time can't be null");
        Validate.notNull(end, "end time can't be null");
        Request request = Request.Get(NEWS_END_POINT);

        request.withQuery(START, start);
        request.withQuery(END,end);
        request.withQuery(OUT_PUT_MODE, "json");
        if(timeSlice!=null)
            request.withQuery(TIME_SLICE,timeSlice);

        HttpRequestBase requestBase = request.build();
        try {
            HttpResponse response = execute(requestBase);
            String jsonString = ResponseUtil.getString(response);
            VolumeResult result = GsonSingleton.getGson().fromJson(
                    jsonString, VolumeResult.class);
            return result;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
