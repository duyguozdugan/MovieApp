package com.dozdugan.MovieApp.service;

import com.dozdugan.MovieApp.controller.MovieController;
import com.dozdugan.MovieApp.converter.MovieConverter;
import com.dozdugan.MovieApp.converter.UserConverter;
import com.dozdugan.MovieApp.dto.request.MovieRequest;
import com.dozdugan.MovieApp.dto.response.MovieResponse;
import com.dozdugan.MovieApp.repository.MovieRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class MovieService {

    private final MovieRepository movieRepository;

    public MovieResponse createMovie(MovieRequest movieRequest) {
        return  MovieConverter.convertToMovieResponse(movieRepository.save(MovieConverter.convertToMovie(movieRequest)));
    }


    public List<MovieResponse> getAllMovies() {
        return MovieConverter.convertListMovieResponse(movieRepository.findAll());
    }
}
