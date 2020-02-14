package sfg.petclinicsfgedition.services.mapServices;

import sfg.petclinicsfgedition.model.Visit;
import sfg.petclinicsfgedition.services.VisitService;

import java.util.Set;

public class VisitServiceMap extends AbstractServiceMap<Visit, Long> implements VisitService {

    @Override
    public Set<Visit> findAll() {
        return super.findAll();
    }

    @Override
    public void deleteById(Long id) {
        super.deleteById(id);
    }

    @Override
    public void delete(Visit object) {
        super.delete(object);
    }

    @Override
    public Visit save(Visit visit) {
        //validation for saving into the visit map impl (we want to make sure visit has a pet, owner, and their ids
       if (visit.getPet() == null || visit.getPet().getOwner() == null || visit.getPet().getId() == null ||
       visit.getPet().getOwner().getId() == null)
           throw new RuntimeException("Invalid visit");

       return super.save(visit);
    }

    @Override
    public Visit findById(Long id) {
        return super.findById(id);
    }
}
