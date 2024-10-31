package com.colak.springtutorial.config;

import io.micrometer.core.instrument.Counter;
import io.micrometer.core.instrument.MeterRegistry;
import jakarta.annotation.PostConstruct;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

// This class shows that we can create prometheus objects globally
@Component
@RequiredArgsConstructor
@Getter
public class MicrometerCounterConfig {
    private Counter requestErrorCount;
    private Counter orderCount;

    private final MeterRegistry registry;

    @PostConstruct
    private void init() {
        requestErrorCount = registry.counter("requests_error_total", "status", "error");
        orderCount = registry.counter("order_request_count", "order", "test-svc");
    }
}
