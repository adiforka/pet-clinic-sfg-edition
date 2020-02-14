package sfg.petclinicsfgedition.repositories;

import org.springframework.data.repository.CrudRepository;
import sfg.petclinicsfgedition.model.PetType;

public interface PetTypeRepository extends CrudRepository<PetType, Long> {
}
