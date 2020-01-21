package sfg.petclinicsfgedition.bootstrap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import sfg.petclinicsfgedition.model.Owner;
import sfg.petclinicsfgedition.model.Vet;
import sfg.petclinicsfgedition.services.OwnerService;
import sfg.petclinicsfgedition.services.VetService;

/*this bootstrap class is to load up some known data at the boot-up of the app*/

/*bootstrap to load startup data or any startup process in a package called bootstrap*/

/*when this is made a component, it will be registered in the application context, which, when up and ready,
will execute the run method*/
@Component
//CommandLineRunner is a SpringBoot interface with the run method
public class DataLoader implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;

    //no longer need to state @Autowired with constructor-based DI. still do it for intention stating
    @Autowired
    public DataLoader(OwnerService ownerService, VetService vetService) {
        this.ownerService = ownerService;
        this.vetService = vetService;

    }

    @Override
    public void run(String[] args) throws Exception {

        Owner owner1 = new Owner();
        owner1.setFirstName("Juju");
        owner1.setLastName("McBeal");

        ownerService.save(owner1);

        Owner owner2 = new Owner();
        owner2.setFirstName("Daddy");
        owner2.setLastName("McPhee");

        ownerService.save(owner2);

        System.out.println("Loaded owners...");

        Vet vet1 = new Vet();
        vet1.setFirstName("Gettah");
        vet1.setLastName("Suffico");

        vetService.save(vet1);

        Vet vet2 = new Vet();
        vet2.setFirstName("Bobbard");
        vet2.setLastName("Macintosh");

        vetService.save(vet2);

        System.out.println("Loaded vets...");
    }
}
