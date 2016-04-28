package com.hackathontv.model;

/**
 * Author: GrzegorzDec
 * Created by: ModelGenerator on 28/04/16
 */
public class Series {
    public Tags tags;
    public String originalTitle;
    public long franchiseId;
    public long seasonId;
    public long id;
    public int numberInSeries;
    public int numberInSeason;
    public long seriesId;
    public String identifier;
    public String localTitle;
    public String localShortDescription;
    public String localLongDescription;
    public String seriesCategory;
    public Season season;
    public ParentalRating parentalRating;
    public LocalPlaylistsItem[] localPlaylists;
    public String publishedFrom;
    public PublishedUntil publishedUntil;
    public int accessLevel;
    public String playlistCategory;
    public long playlistVideoPosition;
    public Franchise franchise;
    public VodLandscapeImage vodLandscapeImage;
    public VodPortraitImage vodPortraitImage;
    public VodSquareImage vodSquareImage;
    public Image image;
}