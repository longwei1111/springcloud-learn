package com.coolw.springcloudlearn.service;

import com.coolw.springcloudlearn.handler.MyFallbackFactory;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Classname HelloService
 * @Description
 * @Date 2021/1/29 17:48
 * @Author lw
 */
// 通过@FeignClient注解来指定服务名称进而绑定服务
// fallback = MyFallback.class
@FeignClient(value = "SPRINGCLOUD-SERVICE-PROVIDER", fallbackFactory = MyFallbackFactory.class)
@Service
public interface HelloService {

    /**
     * 通过Spring MVC中提供的注解来绑定服务提供者的接口
     */
    @RequestMapping("/provider/hello")
    String hello();

}
