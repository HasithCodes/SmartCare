package com.example.smartcare.service;

import com.example.smartcare.entity.Room;
import java.util.List;

public interface RoomService {
    Room createRoom(Room room);
    List<Room> getAllRooms();
    Room getRoomById(Long id);
    Room updateRoom(Long id, Room room);
    void deleteRoom(Long id);
}