package ua.com.company.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ua.com.company.model.Director;
import ua.com.company.service.DirectorService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/directors")
public class DirectorController {

    @Autowired
    private DirectorService directorService;

    @PostMapping
    public ResponseEntity<Director> createDirector(@RequestBody Director director) {
        Director savedDirector = directorService.saveDirector(director);
        return new ResponseEntity<>(savedDirector, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Director> getDirectorById(@PathVariable String id) {
        Optional<Director> director = directorService.getDirectorById(id);
        return director.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping("/search/first-name")
    public ResponseEntity<List<Director>> getDirectorsByFirstName(@RequestParam String firstName) {
        List<Director> directors = directorService.getDirectorsByFirstName(firstName);
        return ResponseEntity.ok(directors);
    }

    @GetMapping("/search/last-name")
    public ResponseEntity<List<Director>> getDirectorsByLastName(@RequestParam String lastName) {
        List<Director> directors = directorService.getDirectorsByLastName(lastName);
        return ResponseEntity.ok(directors);
    }

    @GetMapping
    public ResponseEntity<List<Director>> getAllDirectors() {
        List<Director> directors = directorService.getAllDirectors();
        return ResponseEntity.ok(directors);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteDirector(@PathVariable String id) {
        directorService.deleteDirector(id);
        return ResponseEntity.noContent().build();
    }
}
