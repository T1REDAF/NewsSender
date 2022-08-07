package com.github.t1redaf.Exception;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class ExceptionController {

    @ExceptionHandler(NotFoundArticleException.class)
    public ResponseEntity<ErrorDto> notFoundHandle(Exception e){
        return new ResponseEntity<>(
                new ErrorDto(e.getLocalizedMessage(),HttpStatus.NOT_FOUND.value()),
                HttpStatus.NOT_FOUND
        );
    }

    @ExceptionHandler({BadConnectionException.class})
    public ResponseEntity<ErrorDto> ioHandle(Exception e){
        return new ResponseEntity<>(
                new ErrorDto(e.getLocalizedMessage(),HttpStatus.SERVICE_UNAVAILABLE.value()),
                HttpStatus.SERVICE_UNAVAILABLE
        );
    }
}
