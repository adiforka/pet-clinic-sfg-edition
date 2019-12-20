package sfg.petclinic.petclinicsfgedition.services;

import java.util.Set;

//generic interface with type T and id ID
public interface CrudService<T, ID> {

    //these methods adapted from Spring Data JPA's CrudRepository interface
    Set<T> findAll();

    T findById(ID id);

    T save(T object);

    void delete(T object);

    void deleteById(ID id);

}
