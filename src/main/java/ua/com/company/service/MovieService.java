package ua.com.company.service;


import ua.com.company.model.Movie;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface MovieService {

    Movie saveMovie(Movie movie);

    Optional<Movie> getMovieById(String id);

    List<Movie> getMoviesByTitle(String title);

    List<Movie> getMoviesByReleaseDate(LocalDate releaseDate);

    List<Movie> getAllMovies();

    void deleteMovie(String id);
}