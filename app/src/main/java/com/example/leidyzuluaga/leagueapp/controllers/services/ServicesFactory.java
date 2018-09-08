package com.example.leidyzuluaga.leagueapp.controllers.services;

import com.example.leidyzuluaga.leagueapp.helper.Constants;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import retrofit2.Converter;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ServicesFactory {

    private static final String API_BASE_PATH = Constants.URL_LEAGUE;
    private final Retrofit restAdapter;



    public ServicesFactory() {
        final OkHttpClient okHttpClient = new OkHttpClient.Builder()
                .connectTimeout(Constants.TEN, TimeUnit.SECONDS)
                .writeTimeout(Constants.TEN, TimeUnit.SECONDS)
                .readTimeout(Constants.TEN, TimeUnit.SECONDS).build();
        restAdapter = new Retrofit.Builder()
                .baseUrl(API_BASE_PATH)
                .client(okHttpClient)
                .addConverterFactory(getGsonConverter())
                .build();
    }


    private Converter.Factory getGsonConverter() {
        Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd").create();
        return GsonConverterFactory.create(gson);
    }


    public Object getInstance(Class service) {
        return restAdapter.create(service);
    }
}
