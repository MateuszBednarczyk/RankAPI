package com.example.rankapi.User.VerificationToken;

import com.example.rankapi.User.AppUser;

import javax.persistence.*;

@Entity
public class VerificationToken {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long tokenId;
    private String value;

    @OneToOne
    private AppUser appUser;

    public VerificationToken(String value, AppUser appUser) {
        this.value = value;
        this.appUser = appUser;
    }

    public VerificationToken() {
    }

    public Long getTokenId() {
        return tokenId;
    }

    public void setTokenId(Long tokenId) {
        this.tokenId = tokenId;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public AppUser getAppUser() {
        return appUser;
    }

    public void setAppUser(AppUser appUser) {
        this.appUser = appUser;
    }
}
