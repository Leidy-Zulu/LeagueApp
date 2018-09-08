package com.example.leidyzuluaga.leagueapp.controllers.activities;

import android.content.DialogInterface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.ProgressBar;

import com.example.leidyzuluaga.leagueapp.R;
import com.example.leidyzuluaga.leagueapp.controllers.BaseActivity;
import com.example.leidyzuluaga.leagueapp.controllers.services.TeamAdapter;
import com.example.leidyzuluaga.leagueapp.controllers.views.ILeagueView;
import com.example.leidyzuluaga.leagueapp.domain.DomainModule;
import com.example.leidyzuluaga.leagueapp.helper.Constants;
import com.example.leidyzuluaga.leagueapp.models.Team;
import com.example.leidyzuluaga.leagueapp.presenters.LeaguePresenter;

import java.util.ArrayList;

public class LeagueActivity extends BaseActivity<LeaguePresenter> implements ILeagueView {

    private ProgressBar progressBar;
    private LinearLayout linearLayoutContent;
    private RecyclerView recyclerView;
    private TeamAdapter teamAdapter;

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
        linearLayoutContent = findViewById(R.id.linearLayoutContent);
        recyclerView = findViewById(R.id.recyclerViewTeam);
    }

    @Override
    public void showListTeam(final ArrayList<Team> teams) {
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                progressBar.setVisibility(View.GONE);
                linearLayoutContent.setVisibility(View.VISIBLE);
                loadListTeam(teams);
            }
        });
    }

    private void loadListTeam(ArrayList<Team> teams) {
        teamAdapter = new TeamAdapter(this, this, teams);
        LinearLayoutManager linearLayoutManager =  new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(teamAdapter);
    }

    @Override
    public void startLeagueDetail(Team team) {
        //TODO
    }

    @Override
    public void showAlertDialogGeneral(final int title, final String message) {
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                showAlertDialog(title, message);
            }
        });

    }

    private void showAlertDialog(int title, String message){
        getCustomAlertDialog().showAlertDialog(title, message, false, R.string.text_load_again, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.dismiss();
                getPresenter().validateInternetToConsultListTeam(Constants.SPANISH_LA_LIGA);
            }
        }, R.string.cancel, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.dismiss();
                finish();
            }
        });
    }

    @Override
    public void showAlertDialogGeneral(int title, int message) {
        showAlertDialog(message, getResources().getString(message));
    }
}
