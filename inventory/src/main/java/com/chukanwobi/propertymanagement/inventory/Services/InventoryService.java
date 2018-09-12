package com.chukanwobi.propertymanagement.inventory.Services;


import com.chukanwobi.propertymanagement.inventory.models.Room;
import com.chukanwobi.propertymanagement.inventory.models.RoomCategory;

import java.util.List;

/**
 * This service provides the necessary funtionality to manage rooms.
 *
 * @author cnwobi
 */
public interface InventoryService {

    /**
     * Adds a category to a room
     *
     * @param roomCategory category the room belongs to
     */
    void addRoomCategory(RoomCategory roomCategory);

    /**
     * Returns a room category given an id
     *
     * @param id the category ID
     * @return the category
     */
    RoomCategory findCategoryById(Long id);

    /**
     * Add a room to the system.
     *
     * @param room the room to add
     */
    void addRoom(Room room);

    /**
     * Return all rooms in a given category id
     *
     * @param id the category id
     * @return all the rooms belonging with the given category
     */
    List<Room> findRoomsByCategoryId(Long id);

    /**
     * Answers the room with the given identifier.
     *
     * @param roomId the room ID
     * @return the room with the given {@code roomId}
     * <p>
     * if the room does not exist
     */
    public Room findRoomById(Long roomId);
}
