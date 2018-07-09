package com.jimmy.revolver.reflection;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author yangyoujun
 * @date 2018/6/12
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface LEVEL {

    /**
     * 表示本方法从哪个api的level开始支持
     * level的值必须大于等于0
     */
    int api();

}
