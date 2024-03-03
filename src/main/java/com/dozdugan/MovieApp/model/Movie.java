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

    @ManyToMany
    @JoinTable(
            name = "movie_genre",
            joinColumns = @JoinColumn(name = "movie_id"),
            inverseJoinColumns = @JoinColumn(name = "genre_id"))
    private List<WatchList> WatchList;

    public void addWatchList(WatchList watchList){
        WatchList.add(watchList);
    }

    public void removeWatchList(WatchList watchList){
        WatchList.remove(watchList);
    }




}
