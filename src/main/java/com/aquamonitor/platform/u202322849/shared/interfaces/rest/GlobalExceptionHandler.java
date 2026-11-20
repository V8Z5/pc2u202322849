package com.aquamonitor.platform.u202322849.shared.interfaces.rest;

import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.ErrorResponse;

/**
 * Localizes malformed JSON and unexpected errors without exposing database details.
 * @author Marlon Packard Viza Quispe
 */
@RestControllerAdvice
public class GlobalExceptionHandler {
    private static final Logger LOG = LoggerFactory.getLogger(GlobalExceptionHandler.class);
    private final ErrorResponses errors;

    public GlobalExceptionHandler(ErrorResponses errors) { this.errors = errors; }

    @ExceptionHandler(HttpMessageNotReadableException.class)
    public ResponseEntity<MessageResource> invalid() { return errors.response(400, "invalid"); }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<MessageResource> unexpected(Exception ex) {
        if (ex instanceof ErrorResponse problem && problem.getStatusCode().is4xxClientError())
            return errors.response(problem.getStatusCode().value(), "invalid");
        LOG.error("Unexpected request failure", ex);
        return errors.response(500, "internal");
    }
}
