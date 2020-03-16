package sfg.petclinicsfgedition.services.springdatajpa;

import org.aspectj.lang.annotation.Before;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import sfg.petclinicsfgedition.model.Pet;
import sfg.petclinicsfgedition.model.Vet;
import sfg.petclinicsfgedition.repositories.VetRepository;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.*;

class VetServiceJPATest {

    VetServiceJPA service;

    @Mock
    VetRepository vetRepository;

    Vet returnVet;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
        service = new VetServiceJPA(vetRepository);
        returnVet = new Vet();
        returnVet.setId(666L);
        returnVet.setLastName("Kelevra");
    }

    @Test
    void findAll() {
        Set<Vet> returnVetSet = new HashSet<>();
        returnVetSet.add(Vet.builder().build());
        returnVetSet.add(Vet.builder().build());

        when(vetRepository.findAll()).thenReturn(returnVetSet);

        Set<Vet> vets = service.findAll();

        assertEquals(returnVetSet.size(), vets.size());
    }

    @Test
    void findById() {
        when(vetRepository.findById(anyLong())).thenReturn(Optional.of(returnVet));

        Vet vet = service.findById(1L);

        assertEquals(returnVet.getId(), vet.getId());
    }

    @Test
    void save() {
        when(vetRepository.save(any())).thenReturn(returnVet);

        Vet savedVet = service.save(new Vet());

        assertEquals(returnVet.getId(), savedVet.getId());
    }

    @Test
    void delete() {
        service.delete(returnVet);

        verify(vetRepository, times(1)).delete(any());
    }

    @Test
    void deleteById() {
        service.deleteById(returnVet.getId());
        service.deleteById(returnVet.getId());

        verify(vetRepository, times(2)).deleteById(anyLong());
    }
}