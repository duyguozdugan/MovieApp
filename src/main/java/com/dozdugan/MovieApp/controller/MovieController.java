package com.dozdugan.MovieApp.controller;

import com.dozdugan.MovieApp.dto.request.MovieRequest;
import com.dozdugan.MovieApp.dto.response.MovieResponse;
import com.dozdugan.MovieApp.service.MovieService;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class MovieController {
    private final MovieService movieService;

    @PostMapping()
    public MovieResponse createMovie(@RequestBody MovieRequest movieRequest){
        return movieService.createMovie(movieRequest);
    }

    @GetMapping()
    public List<MovieResponse> getAlMovies(){
        return movieService.getAllMovies();
    }
}
