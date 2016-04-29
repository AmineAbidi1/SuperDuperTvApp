package com.hackathontv.network;

import com.google.gson.Gson;

import com.hackathontv.model.Feed;

import java.util.List;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RestApi {

    public static final String BASE_URL = "https://api.mtvnn.com/v2/site/4d59cu0qkf/";

    private final ApiService mApiService;

    public RestApi() {
        mApiService = createApiService();
    }

    public Call<List<Feed>> getFranchisesList() {
        return mApiService.getFranchisesList("en");
    }

    protected ApiService createApiService() {
        Retrofit retrofit = new Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create(new Gson()))
                .baseUrl(BASE_URL)
                .build();
        return retrofit.create(ApiService.class);
    }
}
