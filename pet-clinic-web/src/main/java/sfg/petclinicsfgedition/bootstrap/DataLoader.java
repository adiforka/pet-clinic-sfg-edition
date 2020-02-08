package sfg.petclinicsfgedition.bootstrap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import sfg.petclinicsfgedition.model.Owner;
import sfg.petclinicsfgedition.model.Pet;
import sfg.petclinicsfgedition.model.PetType;
import sfg.petclinicsfgedition.model.Vet;
import sfg.petclinicsfgedition.services.OwnerService;
import sfg.petclinicsfgedition.services.PetTypeService;
import sfg.petclinicsfgedition.services.VetService;

import java.time.LocalDate;

/*this bootstrap class is to load up some known data at the boot-up of the app*/

/*bootstrap to load startup data or any startup process in a package called bootstrap*/

/*when this is made a component, it will be registered in the application context, which, when up and ready,
will execute the run method*/
@Component
//CommandLineRunner is a SpringBoot interface with the run method
public class DataLoader implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;
    private final PetTypeService petTypeService;

    //no longer need to state @Autowired with constructor-based DI. still do it for intention stating
    @Autowired
    public DataLoader(OwnerService ownerService, VetService vetService, PetTypeService petTypeService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
        this.petTypeService = petTypeService;
    }

    @Override
    public void run(String[] args) throws Exception {

        PetType dog = new PetType();
        dog.setName("Dog");
        PetType savedDogType  = petTypeService.save(dog);

        PetType cat = new PetType();
        dog.setName("Cat");
        PetType savedCatType  = petTypeService.save(cat);

        Owner owner1 = new Owner();
        owner1.setFirstName("Juju");
        owner1.setLastName("McBeal");
        owner1.setAddress("12 JSON st.");
        owner1.setCity("Johannesburg");
        owner1.setTelephone("334-332-355");
        ownerService.save(owner1);

        Pet jujusPet = new Pet();
        jujusPet.setPetType(savedDogType);
        jujusPet.setOwner(owner1);
        jujusPet.setBirthday(LocalDate.now());
        jujusPet.setName("Butch");
        owner1.getPets().add(jujusPet);

        Owner owner2 = new Owner();
        owner2.setFirstName("Daddy");
        owner2.setLastName("McPhee");
        owner2.setAddress("342 Peekaboo Av.");
        owner2.setCity("Chicago");
        owner2.setTelephone("555-643-312");
        ownerService.save(owner2);

        Pet daddysPet = new Pet();
        daddysPet.setPetType(savedCatType);
        daddysPet.setOwner(owner2);
        daddysPet.setBirthday(LocalDate.now());
        daddysPet.setName("McMeow");
        owner2.getPets().add(daddysPet);

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
