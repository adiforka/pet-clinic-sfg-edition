package sfg.petclinicsfgedition.repositories;

import org.springframework.data.repository.CrudRepository;
import sfg.petclinicsfgedition.model.Owner;

public interface OwnerRepository extends CrudRepository<Owner, Long> {

    Owner findByLastName(String lasName);
}
