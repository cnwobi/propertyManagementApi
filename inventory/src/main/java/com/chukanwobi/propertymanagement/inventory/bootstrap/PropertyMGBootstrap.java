package com.chukanwobi.propertymanagement.inventory.bootstrap;

import com.chukanwobi.propertymanagement.inventory.Services.InventoryService;
import com.chukanwobi.propertymanagement.inventory.models.Pricing;
import com.chukanwobi.propertymanagement.inventory.models.PricingModel;
import com.chukanwobi.propertymanagement.inventory.models.Room;
import com.chukanwobi.propertymanagement.inventory.models.RoomCategory;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class PropertyMGBootstrap implements ApplicationListener<ContextRefreshedEvent> {
    private InventoryService inventoryService;

    public PropertyMGBootstrap(InventoryService inventoryService) {
        this.inventoryService = inventoryService;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        RoomCategory category = new RoomCategory();
        category.setName("Double Rooms");
        category.setDescription("Rooms with double beds");
        Pricing pricing = new Pricing(PricingModel.FIXED);
        pricing.setPriceGuest1(10.0);
        category.setPricing(pricing);
        inventoryService.addRoomCategory(category);

        Room room = new Room();
        room.setName("Room 1");
        room.setDescription("Nice, spacious double bed room with usual amenities");
        room.setRoomCategory(category);
        inventoryService.addRoom(room);

    }
}
