package uk.ac.city.sbbc662.CSBT.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import uk.ac.city.sbbc662.CSBT.domain.CollatedUser;
import uk.ac.city.sbbc662.CSBT.domain.User;
import uk.ac.city.sbbc662.CSBT.services.ProfileService;

@Controller
public class ProfileController {

    private ProfileService profileService;

    @Autowired
    public ProfileController(ProfileService profileService){
        this.profileService = profileService;
    }


    @RequestMapping(value = "/profile")
    public ModelAndView showProfile() {
        String email = SecurityContextHolder.getContext().getAuthentication().getName();
        CollatedUser cu = profileService.getProfile(email);
        return new ModelAndView("profile", "collatedUser", cu);
    }
}
