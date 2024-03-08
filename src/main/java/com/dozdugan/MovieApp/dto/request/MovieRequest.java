package com.dozdugan.MovieApp.dto.request;

import com.dozdugan.MovieApp.model.WatchList;
import lombok.Getter;
import lombok.Setter;
import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
public class MovieRequest {

    private String title;
    private String description;
    private LocalDate relasedDate;
    private Double rating;
}
