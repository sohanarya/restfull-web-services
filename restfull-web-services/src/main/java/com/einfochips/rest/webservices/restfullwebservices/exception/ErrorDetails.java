package com.einfochips.rest.webservices.restfullwebservices.exception;

import java.time.LocalDateTime;

public class ErrorDetails {

	private LocalDateTime currentTime;
	private String message;
	private String errorescription;

	public ErrorDetails(LocalDateTime now, String message, String description) {
		super();
		this.currentTime=now;
		this.message=message;
		this.errorescription=description;
	}

	public LocalDateTime getCurrentTime() {
		return currentTime;
	}

	public String getMessage() {
		return message;
	}

	public String getErrorescription() {
		return errorescription;
	}
}
