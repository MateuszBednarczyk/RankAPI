package com.example.rankapi.Services;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class EncodeService {

    public PasswordEncoder getPasswordEncoder(){

        return new BCryptPasswordEncoder();

    }

}
