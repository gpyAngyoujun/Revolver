package com.meitu.mobile.browser.lib.revolver.reflection;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 表示该参数是反射中的invoker对象
 * 1.每个接口中有且只有一个参数能被Invoker修饰
 * 2.该参数必须排在第一个
 * 3.被Invoker修饰的参数类型必须和{@link CLASS}中提供的数据类型一致
 *
 * @author yangyoujun
 * @date 2018/6/8
 */
@Target(ElementType.PARAMETER)
@Retention(RetentionPolicy.RUNTIME)
public @interface Invoker {

    /**
     * class 类名
     * 如果我们反射的类是以字符串 "..." 的形式提供的，那么我们在提供Invoker的数据类型时，则无法显示的给出参数的类型
     * 那么我们只需要将class的类名提供给invoker，接着将数据类型设定为Object即可.
     *
     * @return class name
     */
    String value() default "";
}
