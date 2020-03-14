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
@Builder
@Table(name = "vets")
public class Vet extends Person {

    /*overriding the default LAZY so we get data upfront. instructor says it'd produce null for Specialities upon querying for
    vets otherwise*/
    /*annotating this as builder.default for builder to take this in as it builds the object. otherwise it ignores it*/
    @Builder.Default
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "vet_specialities", joinColumns = @JoinColumn(name = "vet_id"),
            inverseJoinColumns = @JoinColumn(name = "speciality_id"))
    //avoiding an NPE
    private Set<Speciality> specialities = new HashSet<>();

    @Builder
    public Vet(Long id, String firstName, String lastName, Set<Speciality> specialities) {
        super(id, firstName, lastName);
        this.specialities = specialities;
    }
}
