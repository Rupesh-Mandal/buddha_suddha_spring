package com.softkali.buddha_suddha.pickupboy.repository;

import com.softkali.buddha_suddha.pickupboy.model.PickupBoy;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface PickupBoyRepository extends JpaRepository<PickupBoy,Long> {
    Optional<PickupBoy> findByPhoneNumber(String phoneNumber);
    Optional <List<PickupBoy>> findByLocation(String location);
}
