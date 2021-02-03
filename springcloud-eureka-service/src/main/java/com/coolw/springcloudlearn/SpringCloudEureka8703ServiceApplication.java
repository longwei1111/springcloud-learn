package com.coolw.springcloudlearn;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@EnableEurekaServer
@SpringBootApplication
public class SpringCloudEureka8703ServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringCloudEureka8703ServiceApplication.class, args);
    }

}
