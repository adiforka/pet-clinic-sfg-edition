package sfg.petclinicsfgedition.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/*not to spell out "owners" repeatedly in request mapping above method header. if anything comes in for owners, it'll
go to one of the options above the method header.*/
@RequestMapping("/owners")
@Controller
public class OwnerController {

    @RequestMapping({"", "/", "/index", "/index.html"})
    public String listOwners() {
        return "owners/index";
    }
}
