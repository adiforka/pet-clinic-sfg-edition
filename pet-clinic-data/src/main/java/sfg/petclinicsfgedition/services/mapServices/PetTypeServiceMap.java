package sfg.petclinicsfgedition.services.mapServices;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;
import sfg.petclinicsfgedition.model.PetType;
import sfg.petclinicsfgedition.services.PetTypeService;

import java.util.Set;

@Service
@Profile({"default", "map"})
public class PetTypeServiceMap extends AbstractServiceMap<PetType, Long> implements PetTypeService {

    @Override
    public Set<PetType> findAll() {
        return super.findAll();
    }

    @Override
    public PetType findById(Long id) {
        return super.findById(id);
    }

    @Override
    public PetType save(PetType object) {
        return super.save(object);
    }

    @Override
    public void delete(PetType object) {
        super.delete(object);
    }

    @Override
    public void deleteById(Long id) {
        super.deleteById(id);
    }
}
