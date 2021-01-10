package com.h5190019.ibrahim_metehan_barutcu.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;

import com.h5190019.ibrahim_metehan_barutcu.R;
import com.h5190019.ibrahim_metehan_barutcu.util.AlertUtil;
import com.h5190019.ibrahim_metehan_barutcu.util.NetworkUtil;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init();

    }

    private void init() {
        checkInternet();
    }

    private void startSplashScreen() {
        CountDownTimer countDownTimer = new CountDownTimer(3000, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {

            }

            @Override
            public void onFinish() {
                openNextActivity();
            }
        };
        countDownTimer.start();
    }

    private void checkInternet() {

        if (NetworkUtil.isInternetAvailable(getApplicationContext())) {
            startSplashScreen();
        } else {
            AlertUtil.checkInternetAlert(this);
        }

    }

    private void openNextActivity() {
        Intent splashScreenIntent = new Intent(getApplicationContext(), FilmsActivity.class);
        startActivity(splashScreenIntent);
        finish();
    }
}