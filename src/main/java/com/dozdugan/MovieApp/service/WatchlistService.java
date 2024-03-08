package com.dozdugan.MovieApp.service;

import com.dozdugan.MovieApp.converter.UserConverter;
import com.dozdugan.MovieApp.converter.WatchlistConverter;
import com.dozdugan.MovieApp.dto.request.WatchlistRequest;
import com.dozdugan.MovieApp.exception.MovieNotFoundException;
import com.dozdugan.MovieApp.exception.UserNotFoundException;
import com.dozdugan.MovieApp.exception.WatchlistNotFoundException;
import com.dozdugan.MovieApp.model.Movie;
import com.dozdugan.MovieApp.model.User;
import com.dozdugan.MovieApp.model.WatchList;
import com.dozdugan.MovieApp.repository.MovieRepository;
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
    private final MovieRepository movieRepository;

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

    public String createWatchlist(Long id, WatchlistRequest watchList) {
        Optional<User> optionalUser = userRepository.findById(id);
        if (optionalUser.isPresent()) {
            watchList.setUser(optionalUser.get());
            watchlistRepository.save(WatchlistConverter.convertToWatchlist(watchList));
            return "Watchlist was created successfully";
        } else {
            throw new UserNotFoundException("User not found with id: " + id);
        }
    }

    public String deleteWatchlist(Long id) {
        Optional<WatchList> optionalWatchList = watchlistRepository.findById(id);
        if (optionalWatchList.isPresent()) {
            watchlistRepository.delete(optionalWatchList.get());
            return "Watchlist was deleted successfully";
        } else {
            throw new WatchlistNotFoundException("Watchlist not found with id: " + id);
        }
    }

    public String updateWatchlist(Long id, WatchlistRequest watchList) {
        Optional<WatchList> optionalWatchList = watchlistRepository.findById(id);
        Optional<User> user = userRepository.findById(optionalWatchList.get().getUser().getUserId());
        if (optionalWatchList.isPresent()) {
            optionalWatchList.get().setWatchlistId(id);
            optionalWatchList.get().setTitle(watchList.getTitle());
            optionalWatchList.get().setUser(user.get());
            watchlistRepository.save(optionalWatchList.get());
            return "Watchlist updated successfully";
        } else {
            throw new UserNotFoundException("Watchlist not found with id: " + id);
        }
    }

    public String addMovieToWatchList(Long watchListId,Long movieId) {
        Optional<WatchList> optionalWatchList = watchlistRepository.findById(watchListId);
        if(optionalWatchList.isPresent()){
            Optional<Movie> optionalMovie = movieRepository.findById(movieId);
            if(optionalMovie.isPresent()){
                optionalWatchList.get().addMovie(optionalMovie.get());
                watchlistRepository.save(optionalWatchList.get());
                return "Movie with id: "+ movieId + " added Watchlist with id: "+ watchListId+ " is successfully.";
            }else{
                throw new MovieNotFoundException("Movie not found with id: "+movieId);
            }
        }else{
            throw new WatchlistNotFoundException("Watchlist is not found with id: "+watchListId);
        }

    }
}
