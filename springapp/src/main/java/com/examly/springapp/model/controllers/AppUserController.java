package com.examly.springapp.model.controllers;

import com.examly.springapp.model.entitymodels.AppAdmin;
import com.examly.springapp.model.entitymodels.AppCar;
import com.examly.springapp.model.entitymodels.AppUser;
import com.examly.springapp.model.entitymodels.LoginData;
import com.examly.springapp.model.services.AppUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class AppUserController{

    private final AppUserService appUserService;

    @Autowired
    public AppUserController(AppUserService appUserService) {
        this.appUserService = appUserService;
    }
    @PostMapping("/user/signup")
    ResponseEntity<AppUser> signup(@RequestBody AppUser appUser){
        AppUser newAppUser = appUserService.addAppUser(appUser);
        return new ResponseEntity<AppUser>(newAppUser, HttpStatus.CREATED);
    }

    @PostMapping("/user/login")
    ResponseEntity<AppUser> login(@RequestBody LoginData loginData){
        AppUser userData = appUserService.getUserByEmail(loginData);
        if(userData!=null) {
            return new ResponseEntity<AppUser>(userData, HttpStatus.FOUND);
        }else{
            return new ResponseEntity<AppUser>(userData,HttpStatus.NOT_FOUND);
        }
    }
    @GetMapping("user/dashboard")
    ResponseEntity<List<AppAdmin>> getAllCompanies(){
        List<AppAdmin> listOfCompanies = appUserService.getAllAcompanies();
        return new ResponseEntity<>(listOfCompanies,HttpStatus.FOUND);
    }
    @GetMapping("user/cars/{adminid}")
    ResponseEntity<List<AppCar>> getAllCars(@PathVariable Long adminid){
        List<AppCar> listOfCars = appUserService.getAllCarsByAdminId(adminid);
        return new ResponseEntity<>(listOfCars,HttpStatus.FOUND);
    }
    @GetMapping("user/cardetails/{carid}")
    ResponseEntity<AppCar> getCarDetails(@PathVariable Long carid){
        AppCar carDetails = appUserService.getCarDetailsByCarId(carid);
        return new ResponseEntity<>(carDetails,HttpStatus.FOUND);
    }

}
