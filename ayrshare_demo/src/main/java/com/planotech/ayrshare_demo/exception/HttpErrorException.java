package com.planotech.ayrshare_demo.exception;

import org.springframework.http.HttpStatus;

public class HttpErrorException extends RuntimeException {
	private final HttpStatus status;

	public HttpErrorException(HttpStatus status, String message) {
		super(message);
		this.status = status;
	}

	public HttpStatus getStatus() {
		return status;
	}
}
