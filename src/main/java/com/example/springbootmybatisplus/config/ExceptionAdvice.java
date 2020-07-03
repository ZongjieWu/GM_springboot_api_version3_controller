package com.example.springbootmybatisplus.config;

import com.example.springbootmybatisplus.enums.Result;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/***
 * 统一异常处理
 * */
@RestControllerAdvice
public class ExceptionAdvice {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());
    /**
     * 拦截捕捉自定义异常Exception.class
     * @param e
     * @return
     */
    @ExceptionHandler(value = Exception.class)
    public Result ExceptionHandler(Exception e) {
        Map<String,Object> dataMap=new HashMap<>();
        List<Object> dataList=new ArrayList();
        StackTraceElement[] stackTraceElements=e.getStackTrace();
        for(int i=0;i<stackTraceElements.length;i++){
            if(stackTraceElements[i].getClassName().contains("Controller")){
                dataList.add(stackTraceElements[i]);
                logger.info(stackTraceElements[0].getClass().toString());
                logger.info(stackTraceElements[0].getClassName());
                logger.info(stackTraceElements[0].getMethodName());
                logger.info(stackTraceElements[0].getClassName());
                logger.info(stackTraceElements[0].getFileName());
            }
        }
        dataMap.put("result",e.getMessage());
        dataMap.put("helpInfo",dataList);
        e.printStackTrace();
        return Result.retrunFailMsgData(dataMap);
    }


//    @ResponseBody
//    @ExceptionHandler(value = ArithmeticException.class)
//    public Map ArithmeticExceptionHandler(ArithmeticException ex) {
//        Map map = new HashMap();
//        map.put("code", -1);
//        map.put("msg", ex.getMessage());
//        map.put("msg2", ex.getLocalizedMessage());
//        map.put("msg3", ex.getCause());
//        map.put("msg4", ex.getCause());
//        map.put("msg5", ex.getSuppressed());
//        map.put("msg6", ex.getClass());
//        return map;
//    }
}

