package com.example.leidyzuluaga.leagueapp.presenters;

import com.example.leidyzuluaga.leagueapp.R;
import com.example.leidyzuluaga.leagueapp.controllers.views.ILeagueDetailView;
import com.example.leidyzuluaga.leagueapp.models.EventObject;
import com.example.leidyzuluaga.leagueapp.repositories.ILeagueRepository;
import com.example.leidyzuluaga.leagueapp.repositories.LeagueRepository;

import java.io.IOException;
import java.util.ArrayList;

public class LeagueDetailPresenter extends BasePresenter<ILeagueDetailView>{

    private ILeagueRepository ileagueRepository;

    public LeagueDetailPresenter(ILeagueRepository iLeagueRepository) {
        this.ileagueRepository = iLeagueRepository;
    }


    public void validateInternetToConsultListEvent(String id) {
        if (getValidateInternet().isConnected()){
            createThreadToConsultListEvent(id);
        }else{
            getView().showAlertDialogGeneral(R.string.title, R.string.validate_internet);
        }
    }

    private void createThreadToConsultListEvent(final String id) {
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                consultListEvent(id);
            }
        });
        thread.start();
    }

    private void consultListEvent(String id) {
        try {
            EventObject eventObject = ileagueRepository.consultEvent(id);
            getView().showListEvent(eventObject.getEvents());
        } catch (IOException e) {
            getView().showAlertDialogGeneral(R.string.title, e.getMessage());
        }
    }
}
