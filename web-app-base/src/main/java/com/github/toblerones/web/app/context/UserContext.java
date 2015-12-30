package com.github.toblerones.web.app.context;

import java.util.HashMap;
import java.util.Map;

public class UserContext {

	private Map<String, Object> context = new HashMap<String, Object>();

	public Map<String, Object> getContext() {
		return context;
	}

	public void setContext(Map<String, Object> context) {
		this.context = context;
	}
}
