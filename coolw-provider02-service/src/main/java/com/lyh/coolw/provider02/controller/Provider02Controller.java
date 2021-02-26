package com.lyh.coolw.provider02.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Classname ProviderController
 * @Description
 * @Date 2021/1/29 10:41
 * @Author lw
 */
@RestController
public class Provider02Controller {

    @GetMapping("/provider/hello")
    public String hello() {
        return "spring cloud provider-02 hello world";
    }
}
