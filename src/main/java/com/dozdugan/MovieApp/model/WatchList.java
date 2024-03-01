package com.dozdugan.MovieApp.model;

import jakarta.persistence.*;
import lombok.NoArgsConstructor;

import java.util.List;

@Table(name = "watchlist")
@Entity
@NoArgsConstructor
public class WatchList {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long watchlistId;

    @ManyToOne
    @JoinColumn(name="user_id")
    private User user;
    @ManyToMany
    @JoinTable(
            name = "watchlist_movies",
            joinColumns = @JoinColumn(name = "watchlist_id"),
            inverseJoinColumns = @JoinColumn(name = "movie_id")
    )
    private List<Movie> movies;


}
