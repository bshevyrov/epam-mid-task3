package ua.com.company.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import ua.com.company.model.Director;

import java.util.List;

@Repository
public interface DirectorRepository extends MongoRepository<Director, String> {
    List<Director> findByFirstName(String firstName);
    List<Director> findByLastName(String lastName);
}