package com.example.snake;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@CrossOrigin(origins = "*")
public class SnakeController {

    @CrossOrigin
    @GetMapping("/")
    public String snake(){

        return "index.html";

    }

}
