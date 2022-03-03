package com.example.rankapi.User;

import com.example.rankapi.Configurations.SufixConfiguration;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    private AppUserRepository appUserRepository;
    private SufixConfiguration sufixConfiguration;

    public UserController(AppUserRepository appUserRepository, SufixConfiguration encodeService) {
        this.appUserRepository = appUserRepository;
        this.sufixConfiguration = encodeService;
    }
}
