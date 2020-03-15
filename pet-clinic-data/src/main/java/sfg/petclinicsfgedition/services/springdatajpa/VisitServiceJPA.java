package sfg.petclinicsfgedition.services.springdatajpa;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;
import sfg.petclinicsfgedition.model.Visit;
import sfg.petclinicsfgedition.repositories.VisitRepository;
import sfg.petclinicsfgedition.services.VisitService;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

@Service
@Profile("SDJpa")
public class VisitServiceJPA implements VisitService {

    private final VisitRepository visitRepository;

    public VisitServiceJPA(VisitRepository visitRepository) {
        this.visitRepository = visitRepository;
    }

    @Override
    public Set<Visit> findAll() {
       return new HashSet<>((Collection<? extends Visit>)visitRepository.findAll());
    }

    @Override
    public Visit findById(Long aLong) {
        return visitRepository.findById(aLong).orElse(null);
    }

    @Override
    public Visit save(Visit object) {
        return visitRepository.save(object);
    }

    @Override
    public void delete(Visit object) {
        visitRepository.delete(object);
    }

    @Override
    public void deleteById(Long aLong) {
        visitRepository.deleteById(aLong);
    }
}
