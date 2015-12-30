package com.github.toblerones.web.app.context;

import org.springframework.beans.factory.annotation.Autowired;

public class Context {
	
	public static final String JSON_REQUEST_OBJECT = "json_request_object";
	public static final String JSON_RESPONSE_OBJECT = "json_response_object";
	public static final String HTTP_SERVLET_REQUEST = "http_servlet_request";
	
	@Autowired
	private UserContext userContext;
	@Autowired
	private RequestContext requestContext;

	@SuppressWarnings("unchecked")
	public <T> T getUserData(String key) {
		return (T) userContext.getContext().get(key);
	}

	@SuppressWarnings("unchecked")
	public <T> T getRequestData(String key) {
		return (T) requestContext.getContext().get(key);
	}
	
	public <T> void putUserData(String key, T data) {
		userContext.getContext().put(key, data);
	}
	
	public <T> void putRequestData(String key, T data) {
		requestContext.getContext().put(key, data);
	}
}
