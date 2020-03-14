package sfg.petclinicsfgedition.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import java.io.Serializable;

/*java bean domain object with an ID property. the object is used as a base class for objects that need the ID property*/

/*this anno says: we're going to be persisting objects inheriting from this but don't need to create anything for this object
in the db*/
@MappedSuperclass
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class BaseEntity implements Serializable {

    @Id
    //targeting MySQL, so using an autoincrement field
    @GeneratedValue(strategy = GenerationType.IDENTITY) // means autoincrement -- some dbs, like Oracle, don't support this
    private Long id;

}
