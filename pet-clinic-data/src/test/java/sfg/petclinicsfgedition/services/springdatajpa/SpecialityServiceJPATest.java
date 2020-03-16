package sfg.petclinicsfgedition.services.springdatajpa;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import sfg.petclinicsfgedition.model.Pet;
import sfg.petclinicsfgedition.model.Speciality;
import sfg.petclinicsfgedition.repositories.SpecialityRepository;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.*;

class SpecialityServiceJPATest {

    @Mock
    SpecialityRepository specialityRepository;

    SpecialityServiceJPA service;

    Speciality returnSpec;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
        service = new SpecialityServiceJPA(specialityRepository);
        returnSpec = Speciality.builder().id(15L).description("Surgery").build();
    }

    @Test
    void findAll() {
        Set<Speciality> returnPetSet = new HashSet<>();
        returnPetSet.add(Speciality.builder().id(1L).build());
        returnPetSet.add(Speciality.builder().id(2L).build());

        when(specialityRepository.findAll()).thenReturn(returnPetSet);

        Set<Speciality> specialities = service.findAll();

        assertEquals(2, specialities.size());
    }

    @Test
    void findById() {
        when(specialityRepository.findById(anyLong())).thenReturn(Optional.of(returnSpec));

        Speciality speciality = service.findById(1L);

        assertEquals(15, speciality.getId());
    }

    @Test
    void save() {
        when(specialityRepository.save(any())).thenReturn(returnSpec);

        Speciality speciality = service.save(new Speciality());
        assertEquals(returnSpec.getId(), speciality.getId());
    }

    @Test
    void delete() {
        service.delete(returnSpec);
        service.delete(returnSpec);

        verify(specialityRepository, times(2)).delete(any());
    }

    @Test
    void deleteById() {
        service.deleteById(returnSpec.getId());
        service.deleteById(returnSpec.getId());
        service.deleteById(returnSpec.getId());

        verify(specialityRepository, times(3)).deleteById(anyLong());
    }
}