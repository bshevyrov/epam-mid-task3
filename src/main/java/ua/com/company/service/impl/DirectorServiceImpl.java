package ua.com.company.service.impl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.com.company.model.Director;
import ua.com.company.repository.DirectorRepository;
import ua.com.company.service.DirectorService;

import java.util.List;
import java.util.Optional;

@Service
public class DirectorServiceImpl implements DirectorService {

    @Autowired
    private DirectorRepository directorRepository;

    @Override
    public Director saveDirector(Director director) {
        return directorRepository.save(director);
    }

    @Override
    public Optional<Director> getDirectorById(String id) {
        return directorRepository.findById(id);
    }

    @Override
    public List<Director> getDirectorsByFirstName(String firstName) {
        return directorRepository.findByFirstName(firstName);
    }

    @Override
    public List<Director> getDirectorsByLastName(String lastName) {
        return directorRepository.findByLastName(lastName);
    }

    @Override
    public List<Director> getAllDirectors() {
        return directorRepository.findAll();
    }

    @Override
    public void deleteDirector(String id) {
        directorRepository.deleteById(id);
    }
}