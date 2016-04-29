package com.hackathontv.model.show;

import com.google.gson.annotations.SerializedName;

/**
 * Author: GrzegorzDec
 * Created by: ModelGenerator on 29/04/16
 */
public class Show {
    public String tags;
    @SerializedName("original_title")
    public String originalTitle;
    public long franchiseId;
    public long seasonId;
    public long id;
    public int numberInSeries;
    public int numberInSeason;
    public long seriesId;
    public String identifier;
    public String localTitle;
    @SerializedName("local_short_description")
    public String localShortDescription;
    public String localLongDescription;
    public String seriesCategory;
    public Season season;
    public ParentalRating parentalRating;
    public LocalPlaylistsItem[] localPlaylists;
    public String publishedFrom;
    public String publishedUntil;
    public int accessLevel;
    public String playlistCategory;
    public long playlistVideoPosition;
    public Franchise franchise;
    public String vodLandscapeImage;
    public String vodPortraitImage;
    public String vodSquareImage;
    public Image image;

}