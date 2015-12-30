package com.github.toblerones.web.app.context;

public class WorkContext extends Context{
	
	public <T> T getJsonRequestObjectFromContext(){
		return getRequestData(JSON_REQUEST_OBJECT);
	}
	public <T> T getJsonResponseObjectFromContext(){
		return getRequestData(JSON_RESPONSE_OBJECT);
	}
	public <T> void putJsonRequestObjectToContext(T jsonRequest){
		putRequestData(JSON_REQUEST_OBJECT, jsonRequest);
	}
	public <T> void putJsonResponseObjectToContext(T jsonResponse){
		putRequestData(JSON_RESPONSE_OBJECT, jsonResponse);
	}
	public <T> void putHttpServletRequestObjectToContext(T httpServletRequest){
		putRequestData(HTTP_SERVLET_REQUEST, httpServletRequest);
	}
}
