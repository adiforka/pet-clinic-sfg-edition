package sfg.petclinic.petclinicsfgedition.services;

import java.util.Set;

/*implementing a service layer so controllers don't interact with repositories directly and we can have
more flexibility with actual data sources (HashMap, Spring Data JPA, JDBC etc.)
 */

public interface VetService {

    VetService findById(Long id);

    VetService save(VetService vetService);

    Set<VetService> findAll();
}
