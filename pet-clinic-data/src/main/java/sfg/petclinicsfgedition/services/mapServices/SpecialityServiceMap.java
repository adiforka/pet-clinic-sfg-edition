package sfg.petclinicsfgedition.services.mapServices;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;
import sfg.petclinicsfgedition.model.Speciality;
import sfg.petclinicsfgedition.services.SpecialityService;

import java.util.Set;

@Service
@Profile({"default", "map"})
public class SpecialityServiceMap extends AbstractServiceMap<Speciality, Long> implements SpecialityService {

}
