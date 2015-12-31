package com.github.toblerones.web.app.base.interceptor;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.Type;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.toblerones.annotation.WebAppRequestAnnotation;
import com.github.toblerones.base.gson.JsonObjectUtil;
import com.github.toblerones.web.app.base.interceptor.configuration.InterceptorConfigurationHelper;
import com.github.toblerones.web.app.base.object.JsonMessageReqBase;
import com.github.toblerones.web.app.base.object.JsonMessageRespBase;
import com.github.toblerones.web.app.base.processor.RequestProcessor;
import com.github.toblerones.web.app.context.WorkContext;

@Controller
public class JsonMsgController<T> {
	
	@Autowired
	private ApplicationContext context;
	
	@Autowired
	private WorkContext workContext;
	
//	private InterceptorConfigurationHelper interceptorConfigurationHelper;
	
	@Autowired(required = false)
	@Qualifier("customizedRequestBase")
	private T customizedRequestBase;
	
	@Autowired(required = false)
	@Qualifier("customizedResponseBase")
	private T customizedResponseBase;
	
	private final String defaultErrorResponse = "{\"responseStatus\":\"error\"}";
	
	//The @RequestMapping annotation ensures that HTTP requests to /msgchannel are mapped to the jsonInterceptor() method.
	// Accepts all kinds of http operation.
	@RequestMapping("/msgchannel")
	public @ResponseBody String msgInterceptor(@RequestBody String requestStr, HttpServletRequest request) {	
		try{
	    	String responseStr = defaultErrorResponse;
		    JsonMessageRespBase jsonResp = new JsonMessageRespBase();

		    String cmd = null; 
		    T jsonReq = null;
		    
		    // Uses annotation to get the CMD and determines the processor to be called
		    // Use default class if not provided.
		    if(customizedRequestBase == null){
		    	customizedRequestBase = (T) new JsonMessageReqBase();
		    }
		    
	    	// get the class type
	    	jsonReq = (T)JsonObjectUtil.convertStringToObject(requestStr, customizedRequestBase.getClass());
	    	
	    	Field[] fields = customizedRequestBase.getClass().getDeclaredFields(); //obtain field object
	    	for(Field field : fields){
	    		field.setAccessible(true);
    			Annotation[] annotations = field.getDeclaredAnnotations();

    			for(Annotation annotation : annotations){
    				if(annotation instanceof WebAppRequestAnnotation){
    					WebAppRequestAnnotation myAnnotation = (WebAppRequestAnnotation) annotation;
    			    	if(myAnnotation.isCMD()){
    			    		cmd = (String) field.get(jsonReq);
    			    		break;
    			    	}
    			    }
    			}
	    	}
		    
	    	InterceptorConfigurationHelper interceptorConfigurationHelper = new InterceptorConfigurationHelper();
	    	String requestObjName = interceptorConfigurationHelper.getRequestObjectClassByCmd(cmd);
	    	String requestProcessorName = interceptorConfigurationHelper.getRequestProcessorClassByCmd(cmd);
	    	
	 		try {
	 			jsonReq= (T) JsonObjectUtil.convertStringToObject(requestStr, requestObjName);
	 
			    RequestProcessor processor = (RequestProcessor) context.getBean(Class.forName(requestProcessorName));
			    
			    workContext.putJsonRequestObjectToContext(jsonReq);
			    workContext.putHttpServletRequestObjectToContext(request);
			
			    String result = processor.process(workContext);
			    System.out.println(result);
			    jsonResp = workContext.getJsonResponseObjectFromContext();
			} catch (Exception e){
				jsonResp.setErrorCode("GE0001");
				jsonResp.setResponseStatus("error");
				e.printStackTrace();			
			}

	 		jsonResp.setCmd(cmd);
	    	responseStr = JsonObjectUtil.convertObjectToString(jsonResp);
	        return responseStr;
			
		}catch(Exception e){
			e.printStackTrace();
			return defaultErrorResponse;
		}
	}
}
