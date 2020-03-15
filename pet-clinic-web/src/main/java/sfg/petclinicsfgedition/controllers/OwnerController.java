package sfg.petclinicsfgedition.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import sfg.petclinicsfgedition.services.OwnerService;

/*not to spell out "owners" repeatedly in request mapping above method header. if anything comes in for owners, it'll
go to one of the options above the method header.*/
@RequestMapping("/owners")
@Controller
public class OwnerController {

    //making this final so it cannot be changed after the object is injected thru the constructor
    private final OwnerService ownerService;

    //gimme a DI
    @Autowired
    public OwnerController(OwnerService ownerService) {
        this.ownerService = ownerService;
    }

    @GetMapping({"", "/", "/index", "/index.html"})
    public String listOwners(Model model) {

        //passing attribute named owners to the view. then returning view called owners/index
        model.addAttribute("owners", ownerService.findAll());

        return "owners/index";
    }

    @RequestMapping("/find")
    public String findOwners() {
        return "notImplemented";
    }
}
