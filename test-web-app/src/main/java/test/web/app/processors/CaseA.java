package test.web.app.processors;

import com.github.toblerones.web.app.base.processor.RequestProcessor;
import com.github.toblerones.web.app.context.WorkContext;

import test.web.app.request.obj.CaseARequestObj;
import test.web.app.request.obj.CaseAResponseObj;

public class CaseA implements RequestProcessor{

	@Override
	public String process(WorkContext workContext) {
		if(workContext.getRequestData("checkpoint1") != null){
			System.out.println((int)workContext.getRequestData("checkpoint1"));
			workContext.putRequestData("checkpoint1",(int)workContext.getRequestData("checkpoint1")+1 );
		}else{
			workContext.putRequestData("checkpoint1", 1);
		}
		
		CaseARequestObj req = (CaseARequestObj)workContext.getJsonRequestObjectFromContext();
		CaseAResponseObj resp = new CaseAResponseObj();
		resp.setFieldA("get TextOne data: [" + req.getTextOne() + "]");
		resp.setResponseStatus("success");
		workContext.putJsonResponseObjectToContext(resp);
		return "DONE";
	}

}
