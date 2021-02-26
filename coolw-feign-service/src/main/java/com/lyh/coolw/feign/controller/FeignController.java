package com.lyh.coolw.feign.controller;

import com.lyh.coolw.feign.service.HelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Classname FeignController
 * @Description
 * @Date 2021/1/29 17:51
 * @Author lw
 */
@RestController
public class FeignController {

    @Autowired
    private HelloService helloService;

    @GetMapping("/feign/hello")
    public String hello() {
        return helloService.hello();
    }

}
