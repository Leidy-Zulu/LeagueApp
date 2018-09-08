package com.example.leidyzuluaga.leagueapp.controllers.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ProgressBar;

import com.example.leidyzuluaga.leagueapp.R;
import com.example.leidyzuluaga.leagueapp.controllers.BaseActivity;
import com.example.leidyzuluaga.leagueapp.controllers.views.ILeagueView;
import com.example.leidyzuluaga.leagueapp.domain.DomainModule;
import com.example.leidyzuluaga.leagueapp.helper.Constants;
import com.example.leidyzuluaga.leagueapp.models.Team;
import com.example.leidyzuluaga.leagueapp.presenters.LeaguePresenter;

import java.util.ArrayList;

public class LeagueActivity extends BaseActivity<LeaguePresenter> implements ILeagueView {

    private ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setPresenter(new LeaguePresenter(DomainModule.getLeagueRepositoryInstance()));
        getPresenter().inject(this, getValidateInternet());
        loadView();
        getPresenter().validateInternetToConsultListTeam(Constants.SPANISH_LA_LIGA);
    }

    private void loadView() {
        progressBar = findViewById(R.id.progressBar);
    }

    @Override
    public void showListTeam(ArrayList<Team> teams) {
        //TODO
    }
}
