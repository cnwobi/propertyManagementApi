package com.chukanwobi.propertymanagement.inventory.models;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
@Setter
@EqualsAndHashCode
public class Room{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private  byte[] photo;
    private String description;
@ManyToOne
   private RoomCategory roomCategory;

  /*  @OneToMany(mappedBy = "room",cascade = CascadeType.ALL)
    private Set<Booking> bookings = new HashSet<>();
*/



}
