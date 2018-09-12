package com.chukanwobi.propertymanagement.inventory.controller;

import com.chukanwobi.propertymanagement.inventory.Services.InventoryService;
import com.chukanwobi.propertymanagement.inventory.dto.RoomDTO;
import com.chukanwobi.propertymanagement.inventory.models.Room;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/rooms")
public class RoomsResource {

    private final InventoryService inventoryService;

    public RoomsResource(InventoryService inventoryService) {
        this.inventoryService = inventoryService;
    }

    @GetMapping( "/{roomId}")
    public RoomDTO getRoom(@PathVariable String roomId){
       var room =  inventoryService.findRoomById(Long.valueOf(roomId));
        return new RoomDTO(room);
    }
}
