package test.web.app.request.obj;

import com.github.toblerones.web.app.base.object.JsonMessageReqBase;

public class CaseBRequestObj extends JsonMessageReqBase{
	private String textTwo;

	public String getTextTwo() {
		return textTwo;
	}

	public void setTextTwo(String textTwo) {
		this.textTwo = textTwo;
	}
}	
