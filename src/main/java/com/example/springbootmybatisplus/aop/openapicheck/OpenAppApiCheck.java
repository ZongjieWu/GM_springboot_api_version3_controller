package com.example.springbootmybatisplus.aop.openapicheck;

import java.lang.annotation.*;

/**
 * @author wzj
 * @date 2019-07-04 15:23
 */
@Documented
@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
public @interface OpenAppApiCheck {
    /**
     * 请求的接口名称
     *
     * @return 接口名称
     */
//    String value();
}
