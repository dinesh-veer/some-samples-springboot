package com.spring.ratelimiterspringboot.config;

import io.github.bucket4j.Bandwidth;
import io.github.bucket4j.Bucket;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.Duration;

@Configuration
public class RateLimitingConfig {

    @Bean
    public Bucket rateLimitConfig(){

        Bandwidth limit =Bandwidth.builder()
                .capacity(5)
                .refillIntervally(5, Duration.ofMinutes(1))
                .build();

        return Bucket.builder().addLimit(limit).build();
    }
}
