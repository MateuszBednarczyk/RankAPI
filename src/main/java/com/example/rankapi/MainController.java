package com.example.rankapi;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainController {

    @RequestMapping("/")
    public String index() {
        return "redirect:/login";
    }

    @RequestMapping("/home")
    public String home(){

        return "home.html";
    }

}
