package org.jsp.app.excepptionhandler;

import org.jsp.app.exception.InvalidDataException;
import org.jsp.app.exception.NoElementsFoundException;
import org.jsp.app.structure.ResponseStructure;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class BillsExceptionHandler {
	
	@ExceptionHandler(InvalidDataException.class)
	public ResponseEntity<?> invalidException(InvalidDataException e){
		return ResponseEntity.status(HttpStatus.BAD_REQUEST.value()).body(ResponseStructure.builder().httpcode(HttpStatus.BAD_REQUEST.value())
				.message("Wrong Input Data").body(e.toString()).build());
	}
	@ExceptionHandler(NoElementsFoundException.class)
	public ResponseEntity<?> noElementsFoundException(NoElementsFoundException e){
		return ResponseEntity.status(HttpStatus.NOT_FOUND.value()).body(ResponseStructure.builder().httpcode(HttpStatus.NOT_FOUND.value())
				.message("No Such Element Found").body(e.toString()).build());
	}
}
