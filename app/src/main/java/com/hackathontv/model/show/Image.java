package com.hackathontv.model.show;

import com.google.gson.annotations.SerializedName;

/**
 * Author: GrzegorzDec
 * Created by: ModelGenerator on 29/04/16
 */
public class Image {
    public static final String BaseURL = "http://images.mtvnn.com/";
    public static final String cartImageSize = "/200x200";

    @SerializedName("riptide_image_id")
    public String riptideImageId;
    public String caption;
    public String copyright;
    public String photographer;

    public String getCardImageUrl() {
        return BaseURL + riptideImageId + cartImageSize;
    }
}