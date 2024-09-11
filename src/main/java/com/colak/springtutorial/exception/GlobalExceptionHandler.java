package com.colak.springtutorial.exception;

import com.colak.springtutorial.config.PrometheusCustomMonitor;
import jakarta.annotation.Resource;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
@RequiredArgsConstructor
public class GlobalExceptionHandler {

    private final PrometheusCustomMonitor monitor;

    @ResponseBody
    @ExceptionHandler(value = Exception.class)
    public String handle(Exception exception) {
        monitor.getRequestErrorCount().increment();
        return "error, message: " + exception.getMessage();
    }
}
