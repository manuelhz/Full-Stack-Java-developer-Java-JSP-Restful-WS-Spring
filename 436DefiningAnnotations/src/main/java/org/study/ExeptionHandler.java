package org.study;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExeptionHandler {
	@ExceptionHandler(Exception.class)
	public String exeptionHandler(Exception ex) {
		return "error";
	}

}
