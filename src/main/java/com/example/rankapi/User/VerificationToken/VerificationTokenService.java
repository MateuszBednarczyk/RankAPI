package com.example.rankapi.User.VerificationToken;

import com.example.rankapi.MailSender.MailSenderService;
import com.example.rankapi.User.AppUser;
import com.example.rankapi.User.AppUserRepository;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import javax.transaction.Transactional;
import java.util.UUID;

@Service
public class VerificationTokenService {

    private VerificationTokenRepository verificationTokenRepository;
    private AppUserRepository appUserRepository;
    private MailSenderService mailSenderService;

    public VerificationTokenService(VerificationTokenRepository verificationTokenRepository, AppUserRepository appUserRepository, MailSenderService mailSenderService) {
        this.verificationTokenRepository = verificationTokenRepository;
        this.appUserRepository = appUserRepository;
        this.mailSenderService = mailSenderService;
    }

    public void generateVerificationToken(AppUser appUser, HttpServletRequest request){

        String token = UUID.randomUUID().toString();
        VerificationToken verificationToken = new VerificationToken(token,appUser);
        verificationTokenRepository.save(verificationToken);

        String url = "http://" + request.getServerName() + ":" + request.getServerPort()
                + request.getContextPath() + "/verify?token=" + token;

        mailSenderService.sendEmail(appUser.getUsername(), "Verify your account", url);

    }

    @Transactional
    public void verify(String token){

       AppUser appUser = verificationTokenRepository.findByValue(token).getAppUser();
       appUser.setEnabled(true);
       appUserRepository.save(appUser);

    }
}
