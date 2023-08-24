package com.example.hystrixservice.controller;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class HystrixController {


    //localhost:8090/check
    @GetMapping("/check")
    @HystrixCommand(fallbackMethod = "fallBack")
    public ResponseEntity<String> getHystrixService() {
        RestTemplate restTemplate = new RestTemplate();
        String fooResourceUrl
                = "http://localhost:8080/spring-rest/foos";
        ResponseEntity<String> response
                = restTemplate.getForEntity(fooResourceUrl + "/1", String.class);
        return response;
    }

    public ResponseEntity<String> fallBack() {
        return ResponseEntity.ok("Currently server is down");
    }


}
