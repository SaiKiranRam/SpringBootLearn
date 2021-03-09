package edu.user.learning.exceptions;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
public class AllExceptionsHandler {
	
	/*
	 * Handles all ResourceNotFoundException
	 */
	@ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity<?> handleResourceNotFoundException(ResourceNotFoundException exception, WebRequest req) {
		
		ErrorDetails errorDetails = new ErrorDetails(exception.getMessage(), new Date(), req.getDescription(false));
		
		return new ResponseEntity(errorDetails, HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler(Exception.class)
	public ResponseEntity<?> handleException(Exception exception, WebRequest req) {
		
		ErrorDetails errorDetails = new ErrorDetails(exception.getMessage(), new Date(), req.getDescription(false));
		
		return new ResponseEntity(errorDetails, HttpStatus.NOT_FOUND);
	}

//	@ExceptionHandler(Exception.class)
//	public ResponseEntity<?> handleException(Exception exception, WebRequest req) {
//		
//		ErrorDetails errorDetails = new ErrorDetails(exception.getMessage(), new Date(), req.getDescription(false));
//		
//		return new ResponseEntity(errorDetails, HttpStatus.NOT_FOUND);
//	}
}
