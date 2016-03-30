package com.ibm.watson.developer_cloud.service;

public abstract class AuthenticationStrategy {
	private String token;
	private String apiKey;
	private String serviceName;
	
	public void setApiKey(String a) {
		apiKey = a;
	}
	public String getApiKey() {
		return apiKey;
	}
	
	public void setToken(String t) {
		token = t;
	}
	public String getToken() {
		return token;
	}
	
	public void setServiceName(String n) {
		serviceName = n;
	}
	public String getServiceName() {
		return serviceName;
	}
	
	public abstract String refreshToken();
}
