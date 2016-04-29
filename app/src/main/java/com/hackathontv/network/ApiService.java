package com.hackathontv.network;

import com.hackathontv.model.Feed;
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
}
