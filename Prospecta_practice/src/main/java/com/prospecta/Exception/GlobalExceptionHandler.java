package com.prospecta.Exception;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;


@RestControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(NotFoundException.class)
	public ResponseEntity<ErrorDetails> notFoundException(NotFoundException be, WebRequest webReq) {

		ErrorDetails red = new ErrorDetails();
		red.setTimeStamp(LocalDateTime.now());
		red.setMsg(be.getMessage());
		red.setDetails(webReq.getDescription(false));

		return new ResponseEntity<ErrorDetails>(red, HttpStatus.BAD_REQUEST);
	}
}
