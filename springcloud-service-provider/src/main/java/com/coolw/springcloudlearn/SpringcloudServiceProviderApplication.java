package com.coolw.springcloudlearn;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
public class SpringcloudServiceProviderApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringcloudServiceProviderApplication.class, args);
    }

}
