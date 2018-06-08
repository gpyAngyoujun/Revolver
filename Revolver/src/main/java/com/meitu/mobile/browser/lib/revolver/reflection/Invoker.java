package com.meitu.mobile.browser.lib.revolver.reflection;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 表示该参数是反射中的invoker对象
 *
 * @author yangyoujun
 * @date 2018/6/8
 */
@Target(ElementType.PARAMETER)
@Retention(RetentionPolicy.RUNTIME)
public @interface Invoker {
}
