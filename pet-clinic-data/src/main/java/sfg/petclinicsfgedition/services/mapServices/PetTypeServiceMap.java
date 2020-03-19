package sfg.petclinicsfgedition.services.mapServices;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;
import sfg.petclinicsfgedition.model.PetType;
import sfg.petclinicsfgedition.services.PetTypeService;

import java.util.Set;

@Service
@Profile({"default", "map"})
public class PetTypeServiceMap extends AbstractServiceMap<PetType, Long> implements PetTypeService {

}
