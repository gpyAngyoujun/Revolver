package com.meitu.mobile.browser.lib.revolver;

import com.meitu.mobile.browser.lib.revolver.reflection.CLASS;

import java.util.Objects;

/**
 * @author yangyoujun
 * @date 2018/6/8
 */
class Utils {
    static <T> void validateServiceInterface(Class<T> reflection) {
        Objects.requireNonNull(reflection);
        if (!reflection.isInterface()) {
            throw new IllegalArgumentException("API declarations must be interfaces.");
        }
        // Prevent API interfaces from extending other interfaces. This not only avoids a bug in
        // Android (http://b.android.com/58753) but it forces composition of API declarations which is
        // the recommended pattern.
        if (reflection.getInterfaces().length > 0) {
            throw new IllegalArgumentException("API interfaces must not extend other interfaces.");
        }
    }

    public static boolean isEmptyString(String cls) {
        return cls == null || cls.length() == 0;
    }

    public static boolean isValidateClass(Class reflect) {
        return reflect != null && reflect != CLASS.class;
    }
}
