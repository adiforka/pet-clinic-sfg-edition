package sfg.petclinicsfgedition.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class VetController {

    //this is options for user input convenience
    @RequestMapping({"/vets", "vets/index", "/vets/index.html"})
    public String listVets(){

        //this returns a view in mvc controllers
        return "vets/index";
    }
}
