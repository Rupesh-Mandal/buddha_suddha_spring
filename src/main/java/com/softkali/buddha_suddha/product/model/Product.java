package com.softkali.buddha_suddha.product.model;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class Product {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NonNull
    private String productId;

    private String productName;
    private String productDescription;
    private String productRate;
    private String productDeliverCharge;

    @Column(columnDefinition="TEXT")
    private String productImageLink;

    private LocalDateTime createdTime;
    private String productType;
    private String category;
    private String location;

    public Product(@NonNull String productId, String productName, String productDescription, String productRate, String productDeliverCharge, String productImageLink, LocalDateTime createdTime, String productType, String category, String location) {
        this.productId = productId;
        this.productName = productName;
        this.productDescription = productDescription;
        this.productRate = productRate;
        this.productDeliverCharge = productDeliverCharge;
        this.productImageLink = productImageLink;
        this.createdTime = createdTime;
        this.productType = productType;
        this.category = category;
        this.location = location;
    }
}
