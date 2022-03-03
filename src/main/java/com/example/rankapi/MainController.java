package com.example.rankapi;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@CrossOrigin(origins = "http://localhost:7070")
public class MainController {

    @RequestMapping("/")
    public String index() {
        return "redirect:/login";
    }

    @RequestMapping("/home")
    public String home(){

        return "home.html";
    }

    @RequestMapping("/clicker")
    public String goToClicker() {
        return "redirect:http://localhost:7070";
    }

}
