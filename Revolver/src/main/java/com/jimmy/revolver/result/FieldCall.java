package com.jimmy.revolver.result;

/**
 * Created by yangyoujun on 2018/7/11 .
 */
public interface FieldCall<T> {

    /**
     * 获取到字段的数据
     *
     * @return
     */
    T get();

    /**
     * 设置字段的数据
     *
     * @param val 要设置的数据
     */
    void set(T val);
}
