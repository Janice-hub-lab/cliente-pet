package dev.wakandaacademy.produdoro.handler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.apache.commons.logging.Log;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import lombok.extern.log4j.Log4j2;

@RestControllerAdvice
@Log4j2

public class RestResponseEntityExceptionHandler {
	@ExceptionHandler(APIException.class)
	public ResponseEntity<ErrorApiResponse>handlerGenericException(APIException ex) {
		return ex.buildErrorResponseEntity();
	
	}
	@ExceptionHandler(Exception.class)
	public ResponseEntity<ErrorApiResponse>handlerGenericException(Exception ex) {
		
		Log.error("Exception: ",ex);
		return ResponseEntity
				.status(HttpStatus.INTERNAL_SERVER_ERROR)
				.body(ErrorApiResponse
						.description("INTERNAL_SERVER_ERROR!")
						.message("POR FAVOR INFORME AO ADMINISTRADOR DO SISTEMA")
						.builder());
		
	}

}
