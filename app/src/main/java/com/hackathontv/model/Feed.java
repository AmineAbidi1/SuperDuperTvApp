package com.hackathontv.model;

import com.google.gson.annotations.SerializedName;

/**
 * Author: GrzegorzDec
 * Created by: ModelGenerator on 29/04/16
 */
public class Feed {
    public long id;
    public String identifier;
    @SerializedName("original_name")
    public String originalName;
    public long originalBrandId;
    public String originalLanguageCode;
    public Integer productionYearFrom;
    public Integer productionYearTo;
    public String genre;
    public boolean corporate;
    public String logoRiptideId;
    public String socialHashtag;
    public String localTitle;
    public String localShortDescription;
    public String localLongDescription;
    public SeriesItem[] series;
    public LatestEpisode latestEpisode;
    public Image image;
    public String vodLandscapeImage;
    public String vodPortraitImage;
    public String vodSquareImage;
}