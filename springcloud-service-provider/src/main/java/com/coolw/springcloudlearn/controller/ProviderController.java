package com.coolw.springcloudlearn.controller;

import com.coolw.springcloud.domain.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Classname ProviderController
 * @Description
 * @Date 2021/1/29 10:41
 * @Author lw
 */
@RestController
public class ProviderController {

    @GetMapping("/provider/hello")
    public String hello() {
        return "spring cloud provider-01 hello world";
    }

    @GetMapping("/provider/getUser")
    public User getUser() {
        return User.builder().id(888888).userName("coolw").password("123456").mobileNo("15000994425").build();
    }

}
