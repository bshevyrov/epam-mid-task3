package ua.com.company.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ua.com.company.model.Actor;
import ua.com.company.service.ActorService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/actors")
public class ActorController {

    @Autowired
    private ActorService actorService;

    @PostMapping
    public ResponseEntity<Actor> createActor(@RequestBody Actor actor) {
        Actor savedActor = actorService.saveActor(actor);
        return new ResponseEntity<>(savedActor, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Actor> getActorById(@PathVariable String id) {
        Optional<Actor> actor = actorService.getActorById(id);
        return actor.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping("/search/first-name")
    public ResponseEntity<List<Actor>> getActorsByFirstName(@RequestParam String firstName) {
        List<Actor> actors = actorService.getActorsByFirstName(firstName);
        return ResponseEntity.ok(actors);
    }

    @GetMapping("/search/last-name")
    public ResponseEntity<List<Actor>> getActorsByLastName(@RequestParam String lastName) {
        List<Actor> actors = actorService.getActorsByLastName(lastName);
        return ResponseEntity.ok(actors);
    }

    @GetMapping
    public ResponseEntity<List<Actor>> getAllActors() {
        List<Actor> actors = actorService.getAllActors();
        return ResponseEntity.ok(actors);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteActor(@PathVariable String id) {
        actorService.deleteActor(id);
        return ResponseEntity.noContent().build();
    }
}