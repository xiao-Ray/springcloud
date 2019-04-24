package com.springcloud.feign.feignClient;

import feign.hystrix.FallbackFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@FeignClient(value="demo-eureka-client",fallbackFactory = EurekaFeignClientFallBackFactory.class)
@RestController
public interface EurekaFeignClient {

    @GetMapping(value="/hello")
    String hello();
}


//熔断器的处理类,实现EurekaFeignClient接口,并注入到IOC容器中
@Component
class EurekaFeignClientFallBackFactory implements FallbackFactory<EurekaFeignClient>{

    private static final Logger LOGGER = LoggerFactory.getLogger(EurekaFeignClientFallBackFactory.class);

    @Override
    public EurekaFeignClient create(Throwable cause) {
        return new EurekaFeignClient(){

            @Override
            public String hello() {
                EurekaFeignClientFallBackFactory.LOGGER.info("fallback; reason was:", cause);
//                return cause.getMessage();
                return "请求超时";
            }
        };
    }
}