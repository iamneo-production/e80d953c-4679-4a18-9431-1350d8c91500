package com.examly.springapp.model.services;

import com.examly.springapp.model.entitymodels.AppAdmin;
import com.examly.springapp.model.entitymodels.AppUser;
import com.examly.springapp.model.entitymodels.LoginData;
import com.examly.springapp.model.repository.AppAdminRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AppAdminService {
    @Autowired
    private AppAdminRepo appAdminRepo;

    AppAdminService(AppAdminRepo appAdminRepo){
        this.appAdminRepo = appAdminRepo;
    }

    public AppAdmin addAppAdmin(AppAdmin appAdmin) {
        return appAdminRepo.save(appAdmin);
    }

    public AppAdmin getAdminByEmail(LoginData loginData) {
        AppAdmin appAdmin = appAdminRepo.findAppAdminByEmail(loginData.getEmail());
        if(appAdmin!=null && appAdmin.getPassword().equals(loginData.getPassword())){
            return appAdmin;
        }
        return null;
    }

    public AppAdmin getAdminById(Long id) {
        Optional<AppAdmin> appAdmin =  appAdminRepo.findById(id);
        return appAdmin.orElse(null);
    }

    public AppAdmin updateAdmin(AppAdmin appAdmin) {
        return appAdminRepo.save(appAdmin);
    }
}
