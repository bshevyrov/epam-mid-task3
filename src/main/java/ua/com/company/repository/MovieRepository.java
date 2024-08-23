package ua.com.company.repository;


import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import ua.com.company.model.Movie;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface MovieRepository extends MongoRepository<Movie, String> {
    List<Movie> findByTitle(String title);
    List<Movie> findByReleaseDate(LocalDate releaseDate);
}