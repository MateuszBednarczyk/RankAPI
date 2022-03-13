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
        String url = "http://" + request.getServerName() + ":" + "7070";
        return new ModelAndView("redirect:" + url);
    }

    @CrossOrigin
    @RequestMapping("/snake")
    public ModelAndView goToSnake(HttpServletRequest request) {
        String url = "http://" + request.getServerName() + ":" + "6060";
        return new ModelAndView("redirect:" + url);
    }

    @CrossOrigin
    @RequestMapping("/breakout")
    public ModelAndView goToBreakout(HttpServletRequest request) {
        String url = "http://" + request.getServerName() + ":" + "5050";
        return new ModelAndView("redirect:" + url);
    }

}
