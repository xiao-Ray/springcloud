package com.springcloud.commoncore.ExceptionUtil;

/**
 * 自定义异常类ExceptionTest1
 */
public class ExceptionTest1 extends Exception {

    //提供一个string类型的构造方法
    public ExceptionTest1(String message) {
        super(message);
    }

    private String s;

    public ExceptionTest1(String s,String message){
        super(message);
        this.s=s;
    }

}
