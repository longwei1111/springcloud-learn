package com.coolw.springcloudlearn;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@SpringBootApplication
public class SpringcloudFeignServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringcloudFeignServiceApplication.class, args);
    }

}
