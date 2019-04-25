package com.springcloud.zuul;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

@SpringBootApplication
@EnableEurekaClient
@EnableZuulProxy     //开启zuul
public class DemoZuulClientApplication {
    public static void main(String[] args) {
        SpringApplication.run(DemoZuulClientApplication.class,args);
    }
}
