package com.anju.sportyshoe.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value=HttpStatus.IM_USED)
public class DuplicateUserException extends RuntimeException {
	
	public static final long serialVersionUID = 1L;
	
	public DuplicateUserException(String message) {
		super(message);
	}
}
