package com.chukanwobi.propertymanagement.inventory.models;

import lombok.Data;


import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Data

@Entity
public class RoomCategory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String description;
    @OneToOne(cascade = CascadeType.ALL)
    private Pricing pricing;
    @OneToMany(mappedBy = "roomCategory",cascade = CascadeType.ALL)
    private Set<Room> rooms = new HashSet<>();


    public RoomCategory addRoom(Room room){
        room.setRoomCategory(this);
        rooms.add(room);
        return this;
    }

}
