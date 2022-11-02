package com.einfochips.rest.webservices.restfullwebservices.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code=HttpStatus.NOT_FOUND)
public class UserNotFoundException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 749745943039128976L;

	public UserNotFoundException(String message)
	{
		super(message);
	}
}
