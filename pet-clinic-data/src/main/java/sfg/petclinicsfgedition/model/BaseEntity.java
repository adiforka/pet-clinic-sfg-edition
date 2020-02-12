package sfg.petclinicsfgedition.model;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import java.io.Serializable;

/*java bean domain object with an ID property. the object is used as a base class for objects that need the ID property*/

/*this anno says: we're going to be persisting objects inheriting from this but don't need to create anything for this object
in the db*/
@MappedSuperclass
public class BaseEntity implements Serializable {

    @Id
    //targeting MySQL, so using an autoincrement field
    @GeneratedValue(strategy = GenerationType.IDENTITY) // means autoincrement -- some dbs, like Oracle, don't support this
    private Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

}
