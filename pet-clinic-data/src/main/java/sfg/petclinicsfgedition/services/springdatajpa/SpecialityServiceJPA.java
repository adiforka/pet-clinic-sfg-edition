package sfg.petclinicsfgedition.services.springdatajpa;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;
import sfg.petclinicsfgedition.model.Speciality;
import sfg.petclinicsfgedition.repositories.SpecialityRepository;
import sfg.petclinicsfgedition.services.SpecialityService;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

@Service
@Profile("SDJpa")
public class SpecialityServiceJPA implements SpecialityService {

    private final SpecialityRepository specialityRepository;

    public SpecialityServiceJPA(SpecialityRepository specialityRepository) {
        this.specialityRepository = specialityRepository;
    }

    @Override
    public Set<Speciality> findAll() {
        //a bit leaner, but need to cast returned Iterable to a Collection of elements that are or extend a type Speciality
        return new HashSet<>((Collection<? extends Speciality>) specialityRepository.findAll());
    }

    @Override
    public Speciality findById(Long aLong) {
        return specialityRepository.findById(aLong).orElse(null);
    }

    @Override
    public Speciality save(Speciality object) {
        return specialityRepository.save(object);
    }

    @Override
    public void delete(Speciality object) {
        specialityRepository.delete(object);
    }

    @Override
    public void deleteById(Long aLong) {
        specialityRepository.deleteById(aLong);
    }
}
