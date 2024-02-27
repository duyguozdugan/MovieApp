package com.dozdugan.MovieApp.dto.request;

import lombok.Getter;
import lombok.Setter;
import java.time.LocalDate;

@Getter
@Setter
public class MovieRequest {

    private String title;
    private String description;
    private LocalDate relasedDate;
    private Double rating;

}
