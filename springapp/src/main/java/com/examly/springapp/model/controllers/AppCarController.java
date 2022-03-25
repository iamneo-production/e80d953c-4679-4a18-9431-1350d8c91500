package com.examly.springapp.model.controllers;

import com.examly.springapp.model.entitymodels.AppCar;
import com.examly.springapp.model.services.AppCarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class AppCarController {
    private final AppCarService appCarService;

    @Autowired
    AppCarController(AppCarService appCarService){
        this.appCarService = appCarService;
    }


    @GetMapping("/admin/dashboard/{id}")
    ResponseEntity<List<AppCar>> getAllCar(@PathVariable Long id){
        List<AppCar> carList = appCarService.getAllCarsById(id);
        return new ResponseEntity<List<AppCar>>(carList,HttpStatus.OK);
    }

   @PostMapping("/admin/addCar")
    ResponseEntity<AppCar> addCar(@RequestBody AppCar appCar){
        AppCar addedAppCar = appCarService.addCar(appCar);
        return new ResponseEntity<AppCar>(addedAppCar,HttpStatus.OK);
    }
    @PutMapping("/admin/editCar")
    ResponseEntity<AppCar> editCar(@RequestBody AppCar appCar){
        AppCar editAppCar = appCarService.editCar(appCar);
        return new ResponseEntity<>(editAppCar,HttpStatus.OK);
    }
    @DeleteMapping("/admin/deleteCar/{id}")
    ResponseEntity<Boolean> deleteCar(@PathVariable Long id){
        Boolean isDeleted = appCarService.deleteCar(id);
        if(isDeleted)
            return new ResponseEntity<>(isDeleted,HttpStatus.ACCEPTED);
        else
            return new ResponseEntity<>(isDeleted,HttpStatus.NOT_FOUND);
    }

}
