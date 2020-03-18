package sfg.petclinicsfgedition.services.springdatajpa;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import sfg.petclinicsfgedition.model.Vet;
import sfg.petclinicsfgedition.model.Visit;
import sfg.petclinicsfgedition.repositories.VisitRepository;
import sfg.petclinicsfgedition.services.VisitService;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.*;

class VisitServiceJPATest {

    @Mock
    VisitRepository visitRepository;

    VisitService service;

    Visit returnVisit;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
        service = new VisitServiceJPA(visitRepository);
        returnVisit = Visit.builder().id(1L).description("Sneezing kitty").build();
    }

    @Test
    void findAll() {
        Set<Visit> returnVetSet = new HashSet<>();
        returnVetSet.add(new Visit());
        returnVetSet.add(new Visit());

        when(visitRepository.findAll()).thenReturn(returnVetSet);

        Set<Visit> visits = service.findAll();

        assertEquals(returnVetSet.size(), visits.size());
    }

    @Test
    void findById() {
        when(visitRepository.findById(anyLong())).thenReturn(Optional.of(returnVisit));

        Visit visit = service.findById(1L);

        assertEquals(returnVisit.getId(), visit.getId());
    }

    @Test
    void save() {
        when(visitRepository.save(any())).thenReturn(returnVisit);

        Visit savedVisit = service.save(new Visit());

        assertEquals(returnVisit.getId(), savedVisit.getId());
    }

    @Test
    void delete() {
        service.delete(returnVisit);

        verify(visitRepository, times(1)).delete(any());
    }

    @Test
    void deleteById() {
        service.deleteById(returnVisit.getId());
        service.deleteById(returnVisit.getId());

        verify(visitRepository, times(2)).deleteById(anyLong());
    }
}