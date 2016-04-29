package com.hackathontv.model.show;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class LocalPlayListResponse {

    public String language_code;

    public String category;

    public String id;

    @SerializedName("local_playlist_videos")
    public List<LocalPlayListVideo> localPlaylistVideos;

    public LocalPlayListVideo getFistLocalPlayListVideo() {
        if (localPlaylistVideos != null && localPlaylistVideos.size() > 0) {
            return localPlaylistVideos.get(0);
        }
        return null;
    }
}
