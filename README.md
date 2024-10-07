# Read Me First

The original idea is from  
https://erkanyasun.medium.com/spring-boot-3-3-embracing-the-latest-features-and-future-prospects-ebd76645a447

# Prometheus
http://localhost:8080/actuator/prometheus

We can get a counter by

- MeterRegistry registry.counter() method

```
Counter counter = MeterRegistry registry.counter(name,tags)
```
- Or by Counter.builder method

```
Counter.builder("counter_read_get")
                .description("The number of requests to /read endpoint")
                .tag("region", "us-east")
                .register(meterRegistry);
```

