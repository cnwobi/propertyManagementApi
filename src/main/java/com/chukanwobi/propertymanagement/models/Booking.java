package com.chukanwobi.propertymanagement.models;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;


@Data
@Entity
public class Booking {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    private Date fromDate;

    private Date until;
    private String guestFirstName;

    private String guestLastName;

    private String guestPhone;

    @ManyToOne
    private Room room;
@OneToOne
    private Booking booking;
}
