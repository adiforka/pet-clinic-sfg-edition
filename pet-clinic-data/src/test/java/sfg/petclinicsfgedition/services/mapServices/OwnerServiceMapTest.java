package sfg.petclinicsfgedition.services.mapServices;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import sfg.petclinicsfgedition.model.Owner;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class OwnerServiceMapTest {

    OwnerServiceMap service;
    final Long testOwnerId = 1L;
    final String testOwnerLastName = "Kirby";

    @BeforeEach
    void setUp() {
        //interactions with PetTypeServiceMap and PetServiceMap not tested yet
        service = new OwnerServiceMap(new PetTypeServiceMap(), new PetServiceMap());
        service.save(Owner.builder().id(testOwnerId).lastName(testOwnerLastName).build());
    }

    @Test
    void findAll() {
        Set<Owner> owners = service.findAll();
        assertEquals(1, owners.size());
    }

    @Test
    void findById() {
        Owner owner = service.findById(testOwnerId);
        assertEquals(testOwnerId, owner.getId());
    }

    @Test
    void findByLastName() {
        Owner kirby = service.findByLastName(testOwnerLastName);

        assertNotNull(kirby);
        assertEquals(testOwnerId, kirby.getId());
    }

    @Test
    void findByLastNameNotFound() {
        Owner kirby = service.findByLastName("boo");

        assertNull(kirby);
    }

    @Test
    void saveWithId() {
        Long id = 2L;
        Owner owner2 = Owner.builder().id(id).build();
        Owner savedOwner = service.save(owner2);

        assertEquals(id, savedOwner.getId());
    }

    @Test
    void saveWithoutId() {
        Owner savedOwner = service.save(Owner.builder().build());
        assertNotNull(savedOwner);
        assertNotNull(savedOwner.getId());
    }

    @Test
    void deleteById() {
        service.deleteById(testOwnerId);
        assertEquals(0, service.findAll().size());
    }

    @Test
    void delete() {
        service.delete(service.findById(testOwnerId));
        assertEquals(0, service.findAll().size());
    }
}