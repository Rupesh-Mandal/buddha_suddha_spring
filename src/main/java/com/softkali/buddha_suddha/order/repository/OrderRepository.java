package com.softkali.buddha_suddha.order.repository;

import com.softkali.buddha_suddha.order.model.OrderModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface OrderRepository extends JpaRepository<OrderModel, Long> {

    Optional<OrderModel> findByOrderId(String orderId);
    Optional<List<OrderModel>> findByUserId(String userId);
    Optional<List<OrderModel>> findByPickupBoyId(String pickupBoyId);
    Optional<List<OrderModel>> findByLocation(String location);
    Optional<List<OrderModel>> findByStatus(String status);
    Optional<List<OrderModel>> findByPickupBoyStatus(boolean pickupBoyStatus);

}
