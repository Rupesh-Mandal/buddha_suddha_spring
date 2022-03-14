package com.softkali.buddha_suddha.order.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class OrderModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String orderId;

    private String userId;
    private String pickupBoyId;
    private boolean pickupBoyStatus;
    private boolean isRunning;

    private String name;
    private String phoneNumber;
    private String productDeliverAddress;
    private String location;

    @Column(columnDefinition="TEXT")
    private String orderData;

    private String totalRate;

    private String status;
    private String statusMessage;
    private LocalDateTime createdTime;

    public OrderModel(String orderId, String userId, String pickupBoyId, boolean pickupBoyStatus, boolean isRunning, String name, String phoneNumber, String productDeliverAddress, String location, String orderData, String totalRate, String status, String statusMessage, LocalDateTime createdTime) {
        this.orderId = orderId;
        this.userId = userId;
        this.pickupBoyId = pickupBoyId;
        this.pickupBoyStatus = pickupBoyStatus;
        this.isRunning = isRunning;
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.productDeliverAddress = productDeliverAddress;
        this.location = location;
        this.orderData = orderData;
        this.totalRate = totalRate;
        this.status = status;
        this.statusMessage = statusMessage;
        this.createdTime = createdTime;
    }
}
