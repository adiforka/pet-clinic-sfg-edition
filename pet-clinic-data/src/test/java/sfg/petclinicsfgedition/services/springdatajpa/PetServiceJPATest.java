package sfg.petclinicsfgedition.services.springdatajpa;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import sfg.petclinicsfgedition.model.Owner;
import sfg.petclinicsfgedition.model.Pet;
import sfg.petclinicsfgedition.repositories.PetRepository;
import sfg.petclinicsfgedition.services.PetService;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class PetServiceJPATest {

    @Mock
    PetRepository petRepository;

    @InjectMocks
    PetServiceJPA service;

    /*used with when/thenReturn for a controlled return from repo when service called (we're testing if service calls
    * repo right */
    Pet returnPet;

    @BeforeEach
    void setUp() {
        returnPet = Pet.builder().id(1L).name("Pooch").build();
    }

    @Test
    void findAll() {
        Set<Pet> returnPetSet = new HashSet<>();
        returnPetSet.add(Pet.builder().id(1L).build());
        returnPetSet.add(Pet.builder().id(2L).build());

        when(petRepository.findAll()).thenReturn(returnPetSet);

        Set<Pet> pets = service.findAll();

        assertEquals(2, pets.size());

    }

    @Test
    void findById() {
        when(petRepository.findById(anyLong())).thenReturn(Optional.of(returnPet));

        Pet pet = service.findById(1L);

        assertEquals(returnPet.getId(), pet.getId());
    }

    @Test
    void save() {

        when(petRepository.save(any())).thenReturn(returnPet);

        Pet savedPet = service.save(new Pet());

        assertEquals(returnPet.getId(), savedPet.getId());
    }

    @Test
    void delete() {
        service.delete(returnPet);

        verify(petRepository, times(1)).delete(any());
    }

    @Test
    void deleteById() {
        service.deleteById(returnPet.getId());

        verify(petRepository).deleteById(anyLong());
    }
}