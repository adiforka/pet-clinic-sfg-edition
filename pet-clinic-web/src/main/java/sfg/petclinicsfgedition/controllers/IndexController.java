package sfg.petclinicsfgedition.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {

    //all these requests are going to be mapped to this controller
    @RequestMapping({"", "/", "index", "index.html"})
    public String index() {
        //this is going to look for a thymeleaf (view) template called index
        return "index";
    }
}
