/**
 * Module: roulette
 */
package com.game.play.roulette.exception;

import org.apache.commons.lang3.StringUtils;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

/**
 * 
 * ApplicationExceptionHandler.java - This class is Global exception handler and intercepts requests on all rest
 * controller
 * 
 * 
 * @since 23 Sep 2018
 */
@ControllerAdvice
@RestController
@Order(Ordered.HIGHEST_PRECEDENCE)
public class ApplicationExceptionHandler extends ResponseEntityExceptionHandler {

    // private final static Logger LOGGER = LoggerFactory.getLogger(ApplicationExceptionHandler.class);

    @Override
    protected ResponseEntity<Object> handleHttpMessageNotReadable(HttpMessageNotReadableException ex, HttpHeaders headers,
            HttpStatus status, WebRequest request) {

        String error = "Malformed JSON request";
        return new ResponseEntity<>(new ApiError(HttpStatus.BAD_REQUEST, error, ex), HttpStatus.BAD_REQUEST);
    }

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(
            MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {

        String error = "Validation failed";

        return new ResponseEntity<>(new ApiError(HttpStatus.BAD_REQUEST, error, getValidationErrorMessages(ex)), HttpStatus.BAD_REQUEST);
    }

    private String getValidationErrorMessages(MethodArgumentNotValidException ex) {
        StringBuffer buffer = new StringBuffer();

        for (ObjectError objectError : ex.getBindingResult().getAllErrors()) {
            buffer.append(objectError.getDefaultMessage()).append(",");
        }

        return StringUtils.chop(buffer.toString());
    }

}
