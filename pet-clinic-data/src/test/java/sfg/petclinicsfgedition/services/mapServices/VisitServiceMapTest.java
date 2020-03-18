package sfg.petclinicsfgedition.services.mapServices;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import sfg.petclinicsfgedition.model.Owner;
import sfg.petclinicsfgedition.model.Pet;
import sfg.petclinicsfgedition.model.Visit;
import sfg.petclinicsfgedition.services.VisitService;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class VisitServiceMapTest {

    VisitService service;
    Pet testPet;
    Long testId = 1L;

    @BeforeEach
    void setUp() {
        service = new VisitServiceMap();
        Owner testPetsOwner = Owner.builder().id(1L).build();
        testPet = Pet.builder().id(1L).owner(testPetsOwner).build();
        service.save(Visit.builder().pet(testPet).id(testId).build());
    }

    @Test
    void findAll() {
        Set<Visit> visits = service.findAll();
        assertEquals(1, visits.size());
    }

    @Test
    void findById() {
        Visit visit = service.findById(testId);
        assertEquals(testId, visit.getId());
    }

    @Test
    void save() {
        //reusing same pet: can have more than 1 visit. Not reusing id, obviously
        Long id = 2L;
        Visit visitToSave = Visit.builder().pet(testPet).id(id).build();
        Visit savedVisit = service.save(visitToSave);
        assertEquals(2L, savedVisit.getId());
    }

    @Test
    void deleteById() {
        service.deleteById(testId);
        assertTrue(service.findAll().isEmpty());
    }

    @Test
    void delete() {
        service.delete(service.findById(testId));
        assertTrue(service.findAll().isEmpty());
    }




}