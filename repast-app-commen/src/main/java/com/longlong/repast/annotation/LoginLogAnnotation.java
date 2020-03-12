package com.longlong.repast.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @autor: 日思夜想的龙哥哥
 * @date: 2020-03-11
 * @Description:
 * 自定义登录日志注解
 *
 * 注解在什么时候会被加载
 * @Retention
 * */
@Target({ElementType.METHOD,ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface LoginLogAnnotation {

    /**
     * @Author longlong
     * @Description
     * 用户要执行的操作类型
     *      登录，删除，下单
     * @Date 2020/3/11
     * @Param
     * @Return
     **/
    String operationType() default "";

    /**
     * @Author longlong
     * @Description
     * 具体要执行的操作
     *      删除--删除用户 ，清空购物车，删除商品
     * @Date 2020/3/11
     * @Param
     * @Return
     **/
    String operationName() default "";
}
