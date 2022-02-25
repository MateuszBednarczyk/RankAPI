package com.example.rankapi.UserOperations;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class LoginController {

    @RequestMapping("/login")
    public String login(){

        return "login.html";

    }

    @RequestMapping("/register")
    public String register(){

        return "test reg";

    }

    @RequestMapping("/home")
    public String games(){

        return "home.html";
    }

}