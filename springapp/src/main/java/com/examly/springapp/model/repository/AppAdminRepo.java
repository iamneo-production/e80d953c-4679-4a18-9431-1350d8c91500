package com.examly.springapp.model.repository;

import com.examly.springapp.model.entitymodels.AppAdmin;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AppAdminRepo extends JpaRepository<AppAdmin,Long> {
    AppAdmin findAppAdminByEmail(String email);
}
