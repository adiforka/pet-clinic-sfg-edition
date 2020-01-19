package sfg.petclinicsfgedition.bootstrap;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import sfg.petclinic.petclinicsfgedition.model.Owner;
import sfg.petclinic.petclinicsfgedition.model.Vet;
import sfg.petclinic.petclinicsfgedition.services.OwnerService;
import sfg.petclinic.petclinicsfgedition.services.VetService;
import sfg.petclinic.petclinicsfgedition.services.map.OwnerServiceMap;
import sfg.petclinic.petclinicsfgedition.services.map.VetServiceMap;

/*this bootstrap class is to load up some known data at the boot-up of the app*/

/*when this is made a component, it will be registered in the application context, which, when up and ready,
will execute the run method*/
@Component
//CommandLineRunner is a SpringBoot interface with the run method
public class DataLoader implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;

    public DataLoader() {
        this.ownerService = new OwnerServiceMap();
        this.vetService = new VetServiceMap();
    }

    @Override
    public void run(String[] args) throws Exception {

        Owner owner1 = new Owner();
        owner1.setId(1L);
        owner1.setFirstName("Michael");
        owner1.setLastName("Weston");

        ownerService.save(owner1);

        Owner owner2 = new Owner();
        owner2.setId(2L);
        owner2.setFirstName("Fiona");
        owner2.setLastName("Glenanne");

        ownerService.save(owner2);

        System.out.println("Loaded owners...");

        Vet vet1 = new Vet();
        vet1.setId(1L);
        vet1.setFirstName("Sam");
        vet1.setLastName("Bonardi");

        vetService.save(vet1);

        Vet vet2 = new Vet();
        vet2.setId(2L);
        vet2.setFirstName("Bob");
        vet2.setLastName("Johnson");

        vetService.save(vet2);

        System.out.println("Loaded vets...");
    }
}
