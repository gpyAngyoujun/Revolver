package com.jimmy.revolverdemo;

import android.content.Context;
import android.content.res.Resources;
import android.media.AudioManager;
import android.telephony.TelephonyManager;
import android.view.View;

import com.jimmy.revolver.reflection.METHOD;
import com.jimmy.revolver.reflection.CONSTRUCTOR;
import com.jimmy.revolver.reflection.FIELD;
import com.jimmy.revolver.reflection.Invoker;
import com.jimmy.revolver.result.FieldCall;

/**
 * @author yangyoujun
 * @date 2018/6/8
 */
public interface ReflectionApi {

    /**
     * 反射 TelephonyManager.class 类中的 getImei()方法
     *
     * @param invoker 反射处理者，其类型必须和 {@link METHOD} 中提供的一致
     * @return 返回一个String类型的imei
     */
    @METHOD(TelephonyManager.class)
    String getImei(@Invoker TelephonyManager invoker);

    /**
     * 反射 View.class 类中的 mResources 字段
     *
     * @param invoker invoker 反射处理者，其类型必须和 {@link FIELD} 中提供的一致
     * @return 返回 View 中的 mResources 对象
     */
    @FIELD(View.class)
    FieldCall<Resources> mResources(@Invoker View invoker);

    /**
     * 反射 AudioManager.class 类中的 构造函数，以此来生成新的实例
     * <p>
     * //@hide public AudioManager(Context context)
     *
     * @return 返回 AudioManager 的实例
     */
    @CONSTRUCTOR(AudioManager.class)
    AudioManager AudioManager(Context context);
}
