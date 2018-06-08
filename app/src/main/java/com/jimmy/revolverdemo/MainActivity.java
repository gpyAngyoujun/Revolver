package com.jimmy.revolverdemo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.telephony.TelephonyManager;
import android.util.Log;
import android.view.View;

import com.meitu.mobile.browser.lib.revolver.Revolver;

/**
 * @author jimmy
 */
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViewById(R.id.btn_get_imei)
                .setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Revolver revolver = new Revolver.Builder()
                                .build();
                        ReflectionApi api = revolver.create(ReflectionApi.class);
                        String imei = api.getImei((TelephonyManager) getSystemService(TELEPHONY_SERVICE));
                        Log.i("MainActivity", imei);
                    }
                });
    }
}
