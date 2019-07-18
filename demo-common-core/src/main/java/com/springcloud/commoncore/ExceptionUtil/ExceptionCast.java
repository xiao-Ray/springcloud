package com.springcloud.commoncore.ExceptionUtil;

/**
 * 返回一个异常类
 */
public class ExceptionCast {

    public static void cast(String message) throws ExceptionTest1 {
        throw new ExceptionTest1(message);
    }
}
