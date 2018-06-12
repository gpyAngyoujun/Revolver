package com.meitu.mobile.browser.lib.revolver.reflection;

/**
 * @author yangyoujun
 * @date 2018/6/12
 */
public @interface LEVEL {

    /**
     * 表示本方法从哪个api的level开始支持
     * level的值必须大于等于0
     */
    int api();

//    Object def();

}
