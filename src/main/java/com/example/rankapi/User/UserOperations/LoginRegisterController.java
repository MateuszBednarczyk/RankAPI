package com.example.rankapi.User.UserOperations;

import com.example.rankapi.Configurations.SufixConfiguration;
import com.example.rankapi.User.AppUser;
import com.example.rankapi.User.AppUserRepository;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class LoginRegisterController {

    private AppUserRepository appUserRepository;
    private SufixConfiguration sufixConfiguration;

    public LoginRegisterController(AppUserRepository appUserRepository, SufixConfiguration sufixConfiguration) {
        this.appUserRepository = appUserRepository;
        this.sufixConfiguration = sufixConfiguration;
    }

    @RequestMapping("/login")
    public String login(){

        return "login.html";

    }

    @RequestMapping("/signup")
    public ModelAndView signUp(){

        return new ModelAndView("register", "user", new AppUser());

    }

    @RequestMapping("/register")
    public ModelAndView register(AppUser appUser){
        appUser.setPassword(sufixConfiguration.getPasswordEncoder().encode(appUser.getPassword()));
        appUserRepository.save(appUser);
        return new ModelAndView("redirect:/login");

    }

    @RequestMapping("/home")
    public String games(){

        return "home.html";
    }

}
