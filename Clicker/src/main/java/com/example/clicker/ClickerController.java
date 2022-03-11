package com.example.clicker;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@CrossOrigin(origins = "*")
public class ClickerController {

    @CrossOrigin
    @GetMapping("/")
    public String index() {
        return "clicker.html";
    }

}
