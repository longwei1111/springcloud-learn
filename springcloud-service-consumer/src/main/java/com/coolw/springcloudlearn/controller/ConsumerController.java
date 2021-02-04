package com.coolw.springcloudlearn.controller;

import com.coolw.springcloud.api.CommonResult;
import com.coolw.springcloud.domain.User;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @Classname ProviderController
 * @Description
 * @Date 2021/1/29 10:41
 * @Author lw
 */
@Slf4j
@RestController
public class ConsumerController {

    @Autowired
    private RestTemplate restTemplate;

    /**
     * Eureka单机版
     */
    @GetMapping("/consumer/hello")
    public String hello() {
        // 调用spring cloud服务提供者提供的服务
        //return restTemplate.getForEntity("http://localhost:8080/provider/hello", String.class).getBody();

        // 将ip:port改为服务名称调用即可
        ResponseEntity<String> responseEntity = restTemplate.getForEntity("http://SPRINGCLOUD-SERVICE-PROVIDER/provider/hello", String.class);
        String body = responseEntity.getBody();
        HttpStatus httpStatus = responseEntity.getStatusCode();
        int statusCodeValue = responseEntity.getStatusCodeValue();
        HttpHeaders httpHeaders = responseEntity.getHeaders();
        log.info("==>body:{}, httpStatus={}, statusCodeValue={}, httpHeaders={}", body, httpStatus, statusCodeValue, httpHeaders);
        return body;
    }

    /**
     * Eureka集群版
     */
    @GetMapping("/consumer/hello2")
    public String hello2() {
        return restTemplate.getForEntity("http://SPRINGCLOUD-SERVICE-PROVIDER/provider/hello", String.class).getBody();
    }

    @GetMapping("consumer/getUser")
    public User getUser() {
        //return User.builder().id(888888).userName("coolw").password("123456").mobileNo("15000994425").build();

        ResponseEntity<User> responseEntity = restTemplate.getForEntity("http://SPRINGCLOUD-SERVICE-PROVIDER/provider/getUser", User.class);
        return responseEntity.getBody();
    }

    @GetMapping("/consumer/hello3")
    public CommonResult<User> hello3() {
        CommonResult commonResult = restTemplate.postForEntity("http://SPRINGCLOUD-SERVICE-PROVIDER/provider/postHello", null, CommonResult.class).getBody();
        return commonResult;
    }

    /**
     * hystrix默认超时时间为1000ms，如果后端响应时间超过此时间，就会触发断路器
     * fallbackMethod：发生熔断，对应的处理方法；属性ignoreExceptions忽略指定异常
     * 此处不会抛出异常，只是服务降级，被error方法拦截处理
     */
    @GetMapping("/consumer/hystrix")
    @HystrixCommand(fallbackMethod = "error", commandProperties = {@HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "3000")})
    public String hystrix() {
        // 除数不能为0，这一行代码会触发熔断
        //int a = 10 / 0;
        return restTemplate.getForEntity("http://SPRINGCLOUD-SERVICE-PROVIDER/provider/hello", String.class).getBody();
    }

    public String error(Throwable throwable) {
        log.error("异常信息：{}", throwable.getMessage());
        // 访问远程服务失败，对应逻辑可写在此处
        return "ERROR";
    }
}
