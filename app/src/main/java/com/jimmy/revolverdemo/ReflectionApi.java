package com.jimmy.revolverdemo;

import android.telephony.TelephonyManager;

import com.meitu.mobile.browser.lib.revolver.reflection.CLASS;
import com.meitu.mobile.browser.lib.revolver.reflection.Invoker;

/**
 * @author yangyoujun
 * @date 2018/6/8
 */
public interface ReflectionApi {

    /**
     * 反射 @CLASS 类中的 getImei()方法
     *
     * @param invoker 反射处理者，是@CLASS中的数值对象
     * @return 返回一个String类型的imei
     */
    @CLASS(TelephonyManager.class)
    String getImei(@Invoker TelephonyManager invoker);
}
