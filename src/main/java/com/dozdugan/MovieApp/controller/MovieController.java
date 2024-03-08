package com.dozdugan.MovieApp.controller;

import com.dozdugan.MovieApp.dto.request.MovieRequest;
import com.dozdugan.MovieApp.dto.response.MovieResponse;
import com.dozdugan.MovieApp.service.MovieService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RequestMapping("v1/api/movies")
@RequiredArgsConstructor
@RestController
public class MovieController {
    private final MovieService movieService;

    /* @PostMapping("/{watchlistId}")
    public String createMovie(@PathVariable Long watchlistId, @RequestBody MovieRequest movieRequest) {
        return movieService.createMovie(watchlistId,movieRequest);
    } */

    @PostMapping()
    public String createMovie(@RequestBody MovieRequest movieRequest){
        return movieService.createMovie(movieRequest);
    }

    @PutMapping("/status/{id}")
    public  String changeIsWatchedStatus(@PathVariable Long id,@RequestParam String status){
        return movieService.changeIsWatched(id,status);
    }

    @GetMapping()
    public List<MovieResponse> getAlMovies(){
        return movieService.getAllMovies();
    }

    @GetMapping("/{id}")
    public MovieResponse getMovieById(@PathVariable Long id){
        return movieService.getMovieById(id);
    }

    @PutMapping("/{id}")
    public String updateMovie(@PathVariable Long id,@RequestBody MovieRequest movieRequest){
        return movieService.updateMovie(id, movieRequest);
    }

    @DeleteMapping("/{id}")
    public String deleteMovie(@PathVariable Long id){
        return movieService.deleteMovie(id);
    }
}
