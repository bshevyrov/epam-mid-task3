package ua.com.company.service.impl;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import ua.com.company.model.Actor;
import ua.com.company.repository.ActorRepository;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@SpringBootTest
 class ActorServiceTest {

    @Mock
    private ActorRepository actorRepository;

    @InjectMocks
    private ActorServiceImpl actorService;

     ActorServiceTest() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
     void testSaveActor() {
        Actor actor = new Actor();
        actor.setFirstName("John");
        when(actorRepository.save(actor)).thenReturn(actor);

        Actor savedActor = actorService.saveActor(actor);
        assertNotNull(savedActor);
        assertEquals("John", savedActor.getFirstName());
    }

    @Test
     void testGetActorById() {
        Actor actor = new Actor();
        actor.setId("1");
        when(actorRepository.findById("1")).thenReturn(Optional.of(actor));

        Optional<Actor> foundActor = actorService.getActorById("1");
        assertTrue(foundActor.isPresent());
        assertEquals("1", foundActor.get().getId());
    }

    @Test
     void testGetActorsByFirstName() {
        Actor actor = new Actor();
        actor.setFirstName("John");
        when(actorRepository.findByFirstName("John")).thenReturn(List.of(actor));

        List<Actor> actors = actorService.getActorsByFirstName("John");
        assertFalse(actors.isEmpty());
        assertEquals("John", actors.get(0).getFirstName());
    }

    @Test
     void testGetActorsByLastName() {
        Actor actor = new Actor();
        actor.setLastName("Doe");
        when(actorRepository.findByLastName("Doe")).thenReturn(List.of(actor));

        List<Actor> actors = actorService.getActorsByLastName("Doe");
        assertFalse(actors.isEmpty());
        assertEquals("Doe", actors.get(0).getLastName());
    }

    @Test
     void testDeleteActor() {
        actorService.deleteActor("1");
        verify(actorRepository, times(1)).deleteById("1");
    }
}
