package sfg.petclinicsfgedition.repositories;

import org.springframework.data.repository.CrudRepository;
import sfg.petclinicsfgedition.model.Vet;

public interface VetRepository extends CrudRepository<Vet, Long> {
}
