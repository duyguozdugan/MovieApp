package com.dozdugan.MovieApp.repository;

import com.dozdugan.MovieApp.model.Movie;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.Optional;

public interface MovieRepository extends JpaRepository<Movie,Long> {


    Optional<Movie> findByTitle(String title);
    Optional<Movie> findByRelasedDate(LocalDate date);
}
