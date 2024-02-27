package com.dozdugan.MovieApp.service;

import com.dozdugan.MovieApp.repository.MovieRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
@RequiredArgsConstructor
@Service
public class MovieService {

    private final MovieRepository movieRepository;
}
