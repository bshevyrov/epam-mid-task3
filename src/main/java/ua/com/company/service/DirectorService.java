package ua.com.company.service;



import ua.com.company.model.Director;

import java.util.List;
import java.util.Optional;

public interface DirectorService {

    Director saveDirector(Director director);

    Optional<Director> getDirectorById(String id);

    List<Director> getDirectorsByFirstName(String firstName);

    List<Director> getDirectorsByLastName(String lastName);

    List<Director> getAllDirectors();

    void deleteDirector(String id);
}