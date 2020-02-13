package sfg.petclinicsfgedition.repositories;

import org.springframework.data.repository.CrudRepository;
import sfg.petclinicsfgedition.model.Visit;

public interface VisitRepository extends CrudRepository<Visit, Long> {
}
