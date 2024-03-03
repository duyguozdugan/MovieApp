package com.dozdugan.MovieApp.exception;

public class WatchlistNotFoundException extends RuntimeException{
    public WatchlistNotFoundException(String message) {
        super(message);
    }
}
