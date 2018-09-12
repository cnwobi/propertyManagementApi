package com.chukanwobi.propertymanagement.inventory.models;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data

public class Pricing {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Enumerated
    private PricingModel pricingModel;
    private Double priceGuest1;
    private Double priceGuest2;
    private Double priceGuest3;

    public Pricing(PricingModel pricingModel) {
        if (pricingModel == null) {
            throw new IllegalArgumentException("pricingModel");
        }
        this.pricingModel = pricingModel;
    }
}
