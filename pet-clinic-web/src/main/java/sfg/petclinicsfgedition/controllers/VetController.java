package sfg.petclinicsfgedition.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import sfg.petclinicsfgedition.services.VetService;

@Controller
public class VetController {

    private VetService vetService;

    @Autowired
    public VetController(VetService vetService) {
        this.vetService = vetService;
    }


    @RequestMapping({"/vets", "vets/index", "/vets/index.html"})
    public String listVets(Model model) {

        model.addAttribute("vets", vetService.findAll());

        //this returns a view in mvc controllers
        return "vets/index";
    }
}
