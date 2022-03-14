package com.softkali.buddha_suddha.order.model;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class AddOrder {

    private String userId;
    private String name;
    private String phoneNumber;
    private String productDeliverAddress;
    private String location;
    private String orderData;
    private String totalRate;


}
