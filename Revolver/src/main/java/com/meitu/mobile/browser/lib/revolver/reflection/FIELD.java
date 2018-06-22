package com.meitu.mobile.browser.lib.revolver.reflection;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 1. 每一个需要 反射字段 的接口都必须被该注解修饰
 * 2. 该注解中必须提供 cls 或者 value 两者中的某一个
 *
 * @author jimmy
 * @date 2018/6/22
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface FIELD {

    /**
     * 需要反射的class name
     */
    String cls() default "";

    /**
     * 要放射的class对象
     */
    Class value() default FIELD.class;
}
