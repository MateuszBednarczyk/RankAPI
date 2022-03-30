package com.example.rankapi.User;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.example.rankapi.Configurations.SufixConfiguration;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.Date;
import java.util.ArrayList;
import java.util.Collection;
import java.util.stream.Collectors;

import static java.util.Arrays.stream;
import static org.springframework.http.HttpHeaders.AUTHORIZATION;

@RestController
public class UserController {

    private AppUserRepository appUserRepository;
    private SufixConfiguration sufixConfiguration;

    public UserController(AppUserRepository appUserRepository, SufixConfiguration encodeService) {
        this.appUserRepository = appUserRepository;
        this.sufixConfiguration = encodeService;
    }
}
