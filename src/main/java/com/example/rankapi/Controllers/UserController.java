package com.example.rankapi.Controllers;

import com.example.rankapi.Entities.AppUser;
import com.example.rankapi.Repositories.AppUserRepository;
import com.example.rankapi.Configurations.SufixConfiguration;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    private AppUserRepository appUserRepository;
    private SufixConfiguration sufixConfiguration;

    public UserController(AppUserRepository appUserRepository, SufixConfiguration encodeService) {
        this.appUserRepository = appUserRepository;
        this.sufixConfiguration = encodeService;
    }

    @PostMapping("/createuser")
    public void createUser(@RequestBody AppUser appUser) {
        appUser.setPassword(sufixConfiguration.getPasswordEncoder().encode(appUser.getPassword()));
        appUserRepository.save(appUser);
    }

}
