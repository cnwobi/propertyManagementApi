package com.chukanwobi.propertymanagement.inventory.models;

import lombok.Data;


import javax.persistence.*;

@Data

@Entity
public class RoomCategory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String description;
    @ManyToOne
    private Room room;
}
