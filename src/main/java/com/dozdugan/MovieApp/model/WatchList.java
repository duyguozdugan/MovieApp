package com.dozdugan.MovieApp.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
@Getter
@Setter
@Entity
@Table(name = "watchlist")
public class WatchList {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long watchlistId;

    private String title;

    @ManyToOne(cascade = {CascadeType.DETACH,
                          CascadeType.MERGE,
                          CascadeType.PERSIST,
                          CascadeType.REFRESH})
    @JoinColumn(name="user_id")
    @JsonIgnore
    private User user;

    @ManyToMany
    @JoinTable(
            name = "movie_watchlist",
            joinColumns = @JoinColumn(name = "watchlist_id"),
            inverseJoinColumns = @JoinColumn(name = "movie_id"))
    private List<Movie> movies;

    public void addMovie(Movie movie){
        movies.add(movie);
    }

    public void removeMovie(Movie movie){
        movies.remove(movie);
    }


    public WatchList() {
    }

    public WatchList(String title) {
        this.title = title;
    }
}
