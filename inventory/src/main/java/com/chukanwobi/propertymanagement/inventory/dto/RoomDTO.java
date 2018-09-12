package com.chukanwobi.propertymanagement.inventory.dto;


import com.chukanwobi.propertymanagement.inventory.models.Room;
import lombok.Data;

import java.io.Serializable;

/**
 * DTO object for {@link Room}s.
 *
 * @author cnwobi
 */
@Data
public class RoomDTO implements Serializable {
    private static final Long serialVersionUID = 2682046985632747474L;

    private Long id;
    private String name;
    private Long roomCategoryId;
    private String description;

    public RoomDTO(Room room) {
        this.id = room.getId();
        this.name = room.getName();
        this.roomCategoryId = room.getRoomCategory().getId();
        this.description = room.getDescription();
    }


}
