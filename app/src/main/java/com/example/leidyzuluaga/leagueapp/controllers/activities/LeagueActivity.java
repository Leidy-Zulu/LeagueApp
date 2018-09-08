package com.example.leidyzuluaga.leagueapp.controllers.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.leidyzuluaga.leagueapp.R;
import com.example.leidyzuluaga.leagueapp.controllers.BaseActivity;
import com.example.leidyzuluaga.leagueapp.controllers.views.ILeagueView;
import com.example.leidyzuluaga.leagueapp.presenters.LeaguePresenter;

public class LeagueActivity extends BaseActivity<LeaguePresenter> implements ILeagueView {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
