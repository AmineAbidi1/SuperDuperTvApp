package com.hackathontv.network;

import com.google.gson.Gson;

import com.hackathontv.model.Feed;
import com.hackathontv.model.VideoInfo;
import com.hackathontv.model.show.LocalPlayListResponse;
import com.hackathontv.model.show.Show;

import java.util.List;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RestApi {

    public static final String VIDEO_URL = "https://videos.mtvnn.com/api/v2/";

    public static final String BASE_URL = "https://api.mtvnn.com/v2/site/4d59cu0qkf/";

    private final ApiService mApiService;

    private final VideoService mVideoService;

    public RestApi() {
        mApiService = createApiService();
        mVideoService = createVideoService();
    }

    public Call<List<Feed>> getFranchisesList() {
        return mApiService.getFranchisesList("en");
    }

    public Call<List<Show>> getShowDetails(final int showId) {
        return mApiService.getEpisodeList("en", showId);
    }

    public Call<LocalPlayListResponse> getLocalPlaylistVideo(final String plistId) {
        return mApiService.getLocalPlaylistVideo("en", plistId);
    }

    public Call<VideoInfo> getVideoInfo(final String riptide) {
        return mVideoService.getVideoInfo(riptide);
    }

    protected ApiService createApiService() {
        final HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        final OkHttpClient client = new OkHttpClient.Builder().addInterceptor(interceptor).build();

        final Retrofit retrofit = new Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create(new Gson()))
                .client(client)
                .baseUrl(BASE_URL)
                .build();
        return retrofit.create(ApiService.class);
    }

    private VideoService createVideoService() {
        final HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        final OkHttpClient client = new OkHttpClient.Builder().addInterceptor(interceptor).build();

        final Retrofit retrofit = new Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create(new Gson()))
                .client(client)
                .baseUrl(VIDEO_URL)
                .build();
        return retrofit.create(VideoService.class);
    }
}
