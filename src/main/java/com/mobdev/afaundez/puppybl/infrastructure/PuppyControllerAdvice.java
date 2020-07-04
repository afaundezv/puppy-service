package com.mobdev.afaundez.puppybl.infrastructure;

import com.mobdev.afaundez.puppybl.subbreed.core.exceptions.PuppySubBreedException;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@Order(Ordered.HIGHEST_PRECEDENCE)
@ControllerAdvice(annotations = RestController.class)
public class PuppyControllerAdvice extends ResponseEntityExceptionHandler {


    @ExceptionHandler(PuppySubBreedException.class)
    public ResponseEntity<PuppyError> subBreedNotExist(PuppySubBreedException e) {
        return new ResponseEntity<>(new PuppyError(e.getStatus(), e.getMessage(), e.getCode()), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(HttpClientErrorException.class)
    public ResponseEntity<PuppyError> HttpClientErrorException(HttpClientErrorException e) {
        PuppyError puppyError = new PuppyError("error", "Breed not found (master breed does not exist)", e.getStatusCode().value());
        return new ResponseEntity<>(puppyError, e.getStatusCode());
    }


}
