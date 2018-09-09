package com.example.leidyzuluaga.leagueapp.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class EventObject {

    @SerializedName("events")
    @Expose
    private ArrayList<Event> events;


    public ArrayList<Event> getEvents() {
        return events;
    }

    public void setEvents(ArrayList<Event> events) {
        this.events = events;
    }
}
