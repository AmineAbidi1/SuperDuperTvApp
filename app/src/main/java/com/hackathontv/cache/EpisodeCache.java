package com.hackathontv.cache;

import com.hackathontv.model.show.Show;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class EpisodeCache {
    private Map<Integer, List<Show>> episodeMap = new HashMap();

    private static EpisodeCache ourInstance = new EpisodeCache();

    public static EpisodeCache getInstance() {
        return ourInstance;
    }

    private EpisodeCache() {
    }

    public void putShowList(int showId, List<Show> body) {
        episodeMap.put(showId, body);
    }

    public List<Show> getEpisodeList(int id) {
        return episodeMap.get(id);
    }
}
