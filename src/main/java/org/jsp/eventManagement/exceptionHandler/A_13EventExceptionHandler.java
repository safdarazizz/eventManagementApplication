package org.jsp.eventManagement.exceptionHandler;

import org.jsp.eventManagement.exceptionClasses.A_12NoEventFoundException;
import org.jsp.eventManagement.exceptionClasses.A_14InvalidEventIdException;
import org.jsp.eventManagement.responseStructure.A_5ResponseStructure;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class A_13EventExceptionHandler {
	
	@ExceptionHandler(A_12NoEventFoundException.class)
	public ResponseEntity<?> handleNoEventFoundException(A_12NoEventFoundException e)
	{
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(A_5ResponseStructure.builder().status(HttpStatus.BAD_REQUEST.value()).message("No Event Present in Database").body(e.getMessage()).build());
	}
	
	@ExceptionHandler(A_14InvalidEventIdException.class)
	public ResponseEntity<?> handleInvalidEventIdException(A_14InvalidEventIdException e)
	{
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(A_5ResponseStructure.builder().status(HttpStatus.BAD_REQUEST.value()).message("Event status can not be changed").body(e.getMessage()).build());
	}
}
