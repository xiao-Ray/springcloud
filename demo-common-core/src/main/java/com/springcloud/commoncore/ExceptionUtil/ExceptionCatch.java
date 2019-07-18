package com.springcloud.commoncore.ExceptionUtil;

import com.springcloud.commoncore.constant.Result;
import com.springcloud.commoncore.constant.ResultMessage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 捕获异常处理类
 */
@ControllerAdvice
public class ExceptionCatch {

    private static final Logger LOGGER = LoggerFactory.getLogger(ExceptionCatch.class);

    //捕获ExceptionTest1异常
    @ExceptionHandler(ExceptionTest1.class)
    @ResponseBody
    public Result exceptionTest1(ExceptionTest1 exceptionTest1){

        exceptionTest1.printStackTrace();

        LOGGER.error("catch exception:{}",exceptionTest1.getMessage());
        return new Result(500,exceptionTest1.getMessage());

    }

}
