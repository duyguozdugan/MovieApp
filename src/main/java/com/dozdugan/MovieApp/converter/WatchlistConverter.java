package com.dozdugan.MovieApp.converter;

import com.dozdugan.MovieApp.dto.request.WatchlistRequest;
import com.dozdugan.MovieApp.model.WatchList;

public class WatchlistConverter {

    public static WatchList convertToWatchlist(WatchlistRequest watchlistRequest){
        WatchList watchList = new WatchList();
        watchList.setUser(watchlistRequest.getUser());
        watchList.setTitle(watchlistRequest.getTitle());
        return watchList;
    }
}
