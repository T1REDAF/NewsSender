package com.github.t1redaf.Exception;

import lombok.AllArgsConstructor;
import lombok.Value;
import org.springframework.http.HttpStatus;

@Value
@AllArgsConstructor
public class ErrorDto {
    private String error;
    private int httpStatus;
}
