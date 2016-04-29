package com.hackathontv.model.show;

import com.google.gson.annotations.SerializedName;

import com.hackathontv.model.Image;

import java.io.Serializable;
import java.util.Objects;

/**
 * Author: GrzegorzDec
 * Created by: ModelGenerator on 29/04/16
 */
public class Show implements Serializable {

    public String tags;

    @SerializedName("original_title")
    public String originalTitle;

    @SerializedName("franchise_id")
    public long franchiseId;

    @SerializedName("season_id")
    public long seasonId;

    public long id;

    public int numberInSeries;

    public int numberInSeason;

    public long seriesId;

    public String identifier;

    @SerializedName("local_title")
    public String localTitle;

    @SerializedName("local_short_description")
    public String localShortDescription;

    @SerializedName("local_long_description")
    public String localLongDescription;

    public String seriesCategory;

    public Season season;

    public ParentalRating parentalRating;

    @SerializedName("local_playlists")
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
    public String videoUrl;

    public LocalPlaylistsItem getCorrectPlayList() {
        if (localPlaylists == null || localPlaylists.length == 0) {
            return null;
        }
        for (final LocalPlaylistsItem localPlaylist : localPlaylists) {
            if (Objects.equals(localPlaylist.languageCode, "en")) {
                return localPlaylist;
            }
        }
        return localPlaylists[0];
    }
}