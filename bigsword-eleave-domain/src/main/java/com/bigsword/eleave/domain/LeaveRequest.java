package com.bigsword.eleave.domain;

import java.util.Date;

public class LeaveRequest {
	
	private String requestedBy;
	private String requestedById;
	
	private Date fromDate;
	private Date ToDate;
	
	private String leaveType;
	private boolean isCoreLeave;
	
	private String status;
}
