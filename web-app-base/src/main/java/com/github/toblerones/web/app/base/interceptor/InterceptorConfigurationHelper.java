package com.github.toblerones.web.app.base.interceptor;

import java.util.Map;

public class InterceptorConfigurationHelper {

	private Map<String, String> objectsName;
	private Map<String, String> requestProcessorsName;
	
	public String getRequestObjectName(String cmd) {
	
		return objectsName.get(cmd);
	}

	public String getRequestProcessorName(String cmd) {
		// TODO Auto-generated method stub
		return requestProcessorsName.get(cmd);
	}

	public void setObjectsName(Map<String, String> objectsName) {
		this.objectsName = objectsName;
	}

	public void setRequestProcessorsName(Map<String, String> requestProcessorsName) {
		this.requestProcessorsName = requestProcessorsName;
	}

	

}
