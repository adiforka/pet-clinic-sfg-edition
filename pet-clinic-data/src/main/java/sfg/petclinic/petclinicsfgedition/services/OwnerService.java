package sfg.petclinic.petclinicsfgedition.services;

import sfg.petclinic.petclinicsfgedition.model.Owner;

import java.util.Set;

/*implementing a service layer so controllers don't interact with repositories directly and we can have
more flexibility with actual data sources (HashMap, Spring Data JPA, JDBC etc.)
 */
public interface OwnerService {

    Owner findByLastName(String lastName);

    Owner findById(Long id);

    Owner save(Owner owner);

    Set<Owner> findAll();
}
