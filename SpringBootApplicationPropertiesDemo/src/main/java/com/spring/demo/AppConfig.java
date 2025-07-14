package com.spring.demo;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix="properties")
@Getter
@Setter
public class AppConfig {
    private String name;
    private int timeout;//not stored initialised to default value
    private float javaVersion;
    private String springBootVersion;
}
