package com.meitu.mobile.browser.lib.revolver.reflection;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author yangyoujun
 * @date 2018/6/8
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface CLASS {

    /**
     * 需要反射的class name
     */
    String cls() default "";

    /**
     * 要放射的class对象
     */
    Class value() default CLASS.class;
}
