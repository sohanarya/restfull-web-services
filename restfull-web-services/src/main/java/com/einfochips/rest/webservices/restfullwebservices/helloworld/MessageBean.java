package com.einfochips.rest.webservices.restfullwebservices.helloworld;

public class MessageBean {

	private String message;

	public MessageBean(String message) {
		this.message=message;
	}

	public MessageBean() {
		// TODO Auto-generated constructor stub
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	@Override
	public String toString() {
		return "MessageBean [message=" + message + "]";
	}

}
