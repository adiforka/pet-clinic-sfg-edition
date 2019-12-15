package sfg.petclinic.petclinicsfgedition.model;

import java.io.Serializable;

public class BaseEntity implements Serializable {

    //implementing box-type Long id field as per Hibernate recommendation to use nullable types
    private Long id;

    public Long getid() {
        return id;
    }

    public void setid(Long id) {
        this.id = id;
    }

}
