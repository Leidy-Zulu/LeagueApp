package com.example.leidyzuluaga.leagueapp.controllers.views;

import com.example.leidyzuluaga.leagueapp.models.Event;
import com.example.leidyzuluaga.leagueapp.models.EventObject;

import java.util.ArrayList;

public interface ILeagueDetailView extends IBaseView{

    void showListEvent(ArrayList<Event> eventObject);
}
