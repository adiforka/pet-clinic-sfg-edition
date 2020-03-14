package sfg.petclinicsfgedition.services.mapServices;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;
import sfg.petclinicsfgedition.model.Owner;
import sfg.petclinicsfgedition.model.Pet;
import sfg.petclinicsfgedition.services.OwnerService;
import sfg.petclinicsfgedition.services.PetService;
import sfg.petclinicsfgedition.services.PetTypeService;

import java.util.Set;

@Service
@Profile({"default", "map"})
public class OwnerServiceMap extends AbstractServiceMap<Owner, Long> implements OwnerService {

    private final PetTypeService petTypeService;
    private final PetService petService;

    public OwnerServiceMap(PetTypeService petTypeService, PetService petService) {
        this.petTypeService = petTypeService;
        this.petService = petService;
    }

    @Override
    public Set<Owner> findAll() {
        return super.findAll();
    }

    @Override
    public Owner findById(Long id) {
        return super.findById(id);
    }

    @Override
    public Owner findByLastName(String lastName) {
        return this.findAll().stream()
                .filter(owner -> owner.getLastName().equalsIgnoreCase(lastName))
                .findFirst()
                .orElse(null);
    }

    @Override
    public Owner save(Owner owner) {

        //making sure we have IDs for Pet and PetType (as of now--UNTESTED)
        if (owner != null) {
            if (owner.getPets() != null) {
                owner.getPets().forEach(pet ->
                {
                    if (pet.getPetType() != null) {
                        //if the pet type id is null, the pet type has not been saved before, so we need to save it
                        if (pet.getPetType().getId() == null) {
                            pet.setPetType(petTypeService.save(pet.getPetType()));
                        }
                    } else {
                        throw new RuntimeException("Pet Type is Required");
                    }

                    if (pet.getId() == null) {
                        Pet savedPet = petService.save(pet);
                        /*so if ID has been set for Pet in the map,
                        why is he setting it for Pet again here, using same value, no less?*/
                        pet.setId(savedPet.getId());
                    }
                });

            }
            return super.save(owner);
        } else
            return null;
    }

    @Override
    public void deleteById(Long id) {
        super.deleteById(id);
    }

    @Override
    public void delete(Owner owner) {
        super.delete(owner);
    }
}
