package com.hackathontv.cache;

import com.hackathontv.model.Feed;

import java.util.ArrayList;
import java.util.List;

public class SeriesCache {
    private static SeriesCache ourInstance = new SeriesCache();
    private List<Feed> seriesList = new ArrayList<>();

    public static SeriesCache getInstance() {
        return ourInstance;
    }

    private SeriesCache() {
    }

    public void setSeriesList(List<Feed> seriesList) {
        this.seriesList = seriesList;
    }

    public List<Feed> getSeriesList() {
        return seriesList;
    }

    public int getSize() {
        return seriesList.size();
    }

    public int getLastItemId() {
        return (int) seriesList.get(getSize()-1).id;
    }
}
