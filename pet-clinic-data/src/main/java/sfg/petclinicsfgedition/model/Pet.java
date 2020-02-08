package sfg.petclinicsfgedition.model;

import java.time.LocalDate;

public class Pet extends BaseEntity {

    private String name;
    private PetType petType;
    private Owner owner;
    private LocalDate birthday;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPetType(PetType petType) {
        this.petType = petType;
    }

    public PetType getPetType() {
        return petType;
    }

    public void setOwner(Owner owner) {
        this.owner = owner;
    }

    public Owner getOwner() {
        return owner;
    }

    public void setBirthday(LocalDate birthday) {
        this.birthday = birthday;
    }

    public LocalDate getBirthday() {
        return birthday;
    }

}
