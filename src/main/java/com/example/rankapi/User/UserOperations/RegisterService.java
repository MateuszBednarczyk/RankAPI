package com.example.rankapi.User.UserOperations;

import com.example.rankapi.Configurations.SufixConfiguration;
import com.example.rankapi.User.AppUser;
import com.example.rankapi.User.AppUserRepository;
import com.example.rankapi.User.VerificationToken.VerificationTokenService;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;

@Service
public class RegisterService {

    private AppUserRepository appUserRepository;
    private VerificationTokenService verificationTokenService;
    private SufixConfiguration sufixConfiguration;

    public RegisterService(AppUserRepository appUserRepository, VerificationTokenService verificationTokenService, SufixConfiguration sufixConfiguration) {
        this.appUserRepository = appUserRepository;
        this.verificationTokenService = verificationTokenService;
        this.sufixConfiguration = sufixConfiguration;
    }

    public void register(AppUser appUser, HttpServletRequest request){
        appUser.setPassword(sufixConfiguration.getPasswordEncoder().encode(appUser.getPassword()));
        appUserRepository.save(appUser);
        verificationTokenService.generateVerificationToken(appUser,request);
    }

}
