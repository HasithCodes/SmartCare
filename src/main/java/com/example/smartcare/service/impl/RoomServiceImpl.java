package com.example.smartcare.service.impl;

import com.example.smartcare.entity.Room;
import com.example.smartcare.repository.RoomRepository;
import com.example.smartcare.service.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class RoomServiceImpl implements RoomService {

    @Autowired
    private RoomRepository roomRepository;

    @Override
    public Room createRoom(Room room) {
        return roomRepository.save(room);
    }

    @Override
    public List<Room> getAllRooms() {
        return roomRepository.findAll();
    }

    @Override
    public Room getRoomById(Long id) {
        return roomRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Room record not found with id: " + id));
    }

    @Override
    public Room updateRoom(Long id, Room updatedRoom) {
        Room existingRoom = getRoomById(id);

        existingRoom.setRoomCategory(updatedRoom.getRoomCategory());
        existingRoom.setAvailabilityStatus(updatedRoom.getAvailabilityStatus());

        return roomRepository.save(existingRoom);
    }

    @Override
    public void deleteRoom(Long id) {
        Room existingRoom = getRoomById(id);
        roomRepository.delete(existingRoom);
    }
}