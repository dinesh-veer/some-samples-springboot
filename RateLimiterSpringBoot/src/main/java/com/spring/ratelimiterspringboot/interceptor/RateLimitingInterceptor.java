package com.spring.ratelimiterspringboot.interceptor;

import io.github.bucket4j.Bucket;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

@Component
public class RateLimitingInterceptor implements HandlerInterceptor {

    private final Bucket apiRequestBucket;

    @Autowired
    public RateLimitingInterceptor(Bucket apiRequestBucket) {
        this.apiRequestBucket = apiRequestBucket;
    }

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        // Try to consume one token. If no token is available, deny the request.
        if (apiRequestBucket.tryConsume(1)) {
            return true; // Request allowed
        } else {
            // Request denied - set HTTP 429 Too Many Requests status
            response.setStatus(HttpStatus.TOO_MANY_REQUESTS.value());
            response.getWriter().write("You have exceeded your API request limit.");
            return false; // Request not allowed
        }
    }
}