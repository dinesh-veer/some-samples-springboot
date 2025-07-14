package com.spring.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PropertiesController {

    @Value("${name.properties}")
    public String name;
    @Autowired
    AppConfig appConfig;

    @GetMapping("/")
    public String getMessageFromProperties() {
        return "Got the message from Properties "+ name;
    }

    @GetMapping("/loadProd")
    public ResponseEntity<AppConfig> getAppConfig() {

        return appConfig != null ? ResponseEntity.ok(appConfig) : ResponseEntity.notFound().build();
    }
}
