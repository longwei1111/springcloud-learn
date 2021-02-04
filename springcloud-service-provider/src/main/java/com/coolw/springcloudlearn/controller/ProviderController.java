package com.coolw.springcloudlearn.controller;

import com.coolw.springcloud.api.CommonResult;
import com.coolw.springcloud.domain.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
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
        try {
            // 测试hystrix熔断器-超时场景
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "spring cloud provider-01 hello world";
    }

    @PostMapping("/provider/postHello")
    public CommonResult<User> postHello() {
        User user = User.builder().id(888888).userName("coolw").password("123456").mobileNo("15000994425").build();
        return new CommonResult<User>().success(user);
    }

    @GetMapping("/provider/getUser")
    public User getUser() {
        return User.builder().id(888888).userName("coolw").password("123456").mobileNo("15000994425").build();
    }

}
