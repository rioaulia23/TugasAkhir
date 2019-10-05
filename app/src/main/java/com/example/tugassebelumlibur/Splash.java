package com.example.tugassebelumlibur;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.example.tugassebelumlibur.helper.Pref;

public class Splash extends AppCompatActivity {
    private static final int lamawaktu = 3000;
    private Context ctx;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (!Pref.sharedIntance(this).getSplash()) {
            startActivity(new Intent(this, Login.class));

        }
        ctx = this;
        setContentView(R.layout.splash_act);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent i = new Intent(ctx, Login.class);
                startActivity(i);
                finish();
            }
        }, lamawaktu);
    }
}


