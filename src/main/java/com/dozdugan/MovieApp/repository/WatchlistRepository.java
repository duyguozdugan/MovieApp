package com.dozdugan.MovieApp.repository;

import com.dozdugan.MovieApp.model.WatchList;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WatchlistRepository extends JpaRepository<WatchList, Long> {
}
