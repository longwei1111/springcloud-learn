package com.coolw.springcloudlearn.controller;

import com.coolw.springcloudlearn.service.HelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
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

    @RequestMapping("/feign/hello")
    public String hello() {
        return helloService.hello();
    }

}
