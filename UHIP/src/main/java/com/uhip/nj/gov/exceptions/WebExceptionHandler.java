package com.uhip.nj.gov.exceptions;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@Configuration
@ControllerAdvice
public class WebExceptionHandler {
	@ExceptionHandler(UhipAdminWebException.class)
	public String handleUhipAdminWebException() {
		return "errorJsp";
	}

}
