package ua.com.company.service;


import ua.com.company.model.Actor;

import java.util.List;
import java.util.Optional;

public interface ActorService {

    Actor saveActor(Actor actor);

    Optional<Actor> getActorById(String id);

    List<Actor> getActorsByFirstName(String firstName);

    List<Actor> getActorsByLastName(String lastName);

    List<Actor> getAllActors();

    void deleteActor(String id);
}