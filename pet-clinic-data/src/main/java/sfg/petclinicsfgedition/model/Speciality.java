package sfg.petclinicsfgedition.model;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "specialities")
public class Speciality extends BaseEntity {

    @Column(name = "description")
    private String description;

    @Builder //annotate at constructor level to get id from superclass
    public Speciality(Long id, String description) {
        super(id);
        this.description = description;
    }
}
