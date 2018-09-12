package com.chukanwobi.propertymanagement.models;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class Invoice {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String uri;
    @OneToOne
    private Booking booking;
}
