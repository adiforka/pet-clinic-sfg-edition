package sfg.petclinicsfgedition.services.mapServices;

import sfg.petclinicsfgedition.model.BaseEntity;

import java.util.*;

//making T extend Base entity lets us make assumptions about it: namely, that it has an ID
public abstract class AbstractMapService<T extends BaseEntity, ID extends Long> {

    protected Map<Long, T> map = new HashMap<>();

    Set<T> findAll() {
        return new HashSet<>(map.values());
    }

    T findById(ID id) {
        return map.get(id);
    }

    /*to auto-generate ID property from the map -- this is a step towards making services in line with JPA
    requirements for ID generation by the persistence layer-- services are shared among data layer implementations*/
    private Long getNextId() {

        /*if map is empty, return 1L for the initial ID value (course impl of this was to catch the NoSuchElem exc. that
        is thrown when trying to get max out of an empty map and send 1L as a matter of handling that exc.*/
        if (map.isEmpty()) {
            return 1L;
        }
        //get max and increment by 1 to for the next element
       return Collections.max(map.keySet()) + 1L;
    }

    //now we don't need to pass the id to save method at call. it's generated from some map key manipulation
    T save(T object) {

        if (object != null) {
            if (object.getId() == null) {
                object.setId(getNextId());
            }
            map.put(object.getId(), object);
        } else throw new RuntimeException("Object cannot be null");

        return object;
    }

    void deleteById(ID id) {
        map.remove(id);
    }

    void delete(T object) {
        map.entrySet().removeIf(entry -> entry.getValue().equals(object));
    }


}
