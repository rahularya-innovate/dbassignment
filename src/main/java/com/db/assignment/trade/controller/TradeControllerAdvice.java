package com.db.assignment.trade.controller;

import com.db.assignment.trade.exception.NotValidTradeException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.LocalDateTime;
import java.util.LinkedHashMap;
import java.util.Optional;
import java.util.Map;

@ControllerAdvice
@RequestMapping(produces = "application/vnd.error+json")
public class TradeControllerAdvice extends ResponseEntityExceptionHandler{
    
	@ExceptionHandler(NotValidTradeException.class)
    public ResponseEntity<Object> notFoundException(final NotValidTradeException e) {
        return error(e, HttpStatus.NOT_ACCEPTABLE, e.getId());
    }

    private ResponseEntity<Object> error(
            final Exception exception, final HttpStatus httpStatus, final String logRef) {
        
    	final String message =
                Optional.of(exception.getMessage()).orElse(exception.getClass().getSimpleName());
        
        Map<String, Object> body = new LinkedHashMap<>();
        body.put("timestamp", LocalDateTime.now());
        body.put("message", message);

        return new ResponseEntity<>(body, httpStatus);
    }

    



}
