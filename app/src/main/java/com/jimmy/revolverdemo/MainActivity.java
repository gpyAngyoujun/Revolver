package com.jimmy.revolverdemo;

import android.app.Activity;
import android.media.AudioManager;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.telephony.TelephonyManager;
import android.util.Log;
import android.view.View;

import com.jimmy.revolver.Revolver;

/**
 * @author jimmy
 */
public class MainActivity extends AppCompatActivity {

    private Revolver mRevolver;
    private static final String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mRevolver = new Revolver.Builder()
                .level(Build.VERSION.SDK_INT)
                .build();
        findViewById(R.id.btn_get_imei)
                .setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        ReflectionApi api = mRevolver.create(ReflectionApi.class);
                        String imei = api.getImei((TelephonyManager) getSystemService(TELEPHONY_SERVICE));
                        AudioManager manager = api.AudioManager(getApplicationContext());
                        Log.i(TAG, imei);
                    }
                });

        Log.i(TAG, String.valueOf(Activity.class.getSuperclass()));
    }
}
