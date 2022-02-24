package com.example.rankapi.User;

import org.springframework.context.annotation.Primary;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class EncodeService {

    public PasswordEncoder getPasswordEncoder(){

        return new BCryptPasswordEncoder();

    }

}
