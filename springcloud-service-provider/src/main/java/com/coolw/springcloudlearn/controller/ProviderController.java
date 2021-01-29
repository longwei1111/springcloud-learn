package com.coolw.springcloudlearn.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Classname ProviderController
 * @Description
 * @Date 2021/1/29 10:41
 * @Author lw
 */
@RestController
public class ProviderController {

    @RequestMapping("/provider/hello")
    public String hello() {
        return "spring cloud provider-01 hello world";
    }
}
