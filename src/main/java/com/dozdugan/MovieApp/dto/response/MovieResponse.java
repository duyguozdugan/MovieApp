package com.dozdugan.MovieApp.dto.response;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class MovieResponse {

    private String title;
    private String description;
    private LocalDate relasedDate;
    private Double rating;
}
