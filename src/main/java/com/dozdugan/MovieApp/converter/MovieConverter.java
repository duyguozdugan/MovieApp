package com.dozdugan.MovieApp.converter;

import com.dozdugan.MovieApp.dto.request.MovieRequest;
import com.dozdugan.MovieApp.dto.response.MovieResponse;
import com.dozdugan.MovieApp.model.Movie;
import lombok.experimental.UtilityClass;

import java.util.ArrayList;
import java.util.List;

@UtilityClass
public class MovieConverter {

    public static Movie convertToMovie(MovieRequest movieRequest){
        Movie movie = new Movie();
        movie.setTitle(movieRequest.getTitle());
        movie.setDescription(movieRequest.getDescription());
        movie.setRelasedDate(movieRequest.getRelasedDate());
        movie.setRating(movieRequest.getRating());
        return movie;
    }

    public static MovieResponse convertToMovieResponse(Movie movie){
        MovieResponse movieResponse= new MovieResponse();
        movieResponse.setTitle(movie.getTitle());
        movieResponse.setDescription(movie.getDescription());
        movieResponse.setRelasedDate(movie.getRelasedDate());
        movieResponse.setRating(movie.getRating());
        return movieResponse;
    }

    public static List<MovieResponse> convertListMovieResponse(List<Movie> movies){
        List<MovieResponse> movieResponses=new ArrayList<>();

        for (Movie movie: movies){
            MovieResponse movieResponse=new MovieResponse();
            movieResponse.setTitle(movie.getTitle());
            movieResponse.setDescription(movie.getDescription());
            movieResponse.setRelasedDate(movie.getRelasedDate());
            movieResponse.setRating(movie.getRating());
            movieResponses.add(movieResponse);
        }
        return movieResponses;
    }
}
