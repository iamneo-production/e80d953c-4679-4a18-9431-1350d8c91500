package com.examly.springapp.model.repository;

import com.examly.springapp.model.entitymodels.AppCar;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AppCarRepo extends JpaRepository<AppCar,Long> {
    AppCar findByCarId(Long carId);
}
