package ua.com.company.repository;


import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import ua.com.company.model.Actor;

import java.util.List;

@Repository
public interface ActorRepository extends MongoRepository<Actor, String> {
    List<Actor> findByFirstName(String firstName);
    List<Actor> findByLastName(String lastName);
}