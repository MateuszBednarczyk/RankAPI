package com.example.rankapi.User.UserOperations;

import com.example.rankapi.Configurations.SufixConfiguration;
import com.example.rankapi.User.AppUser;
import com.example.rankapi.User.AppUserRepository;
import com.example.rankapi.User.VerificationToken.VerificationTokenService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.transaction.Transactional;

@Controller
@CrossOrigin(origins = "*")
public class LoginRegisterController {

    private AppUserRepository appUserRepository;
    private SufixConfiguration sufixConfiguration;
    private VerificationTokenService verificationTokenService;
    private RegisterService registerService;

    public LoginRegisterController(AppUserRepository appUserRepository, SufixConfiguration sufixConfiguration, VerificationTokenService verificationTokenService, RegisterService registerService) {
        this.appUserRepository = appUserRepository;
        this.sufixConfiguration = sufixConfiguration;
        this.verificationTokenService = verificationTokenService;
        this.registerService = registerService;
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
        registerService.register(appUser,request);
        return new ModelAndView("redirect:/login");

    }

    @Transactional
    @RequestMapping("/verify")
    public ModelAndView verify(@RequestParam String token){
        verificationTokenService.verify(token);
        return new ModelAndView("redirect:/login");
    }
}
