package com.bigsword.eleave.web.processors.authentication;

import org.apache.log4j.Logger;

import com.bigsword.eleave.web.json.request.JsonLogonRequest;
import com.github.toblerones.web.app.base.processor.RequestProcessor;
import com.github.toblerones.web.app.context.WorkContext;

public class LogonProcessor implements RequestProcessor{

	final static Logger logger = Logger.getLogger(LogonProcessor.class);
	
	@Override
	public String process(WorkContext workContext) {
		JsonLogonRequest json = (JsonLogonRequest)workContext.getJsonRequestObjectFromContext();
		
		if(logger.isDebugEnabled()){
		    logger.debug("json cmd" + json.getCmd());
		    logger.debug("json Username" + json.getUsername());
		    logger.debug("json Password" + json.getPassword());
		}
		
		return "DONE";
	}

}
