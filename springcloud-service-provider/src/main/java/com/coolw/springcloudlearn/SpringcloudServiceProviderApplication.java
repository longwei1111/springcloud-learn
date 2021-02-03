package com.coolw.springcloudlearn;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * "@EnableEurekaClient"：Eureka注册中心，推荐使用
 * "@EnableDiscoveryClient"：其他注册中心，推荐使用
 */
//@EnableEurekaClient
@EnableDiscoveryClient
@SpringBootApplication
public class SpringcloudServiceProviderApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringcloudServiceProviderApplication.class, args);
    }

}
