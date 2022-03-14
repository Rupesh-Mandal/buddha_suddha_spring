package com.softkali.buddha_suddha.admin.repository;

import com.softkali.buddha_suddha.admin.model.Location;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface LocationRepository extends JpaRepository<Location,Long> {
    Optional<Location> findByName(String name);
}
