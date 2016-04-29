package com.hackathontv.network;

import com.hackathontv.model.VideoInfo;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface VideoService {

    //https://videos.mtvnn.com/api/v2/0325385f2c9ef7fa4e1ad1bbdbcad147?video_format=hls&format=json
    @GET("{riptideId}?video_format=hls&format=json")
    Call<VideoInfo> getVideoInfo(@Path("riptideId") String riptideId);
}
