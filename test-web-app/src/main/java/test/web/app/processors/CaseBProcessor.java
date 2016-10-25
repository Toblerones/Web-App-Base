package test.web.app.processors;

import com.github.toblerones.web.app.base.processor.RequestProcessor;
import com.github.toblerones.web.app.context.WorkContext;
import test.web.app.request.obj.CaseBRequestObj;
import test.web.app.request.obj.CaseBResponseObj;

public class CaseBProcessor implements RequestProcessor{

	@Override
	public String process(WorkContext workContext) {
		if(workContext.getRequestData("RequestData") != null){
			
			workContext.putRequestData("RequestData",(Integer)workContext.getRequestData("RequestData")+1 );
		}else{
			workContext.putRequestData("RequestData", 1);
		}
		
		if(workContext.getUserData("UserData") != null){
			
			workContext.putUserData("UserData",(Integer)workContext.getUserData("UserData")+1 );
		}else{
			workContext.putUserData("UserData", 1);
		}
//		
//		System.out.println("RequestData = [ " + (int)workContext.getRequestData("RequestData") + "]");
//		System.out.println("UserData = [ " + (int)workContext.getUserData("UserData") + "]");
		
		CaseBRequestObj req = (CaseBRequestObj)workContext.getJsonRequestObjectFromContext();
		CaseBResponseObj resp = new CaseBResponseObj();
		resp.setFieldA("get TextOne data: [" + req.getTextOne() + "]");
		resp.setResponseStatus("success");
		workContext.putJsonResponseObjectToContext(resp);
		return "DONE";
	}

}
