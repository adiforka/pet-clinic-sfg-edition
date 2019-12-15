package sfg.petclinic.petclinicsfgedition.services;

import sfg.petclinic.petclinicsfgedition.model.Pet;

import java.util.Set;

/*implementing a service layer so controllers don't interact with repositories directly and we can have
more flexibility with actual data sources (HashMap, Spring Data JPA, JDBC etc.)
 */

public interface PetService {

    Pet findById(Long id);

    Pet save(Pet pet);

    Set<Pet> findAll();
}
