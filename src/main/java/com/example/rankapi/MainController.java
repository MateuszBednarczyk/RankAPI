package com.example.rankapi;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

@Controller
@CrossOrigin(origins = "*")
public class MainController {

    @RequestMapping("/")
    public String index() {
        return "redirect:/login";
    }

    @RequestMapping("/home")
    public String home(){

        return "home.html";
    }

    @CrossOrigin
    @RequestMapping("/clicker")
    public ModelAndView goToClicker(HttpServletRequest request) {
        //http://localhost:7070/
        //http://192.168.254.115:7070/
        String url = "http://" + request.getServerName() + ":" + "7070";
        return new ModelAndView("redirect:" + url);
    }

}
