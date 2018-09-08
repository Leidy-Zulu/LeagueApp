package com.example.leidyzuluaga.leagueapp.repositories;

import com.example.leidyzuluaga.leagueapp.controllers.services.IServicesLeague;
import com.example.leidyzuluaga.leagueapp.controllers.services.ServicesFactory;
import com.example.leidyzuluaga.leagueapp.helper.Constants;
import com.example.leidyzuluaga.leagueapp.models.TeamObject;

import java.io.IOException;

import retrofit2.Call;
import retrofit2.Response;

public class LeagueRepository implements ILeagueRepository {

    private final IServicesLeague iServicesLeague;

    public LeagueRepository() {
        ServicesFactory servicesFactory = new ServicesFactory();
        iServicesLeague = (IServicesLeague) servicesFactory.getInstance(IServicesLeague.class);
    }

    @Override
    public TeamObject consultTeam(int codeTeam) throws IOException {
        try {
            Call<TeamObject> call = iServicesLeague.consultTeam(codeTeam);
            Response<TeamObject> teamObjectResponse = call.execute();
            if (teamObjectResponse.errorBody() != null || teamObjectResponse.body().getTeams() == null) {
                 throw defaultError();
            } else {
                return teamObjectResponse.body();
            }
        } catch (IOException exception) {
            throw  defaultError();
        }
    }

    private IOException defaultError()  {
         return new IOException(Constants.DEFAUL_ERROR);
    }


}
