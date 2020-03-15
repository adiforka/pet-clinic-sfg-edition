package sfg.petclinicsfgedition.services.springdatajpa;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;
import sfg.petclinicsfgedition.model.PetType;
import sfg.petclinicsfgedition.repositories.PetTypeRepository;
import sfg.petclinicsfgedition.services.PetTypeService;

import java.util.HashSet;
import java.util.Set;

@Service
@Profile("SDJpa")
public class PetTypeServiceJPA implements PetTypeService {

    private final PetTypeRepository petTypeRepository;

    public PetTypeServiceJPA(PetTypeRepository petTypeRepository) {
        this.petTypeRepository = petTypeRepository;
    }

    @Override
    public Set<PetType> findAll() {
        Set<PetType> petTypes = new HashSet<>();
        petTypeRepository.findAll().forEach(petTypes::add);
        return petTypes;
    }

    @Override
    public PetType findById(Long aLong) {
        return petTypeRepository.findById(aLong).orElse(null);
    }

    @Override
    public PetType save(PetType object) {
        return petTypeRepository.save(object);
    }

    @Override
    public void delete(PetType object) {
        petTypeRepository.delete(object);
    }

    @Override
    public void deleteById(Long aLong) {
        petTypeRepository.deleteById(aLong);
    }
}
