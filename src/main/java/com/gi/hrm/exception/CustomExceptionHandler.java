package com.gi.hrm.exception;

import java.util.Date;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.reactive.result.method.annotation.ResponseEntityExceptionHandler;

import com.gi.hrm.common.Constants;
import com.gi.hrm.dto.response.ErrorResponse;

import reactor.core.publisher.Mono;

@ControllerAdvice
public class CustomExceptionHandler extends ResponseEntityExceptionHandler {
	private Map<String, String> errors;

	@ExceptionHandler(BadCredentialsException.class)
	public final Mono<ResponseEntity<Object>> handleBadCredentialsException(BadCredentialsException ex) {
		String errorMessage = ex.getLocalizedMessage() != null ? ex.getLocalizedMessage() : Constants.CREDENTIAL_FALSE;
		ErrorResponse error = new ErrorResponse(HttpStatus.UNAUTHORIZED, new Date(), errorMessage, errors);

		return Mono.just(new ResponseEntity<Object>(error, HttpStatus.UNAUTHORIZED));
	}

	@ExceptionHandler(RecordNotFoundException.class)
	public final Mono<ResponseEntity<Object>> handleRecordNotFoundException(RecordNotFoundException ex) {
		String errorMessage = String.format(Constants.RECORD_NOT_FOUND, ex.getLocalizedMessage());
		ErrorResponse error = new ErrorResponse(HttpStatus.NOT_FOUND, new Date(), errorMessage, errors);

		return Mono.just(new ResponseEntity<Object>(error, HttpStatus.OK));
	}
}
