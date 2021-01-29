package com.coolw.springcloudlearn;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableCircuitBreaker
//@EnableEurekaClient
@EnableDiscoveryClient
@SpringBootApplication
public class SpringcloudServiceConsumerApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringcloudServiceConsumerApplication.class, args);
    }

}
