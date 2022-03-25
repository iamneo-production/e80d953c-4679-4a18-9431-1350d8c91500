package com.examly.springapp.model.controllers;

import com.examly.springapp.model.entitymodels.AppAdmin;
import com.examly.springapp.model.entitymodels.LoginData;
import com.examly.springapp.model.services.AppAdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class AppAdminController {
    private final AppAdminService appAdminService;

    @Autowired
    public AppAdminController(AppAdminService appAdminService) {
        this.appAdminService = appAdminService;
    }

    @PostMapping("/admin/signup")
    ResponseEntity<AppAdmin> signup(@RequestBody AppAdmin appAdmin){
        AppAdmin newAppAdmin = appAdminService.addAppAdmin(appAdmin);
        return new ResponseEntity<AppAdmin>(newAppAdmin, HttpStatus.CREATED);
    }

    @PostMapping("/admin/login")
    ResponseEntity<AppAdmin> login(@RequestBody LoginData loginData){
        AppAdmin adminData = appAdminService.getAdminByEmail(loginData);
        if(adminData!=null) {
            return new ResponseEntity<AppAdmin>(adminData, HttpStatus.FOUND);
        }else{
            return new ResponseEntity<AppAdmin>(adminData,HttpStatus.NOT_FOUND);
        }
    }
    @GetMapping("/admin/profile/{id}")
    ResponseEntity<AppAdmin> getAdmin(@PathVariable Long id){
        AppAdmin appAdmin = appAdminService.getAdminById(id);
        return new ResponseEntity<AppAdmin>(appAdmin,HttpStatus.FOUND);
    }
    @PutMapping("/admin/editprofile")
    ResponseEntity<AppAdmin> updateAdmin(@RequestBody AppAdmin appAdmin){
        AppAdmin updatedAppAdmin = appAdminService.updateAdmin(appAdmin);
        return new ResponseEntity<>(updatedAppAdmin,HttpStatus.ACCEPTED);
    }
}
