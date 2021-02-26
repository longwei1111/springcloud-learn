package com.lyh.coolw.feign.service;

import com.lyh.coolw.feign.handler.MyFallbackFactory;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @Classname HelloService
 * @Description
 * @Date 2021/1/29 17:48
 * @Author lw
 */
// 通过@FeignClient注解来指定服务名称进而绑定服务COOLW-PROVIDER-SERVICE
// fallback = MyFallback.class
@FeignClient(value = "COOLW-PROVIDER-SERVICE", fallbackFactory = MyFallbackFactory.class)
public interface HelloService {

    @GetMapping("/provider/hello")
    String hello();
}
