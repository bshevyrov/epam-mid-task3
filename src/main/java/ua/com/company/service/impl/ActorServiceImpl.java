package ua.com.company.service.impl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.com.company.model.Actor;
import ua.com.company.repository.ActorRepository;
import ua.com.company.service.ActorService;

import java.util.List;
import java.util.Optional;

@Service
public class ActorServiceImpl implements ActorService {

    @Autowired
    private ActorRepository actorRepository;

    @Override
    public Actor saveActor(Actor actor) {
        return actorRepository.save(actor);
    }

    @Override
    public Optional<Actor> getActorById(String id) {
        return actorRepository.findById(id);
    }

    @Override
    public List<Actor> getActorsByFirstName(String firstName) {
        return actorRepository.findByFirstName(firstName);
    }

    @Override
    public List<Actor> getActorsByLastName(String lastName) {
        return actorRepository.findByLastName(lastName);
    }

    @Override
    public List<Actor> getAllActors() {
        return actorRepository.findAll();
    }

    @Override
    public void deleteActor(String id) {
        actorRepository.deleteById(id);
    }
}