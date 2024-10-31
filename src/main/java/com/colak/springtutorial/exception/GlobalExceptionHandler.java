package com.colak.springtutorial.exception;

import com.colak.springtutorial.config.MicrometerCounterConfig;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
@RequiredArgsConstructor
public class GlobalExceptionHandler {

    private final MicrometerCounterConfig micrometerCounterConfig;

    @ResponseBody
    @ExceptionHandler(value = Exception.class)
    public String handle(Exception exception) {
        micrometerCounterConfig.getRequestErrorCount().increment();
        return "error, message: " + exception.getMessage();
    }
}
