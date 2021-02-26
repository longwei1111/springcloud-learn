package com.lyh.coolw.eureka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@EnableEurekaServer
@SpringBootApplication
public class Eureka8703ServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(Eureka8703ServiceApplication.class, args);
    }

}