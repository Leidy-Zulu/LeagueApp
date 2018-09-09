package com.example.leidyzuluaga.leagueapp.controllers.services;

import com.example.leidyzuluaga.leagueapp.models.EventObject;
import com.example.leidyzuluaga.leagueapp.models.Team;
import com.example.leidyzuluaga.leagueapp.models.TeamObject;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface IServicesLeague {

    @GET("lookup_all_teams.php")
    Call<TeamObject> consultTeam(@Query("id") int codeTeam);

    @GET("eventsnext.php")
    Call<EventObject> consultEvent(@Query("id") String id);
}
