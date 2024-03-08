package com.dozdugan.MovieApp.dto.response;

import com.dozdugan.MovieApp.model.Movie;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
@Getter
@Setter
public class WatchlistResponse {

    private String title;
    private List<Movie> movies;
}
