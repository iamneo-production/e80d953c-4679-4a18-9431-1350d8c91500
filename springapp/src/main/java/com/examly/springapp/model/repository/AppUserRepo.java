package com.examly.springapp.model.repository;

import com.examly.springapp.model.entitymodels.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AppUserRepo extends JpaRepository<AppUser,Long> {
    AppUser findAppUserByEmail(String email);
    AppUser deleteByEmail(String email);
}
