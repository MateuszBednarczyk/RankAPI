package com.example.breakout;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@CrossOrigin(origins = "*")
public class BreakoutController {

    @CrossOrigin
    @GetMapping("/")
    public String breakout() {
        return "index.html";
    }
}
