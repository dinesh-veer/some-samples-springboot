package com.spring.authtokengeneration.controller;

import com.spring.authtokengeneration.model.AuthRequest;
import com.spring.authtokengeneration.model.AuthResponse;
import com.spring.authtokengeneration.util.JwtUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@Slf4j
@RestController
@RequestMapping("/api")
public class AuthController {

    private final JwtUtil jwtUtil;

    public AuthController(JwtUtil jwtUtil) {
        this.jwtUtil = jwtUtil;
    }

    @PostMapping("/login")
    public ResponseEntity<?> getToken(@RequestBody AuthRequest authRequest) {
        if ("admin".equals(authRequest.getUsername()) && "password".equals(authRequest.getPassword())) {
            String token = jwtUtil.generateToken(authRequest.getUsername());
            return ResponseEntity.ok(new AuthResponse(token));
        } else {
            return ResponseEntity.status(401).body(Map.of("message", "Invalid credentials"));
        }
    }

    @GetMapping("/data")
    public ResponseEntity<?> getData(@RequestHeader("Authorization") String authHeader) {
        if (authHeader == null || !authHeader.startsWith("Bearer ")) {
            return ResponseEntity.status(401).body("Missing or invalid Authorization header");
        }

        try {
            String token = authHeader.substring(7);
            String username = jwtUtil.validateTokenAndGetUsername(token);
            return ResponseEntity.ok(Map.of("message", "Successful response", "user", username));
        } catch (Exception e) {
            log.error("Error validating token {}", e.getMessage());
            return ResponseEntity.status(403).body("Invalid token");
        }
    }
}

