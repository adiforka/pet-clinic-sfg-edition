package sfg.petclinicsfgedition.services;

import sfg.petclinicsfgedition.model.Pet;

/*implementing a service layer so controllers don't interact with repositories directly and we can have
more flexibility with actual data sources (HashMap, Spring Data JPA, JDBC etc.)
 */

public interface PetService extends CrudService<Pet, Long>{

    //all methods already in parent CrudService<T, ID>
}
