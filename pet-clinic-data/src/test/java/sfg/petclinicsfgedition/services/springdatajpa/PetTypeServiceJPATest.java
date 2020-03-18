package sfg.petclinicsfgedition.services.springdatajpa;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import sfg.petclinicsfgedition.model.Pet;
import sfg.petclinicsfgedition.model.PetType;
import sfg.petclinicsfgedition.repositories.PetTypeRepository;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.*;

class PetTypeServiceJPATest {

    @Mock
    PetTypeRepository petTypeRepository;

    PetTypeServiceJPA service;

    PetType returnPetType;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);

        //remember to instantiate service manually when using initMocks and not MockitoExtension
        service = new PetTypeServiceJPA(petTypeRepository);

        returnPetType = PetType.builder().id(1L).description("dragon").build();
    }

    @Test
    void findAll() {
        Set<PetType> returnPetTypeSet = new HashSet<>();
        returnPetTypeSet.add(PetType.builder().id(1L).build());
        returnPetTypeSet.add(PetType.builder().id(2L).build());

        System.out.println(returnPetTypeSet.size());

        when(petTypeRepository.findAll()).thenReturn(returnPetTypeSet);

        Set<PetType> pets = service.findAll();

        assertEquals(2, pets.size());
    }

    @Test
    void findById() {

        when(petTypeRepository.findById(anyLong())).thenReturn(Optional.of(returnPetType));

        PetType petType = service.findById(1L);

        assertEquals(returnPetType.getId(), petType.getId());
    }

    @Test
    void save() {

        when(petTypeRepository.save(any())).thenReturn(returnPetType);

        PetType savedPetType = service.save(new PetType());

        assertEquals(returnPetType.getId(), savedPetType.getId());
    }

    @Test
    void delete() {
       service.delete(returnPetType);

       verify(petTypeRepository, times(1)).delete(any());

    }

    @Test
    void deleteById() {

        service.deleteById(returnPetType.getId());

        verify(petTypeRepository, times(1)).deleteById(anyLong());
    }
}