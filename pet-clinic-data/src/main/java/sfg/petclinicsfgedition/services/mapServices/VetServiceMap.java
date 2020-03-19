package sfg.petclinicsfgedition.services.mapServices;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;
import sfg.petclinicsfgedition.model.Speciality;
import sfg.petclinicsfgedition.model.Vet;
import sfg.petclinicsfgedition.services.SpecialityService;
import sfg.petclinicsfgedition.services.VetService;

import java.util.Set;

@Service
@Profile({"default", "map"})
public class VetServiceMap extends AbstractServiceMap<Vet, Long> implements VetService {

    private final SpecialityService specialityService;

    public VetServiceMap(SpecialityService specialityService) {
        this.specialityService = specialityService;
    }

    @Override
    public Vet save(Vet vet) {

        if (vet.getSpecialities().size() > 0) {
            vet.getSpecialities().forEach(speciality -> {
                if(speciality.getId() == null) {
                    Speciality savedSpeciality =specialityService.save(speciality);
                    //defensive coding
                    speciality.setId(savedSpeciality.getId());
                }
            });
        }
        return super.save(vet);
    }
}
