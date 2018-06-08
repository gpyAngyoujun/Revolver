package com.meitu.mobile.browser.lib.revolver;

/**
 * @author yangyoujun
 * @date 2018/6/8
 */
class Reflector {

    private final ReflectionMethod reflectionMethod;
    private final Object[] args;

    Reflector(ReflectionMethod reflectionMethod, Object[] args) {
        this.reflectionMethod = reflectionMethod;
        this.args = args;
    }

    public Object reflect() {
        return null;
    }
}
