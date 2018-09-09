package com.example.leidyzuluaga.leagueapp.controllers.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.leidyzuluaga.leagueapp.R;
import com.example.leidyzuluaga.leagueapp.helper.Constants;
import com.example.leidyzuluaga.leagueapp.models.Team;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class LeagueDetailActivity extends AppCompatActivity {

    private ImageView imageViewBadge;
    private ImageView imageViewWebSite;
    private ImageView imageViewFacebook;
    private ImageView imageViewInstagram;
    private ImageView imageViewTwitter;
    private ImageView imageViewYoutube;
    private TextView textViewName;
    private TextView textViewDescription;
    private Team team;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_league_detail);
        team = (Team) getIntent().getSerializableExtra(Constants.TEAM);
        loadView();
        loadListener();
        loadData();
    }

    private void loadData() {
        Picasso.get().load(team.getBadge()).into(imageViewBadge);
        textViewName.setText(team.getName() + "-" + team.getFormedYear());
        textViewDescription.setText(team.getDescripcion());
    }

    private void loadListener() {

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
    }
}
