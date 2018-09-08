package com.example.leidyzuluaga.leagueapp.controllers.services;

import android.content.Context;
import android.media.Image;
import android.support.annotation.NonNull;

import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.leidyzuluaga.leagueapp.R;
import com.example.leidyzuluaga.leagueapp.controllers.views.ILeagueView;
import com.example.leidyzuluaga.leagueapp.models.Team;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class TeamAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private  Context context;
    private ILeagueView iLeagueView;
    private ArrayList<Team> teamArrayList;

    public TeamAdapter(Context context, ILeagueView iLeagueView, ArrayList<Team> teamArrayList) {
        this.context = context;
        this.iLeagueView = iLeagueView;
        this.teamArrayList = teamArrayList;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_team, viewGroup, false);
        return new CustomViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i) {
        CustomViewHolder customViewHolder = (CustomViewHolder) viewHolder;
        final Team team = teamArrayList.get(i);
        Picasso.get().load(team.getBadge()).into(customViewHolder.imageViewBadge);
        customViewHolder.textViewName.setText(team.getName());
        customViewHolder.textViewStadium.setText(team.getStadium());
        customViewHolder.cardViewTeam.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                iLeagueView.startLeagueDetail(team);
            }
        });
    }

    @Override
    public int getItemCount() {
        return teamArrayList.size();
    }


    private class CustomViewHolder extends RecyclerView.ViewHolder {
        private final ImageView imageViewBadge;
        private final TextView textViewName;
        private final TextView textViewStadium;
        private final CardView cardViewTeam;

        CustomViewHolder(View view) {
            super(view);
            imageViewBadge = view.findViewById(R.id.imageViewBadge);
            textViewName = view.findViewById(R.id.textViewName);
            textViewStadium = view.findViewById(R.id.textViewStadium);
            cardViewTeam = view.findViewById(R.id.cardViewTeam);
        }
    }
}
