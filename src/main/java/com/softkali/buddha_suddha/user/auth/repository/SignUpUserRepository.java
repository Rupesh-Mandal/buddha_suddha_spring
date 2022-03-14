package com.softkali.buddha_suddha.user.auth.repository;

import com.softkali.buddha_suddha.user.auth.model.AuthUser;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface SignUpUserRepository extends JpaRepository<AuthUser, Long> {
    Optional<AuthUser> findByPhoneNumber(String phoneNumber);


}
