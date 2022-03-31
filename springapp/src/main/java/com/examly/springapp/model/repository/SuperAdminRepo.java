package com.examly.springapp.model.repository;

import com.examly.springapp.model.entitymodels.SuperAdmin;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SuperAdminRepo extends JpaRepository<SuperAdmin,Long> {
    SuperAdmin getSuperAdminByEmail(String email);
}
