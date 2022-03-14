package com.softkali.buddha_suddha.pickupboy.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class PickupBoy {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String pickupBoyId;

    private String name;
    private String phoneNumber;
    private String password;
    private LocalDateTime createdTime;

    private String location;

    public PickupBoy(String pickupBoyId, String name, String phoneNumber, String password, LocalDateTime createdTime, String location) {
        this.pickupBoyId = pickupBoyId;
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.password = password;
        this.createdTime = createdTime;
        this.location = location;
    }
}
