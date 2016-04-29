package com.hackathontv.model;

/**
 * Author: GrzegorzDec
 * Created by: ModelGenerator on 29/04/16
 */
public class Feed {
    public long id;
    public String identifier;
    public String originalName;
    public long originalBrandId;
    public String originalLanguageCode;
    public int productionYearFrom;
    public String productionYearTo;
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