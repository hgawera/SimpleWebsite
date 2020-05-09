package uk.ac.city.sbbc662.CSBT.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import uk.ac.city.sbbc662.CSBT.domain.User;
import uk.ac.city.sbbc662.CSBT.services.RegistrationService;


@Controller
public class RegistrationController {

    private RegistrationService registrationService;

    @Autowired
    public RegistrationController(RegistrationService registrationService){
        this.registrationService = registrationService;
    }


    @RequestMapping(value = "/register", method = RequestMethod.GET)
    public ModelAndView showRegistrationForm() {
        User user = new User();
        return new ModelAndView("register", "user", user);
    }

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public String processRegistrationForm(User user) {
        registrationService.addUser(user);
        return "redirect:/profile";
    }
}
