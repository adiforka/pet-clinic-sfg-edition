package sfg.petclinicsfgedition.services.mapServices;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import sfg.petclinicsfgedition.model.Pet;
import sfg.petclinicsfgedition.services.PetService;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class PetServiceMapTest {

    PetService service;
    Long testPetId = 1L;

    @BeforeEach
    void setUp() {
        service = new PetServiceMap();
        Pet savedPet = service.save(Pet.builder().id(testPetId).build());
    }

    @Test
    void findAll() {
        Set<Pet> pets = service.findAll();
        assertEquals(1, pets.size());
    }

    @Test
    void findById() {
        Pet savedPet = service.findById(testPetId);
        assertEquals(testPetId, savedPet.getId());
    }

    @Test
    void saveWithId() {
        Pet savedPet = service.save(Pet.builder().id(testPetId).build());
        assertEquals(testPetId, savedPet.getId());
    }

    @Test
    void saveWithoutId() {
        Pet savedPet = service.save(Pet.builder().build());
        assertNotNull(savedPet);
        assertNotNull(savedPet.getId());
    }

    @Test
    void deleteById() {
        service.deleteById(testPetId);
        assertEquals(0, service.findAll().size());
    }

    @Test
    void delete() {
        service.delete(service.findById(testPetId));
        assertEquals(0, service.findAll().size());
    }
}