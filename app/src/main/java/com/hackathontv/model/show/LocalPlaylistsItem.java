package com.hackathontv.model.show;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

/**
 * Author: GrzegorzDec
 * Created by: ModelGenerator on 29/04/16
 */
public class LocalPlaylistsItem implements Serializable {

    public String id;

    public String category;

    @SerializedName("language_code")
    public String languageCode;

    public String localPlaylistContextIdentifier;
}