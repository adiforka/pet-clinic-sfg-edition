package sfg.petclinicsfgedition.services.mapServices;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import sfg.petclinicsfgedition.model.Speciality;
import sfg.petclinicsfgedition.services.SpecialityService;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class SpecialityServiceMapTest {

    SpecialityService service;
    Long testId = 1L;

    @BeforeEach
    void setUp() {
        service = new SpecialityServiceMap();
        service.save(Speciality.builder().id(testId).build());
    }

    @Test
    void findAll() {
        Set<Speciality> specialities = service.findAll();
        assertEquals(1, specialities.size());

    }

    @Test
    void findById() {
        Speciality speciality = service.findById(testId);
        assertEquals(testId, speciality.getId());
    }

    @Test
    void save() {
        Long id=  2L;

        Speciality savedSpeciality = service.save(Speciality.builder().id(id).build());
        assertEquals(id, savedSpeciality.getId());
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