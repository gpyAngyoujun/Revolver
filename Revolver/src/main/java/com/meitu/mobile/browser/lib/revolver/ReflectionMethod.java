package com.meitu.mobile.browser.lib.revolver;

import com.meitu.mobile.browser.lib.revolver.reflection.CLASS;
import com.meitu.mobile.browser.lib.revolver.reflection.Invoker;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;

/**
 * @author yangyoujun
 * @date 2018/6/8
 */
class ReflectionMethod {

    final Class reflectClass;
    final String methodName;
    final Class<?>[] parameterClasses;
    final Class<?> returnType;
    final boolean hasInvoker;

    ReflectionMethod(Builder builder) {
        this.reflectClass = builder.reflectClass;
        this.methodName = builder.methodName;
        this.parameterClasses = builder.parameterClasses;
        this.returnType = builder.returnType;
        this.hasInvoker = builder.hasInvoker;
    }

    static class Builder {

        private final Method method;
        private final Annotation[] annotations;
        private final Annotation[][] parameterAnnotations;
        private final Class<?>[] parameterTypes;

        private Class reflectClass;
        private String methodName;
        private final Class<?> returnType;
        private Class<?>[] parameterClasses;
        private boolean hasInvoker;

        Builder(Method method) {
            this.method = method;
            this.annotations = method.getAnnotations();
            this.parameterAnnotations = method.getParameterAnnotations();
            this.returnType = method.getReturnType();
            this.parameterTypes = method.getParameterTypes();
        }

        ReflectionMethod build() {
            for (Annotation reflect : annotations) {
                parseMethodAnnotation(reflect);
            }

            methodName = method.getName();

            if (reflectClass == null) {
                throw reflectionError("REFLECTION method annotation is required @CLASS.");
            }

            hasInvoker = verityInvokerType();

            parameterClasses = loadParameterClasses(hasInvoker);

            return new ReflectionMethod(this);
        }

        private Class<?>[] loadParameterClasses(boolean hasInvoker) {
            if (!hasInvoker) {
                return parameterTypes;
            }
            // 有一个调用者
            int typeCount = parameterTypes.length - 1;
            if (typeCount <= 0) {
                return null;
            }

            Class<?>[] classes = new Class<?>[typeCount];
            System.arraycopy(parameterTypes, 1, classes, 0, typeCount);
            return classes;
        }

        private boolean verityInvokerType() {
            if (parameterAnnotations.length <= 0) {
                return false;
            }
            // 1. 获取首个parameter的annotations
            Annotation[] parameterAnnotation = parameterAnnotations[0];
            if (parameterAnnotation == null || parameterAnnotation.length <= 0) {
                return false;
            }
            // 2. 获取注解
            Annotation annotation = parameterAnnotation[0];
            return parseInvokerAnnotation(parameterTypes[0], annotation);
        }

        private boolean parseInvokerAnnotation(Class parameterType, Annotation reflect) {
            if (reflect instanceof Invoker) {
                if (parameterType == reflectClass) {
                    return true;
                }
                throw reflectionError("the type of parameter must be " + reflectClass +
                        " , but it is : " + parameterType);
            }
            throw reflectionError("the parameter annotation is not support. annotation: " + reflect);
        }

        private void parseMethodAnnotation(Annotation reflect) {
            if (reflect instanceof CLASS) {
                parseClassAnnotation(((CLASS) reflect));
            } else {
                throw reflectionError("the method annotation is not support. annotation: " + reflect);
            }
        }

        private void parseClassAnnotation(CLASS reflect) {
            if (Utils.isReflect(reflect.value())) {
                reflectClass = reflect.value();
            } else if (!Utils.isEmptyString(reflect.cls())) {
                String cls = reflect.cls();
                try {
                    reflectClass = Class.forName(cls);
                } catch (ClassNotFoundException e) {
                    throw reflectionError("the class is not found. class name: " + cls);
                }
            } else {
                throw reflectionError("the value of @CLASS is invalid.");
            }
        }

        RuntimeException reflectionError(String s) {
            return new IllegalArgumentException("the method:" + methodName + " errorMsg: " + s);
        }

    }
}
