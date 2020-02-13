package sfg.petclinicsfgedition.repositories;

import org.springframework.data.repository.CrudRepository;
import sfg.petclinicsfgedition.model.Pet;

public interface PetRepository extends CrudRepository<Pet, Long> {
}
