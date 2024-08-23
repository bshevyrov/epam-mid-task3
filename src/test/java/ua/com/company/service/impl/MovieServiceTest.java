package ua.com.company.service.impl;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import ua.com.company.model.Movie;
import ua.com.company.repository.MovieRepository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@SpringBootTest
class MovieServiceTest {

    @Mock
    private MovieRepository movieRepository;

    @InjectMocks
    private MovieServiceImpl movieService;

    public MovieServiceTest() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testSaveMovie() {
        Movie movie = new Movie();
        movie.setTitle("Test Movie");
        when(movieRepository.save(movie)).thenReturn(movie);

        Movie savedMovie = movieService.saveMovie(movie);
        assertNotNull(savedMovie);
        assertEquals("Test Movie", savedMovie.getTitle());
    }

    @Test
    void testGetMovieById() {
        Movie movie = new Movie();
        movie.setId("1");
        when(movieRepository.findById("1")).thenReturn(Optional.of(movie));

        Optional<Movie> foundMovie = movieService.getMovieById("1");
        assertTrue(foundMovie.isPresent());
        assertEquals("1", foundMovie.get().getId());
    }

    @Test
    void testGetMoviesByTitle() {
        Movie movie = new Movie();
        movie.setTitle("Test Movie");
        when(movieRepository.findByTitle("Test Movie")).thenReturn(List.of(movie));

        List<Movie> movies = movieService.getMoviesByTitle("Test Movie");
        assertFalse(movies.isEmpty());
        assertEquals("Test Movie", movies.get(0).getTitle());
    }

    @Test
    void testGetMoviesByReleaseDate() {
        Movie movie = new Movie();
        movie.setReleaseDate(LocalDate.of(2024, 8, 23));
        when(movieRepository.findByReleaseDate(LocalDate.of(2024, 8, 23)))
                .thenReturn(List.of(movie));

        List<Movie> movies = movieService.getMoviesByReleaseDate(LocalDate.of(2024, 8, 23));
        assertFalse(movies.isEmpty());
        assertEquals(LocalDate.of(2024, 8, 23), movies.get(0).getReleaseDate());
    }

    @Test
    void testDeleteMovie() {
        movieService.deleteMovie("1");
        verify(movieRepository, times(1)).deleteById("1");
    }
}