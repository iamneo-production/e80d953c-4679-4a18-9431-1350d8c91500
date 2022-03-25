package com.examly.springapp.model.services;

import com.examly.springapp.model.entitymodels.AppAdmin;
import com.examly.springapp.model.entitymodels.AppCar;
import com.examly.springapp.model.entitymodels.AppUser;
import com.examly.springapp.model.entitymodels.LoginData;
import com.examly.springapp.model.repository.AppAdminRepo;
import com.examly.springapp.model.repository.AppCarRepo;
import com.examly.springapp.model.repository.AppUserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class AppUserService {
    private final AppUserRepo appUserRepo;
    private final AppAdminRepo appAdminRepo;
    private final AppCarRepo appCarRepo;

    @Autowired
    AppUserService(AppUserRepo appUserRepo, AppAdminRepo appAdminRepo,AppCarRepo appCarRepo){
        this.appUserRepo = appUserRepo;
        this.appAdminRepo = appAdminRepo;
        this.appCarRepo = appCarRepo;
    }

    public AppUser addAppUser(AppUser appUser){
        return appUserRepo.save(appUser);
    }

    public AppUser getUserByEmail(LoginData loginData) {
        AppUser appUser = appUserRepo.findAppUserByEmail(loginData.getEmail());
        if(appUser!=null && appUser.getPassword().equals(loginData.getPassword())){
            return appUser;
        }
        return null;
    }

    public List<AppAdmin> getAllAcompanies() {
        return appAdminRepo.findAll();
    }

    public List<AppCar> getAllCarsByAdminId(Long adminId) {
        List<AppCar>  list = appCarRepo.findAll();
        list.removeIf(appCar -> !Objects.equals(appCar.getAdminId(), adminId));
        return list;
    }

    public AppCar getCarDetailsByCarId(Long carid) {
        return appCarRepo.findById(carid).orElse(null);
    }
}
