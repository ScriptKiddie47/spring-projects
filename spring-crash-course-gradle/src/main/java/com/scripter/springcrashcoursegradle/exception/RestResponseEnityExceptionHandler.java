package com.scripter.springcrashcoursegradle.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.scripter.springcrashcoursegradle.entity.ErrorMessage;

@ControllerAdvice
@ResponseStatus
public class RestResponseEnityExceptionHandler extends ResponseEntityExceptionHandler {

	@ExceptionHandler(DepartmentNotFoundException.class)
	public ResponseEntity<ErrorMessage> deparmentNotFoundException(
			DepartmentNotFoundException departmentNotFoundException, WebRequest request) {
		ErrorMessage eMessage = new ErrorMessage(HttpStatus.NOT_FOUND, departmentNotFoundException.getMessage());
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(eMessage);
	}
}
