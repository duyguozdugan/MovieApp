package com.dozdugan.MovieApp.service;

import com.dozdugan.MovieApp.converter.MovieConverter;
import com.dozdugan.MovieApp.dto.request.MovieRequest;
import com.dozdugan.MovieApp.dto.response.MovieResponse;
import com.dozdugan.MovieApp.exception.MovieAlreadyExistsException;
import com.dozdugan.MovieApp.exception.MovieNotFoundException;
import com.dozdugan.MovieApp.model.Movie;
import com.dozdugan.MovieApp.repository.MovieRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class MovieService {

    private final MovieRepository movieRepository;

    public MovieResponse createMovie(MovieRequest movieRequest) {
        Optional<Movie> movieByName = movieRepository.findByTitle(movieRequest.getTitle());
        if(movieByName.isPresent()){
            if( movieRepository.findByRelasedDate(movieByName.get().getRelasedDate()).isPresent()){
                throw new MovieAlreadyExistsException("Movie alreadt exists with name and relased date: "+ movieByName.get().getTitle() + movieByName.get().getRelasedDate());
            }
        }
        return  MovieConverter.convertToMovieResponse(movieRepository.save(MovieConverter.convertToMovie(movieRequest)));
    }


    public List<MovieResponse> getAllMovies() {
        return MovieConverter.convertListMovieResponse(movieRepository.findAll());
    }

    public MovieResponse getMovieById(Long id) {
        Optional<Movie> movie =movieRepository.findById(id);
        if (movie.isPresent()){
            return MovieConverter.convertToMovieResponse(movie.get());
        }else{
            throw new MovieNotFoundException("Movie not found with id: "+id);
        }

    }

    public String updateMovie(Long id, MovieRequest movieRequest) {
        Optional<Movie> movieOptional = movieRepository.findById(id);
        if (movieOptional.isPresent()){
            Movie oldMovie= movieOptional.get();
            oldMovie.setTitle(movieRequest.getTitle());
            oldMovie.setDescription(movieRequest.getDescription());
            oldMovie.setRating(movieRequest.getRating());
            oldMovie.setRelasedDate(movieRequest.getRelasedDate());
            movieRepository.save(oldMovie);
            return "Update succesfull.";
        }
        return "Update failed.";
    }


    public void deleteMovie(Long id) {
        movieRepository.deleteById(id);
    }
}
