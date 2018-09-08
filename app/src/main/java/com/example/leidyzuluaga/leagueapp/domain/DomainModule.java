package com.example.leidyzuluaga.leagueapp.domain;

import com.example.leidyzuluaga.leagueapp.repositories.LeagueRepository;

public class DomainModule {

    public static LeagueRepository getLeagueRepositoryInstance(){
        return new LeagueRepository();
    }
}
