package com.planotech.ayrshare_demo.exception;

import org.springframework.http.HttpStatus;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(HttpErrorException.class)
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	public String handleHttpErrorException(HttpErrorException ex, Model model) {
		model.addAttribute("fail", "HTTP Error: " + ex.getMessage());
		return "error"; // Specify the error page in your templates
	}

	@ExceptionHandler(Exception.class)
	@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
	public String handleOtherExceptions(Exception ex, Model model) {
		model.addAttribute("fail", "An unexpected error occurred: " + ex.getMessage());
		return "error"; // Specify the error page in your templates
	}
}