package sfg.petclinic.petclinicsfgedition.services;

import sfg.petclinic.petclinicsfgedition.model.Vet;

/*implementing a service layer so controllers don't interact with repositories directly and we can have
more flexibility with actual data sources (HashMap, Spring Data JPA, JDBC etc.)
 */

public interface VetService extends CrudService<Vet, Long>{

    //all methods already in parent CrudService<T, ID>

}
