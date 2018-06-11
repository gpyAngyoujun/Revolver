package com.meitu.mobile.browser.lib.revolver;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

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

    public Object invoke() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Method targetMethod = getTargetMethod();
        Object invoker = parseInvoker();
        Object[] params = parseParameters();
        verifyMethodReturnType(targetMethod);
        return invokerMethod(targetMethod, invoker, params);
    }

    private void verifyMethodReturnType(Method targetMethod) {
        if (targetMethod.getReturnType() == reflectionMethod.returnType) {
            return;
        }
        throw reflectionError("the return type must be:" + targetMethod.getReturnType() +
                " current type is:" + reflectionMethod.returnType);
    }

    private RuntimeException reflectionError(String s) {
        return new IllegalArgumentException("the method is:" + reflectionMethod.methodName +
                " error:" + s);
    }

    private Object invokerMethod(Method targetMethod, Object invoker, Object[] params)
            throws InvocationTargetException, IllegalAccessException {
        targetMethod.setAccessible(true);
        return targetMethod.invoke(invoker, params);
    }

    private Object[] parseParameters() {
        if (!reflectionMethod.hasInvoker) {
            return args;
        }

        int paramLength = args.length - 1;
        if (paramLength <= 0) {
            return null;
        }

        Object[] params = new Object[paramLength];
        System.arraycopy(args, 1, params, 0, paramLength);
        return params;
    }

    private Object parseInvoker() {
        return reflectionMethod.hasInvoker ? args[0] : null;
    }

    private Method getTargetMethod() throws NoSuchMethodException {
        return reflectionMethod.reflectClass.getDeclaredMethod(
                reflectionMethod.methodName,
                reflectionMethod.parameterClasses);
    }
}
