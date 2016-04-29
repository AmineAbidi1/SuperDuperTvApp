package com.hackathontv;

import com.hackathontv.cache.EpisodeCache;
import com.hackathontv.cache.SeriesCache;
import com.hackathontv.model.Feed;
import com.hackathontv.model.show.Show;
import com.hackathontv.network.RestApi;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SplashScreenActivity extends Activity {

    Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.context = this;
        downloadFeeds();
    }

    private void downloadFeeds() {
        RestApi restApi = new RestApi();
        Call<List<Feed>> seriesList = restApi.getFranchisesList();
        seriesList.enqueue(new SeriesListCallback());
    }

    private class EpisodeListCallback implements Callback<List<Show>> {

        int showId;

        public EpisodeListCallback(int id) {
            showId = id;
        }

        @Override
        public void onResponse(final Call<List<Show>> call, final Response<List<Show>> response) {
            final EpisodeCache instance = EpisodeCache.getInstance();
            instance.putShowList(showId, response.body());
            if(showId == SeriesCache.getInstance().getLastItemId()){
                final Intent intent = new Intent(context, MainActivity.class);
                context.startActivity(intent);

            }
        }

        @Override
        public void onFailure(final Call<List<Show>> call, final Throwable t) {

        }
    }

    private class SeriesListCallback implements Callback<List<Feed>> {

        @Override
        public void onResponse(final Call<List<Feed>> call, final Response<List<Feed>> response) {
            final List<Feed> feed = response.body();
            SeriesCache.getInstance().setSeriesList(feed);
            downloadEpisodes(feed);
        }

        private void downloadEpisodes(List<Feed> feeds) {
            RestApi restApi = new RestApi();

            for(Feed feed : feeds) {
                restApi.getShowDetails((int) feed.id).enqueue(new EpisodeListCallback((int) feed.id));
            }
        }

        @Override
        public void onFailure(final Call<List<Feed>> call, final Throwable t) {

        }
    }
}
