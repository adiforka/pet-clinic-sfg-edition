package sfg.petclinicsfgedition.services.mapServices;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import sfg.petclinicsfgedition.model.PetType;
import sfg.petclinicsfgedition.services.PetTypeService;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class PetTypeServiceMapTest {

    PetTypeService service;
    Long testId = 1L;

    @BeforeEach
    void setUp() {
        service = new PetTypeServiceMap();
        service.save(PetType.builder().id(testId).build());
    }

    @Test
    void findAll() {
        Set<PetType> petTypes = service.findAll();
        assertEquals(1, petTypes.size());
    }

    @Test
    void findById() {
        PetType petType = service.findById(testId);
        assertEquals(testId, petType.getId());
    }

    @Test
    void save() {
        Long id = 2L;
        //need we save another object in addition to the one saved in setUp()?
        PetType savedPetType = service.save(PetType.builder().id(id).build());
        assertEquals(2L, savedPetType.getId());
    }

    @Test
    void deleteById() {
        service.deleteById(testId);
        assertEquals(0, service.findAll().size());
    }

    @Test
    void delete() {
        service.delete(service.findById(testId));
        assertEquals(0, service.findAll().size());
    }


}