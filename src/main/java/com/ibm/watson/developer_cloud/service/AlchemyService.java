package com.ibm.watson.developer_cloud.service;

import java.net.URI;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpRequestBase;

import com.google.gson.JsonObject;
import com.ibm.watson.developer_cloud.util.ResponseUtil;

/**
 * Abstract class which has functionality for the different Alchemy services
 * Created by Nizar Alseddeg nmalsedd@us.ibm.com.
 */
public abstract class AlchemyService extends WatsonService{

    /** The Alchemy endpoint.
     *  (value is "https://access.alchemyapi.com/calls")
     */
    protected final static String ENDPOINT = "https://access.alchemyapi.com/calls";

	// Output mode will be always json and jsonp should not be used
	protected static final String OUTPUT_MODE = "outputMode";
	protected static final String JSONP = "jsonp";

    /* (non-Javadoc)
     * @see com.ibm.watson.developer_cloud.service.WatsonService#setAuthentication(org.apache.http.client.methods.HttpRequestBase)
     */
    @Override
    protected void setAuthentication(HttpRequestBase request){
            if (getApiKey() == null)
                throw new IllegalArgumentException(
                        "apiKey not specified");
            else {
                StringBuilder apiKeyToken = new StringBuilder();
                apiKeyToken.append("apikey").append("=").append(getApiKey());
                addApiKeyToHttpRequest(request, apiKeyToken.toString());

            }

    }

    /**
     * Adds the Alchemy api key to http request.
     *
     * @param request the http request
     * @param apiKey the api key token
     */
    private void addApiKeyToHttpRequest(HttpRequestBase request,String apiKey){
            String query=request.getURI().getQuery();
            if (query == null || query.length() == 0) {
                request.setURI(URI.create(request.getURI() + "?" + apiKey));
            }
            else {
                request.setURI(URI.create(request.getURI() + "&" + apiKey));
            }
    }

	/**
	 * Returns the first non-null accepted format from the parameter map
	 * @param params the request parameters
	 * @param acceptedFormats the accepted formats
	 * @return the first accepted format found in the map
	 */
	protected String getInputFormat(Map<String, Object> params, String... acceptedFormats) {
		int i = 0;
		while (i < acceptedFormats.length && params != null && !params.containsKey(acceptedFormats[i]))
			i++;
		
		if (params == null || i == acceptedFormats.length)
			throw new IllegalArgumentException(StringUtils.join(acceptedFormats, ",") + " should be specified");
		return acceptedFormats[i];
	}
	
    /**
     * Instantiates a new alchemy service.
     */
    public AlchemyService() {
		setEndPoint(ENDPOINT);
	}
    
	/**
	 * Gets the error message from a JSON response
	 *
	 * <pre>
	 * {
	 *   code: 400
	 *   error: 'bad request'
	 * }
	 * </pre>
	 *
	 * @param response
	 *            the HTTP response
	 * @return the error message from the json object
	 */
	@SuppressWarnings("unused")
	private String getErrorMessage(HttpResponse response) {
		JsonObject error = null, jsonResponse = null;

		try {
			jsonResponse = ResponseUtil.getJsonObject(response);
		} catch (Exception e) {}
		
		if (jsonResponse != null && !jsonResponse.get("status").getAsString().equalsIgnoreCase("OK")) {
			error = new JsonObject();
			error.addProperty("error", jsonResponse.get("statusInfo").getAsString());
			error.addProperty("code", "400");
			return error.toString();
		} else 
			return null;
	}

	
//    /* (non-Javadoc)
//     * @see com.ibm.watson.developer_cloud.service.WatsonService#execute(org.apache.http.client.methods.HttpRequestBase)
//     */
//    @Override
//    protected HttpResponse execute(HttpRequestBase request) {
//    	HttpResponse response = super.execute(request);
//		String error = getErrorMessage(response);
//		if (error == null)
//			return response;
//		else
//			throw new BadRequestException(error);
//    }
}
