package com.github.toblerones.web.app.base.object;

import com.github.toblerones.annotation.WebAppRequestAnnotation;

public class JsonMessageReqBase {
	@WebAppRequestAnnotation(isCMD = true, remarks = "testRemark")
	private String cmd = null;

	public String getCmd() {
		return cmd;
	}

	public void setCmd(String cmd) {
		this.cmd = cmd;
	}
}
