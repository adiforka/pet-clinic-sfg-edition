package sfg.petclinic.petclinicsfgedition.services;

import sfg.petclinic.petclinicsfgedition.model.Owner;

/*implementing a service layer so controllers don't interact with repositories directly and we can have
more flexibility with actual data sources (HashMap, Spring Data JPA, JDBC etc.)
 */
public interface OwnerService extends CrudService<Owner, Long> {

    //only method not already implemented for it by the parent CrudService<T, ID>
    Owner findByLastName(String lastName);

}
