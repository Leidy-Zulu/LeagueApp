package com.example.leidyzuluaga.leagueapp.controllers.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.leidyzuluaga.leagueapp.R;

public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        loadingSplash();

    }

    private void loadingSplash() {
        new android.os.Handler().postDelayed(
                new Runnable() {
                    public void run() {
                        starMainActivity();
                    }
                },
                2000);
    }

    private void starMainActivity() {
        Intent intent = new Intent(this, LeagueActivity.class);
        startActivity(intent);
        finish();
    }
}
