package com.dozdugan.MovieApp.service;

import com.dozdugan.MovieApp.converter.MovieConverter;
import com.dozdugan.MovieApp.dto.request.MovieRequest;
import com.dozdugan.MovieApp.dto.response.MovieResponse;
import com.dozdugan.MovieApp.exception.MovieNotFoundException;
import com.dozdugan.MovieApp.model.IsWatched;
import com.dozdugan.MovieApp.model.Movie;
import com.dozdugan.MovieApp.repository.MovieRepository;
import com.dozdugan.MovieApp.repository.UserRepository;
import com.dozdugan.MovieApp.repository.WatchlistRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class MovieService {

    private final MovieRepository movieRepository;
   // Watchlist id'ye göre ekleme
   /*  public String createMovie(Long watchlistId, MovieRequest movieRequest){
         Optional<WatchList> optionalWatchList= watchlistRepository.findById(watchlistId);
         if (optionalWatchList.isPresent()){
             Movie movie= MovieConverter.convertToMovie(movieRequest);
             optionalWatchList.get().addMovie(movie);
             movieRepository.save(movie);
             return "Movie created successfully.";
         }
         else{
             throw new WatchlistNotFoundException("Watchlist not found with id: "+watchlistId);
}
     } */

    public String createMovie(MovieRequest movieRequest){
        movieRepository.save(MovieConverter.convertToMovie(movieRequest));
        return "Movie is created is successfully.";
    }
    public String changeIsWatched(Long id, String trueOrFalse) {
        Optional<Movie> movieOptional = movieRepository.findById(id);

        if (movieOptional.isPresent()) { // Filmin varlığını kontrol et
            Movie movie = movieOptional.get();
            if (trueOrFalse.toLowerCase().equals("true")) {
                movie.setIsWatched(IsWatched.TRUE);
            } else {
                movie.setIsWatched(IsWatched.FALSE);
            }
            movieRepository.save(movie); // Değiştirilen filmi kaydet
            return "Changes saved.";
        } else {
            throw new MovieNotFoundException("Movie not found with id: "+id);
        }
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
            return "Movie was updated successfully.";
        }
        return "Movie update failed.";
    }


    public String deleteMovie(Long id) {
        movieRepository.deleteById(id);
        return "Movie was deleted successfully";
    }

}
