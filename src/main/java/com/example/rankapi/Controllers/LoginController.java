package com.example.rankapi.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class LoginController {

    @RequestMapping("/login")
    public String login(){

        return "login.html";

    }

    @RequestMapping("/games")
    public String games(){

        return "games.html";
    }

}