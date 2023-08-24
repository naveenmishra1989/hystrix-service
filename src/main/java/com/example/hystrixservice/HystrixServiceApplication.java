package com.example.hystrixservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;

@EnableHystrix
@SpringBootApplication
public class HystrixServiceApplication {


    public static void main(String[] args) {
        SpringApplication.run(HystrixServiceApplication.class, args);
    }

}
