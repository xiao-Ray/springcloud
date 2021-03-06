package com.springcloud.test.controller;


import com.springcloud.commoncore.ExceptionUtil.ExceptionCast;
import com.springcloud.commoncore.ExceptionUtil.ExceptionTest1;
import com.springcloud.commoncore.entity.User;
import com.springcloud.commoncore.uuid.UUID8Util;
import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;

/**
 * 测试异常类
 */
public class TestExceptionController {

    public static void main(String[] args) throws ExceptionTest1 {

//        testE1(null);
//        testE2(null);
//        testE3(null);
        testuuid();

    }

    public static void testE1(User user) throws ExceptionTest1 {

        if (null==user){
            throw new ExceptionTest1("用户为空");
        }

    }

    public static void testE2(User user) throws ExceptionTest1 {

        if (null==user){
            throw new ExceptionTest1("1111","用户为空");
        }
    }

    public static void testE3(User user) throws ExceptionTest1 {
        if (null==user){
            ExceptionCast.cast("用户为空");
        }
    }

    //通过
    public static void testuuid(){
        String s = UUID8Util.generate8UUID();
        System.out.println(s);
    }
}
