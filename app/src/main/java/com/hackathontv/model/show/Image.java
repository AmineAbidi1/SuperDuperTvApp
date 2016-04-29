package com.hackathontv.model.show;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.net.URI;

/**
 * Author: GrzegorzDec
 * Created by: ModelGenerator on 29/04/16
 */
public class Image implements Serializable {
    public static final String BaseURL = "http://images.mtvnn.com/";
    public static final String cartImageSize = "/200x200";
    public static final String size500 = "/200x200";

    @SerializedName("riptide_image_id")
    public String riptideImageId;
    public String caption;
    public String copyright;
    public String photographer;

    public String getCardImageUrl() {
        return BaseURL + riptideImageId + cartImageSize;
    }

    public String get500x500Url() {
        return BaseURL + riptideImageId + size500;

    }

    public URI getBackgroundImageURI() {
        return URI.create(get500x500Url());
    }
}