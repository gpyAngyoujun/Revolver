package com.meitu.mobile.browser.lib.revolver;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.HashMap;
import java.util.Map;

/**
 * @author jimmy
 */
public class Revolver {

    private final Map<Method, ReflectionMethod> reflectionMethodCache = new HashMap<>();

    private Revolver(Builder builder) {

    }

    public <T> T create(Class<T> reflection) {
        Utils.validateServiceInterface(reflection);
        return (T) Proxy.newProxyInstance(reflection.getClassLoader(), new Class[]{reflection}, new InvocationHandler() {
            @Override
            public Object invoke(Object o, Method method, Object[] args) throws Throwable {
                // If the method is a method from Object then defer to normal invocation.
                if (method.getDeclaringClass() == Object.class) {
                    return method.invoke(this, args);
                }
                ReflectionMethod reflectionMethod = loadReflectionMethod(method);
                Reflector reflector = new Reflector(reflectionMethod, args);
                return reflector.invoke();
            }
        });
    }

    private ReflectionMethod loadReflectionMethod(Method method) {
        ReflectionMethod result = reflectionMethodCache.get(method);
        if (result != null) {
            return result;
        }

        synchronized (reflectionMethodCache) {
            result = reflectionMethodCache.get(method);
            if (result == null) {
                result = new ReflectionMethod.Builder(method).build();
                reflectionMethodCache.put(method, result);
            }
        }
        return result;
    }

    public static class Builder {

        public Revolver build() {
            return new Revolver(this);
        }
    }
}
