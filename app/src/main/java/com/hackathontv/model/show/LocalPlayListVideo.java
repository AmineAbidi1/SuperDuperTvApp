package com.hackathontv.model.show;

import com.google.gson.annotations.SerializedName;

public class LocalPlayListVideo {

    String id;

    String name;

    @SerializedName("riptide_video_id")
    String riptideVideoId;

    @SerializedName("riptide_image_id")
    String riptideImageId;

    public String getRiptideVideoId() {
        return riptideVideoId;
    }
}
