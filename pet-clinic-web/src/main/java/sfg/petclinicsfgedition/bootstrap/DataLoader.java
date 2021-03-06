package sfg.petclinicsfgedition.bootstrap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import sfg.petclinicsfgedition.model.*;
import sfg.petclinicsfgedition.services.*;

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
    private final SpecialityService specialityService;
    private final VisitService visitService;

    //no longer need to state @Autowired with constructor-based DI. still do it for intention stating
    @Autowired
    public DataLoader(OwnerService ownerService, VetService vetService, PetTypeService petTypeService,
                      SpecialityService specialityService, VisitService visitService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
        this.petTypeService = petTypeService;
        this.specialityService = specialityService;
        this.visitService = visitService;
    }

    @Override
    public void run(String[] args) throws Exception {

        //this is to not have it run if there's a persistence impl running that's taking over the repo layer (when size != 0)
        //I think petTypeService is just one option here of checking stuff's not been loaded up from elsewhere
        int count = petTypeService.findAll().size();

        if (count == 0) {
            loadData();
        }
    }

    private void loadData() {
    /*using respective services to persist objects to their respective maps (this also gives us IDs for them --
    consult AbstractMapService's save() method which calls getNextId()
     */

        PetType dog = new PetType();
        dog.setName("Dog");
        PetType savedDogType = petTypeService.save(dog);

        PetType cat = new PetType();
        cat.setName("Cat");
        PetType savedCatType = petTypeService.save(cat);

        Speciality radiology = new Speciality();
        radiology.setDescription("Radiology");
        Speciality savedRadiology = specialityService.save(radiology);

        Speciality surgery = new Speciality();
        surgery.setDescription("Surgery");
        Speciality savedSurgery = specialityService.save(surgery);

        Speciality dentistry = new Speciality();
        dentistry.setDescription("Dentistry");
        Speciality savedDentistry = specialityService.save(dentistry);

        Owner owner1 = new Owner();
        owner1.setFirstName("Juju");
        owner1.setLastName("McBeal");
        owner1.setAddress("12 JSON st.");
        owner1.setCity("Johannesburg");
        owner1.setTelephone("334-332-355");

        Pet jujusPet = new Pet();
        jujusPet.setPetType(savedDogType);
        jujusPet.setOwner(owner1);
        jujusPet.setBirthday(LocalDate.now());
        jujusPet.setName("Scout");
        owner1.getPets().add(jujusPet);
        ownerService.save(owner1);

        //owner needs to be saved first (with pet etc.) for visit to be valid to save
        Visit dogVisit = new Visit();
        dogVisit.setPet(jujusPet);
        dogVisit.setDescription("Limping doggy");
        dogVisit.setDate(LocalDate.now());
        visitService.save(dogVisit);

        Owner owner2 = new Owner();
        owner2.setFirstName("Daddy");
        owner2.setLastName("McPhee");
        owner2.setAddress("342 Peekaboo Av.");
        owner2.setCity("Chicago");
        owner2.setTelephone("555-643-312");

        Pet daddysPet = new Pet();
        daddysPet.setPetType(savedCatType);
        daddysPet.setOwner(owner2);
        daddysPet.setBirthday(LocalDate.now());
        daddysPet.setName("McMeow");
        owner2.getPets().add(daddysPet);
        ownerService.save(owner2);

        Visit catVisit = new Visit();
        catVisit.setPet(daddysPet);
        catVisit.setDescription("Sneezy kitty");
        catVisit.setDate(LocalDate.now());
        visitService.save(catVisit);

        System.out.println("Loaded owners...");

        Vet vet1 = new Vet();
        vet1.setFirstName("Gettah");
        vet1.setLastName("Suffico");
        vet1.getSpecialities().add(savedRadiology);
        vetService.save(vet1);

        Vet vet2 = new Vet();
        vet2.setFirstName("Bobbard");
        vet2.setLastName("Macintosh");
        vet2.getSpecialities().add(savedSurgery);
        vetService.save(vet2);

        System.out.println("Loaded vets...");
    }
}
