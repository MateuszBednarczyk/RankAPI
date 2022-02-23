package com.example.rankapi.Repositories;

import com.example.rankapi.Entities.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AppUserRepository extends JpaRepository<AppUser, Long> {

    AppUser findAppUserByUsername(String username);

}
