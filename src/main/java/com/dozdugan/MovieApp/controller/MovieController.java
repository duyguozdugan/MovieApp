package com.dozdugan.MovieApp.controller;

import com.dozdugan.MovieApp.service.MovieService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;
@RequiredArgsConstructor
@RestController
public class MovieController {
    private final MovieService movieService;
}
