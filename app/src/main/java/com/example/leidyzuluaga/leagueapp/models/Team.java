package com.example.leidyzuluaga.leagueapp.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class Team implements Serializable{


    @SerializedName("strTeam")
    @Expose
    private String name;

    @SerializedName("strStadium")
    @Expose
    private String stadium;

    @SerializedName("strTeamBadge")
    @Expose
    private String badge;

    @SerializedName("strDescriptionES")
    @Expose
    private String descripcion;

    @SerializedName("intFormedYear")
    @Expose
    private String formedYear;

    @SerializedName("strTeamJersey")
    @Expose
    private String jersey;

    @SerializedName("strWebsite")
    @Expose
    private String webSite;

    @SerializedName("strFacebook")
    @Expose
    private String facebook;

    @SerializedName("strTwitter")
    @Expose
    private String twitter;

    @SerializedName("strInstagram")
    @Expose
    private String instagram;

    @SerializedName("strYoutube")
    @Expose
    private String youtube;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStadium() {
        return stadium;
    }

    public void setStadium(String stadium) {
        this.stadium = stadium;
    }

    public String getBadge() {
        return badge;
    }

    public void setBadge(String badge) {
        this.badge = badge;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getFormedYear() {
        return formedYear;
    }

    public void setFormedYear(String formedYear) {
        this.formedYear = formedYear;
    }

    public String getJersey() {
        return jersey;
    }

    public void setJersey(String jersey) {
        this.jersey = jersey;
    }

    public String getWebSite() {
        return webSite;
    }

    public void setWebSite(String webSite) {
        this.webSite = webSite;
    }

    public String getFacebook() {
        return facebook;
    }

    public void setFacebook(String facebook) {
        this.facebook = facebook;
    }

    public String getTwitter() {
        return twitter;
    }

    public void setTwitter(String twitter) {
        this.twitter = twitter;
    }

    public String getInstagram() {
        return instagram;
    }

    public void setInstagram(String instagram) {
        this.instagram = instagram;
    }

    public String getYoutube() {
        return youtube;
    }

    public void setYoutube(String youtube) {
        this.youtube = youtube;
    }
}
