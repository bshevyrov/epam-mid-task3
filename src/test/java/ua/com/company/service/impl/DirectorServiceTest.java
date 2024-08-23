package ua.com.company.service.impl;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import ua.com.company.model.Director;
import ua.com.company.repository.DirectorRepository;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@SpringBootTest
 class DirectorServiceTest {

   @Mock
   private DirectorRepository directorRepository;

   @InjectMocks
   private DirectorServiceImpl directorService;

    DirectorServiceTest() {
      MockitoAnnotations.openMocks(this);
   }

   @Test
    void testSaveDirector() {
      Director director = new Director();
      director.setFirstName("Jane");
      when(directorRepository.save(director)).thenReturn(director);

      Director savedDirector = directorService.saveDirector(director);
      assertNotNull(savedDirector);
      assertEquals("Jane", savedDirector.getFirstName());
   }

   @Test
    void testGetDirectorById() {
      Director director = new Director();
      director.setId("1");
      when(directorRepository.findById("1")).thenReturn(Optional.of(director));

      Optional<Director> foundDirector = directorService.getDirectorById("1");
      assertTrue(foundDirector.isPresent());
      assertEquals("1", foundDirector.get().getId());
   }

   @Test
    void testGetDirectorsByFirstName() {
      Director director = new Director();
      director.setFirstName("Jane");
      when(directorRepository.findByFirstName("Jane")).thenReturn(List.of(director));

      List<Director> directors = directorService.getDirectorsByFirstName("Jane");
      assertFalse(directors.isEmpty());
      assertEquals("Jane", directors.get(0).getFirstName());
   }

   @Test
    void testGetDirectorsByLastName() {
      Director director = new Director();
      director.setLastName("Smith");
      when(directorRepository.findByLastName("Smith")).thenReturn(List.of(director));

      List<Director> directors = directorService.getDirectorsByLastName("Smith");
      assertFalse(directors.isEmpty());
      assertEquals("Smith", directors.get(0).getLastName());
   }

   @Test
    void testDeleteDirector() {
      directorService.deleteDirector("1");
      verify(directorRepository, times(1)).deleteById("1");
   }
}
