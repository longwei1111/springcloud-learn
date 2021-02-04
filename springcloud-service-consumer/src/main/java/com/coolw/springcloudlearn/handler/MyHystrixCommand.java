package com.coolw.springcloudlearn.handler;

import com.netflix.hystrix.HystrixCommand;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.client.RestTemplate;

/**
 * @Classname MyHystrixCommand
 * @Description 自定义服务熔断处理
 * @Date 2021/1/29 15:57
 * @Author lw
 */
@Slf4j
public class MyHystrixCommand extends HystrixCommand<String> {

    private RestTemplate restTemplate;

    public MyHystrixCommand(Setter setter, RestTemplate restTemplate) {
        super(setter);
        this.restTemplate = restTemplate;
    }

    /**
     * 当远程服务超时、异常、不可用等情况会触发熔断方法
     */
    @Override
    protected String run() {
        return restTemplate.getForEntity("http://SPRINGCLOUD-SERVICE-PROVIDER/provider/hello", String.class).getBody();
    }

    @Override
    protected String getFallback() {
        Throwable throwable = getExecutionException();
        log.error("异常信息：{}", throwable.getMessage());
        return "ERROR";
    }
}
