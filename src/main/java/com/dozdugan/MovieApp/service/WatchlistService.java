package com.dozdugan.MovieApp.service;

import com.dozdugan.MovieApp.converter.UserConverter;
import com.dozdugan.MovieApp.exception.UserNotFoundException;
import com.dozdugan.MovieApp.exception.WatchlistNotFoundException;
import com.dozdugan.MovieApp.model.User;
import com.dozdugan.MovieApp.model.WatchList;
import com.dozdugan.MovieApp.repository.UserRepository;
import com.dozdugan.MovieApp.repository.WatchlistRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class WatchlistService {

    private final WatchlistRepository watchlistRepository;
    private final UserRepository userRepository;


    public List<WatchList> getAllWatchlist() {
        return watchlistRepository.findAll();
    }

    public WatchList getWatchlistById(Long id) {
        Optional<WatchList> optionalWatchlist = watchlistRepository.findById(id);
        if (optionalWatchlist.isPresent()) {
            return optionalWatchlist.get();
        } else {
            throw new WatchlistNotFoundException("Watchlist not found with id: " + id);
        }
    }

    public String createWatchlist(Long id, WatchList watchList) {
        Optional<User> optionalUser = userRepository.findById(id);
        if (optionalUser.isPresent()) {
            watchList.setUser(optionalUser.get());
            watchlistRepository.save(watchList);
            return "Watchlist created successfully";
        } else {
            throw new UserNotFoundException("User not found with id: " + id);
        }
    }

    public String deleteWatchlist(Long id) {
        Optional<WatchList> optionalWatchList = watchlistRepository.findById(id);
        if (optionalWatchList.isPresent()) {
            watchlistRepository.delete(optionalWatchList.get());
            return "Watchlist deleted successfully";
        } else {
            throw new WatchlistNotFoundException("Watchlist not found with id: " + id);
        }
    }

    public String updateWatchlist(Long id, WatchList watchList) {
        Optional<WatchList> optionalWatchList = watchlistRepository.findById(id);
        if (optionalWatchList.isPresent()) {
            watchList.setWatchlistId(id);
            watchlistRepository.save(watchList);
            return "Watchlist updated successfully";
        } else {
            throw new UserNotFoundException("Watchlist not found with id: " + id);
        }
    }


}
