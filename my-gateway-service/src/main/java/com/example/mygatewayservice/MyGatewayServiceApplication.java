package com.example.mygatewayservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class MyGatewayServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(MyGatewayServiceApplication.class, args);
    }

}
