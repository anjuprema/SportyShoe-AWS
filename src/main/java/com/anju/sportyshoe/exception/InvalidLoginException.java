package com.anju.sportyshoe.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value=HttpStatus.NOT_FOUND)
public class InvalidLoginException extends RuntimeException {
	
	public static final long serialVersionUID = 1L;
	
	public InvalidLoginException(String message) {
		super(message);
	}
}
