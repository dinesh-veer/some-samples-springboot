package com.spring.callerservice.controller;


import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@RestController
public class CallingController {

    final private RestTemplate restTemplate;
    final private WebClient.Builder webClientBuilder;

    public CallingController(RestTemplate restTemplate,
                             WebClient.Builder webClientBuilder) {
        this.restTemplate = restTemplate;
        this.webClientBuilder = webClientBuilder;
    }
    @GetMapping("/getLimit")
    public ResponseEntity<String> getLimitInfo(){
        String apiUrl = "http://limit-service/limit";
        return restTemplate.getForEntity(apiUrl, String.class);

    }

    @GetMapping("/getLimitConfig")
    public Mono<String> getLimitConfig(){
        return webClientBuilder.build()
                .get()
                .uri("http://limit-service/limitConfig")
                .retrieve()
                .bodyToMono(String.class);
    }
}