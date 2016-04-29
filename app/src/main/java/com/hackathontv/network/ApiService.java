package com.hackathontv.network;

import com.hackathontv.model.Feed;
import com.hackathontv.model.show.LocalPlayListResponse;
import com.hackathontv.model.show.Show;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface ApiService {

    @GET("{language}/franchises.json")
    Call<List<Feed>> getFranchisesList(@Path("language") String language);

    @GET("{language}/franchises/{showId}/shows/episodes.json")
    Call<List<Show>> getEpisodeList(@Path("language") String language, @Path("showId") int showId);

    // https://api.mtvnn.com/v2/site/4d59cu0qkf/en/local_playlists/7524a0b41ae9855f0a52.json
    @GET("{language}/local_playlists/{playlistId}.json")
    Call<LocalPlayListResponse> getLocalPlaylistVideo(@Path("language") String language, @Path("playlistId") String playlistId);
}
