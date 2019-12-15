package sfg.petclinic.petclinicsfgedition.services;

import sfg.petclinic.petclinicsfgedition.model.Pet;

import java.util.Set;

public interface PetService {

    Pet findById(Long id);

    Pet save(Pet pet);

    Set<Pet> findAll();
}
