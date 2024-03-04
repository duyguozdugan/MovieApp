package com.dozdugan.MovieApp.service;

import com.dozdugan.MovieApp.converter.MovieConverter;
import com.dozdugan.MovieApp.converter.UserConverter;
import com.dozdugan.MovieApp.dto.request.MovieRequest;
import com.dozdugan.MovieApp.dto.response.MovieResponse;
import com.dozdugan.MovieApp.exception.MovieAlreadyExistsException;
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
public class MovieService {

    private final MovieRepository movieRepository;
    private final WatchlistRepository watchlistRepository;
    private final UserRepository userRepository;

     public String createMovie(Long watchlistId, MovieRequest movieRequest){

         Optional<WatchList> optionalWatchList= watchlistRepository.findById(watchlistId);
         if (optionalWatchList.isPresent()){
             Movie movie= MovieConverter.convertToMovie(movieRequest);
             optionalWatchList.get().addMovie(movie);
             movieRepository.save(movie);
             return "Movie created successfully.";
         }
         else{
             throw new WatchlistNotFoundException("Watchlist not found with id: "+watchlistId);
         }

     }


    public List<MovieResponse> getAllMovies() {
        return MovieConverter.convertListMovieResponse(movieRepository.findAll());
    }

    public MovieResponse getMovieById(Long id) {
        Optional<Movie> movie =movieRepository.findById(id);
        if (movie.isPresent()){
            return MovieConverter.convertToMovieResponse(movie.get());
        }else{
            throw new MovieNotFoundException("Movie not found with id: "+id);
        }

    }

    public String updateMovie(Long id, MovieRequest movieRequest) {
        Optional<Movie> movieOptional = movieRepository.findById(id);
        if (movieOptional.isPresent()){
            Movie oldMovie= movieOptional.get();
            oldMovie.setTitle(movieRequest.getTitle());
            oldMovie.setDescription(movieRequest.getDescription());
            oldMovie.setRating(movieRequest.getRating());
            oldMovie.setRelasedDate(movieRequest.getRelasedDate());
            movieRepository.save(oldMovie);
            return "Update succesfull.";
        }
        return "Update failed.";
    }


    public void deleteMovie(Long id) {
        movieRepository.deleteById(id);
    }


}
