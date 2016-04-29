package com.hackathontv;

import com.hackathontv.model.VideoInfo;
import com.hackathontv.model.show.LocalPlayListResponse;
import com.hackathontv.model.show.LocalPlayListVideo;
import com.hackathontv.model.show.LocalPlaylistsItem;
import com.hackathontv.model.show.Show;
import com.hackathontv.network.RestApi;

import android.content.Context;
import android.widget.Toast;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class VideoUrlLoader {

    private final ShowDetailsLoader loaderCallback;

    private Context context;

    public VideoUrlLoader(Context context, final ShowDetailsLoader loaderCallback) {
        this.loaderCallback = loaderCallback;
        this.context = context;
    }

    public void loadVideoUrl(final Show show) {
        final RestApi restApid = new RestApi();
        final LocalPlaylistsItem correctPlayList = show.getCorrectPlayList();
        if (correctPlayList == null) {
            Toast.makeText(context, "No playlist to play!", Toast.LENGTH_LONG).show();
            return;
        }

        restApid.getLocalPlaylistVideo(correctPlayList.id).enqueue(new Callback<LocalPlayListResponse>() {
            @Override
            public void onResponse(final Call<LocalPlayListResponse> call, final Response<LocalPlayListResponse> response) {
                if (response == null || response.body() == null) {
                    loaderCallback.onVideoInfoLoadingError(new Exception("No Video Info - pleas try another video"));
                    return;
                }

                final LocalPlayListResponse body = response.body();
                final LocalPlayListVideo localPlaylistVideo = body.getFistLocalPlayListVideo();
                final String riptideVideoId = localPlaylistVideo.getRiptideVideoId();

                restApid.getVideoInfo(riptideVideoId).enqueue(new Callback<VideoInfo>() {
                    @Override
                    public void onResponse(final Call<VideoInfo> call, final Response<VideoInfo> response) {
                        show.videoUrl = response.body().src;
                        show.duration = response.body().duration;
                        loaderCallback.onVideoInfoLoaded();
                    }

                    @Override
                    public void onFailure(final Call<VideoInfo> call, final Throwable t) {
                        loaderCallback.onVideoInfoLoadingError(t);
                    }
                });
            }

            @Override
            public void onFailure(final Call<LocalPlayListResponse> call, final Throwable t) {
                loaderCallback.onVideoInfoLoadingError(t);
            }
        });
    }

    public interface ShowDetailsLoader {

        void onVideoInfoLoaded();

        void onVideoInfoLoadingError(Throwable t);
    }
}
