package com.example.clicker;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ClickerController {
    @RequestMapping("/")
    public String index() {
        return "clicker.html";
    }
}
