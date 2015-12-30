package test.web.app.request.obj;

import com.github.toblerones.annotation.WebAppRequestAnnotation;


public class CaseARequestBase {
	@WebAppRequestAnnotation(isCMD = true, remarks = "testRemark")
	private String request;

	private String detail;

	public String getRequest() {
		return request;
	}

	public String getDetail() {
		return detail;
	}

	public void setRequest(String request) {
		this.request = request;
	}

	public void setDetail(String detail) {
		this.detail = detail;
	}
	
	
}
