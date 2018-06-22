package com.meitu.mobile.browser.lib.revolver;

import com.meitu.mobile.browser.lib.revolver.reflection.CLASS;
import com.meitu.mobile.browser.lib.revolver.reflection.CONSTRUCTOR;
import com.meitu.mobile.browser.lib.revolver.reflection.FIELD;
import com.meitu.mobile.browser.lib.revolver.reflection.LEVEL;

import java.lang.annotation.Annotation;

/**
 * 一个抽象类，该类是用于构建不同的 Method 注解的处理器
 *
 * @author jimmy
 * @date 2018/6/23
 */
abstract class MethodHandler {

    static MethodHandler create(Annotation annotation) {
        if (annotation instanceof CLASS) {
            return new Class();
        } else if (annotation instanceof FIELD) {
            return new Field();
        } else if (annotation instanceof CONSTRUCTOR) {
            return new Constructor();
        } else if (annotation instanceof LEVEL) {
            return new Level();
        } else {
            return Null.INSTANCE;
        }
    }

    private final static class Null {
        private static final MethodHandler INSTANCE = new MethodHandler() {
        };
    }

    private final static class Class extends MethodHandler {

    }

    private final static class Field extends MethodHandler {

    }

    private final static class Constructor extends MethodHandler {

    }

    private final static class Level extends MethodHandler {

    }
}
