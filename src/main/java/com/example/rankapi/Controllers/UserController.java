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
    private EncodeService encodeService;

    public UserController(AppUserRepository appUserRepository, EncodeService encodeService) {
        this.appUserRepository = appUserRepository;
        this.encodeService = encodeService;
    }

    @PostMapping("/createuser")
    public void createUser(@RequestBody AppUser appUser) {
        appUserRepository.save(appUser);
    }

}
