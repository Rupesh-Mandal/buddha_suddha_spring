package com.softkali.buddha_suddha.admin.repository;

import com.softkali.buddha_suddha.admin.model.Admin;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AdminRepository extends JpaRepository<Admin,Long> {
    Optional<Admin> findByMobileNumber(String mobileNumber);
}
