package com.chukanwobi.propertymanagement.inventory.Services;

import com.chukanwobi.propertymanagement.inventory.RecordNotFoundException;
import com.chukanwobi.propertymanagement.inventory.models.Room;
import com.chukanwobi.propertymanagement.inventory.models.RoomCategory;
import com.chukanwobi.propertymanagement.inventory.repository.RoomCategoryRepository;
import com.chukanwobi.propertymanagement.inventory.repository.RoomRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;


@Service
public class InventoryServiceImpl implements InventoryService {

    private RoomCategoryRepository roomCategoryRepository;
    private RoomRepository roomRepository;

    public InventoryServiceImpl(RoomCategoryRepository roomCategoryRepository, RoomRepository roomRepository) {
        this.roomCategoryRepository = roomCategoryRepository;
        this.roomRepository = roomRepository;
    }

    @Override
    public void addRoomCategory(RoomCategory roomCategory) {
        roomCategoryRepository.save(roomCategory);

    }

    @Override
    public RoomCategory findCategoryById(Long id) {
        return roomCategoryRepository.findById(id).orElseThrow(()-> new RecordNotFoundException("Room category with Id: "+ id+" was not found"));
    }

    @Override
    public void addRoom(Room room) {
roomRepository.save(room);
    }

    @Override
    public List<Room> findRoomsByCategoryId(Long id) {

        return findCategoryById(id).getRooms().stream().collect(Collectors.toList());
    }

    @Override
    public Room findRoomById(Long roomId) {
        return  roomRepository.findById(roomId).orElseThrow(()-> new RecordNotFoundException("Room with id: "+roomId+ " was not found"));
    }
}
