package com.dozdugan.MovieApp.repository;

import com.dozdugan.MovieApp.model.Movie;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MovieRepository extends JpaRepository<Movie,Long> {
}
