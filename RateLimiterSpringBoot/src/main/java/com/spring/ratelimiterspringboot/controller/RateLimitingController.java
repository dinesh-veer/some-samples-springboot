package com.spring.ratelimiterspringboot.controller;

import io.github.bucket4j.Bucket;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class RateLimitingController {

//    private Bucket bucket;

    @GetMapping("/data")
    public ResponseEntity<String> getData( ) {

  //      if (bucket.tryConsume(1)) {
            return ResponseEntity.ok("✅ Allowed: Here is your data!");
//        } else {
//            return ResponseEntity.status(HttpStatus.TOO_MANY_REQUESTS)
//                    .body("❌ Rate limit exceeded. Try again later.");
//        }
    }
}
