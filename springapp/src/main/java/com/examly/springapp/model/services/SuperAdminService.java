package com.examly.springapp.model.services;

import com.examly.springapp.model.entitymodels.AppAdmin;
import com.examly.springapp.model.entitymodels.AppUser;
import com.examly.springapp.model.entitymodels.LoginData;
import com.examly.springapp.model.entitymodels.SuperAdmin;
import com.examly.springapp.model.repository.AppAdminRepo;
import com.examly.springapp.model.repository.AppUserRepo;
import com.examly.springapp.model.repository.SuperAdminRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SuperAdminService {
    private final SuperAdminRepo superAdminRepo;
    private final AppAdminRepo appAdminRepo;
    private final AppUserRepo appUserRepo;
    @Autowired
    SuperAdminService(SuperAdminRepo superAdminRepo,
                      AppAdminRepo appAdminRepo,
                      AppUserRepo appUserRepo){
        this.superAdminRepo = superAdminRepo;
        this.appAdminRepo = appAdminRepo;
        this.appUserRepo = appUserRepo;
    }

    public List<AppAdmin> getAllAdmins() {
        return appAdminRepo.findAll();
    }

    public List<AppUser> getAllUsers() {
        return appUserRepo.findAll();
    }

    public SuperAdmin addSuperAdmin(SuperAdmin superAdmin) {
        return superAdminRepo.save(superAdmin);
    }

    public SuperAdmin getUserByEmail(LoginData loginData) {
        return superAdminRepo.getSuperAdminByEmail(loginData.getEmail());
    }

    public AppAdmin deleteAdmin(String email) {
        return appAdminRepo.deleteByEmail(email);
    }

    public AppUser deleteUser(String email) {
        return appUserRepo.deleteByEmail(email);
    }
}
