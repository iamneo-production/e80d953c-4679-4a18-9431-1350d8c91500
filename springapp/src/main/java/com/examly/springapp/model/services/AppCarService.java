package com.examly.springapp.model.services;

import com.examly.springapp.model.entitymodels.AppCar;
import com.examly.springapp.model.repository.AppCarRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class AppCarService {
    private AppCarRepo appCarRepo;
    @Autowired
    AppCarService(AppCarRepo appCarRepo){
        this.appCarRepo = appCarRepo;
    }

    public List<AppCar> getAllCarsById(Long id) {
        List<AppCar>  list = appCarRepo.findAll();
        list.removeIf(appCar -> !Objects.equals(appCar.getAdminId(), id));
        return list;
    }

    public AppCar addCar(AppCar appCar){
        return appCarRepo.save(appCar);
    }

    public AppCar editCar(AppCar appCar) {
        return appCarRepo.save(appCar);
    }

    public Boolean deleteCar(Long carId) {
        Optional<AppCar> appCar = appCarRepo.findById(carId);
        if(appCar.isPresent()) {
            appCarRepo.delete(appCar.get());
            return true;
        }else{
            return false;
        }
    }
}
