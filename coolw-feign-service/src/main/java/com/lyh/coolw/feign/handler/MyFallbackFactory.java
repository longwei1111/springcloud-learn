package com.lyh.coolw.feign.handler;

import com.lyh.coolw.feign.service.HelloService;
import feign.hystrix.FallbackFactory;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * @Classname MyFallbackHandler
 * @Description
 * @Date 2021/1/29 18:05
 * @Author lw
 */
@Slf4j
@Component
public class MyFallbackFactory implements FallbackFactory<HelloService> {

    /**
     * 捕获提供者抛出的异常
     */
    @Override
    public HelloService create(Throwable throwable) {
        return new HelloService() {
            @Override
            public String hello() {
                log.error("异常信息：{}", throwable.getMessage());
                return throwable.getMessage();
            }
        };
    }
}
