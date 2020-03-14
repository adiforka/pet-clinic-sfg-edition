package sfg.petclinicsfgedition.services.mapServices;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import sfg.petclinicsfgedition.model.Owner;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class OwnerServiceMapTest {

    OwnerServiceMap ownerServiceMap;
    final Long testOwnerId = 1L;
    final String testOwnerLastName = "Kirby";

    @BeforeEach
    void setUp() {
        //interactions with PetTypeServiceMap and PetServiceMap not tested yet
        ownerServiceMap = new OwnerServiceMap(new PetTypeServiceMap(), new PetServiceMap());
        ownerServiceMap.save(Owner.builder().id(testOwnerId).lastName(testOwnerLastName).build());
    }

    @Test
    void findAll() {
        Set<Owner> owners = ownerServiceMap.findAll();
        assertEquals(1, owners.size());
    }

    @Test
    void findById() {
        Owner owner = ownerServiceMap.findById(testOwnerId);
        assertEquals(testOwnerId, owner.getId());
    }

    @Test
    void findByLastName() {
        Owner kirby = ownerServiceMap.findByLastName(testOwnerLastName);

        assertNotNull(kirby);
        assertEquals(testOwnerId, kirby.getId());
    }

    @Test
    void findByLastNameNotFound() {
        Owner kirby = ownerServiceMap.findByLastName("boo");

        assertNull(kirby);
    }

    @Test
    void saveExistingId() {
        Long id = 2L;

        Owner owner2 = Owner.builder().id(id).build();
        Owner savedOwner = ownerServiceMap.save(owner2);

        assertEquals(id, savedOwner.getId());
    }

    @Test
    void saveNoId() {
        Owner savedOwner = ownerServiceMap.save(Owner.builder().build());
        assertNotNull(savedOwner);
        assertNotNull(savedOwner.getId());
    }

    @Test
    void deleteById() {
        ownerServiceMap.deleteById(testOwnerId);
        assertEquals(0, ownerServiceMap.findAll().size());
    }

    @Test
    void delete() {
        ownerServiceMap.delete(ownerServiceMap.findById(testOwnerId));
        assertEquals(0, ownerServiceMap.findAll().size());
    }
}