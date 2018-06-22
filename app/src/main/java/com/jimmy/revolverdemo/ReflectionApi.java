package com.jimmy.revolverdemo;

import android.content.res.Resources;
import android.telephony.TelephonyManager;
import android.view.View;

import com.meitu.mobile.browser.lib.revolver.reflection.CLASS;
import com.meitu.mobile.browser.lib.revolver.reflection.FIELD;
import com.meitu.mobile.browser.lib.revolver.reflection.Invoker;

/**
 * @author yangyoujun
 * @date 2018/6/8
 */
public interface ReflectionApi {

    /**
     * 反射 TelephonyManager.class 类中的 getImei()方法
     *
     * @param invoker 反射处理者，其类型必须和 {@link CLASS} 中提供的一致
     * @return 返回一个String类型的imei
     */
    @CLASS(TelephonyManager.class)
    String getImei(@Invoker TelephonyManager invoker);

    /**
     * 反射 View.class 类中的 mResources 字段
     *
     * @param invoker invoker 反射处理者，其类型必须和 {@link FIELD} 中提供的一致
     * @return 返回 View 中的 mResources 对象
     */
    @FIELD(View.class)
    Resources mResources(@Invoker View invoker);


}
