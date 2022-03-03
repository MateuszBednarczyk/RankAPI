package com.example.rankapi.User.UserOperations;

import com.example.rankapi.Configurations.SufixConfiguration;
import com.example.rankapi.User.AppUser;
import com.example.rankapi.User.AppUserRepository;
import com.example.rankapi.User.UserDetailsServiceImpl;
import com.example.rankapi.User.VerificationToken.VerificationTokenService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

@Controller
public class LoginRegisterController {

    private AppUserRepository appUserRepository;
    private SufixConfiguration sufixConfiguration;
    private VerificationTokenService verificationTokenService;
    private UserDetailsServiceImpl userDetailsServiceImpl;

    public LoginRegisterController(AppUserRepository appUserRepository, SufixConfiguration sufixConfiguration, VerificationTokenService verificationTokenService, UserDetailsServiceImpl userDetailsServiceImpl) {
        this.appUserRepository = appUserRepository;
        this.sufixConfiguration = sufixConfiguration;
        this.verificationTokenService = verificationTokenService;
        this.userDetailsServiceImpl = userDetailsServiceImpl;
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
    public ModelAndView register(AppUser appUser, HttpServletRequest request){
        System.out.println(appUser.getPassword());
        appUser.setPassword(sufixConfiguration.getPasswordEncoder().encode(appUser.getPassword()));
        System.out.println(appUser.getPassword());
        appUserRepository.save(appUser);
        verificationTokenService.generateVerificationToken(appUser,request);
        return new ModelAndView("redirect:/login");

    }

    @RequestMapping("/verify")
    public ModelAndView verify(@RequestParam String token){
        verificationTokenService.verify(token);
        return new ModelAndView("redirect:/login");
    }
}
