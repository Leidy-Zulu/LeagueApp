package com.example.leidyzuluaga.leagueapp.presenters;

import com.example.leidyzuluaga.leagueapp.R;
import com.example.leidyzuluaga.leagueapp.controllers.views.ILeagueView;
import com.example.leidyzuluaga.leagueapp.models.LeagueObject;
import com.example.leidyzuluaga.leagueapp.models.Team;
import com.example.leidyzuluaga.leagueapp.models.TeamObject;
import com.example.leidyzuluaga.leagueapp.repositories.ILeagueRepository;
import com.example.leidyzuluaga.leagueapp.repositories.LeagueRepository;

import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;

public class LeaguePresenter extends BasePresenter<ILeagueView> {

    private ILeagueRepository leagueRepository;

    public LeaguePresenter(ILeagueRepository iLeagueRepository) {
        this.leagueRepository = iLeagueRepository;
    }

    public void validateInternetToConsultListTeam(int codeTeam) {
        if (getValidateInternet().isConnected()){
            createThreadToConsultListTeam(codeTeam);
        }else{
            getView().showAlertDialogGeneral(R.string.title, R.string.validate_internet);
        }
    }

    private void createThreadToConsultListTeam(final int codeTeam) {
        Thread thread= new Thread(new Runnable() {
            @Override
            public void run() {
                consultListTeam(codeTeam);
            }
        });
        thread.start();
    }

    private void consultListTeam(int codeTeam) {
        try {
            TeamObject teamObject = leagueRepository.consultTeam(codeTeam);
            getView().showListTeam(teamObject.getTeams());
        } catch (IOException e) {
            getView().showAlertDialogGeneral(R.string.title, e.getMessage());
        }
    }

    public void validateInternetToConsultListLeague() {
        if (getValidateInternet().isConnected()){
            createThreadToConsultListLeague();
        }else{
            getView().showAlertDialogGeneral(R.string.title, R.string.validate_internet);
        }

    }

    private void createThreadToConsultListLeague() {
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                consultListLeague();
            }
        });
        thread.start();
    }

    private void consultListLeague() {
        try {
            LeagueObject leagueObject = leagueRepository.consultLeague();
            getView().showListLeague(leagueObject.getLeagues());
        } catch (IOException e) {
            getView().showAlertDialogGeneral(R.string.title, e.getMessage());
        }
    }
}
