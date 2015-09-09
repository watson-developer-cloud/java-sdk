package com.ibm.watson.developer_cloud.service;

import org.apache.http.client.methods.HttpRequestBase;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.params.BasicHttpParams;
import org.apache.http.params.HttpParams;

import java.net.URI;

/**
 * Created by Nizar Alseddeg nmalsedd@us.ibm.com.
 */
public class AlchemyService extends WatsonService{

    /** The url. */
    public final static String URL = "https://access.alchemyapi.com/calls";

    @Override
    protected void setAuthentication(HttpRequestBase request){
            if (getApiKey() == null)
                throw new IllegalArgumentException(
                        "apiKey not specified");
            else {
                StringBuilder apiKeyToken = new StringBuilder();
                apiKeyToken.append("apikey").append("=").append(getApiKey());
                addApiKeyHttpUriRequest(request, apiKeyToken.toString());

            }

    }

    private void addApiKeyHttpUriRequest(HttpRequestBase request,String apiKeyToken){
            String query=request.getURI().getQuery();
            if (query == null || query.length() == 0) {
                request.setURI(URI.create(request.getURI() + "?" + apiKeyToken));
            }
            else {
                request.setURI(URI.create(request.getURI() + "&" + apiKeyToken));
            }
    }

}
