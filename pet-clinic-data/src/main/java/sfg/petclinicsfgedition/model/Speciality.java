package sfg.petclinicsfgedition.model;

import lombok.*;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "specialities")
public class Speciality extends BaseEntity {

    @Column(name = "description")
    private String description;

    @ManyToMany(mappedBy = "specialities")
    private Set<Vet> vets = new HashSet<>();

    @Builder //annotate at constructor level to get id from superclass
    public Speciality(Long id, String description, Set<Vet> vets) {
        super(id);
        this.description = description;
        this.vets = vets;
    }
}
