package sfg.petclinic.petclinicsfgedition.model;

import java.time.LocalDate;

public class Pet {

    private PetType petType;
    private Owner owner;
    private LocalDate birthday;

    public void setPetType(PetType petType) {
        this.petType = petType;
    }

    public PetType getPetType() {
        return petType;
    }

    public void setOwner() {
        this.owner = owner;
    }

    public Owner getOwner() {
        return owner;
    }

    public void setBirthday() {
        this.birthday = birthday;
    }

    public LocalDate getBirthday() {
        return birthday;
    }

}
