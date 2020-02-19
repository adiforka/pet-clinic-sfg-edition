package sfg.petclinicsfgedition.services.mapServices;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;
import sfg.petclinicsfgedition.model.Pet;
import sfg.petclinicsfgedition.services.PetService;

import java.util.Set;

@Service
@Profile(value = {"default"})
public class PetServiceMap extends AbstractServiceMap<Pet, Long> implements PetService {

    @Override
    public Set<Pet> findAll() {
        return super.findAll();
    }

    @Override
    public Pet findById(Long id) {
        return super.findById(id);
    }

    @Override
    public Pet save(Pet pet) {
        return super.save(pet);
    }

    @Override
    public void deleteById(Long id) {
        super.deleteById(id);
    }

    @Override
    public void delete(Pet pet) {
        super.delete(pet);
    }




}
