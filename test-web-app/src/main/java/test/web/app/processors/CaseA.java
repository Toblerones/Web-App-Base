package test.web.app.processors;

import com.github.toblerones.web.app.base.object.JsonMessageRespBase;
import com.github.toblerones.web.app.base.processor.RequestProcessor;
import com.github.toblerones.web.app.context.WorkContext;

import test.web.app.request.obj.CaseARequestObj;

public class CaseA implements RequestProcessor{

	@Override
	public String process(WorkContext workContext) {
		CaseARequestObj req = (CaseARequestObj)workContext.getJsonRequestObjectFromContext();
		System.out.println(req.getTextOne());
		JsonMessageRespBase resp = new JsonMessageRespBase();
		resp.setResponseStatus("success");
		workContext.putJsonResponseObjectToContext(resp);
		return "DONE";
	}

}
