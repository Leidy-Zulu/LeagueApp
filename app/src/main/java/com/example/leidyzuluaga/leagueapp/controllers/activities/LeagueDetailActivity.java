package com.example.leidyzuluaga.leagueapp.controllers.activities;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.example.leidyzuluaga.leagueapp.R;
import com.example.leidyzuluaga.leagueapp.controllers.BaseActivity;
import com.example.leidyzuluaga.leagueapp.controllers.views.ILeagueDetailView;
import com.example.leidyzuluaga.leagueapp.domain.DomainModule;
import com.example.leidyzuluaga.leagueapp.helper.Constants;
import com.example.leidyzuluaga.leagueapp.models.Event;
import com.example.leidyzuluaga.leagueapp.models.Team;
import com.example.leidyzuluaga.leagueapp.presenters.LeagueDetailPresenter;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class LeagueDetailActivity extends BaseActivity<LeagueDetailPresenter> implements ILeagueDetailView {

    private ImageView imageViewBadge;
    private ImageView imageViewWebSite;
    private ImageView imageViewJersey;
    private ImageView imageViewFacebook;
    private ImageView imageViewInstagram;
    private ImageView imageViewTwitter;
    private ImageView imageViewYoutube;
    private TextView textViewName;
    private TextView textViewDescription;
    private ListView listViewEvents;
    private Team team;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_league_detail);
        setPresenter(new LeagueDetailPresenter(DomainModule.getLeagueRepositoryInstance()));
        getPresenter().inject(this, getValidateInternet());
        team = (Team) getIntent().getSerializableExtra(Constants.TEAM);
        getPresenter().validateInternetToConsultListEvent(team.getId());
        loadView();
        loadListener();
        loadData();
    }

    private void loadData() {
        Picasso.get().load(team.getBadge()).into(imageViewBadge);
        Picasso.get().load(team.getJersey()).into(imageViewJersey);
        textViewName.setText(team.getName() + "-" + team.getFormedYear());
        textViewDescription.setText(team.getDescripcion());
    }

    private void loadListener() {
        imageViewFacebook.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                validateStringUrl(team.getFacebook());
            }
        });
        imageViewInstagram.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                validateStringUrl(team.getInstagram());
            }
        });
        imageViewTwitter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                validateStringUrl(team.getTwitter());
            }
        });
        imageViewYoutube.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                validateStringUrl(team.getYoutube());
            }
        });
    }

    private void validateStringUrl(String url){
        if (!url.isEmpty()){
            openUrl(url);
        }
    }

    private void openUrl(String url){
        String urlArray[] = url.split(Constants.WWWW);
        String finalUrl = Constants.HTTP + (urlArray.length > 1 ? urlArray[1] : urlArray[0]);
        Intent i = new Intent(Intent.ACTION_VIEW);
        i.setData(Uri.parse(finalUrl));
        startActivity(i);
    }

    private void loadView() {
        imageViewBadge = findViewById(R.id.imageViewBadge);
        imageViewWebSite = findViewById(R.id.imageViewWebSite);
        imageViewFacebook = findViewById(R.id.imageViewFacebook);
        imageViewInstagram = findViewById(R.id.imageViewInstagram);
        imageViewTwitter = findViewById(R.id.imageViewTwitter);
        imageViewYoutube = findViewById(R.id.imageViewYoutube);
        textViewName = findViewById(R.id.textViewName);
        textViewDescription = findViewById(R.id.textViewDescription);
        listViewEvents = findViewById(R.id.listViewEvents);
        imageViewJersey = findViewById(R.id.imageViewJersey);
    }

    @Override
    public void showListEvent(final ArrayList<Event> eventArrayList) {
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(LeagueDetailActivity.this, android.R.layout.simple_list_item_1, getItemsArrayFromListEvent(eventArrayList));
                listViewEvents.setAdapter(arrayAdapter);
            }
        });

    }

    private String[] getItemsArrayFromListEvent(ArrayList<Event> eventArrayList){
        String[] items = new String[eventArrayList.size()];
        for (int i = 0; i < eventArrayList.size(); i++) {
            items[i] = eventArrayList.get(i).getDescription();
        }
        return items;
    }
}
