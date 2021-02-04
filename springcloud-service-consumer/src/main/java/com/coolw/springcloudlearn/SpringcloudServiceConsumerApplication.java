package com.coolw.springcloudlearn;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * "@EnableEurekaClient"：Eureka注册中心，推荐使用
 * "@EnableDiscoveryClient"：其他注册中心，推荐使用
 * "@EnableCircuitBreaker":断路器
 */
@EnableCircuitBreaker
@EnableEurekaClient
@SpringBootApplication
public class SpringcloudServiceConsumerApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringcloudServiceConsumerApplication.class, args);
    }

}
