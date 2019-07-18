package com.springcloud.eurekaclient.controller;


import com.springcloud.commoncore.constant.ResultMessage;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

@RestController
public class HelloController {

    @GetMapping("/hello")
    public String Hello(){
        System.out.println("hello");
        ServletRequestAttributes sra= (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        StringBuffer url = sra.getRequest().getRequestURL();
        return "请求成功"+url;
    }


    public static void main(String[] args) {

        System.out.println(ResultMessage.TestHttpResult.TEST_HTTP_OBJECT_NULL.getIndex());
        System.out.println(ResultMessage.TestHttpResult.TEST_HTTP_OBJECT_NULL.getName());

        System.out.println("---------------");
        System.out.println(ResultMessage.TestHttpResult.getName(200));
    }
}
