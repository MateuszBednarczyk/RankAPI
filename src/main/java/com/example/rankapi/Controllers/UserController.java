package com.example.rankapi.Controllers;

import com.example.rankapi.Entities.AppUser;
import com.example.rankapi.Repositories.AppUserRepository;
import com.example.rankapi.Services.EncodeService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    private AppUserRepository appUserRepository;
    private EncodeService encoder;

    public UserController(AppUserRepository appUserRepository, EncodeService encoder) {
        this.appUserRepository = appUserRepository;
        this.encoder = encoder;
    }

    @PostMapping("/createuser")
    public void createUser(@RequestBody AppUser appUser) {
        appUser.setPassword(encoder.getPasswordEncoder().encode(appUser.getPassword()));
        appUserRepository.save(appUser);
    }

}
