package sfg.petclinicsfgedition.services.springdatajpa;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;
import sfg.petclinicsfgedition.model.Owner;
import sfg.petclinicsfgedition.repositories.OwnerRepository;
import sfg.petclinicsfgedition.repositories.PetRepository;
import sfg.petclinicsfgedition.repositories.PetTypeRepository;
import sfg.petclinicsfgedition.services.OwnerService;

import java.util.HashSet;
import java.util.Set;

@Service
//adding this without an active profile to have this ignored and have the map-service for owner wired up
@Profile("SDJpa")
public class OwnerServiceJPA implements OwnerService {

    private final OwnerRepository ownerRepository;
    private final PetRepository petRepository;
    private final PetTypeRepository petTypeRepository;

    public OwnerServiceJPA(OwnerRepository ownerRepository, PetRepository petRepository,
                           PetTypeRepository petTypeRepository) {
        this.ownerRepository = ownerRepository;
        this.petRepository = petRepository;
        this.petTypeRepository = petTypeRepository;
    }


    @Override
    public Owner findByLastName(String lastName) {
        return ownerRepository.findByLastName(lastName);
    }

    @Override
    public Set<Owner> findAll() {
        Set<Owner> owners = new HashSet<>();
        ownerRepository.findAll().forEach(owners::add);
        return owners;
    }

    @Override
    public Owner findById(Long aLong) {
        return ownerRepository.findById(aLong).orElse(null);
    }

    @Override
    public Owner save(Owner object) {
        return ownerRepository.save(object);
    }

    @Override
    public void delete(Owner object) {
        ownerRepository.delete(object);
    }

    @Override
    public void deleteById(Long aLong) {
        ownerRepository.deleteById(aLong);
    }
}
