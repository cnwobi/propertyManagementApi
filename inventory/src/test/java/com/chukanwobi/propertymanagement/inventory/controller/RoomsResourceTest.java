package com.chukanwobi.propertymanagement.inventory.controller;

import com.chukanwobi.propertymanagement.inventory.Services.InventoryService;
import com.chukanwobi.propertymanagement.inventory.dto.RoomDTO;
import com.chukanwobi.propertymanagement.inventory.models.Pricing;
import com.chukanwobi.propertymanagement.inventory.models.PricingModel;
import com.chukanwobi.propertymanagement.inventory.models.Room;
import com.chukanwobi.propertymanagement.inventory.models.RoomCategory;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.json.JacksonTester;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;


import java.awt.*;

import static org.junit.Assert.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

public class RoomsResourceTest {

    @Mock
    private InventoryService inventoryService;
    private RoomsResource roomsResource;
    private MockMvc mvc;
  private JacksonTester<RoomDTO> jacksonTester;
    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
        roomsResource = new RoomsResource(inventoryService);
        JacksonTester.initFields(this,new ObjectMapper());
        mvc=  MockMvcBuilders.standaloneSetup(roomsResource).build();

    }

    @Test
    public void getRoom() throws Exception{
        RoomCategory category = new RoomCategory();
        category.setName("Double Rooms");
        category.setDescription("Rooms with double beds");
        Pricing pricing = new Pricing(PricingModel.FIXED);
        pricing.setPriceGuest1(10.0);
        category.setPricing(pricing);

        Room room = new Room();
        room.setName("Room 1");
        room.setDescription("Nice, spacious double bed room with usual amenities");
        room.setRoomCategory(category);
room.setName("Room 1");

        when(inventoryService.findRoomById(1l)).thenReturn(room);

       MockHttpServletResponse response =  mvc.perform(get("/rooms/1").accept(MediaType.APPLICATION_JSON)).andReturn().getResponse();

       assertEquals(response.getStatus(),HttpStatus.OK.value());
       assertEquals(response.getContentAsString(),jacksonTester.write(new RoomDTO(room)).getJson());


    }
}