package com.jimmy.revolver.reflection;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 本注解要配合 {@link LEVEL} 一起使用。
 * <p>
 * 如果要使用本注解，必须满足2个条件：
 * 1. 同时使用了 {@link LEVEL}
 * 2. 本注解必须放在参数的最末尾
 * <p>
 * Created by yangyoujun on 2018/7/9 .
 */
@Target(ElementType.PARAMETER)
@Retention(RetentionPolicy.RUNTIME)
public @interface DefVal {
}
