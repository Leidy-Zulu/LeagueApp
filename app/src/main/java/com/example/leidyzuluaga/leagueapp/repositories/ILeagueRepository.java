package com.example.leidyzuluaga.leagueapp.repositories;

import com.example.leidyzuluaga.leagueapp.models.Team;
import com.example.leidyzuluaga.leagueapp.models.TeamObject;

import java.io.IOException;
import java.util.ArrayList;

public interface ILeagueRepository {

    TeamObject consultTeam(int codeTeam) throws IOException;
}
