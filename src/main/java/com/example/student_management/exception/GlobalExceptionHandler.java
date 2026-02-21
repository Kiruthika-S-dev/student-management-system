package com.example.student_management.exception;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {
	
	// Handle Validation Errors (@Valid)
	@ExceptionHandler(MethodArgumentNotValidException.class) // (RuntimeException.class)
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	public Map<String, String>handleValidationExceptions(MethodArgumentNotValidException ex){
		Map<String, String> errors = new HashMap<>();
		ex.getBindingResult().getFieldErrors().forEach(error ->
		errors.put(error.getField(), error.getDefaultMessage())
		);
		return errors;
	}
	
	// handle runtime errors (student not found)
	@ExceptionHandler(RuntimeException.class)
	@ResponseStatus(HttpStatus.NOT_FOUND)
	public Map<String, String>handleRuntimeException(RuntimeException ex){
		Map<String, String> error = new HashMap<>();
		error.put("message", ex.getMessage());
		return error;
	}
		/*public ResponseEntity<String> handleRuntimeException(RuntimeException ex) {
			return new ResponseEntity<>(ex.getMessage(), HttpStatus.NOT_FOUND);
		}*/
	}