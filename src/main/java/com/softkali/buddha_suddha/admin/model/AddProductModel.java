package com.softkali.buddha_suddha.admin.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.Setter;

import javax.persistence.Column;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
public class AddProductModel {


    private String productName;
    private String productDescription;
    private String productRate;
    private String productDeliverCharge;
    private String productImageLink;
    private String productType;
    private String category;
    private String location;


}
