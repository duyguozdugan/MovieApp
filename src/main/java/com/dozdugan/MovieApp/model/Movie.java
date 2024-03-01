package com.dozdugan.MovieApp.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name="movie")
public class Movie {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long movieId;
    private String title;
    private String description;
    private LocalDate relasedDate;
    private Double rating;

    @ManyToMany(mappedBy = "movies")
    private List<WatchList> watchLists;
}
