package sfg.petclinicsfgedition.model;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "visits")
public class Visit extends BaseEntity  {

    @Column(name = "date")
    private LocalDate date;

    @Column(name = "description")
    private String description;

    @ManyToOne
    @JoinColumn(name = "pet_visit")
    private Pet pet;

    public Visit(Long id, String description, Pet pet) {
        super(id);
        this.date = LocalDate.now();
        this.description = description;
        this.pet = pet;
    }
}
