package com.example.leidyzuluaga.leagueapp.controllers.views;

import com.example.leidyzuluaga.leagueapp.models.Team;

import java.util.ArrayList;

public interface ILeagueView extends IBaseView{


    void showListTeam(ArrayList<Team> teams);

    void startLeagueDetail(Team team);
}
