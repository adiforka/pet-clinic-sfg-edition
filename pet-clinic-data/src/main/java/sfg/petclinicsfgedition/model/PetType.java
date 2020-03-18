package sfg.petclinicsfgedition.model;

import lombok.*;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "types")
public class PetType extends BaseEntity {

    @Column(name = "description")
    private String description;

    @Builder
    public PetType(Long id, String description) {
        super(id);
        this.description = description;
    }

    @UpdateTimestamp
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }


}
