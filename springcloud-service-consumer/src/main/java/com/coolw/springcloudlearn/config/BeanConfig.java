package com.coolw.springcloudlearn.config;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import com.netflix.loadbalancer.RetryRule;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * @Classname BeanConfig
 * @Description
 * @Date 2021/1/29 10:51
 * @Author lw
 */
@Configuration
public class BeanConfig {

    /**
     * 使用Ribbon实现负载均衡调用，默认是轮询
     * @LoadBalanced:加入ribbon的支持，在调用时，可改为使用服务名称来访问
     */
    @LoadBalanced
    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }

    @Bean
    public IRule iRule() {
        // 采用随机的负载均衡策略
        //return new RandomRule();

        /**
         * 采用重试的负载均衡策略:
         *   1.先按照RoundRobinRule(轮询)策略分发
         *   2.如果分发到的服务不能访问，则在指定的时间内进行重试
         *   3.如果还是不可用，则分发给其他可用的服务，默认是500ms
         */
        RetryRule retryRule = new RetryRule();
        retryRule.setMaxRetryMillis(500);
        return retryRule;
    }
}
